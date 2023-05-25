package com.controller;

import com.annotation.IgnoreAuth;
import com.baidu.aip.face.AipFace;
import com.service.CommonService;
import com.service.ConfigService;
import com.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;
/**
 * 通用接口
 * 处理通用的请求接口，包含获取选项、获取记录、修改状态、统计等功能。
 */
@RestController
public class CommonController{
	@Autowired
	private CommonService commonService;

    private static AipFace client = null;
    
    @Autowired
    private ConfigService configService;    
	/**
	 * 获取table表中的column列表(联动接口)
	 * @param tableName       表名
	 * @param columnName      列名
	 * @param conditionColumn 条件列名（可选）
	 * @param conditionValue  条件值（可选）
	 * @param level           级别（可选）
	 * @param parent          父级（可选）
	 * @return 包含选项列表的响应结果
	 * @param table
	 * @param column
	 * @return
	 */
	@IgnoreAuth
	@RequestMapping("/option/{tableName}/{columnName}")
	public R getOption(@PathVariable("tableName") String tableName, @PathVariable("columnName") String columnName,@RequestParam(required = false) String conditionColumn,@RequestParam(required = false) String conditionValue,String level,String parent) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("table", tableName);
		params.put("column", columnName);
		if(StringUtils.isNotBlank(level)) {
			params.put("level", level);
		}
		if(StringUtils.isNotBlank(parent)) {
			params.put("parent", parent);
		}
        if(StringUtils.isNotBlank(conditionColumn)) {
            params.put("conditionColumn", conditionColumn);
        }
        if(StringUtils.isNotBlank(conditionValue)) {
            params.put("conditionValue", conditionValue);
        }
		List<String> data = commonService.getOption(params);
		return R.ok().put("data", data);
	}
	
	/**
	 * 根据table中的column获取单条记录
	 * @param tableName    表名
	 * @param columnName   列名
	 * @param columnValue  列值
	 * @return 包含记录的响应结果
	 */
	@IgnoreAuth
	@RequestMapping("/follow/{tableName}/{columnName}")
	public R getFollowByOption(@PathVariable("tableName") String tableName, @PathVariable("columnName") String columnName, @RequestParam String columnValue) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("table", tableName);
		params.put("column", columnName);
		params.put("columnValue", columnValue);
		Map<String, Object> result = commonService.getFollowByOption(params);
		return R.ok().put("data", result);
	}
	
	/**
	 * 修改table表的sfsh状态
	 * @param tableName 表名
	 * @param map       包含修改参数的Map对象
	 * @return 响应结果
	 */
	@RequestMapping("/sh/{tableName}")
	public R sh(@PathVariable("tableName") String tableName, @RequestBody Map<String, Object> map) {
		map.put("table", tableName);
		commonService.sh(map);
		return R.ok();
	}
	
	/**
	 * 获取需要提醒的记录数
	 * @param tableName    表名
	 * @param columnName   列名
	 * @param type         类型 (1:数字, 2:日期)
	 * @param map          包含查询参数的Map对象
	 * @return 包含记录数的响应结果
	 */
	@IgnoreAuth
	@RequestMapping("/remind/{tableName}/{columnName}/{type}")
	public R remindCount(@PathVariable("tableName") String tableName, @PathVariable("columnName") String columnName, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("table", tableName);
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		int count = commonService.remindCount(map);
		return R.ok().put("count", count);
	}
	
	/**
	 * 单列求和
	 * @param tableName  表名
	 * @param columnName 列名
	 * @return 包含求和结果的响应结果
	 */
	@IgnoreAuth
	@RequestMapping("/cal/{tableName}/{columnName}")
	public R cal(@PathVariable("tableName") String tableName, @PathVariable("columnName") String columnName) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("table", tableName);
		params.put("column", columnName);
		Map<String, Object> result = commonService.selectCal(params);
		return R.ok().put("data", result);
	}
	
	/**
	 * 分组统计
	 * @param tableName  表名
	 * @param columnName 列名
	 * @return 包含分组统计结果的响应结果
	 */
	@IgnoreAuth
	@RequestMapping("/group/{tableName}/{columnName}")
	public R group(@PathVariable("tableName") String tableName, @PathVariable("columnName") String columnName) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("table", tableName);
		params.put("column", columnName);
		List<Map<String, Object>> result = commonService.selectGroup(params);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(Map<String, Object> m : result) {
			for(String k : m.keySet()) {
				if(m.get(k) instanceof Date) {
					m.put(k, sdf.format((Date)m.get(k)));
				}
			}
		}
		return R.ok().put("data", result);
	}
	
	/**
	 * （按值统计）
	 * @param tableName    表名
	 * @param yColumnName  Y轴列名
	 * @param xColumnName  X轴列名
	 * @return 包含统计结果的响应结果
	 */
	@IgnoreAuth
	@RequestMapping("/value/{tableName}/{xColumnName}/{yColumnName}")
	public R value(@PathVariable("tableName") String tableName, @PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("table", tableName);
		params.put("xColumn", xColumnName);
		params.put("yColumn", yColumnName);
		List<Map<String, Object>> result = commonService.selectValue(params);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(Map<String, Object> m : result) {
			for(String k : m.keySet()) {
				if(m.get(k) instanceof Date) {
					m.put(k, sdf.format((Date)m.get(k)));
				}
			}
		}
		return R.ok().put("data", result);
	}

	/**
 	 * （按值统计）时间统计类型
	 * @param tableName       表名
	 * @param yColumnName     Y轴列名
	 * @param xColumnName     X轴列名
	 * @param timeStatType    时间统计类型
	 * @return 包含统计结果的响应结果
	 */
	@IgnoreAuth
	@RequestMapping("/value/{tableName}/{xColumnName}/{yColumnName}/{timeStatType}")
	public R valueDay(@PathVariable("tableName") String tableName, @PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("table", tableName);
		params.put("xColumn", xColumnName);
		params.put("yColumn", yColumnName);
		params.put("timeStatType", timeStatType);
		List<Map<String, Object>> result = commonService.selectTimeStatValue(params);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(Map<String, Object> m : result) {
			for(String k : m.keySet()) {
				if(m.get(k) instanceof Date) {
					m.put(k, sdf.format((Date)m.get(k)));
				}
			}
		}
		return R.ok().put("data", result);
	}
	


}
