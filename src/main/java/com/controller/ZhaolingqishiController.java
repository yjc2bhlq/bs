package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ZhaolingqishiEntity;
import com.entity.view.ZhaolingqishiView;

import com.service.ZhaolingqishiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 招领启事
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-10 11:49:03
 */
@RestController
@RequestMapping("/zhaolingqishi")
public class ZhaolingqishiController {
    @Autowired
    private ZhaolingqishiService zhaolingqishiService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhaolingqishiEntity zhaolingqishi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			zhaolingqishi.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZhaolingqishiEntity> ew = new EntityWrapper<ZhaolingqishiEntity>();

		PageUtils page = zhaolingqishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhaolingqishi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhaolingqishiEntity zhaolingqishi, 
		HttpServletRequest request){
        EntityWrapper<ZhaolingqishiEntity> ew = new EntityWrapper<ZhaolingqishiEntity>();

		PageUtils page = zhaolingqishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhaolingqishi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhaolingqishiEntity zhaolingqishi){
       	EntityWrapper<ZhaolingqishiEntity> ew = new EntityWrapper<ZhaolingqishiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhaolingqishi, "zhaolingqishi")); 
        return R.ok().put("data", zhaolingqishiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhaolingqishiEntity zhaolingqishi){
        EntityWrapper< ZhaolingqishiEntity> ew = new EntityWrapper< ZhaolingqishiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhaolingqishi, "zhaolingqishi")); 
		ZhaolingqishiView zhaolingqishiView =  zhaolingqishiService.selectView(ew);
		return R.ok("查询招领启事成功").put("data", zhaolingqishiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhaolingqishiEntity zhaolingqishi = zhaolingqishiService.selectById(id);
        return R.ok().put("data", zhaolingqishi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhaolingqishiEntity zhaolingqishi = zhaolingqishiService.selectById(id);
        return R.ok().put("data", zhaolingqishi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhaolingqishiEntity zhaolingqishi, HttpServletRequest request){
    	zhaolingqishi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhaolingqishi);
        zhaolingqishiService.insert(zhaolingqishi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhaolingqishiEntity zhaolingqishi, HttpServletRequest request){
    	zhaolingqishi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhaolingqishi);
        zhaolingqishiService.insert(zhaolingqishi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhaolingqishiEntity zhaolingqishi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhaolingqishi);
        zhaolingqishiService.updateById(zhaolingqishi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhaolingqishiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
