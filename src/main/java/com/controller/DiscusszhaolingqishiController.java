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

import com.entity.DiscusszhaolingqishiEntity;
import com.entity.view.DiscusszhaolingqishiView;

import com.service.DiscusszhaolingqishiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 招领启事评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-10 11:49:04
 */
@RestController
@RequestMapping("/discusszhaolingqishi")
public class DiscusszhaolingqishiController {
    @Autowired
    private DiscusszhaolingqishiService discusszhaolingqishiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscusszhaolingqishiEntity discusszhaolingqishi,
		HttpServletRequest request){
        EntityWrapper<DiscusszhaolingqishiEntity> ew = new EntityWrapper<DiscusszhaolingqishiEntity>();

		PageUtils page = discusszhaolingqishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusszhaolingqishi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscusszhaolingqishiEntity discusszhaolingqishi, 
		HttpServletRequest request){
        EntityWrapper<DiscusszhaolingqishiEntity> ew = new EntityWrapper<DiscusszhaolingqishiEntity>();

		PageUtils page = discusszhaolingqishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusszhaolingqishi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscusszhaolingqishiEntity discusszhaolingqishi){
       	EntityWrapper<DiscusszhaolingqishiEntity> ew = new EntityWrapper<DiscusszhaolingqishiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discusszhaolingqishi, "discusszhaolingqishi")); 
        return R.ok().put("data", discusszhaolingqishiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscusszhaolingqishiEntity discusszhaolingqishi){
        EntityWrapper< DiscusszhaolingqishiEntity> ew = new EntityWrapper< DiscusszhaolingqishiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discusszhaolingqishi, "discusszhaolingqishi")); 
		DiscusszhaolingqishiView discusszhaolingqishiView =  discusszhaolingqishiService.selectView(ew);
		return R.ok("查询招领启事评论表成功").put("data", discusszhaolingqishiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscusszhaolingqishiEntity discusszhaolingqishi = discusszhaolingqishiService.selectById(id);
        return R.ok().put("data", discusszhaolingqishi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscusszhaolingqishiEntity discusszhaolingqishi = discusszhaolingqishiService.selectById(id);
        return R.ok().put("data", discusszhaolingqishi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscusszhaolingqishiEntity discusszhaolingqishi, HttpServletRequest request){
    	discusszhaolingqishi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusszhaolingqishi);
        discusszhaolingqishiService.insert(discusszhaolingqishi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscusszhaolingqishiEntity discusszhaolingqishi, HttpServletRequest request){
    	discusszhaolingqishi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusszhaolingqishi);
        discusszhaolingqishiService.insert(discusszhaolingqishi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscusszhaolingqishiEntity discusszhaolingqishi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusszhaolingqishi);
        discusszhaolingqishiService.updateById(discusszhaolingqishi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discusszhaolingqishiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
