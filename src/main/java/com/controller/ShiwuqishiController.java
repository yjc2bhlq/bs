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

import com.entity.ShiwuqishiEntity;
import com.entity.view.ShiwuqishiView;

import com.service.ShiwuqishiService;
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
 * 失物启事
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-10 11:49:03
 */
@RestController
@RequestMapping("/shiwuqishi")
public class ShiwuqishiController {
    @Autowired
    private ShiwuqishiService shiwuqishiService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShiwuqishiEntity shiwuqishi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			shiwuqishi.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShiwuqishiEntity> ew = new EntityWrapper<ShiwuqishiEntity>();

		PageUtils page = shiwuqishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shiwuqishi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShiwuqishiEntity shiwuqishi, 
		HttpServletRequest request){
        EntityWrapper<ShiwuqishiEntity> ew = new EntityWrapper<ShiwuqishiEntity>();

		PageUtils page = shiwuqishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shiwuqishi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShiwuqishiEntity shiwuqishi){
       	EntityWrapper<ShiwuqishiEntity> ew = new EntityWrapper<ShiwuqishiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shiwuqishi, "shiwuqishi")); 
        return R.ok().put("data", shiwuqishiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShiwuqishiEntity shiwuqishi){
        EntityWrapper< ShiwuqishiEntity> ew = new EntityWrapper< ShiwuqishiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shiwuqishi, "shiwuqishi")); 
		ShiwuqishiView shiwuqishiView =  shiwuqishiService.selectView(ew);
		return R.ok("查询失物启事成功").put("data", shiwuqishiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShiwuqishiEntity shiwuqishi = shiwuqishiService.selectById(id);
        return R.ok().put("data", shiwuqishi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShiwuqishiEntity shiwuqishi = shiwuqishiService.selectById(id);
        return R.ok().put("data", shiwuqishi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShiwuqishiEntity shiwuqishi, HttpServletRequest request){
    	shiwuqishi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shiwuqishi);
        shiwuqishiService.insert(shiwuqishi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShiwuqishiEntity shiwuqishi, HttpServletRequest request){
    	shiwuqishi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shiwuqishi);
        shiwuqishiService.insert(shiwuqishi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShiwuqishiEntity shiwuqishi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shiwuqishi);
        shiwuqishiService.updateById(shiwuqishi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shiwuqishiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
