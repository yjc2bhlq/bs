package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.DiscussshiwuqishiEntity;
import com.entity.view.DiscussshiwuqishiView;
import com.service.DiscussshiwuqishiService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * 失物启事评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-10 11:49:04
 */
@RestController
@RequestMapping("/discussshiwuqishi")
public class DiscussshiwuqishiController {
    @Autowired
    private DiscussshiwuqishiService discussshiwuqishiService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussshiwuqishiEntity discussshiwuqishi,
		HttpServletRequest request){
        EntityWrapper<DiscussshiwuqishiEntity> ew = new EntityWrapper<DiscussshiwuqishiEntity>();

		PageUtils page = discussshiwuqishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussshiwuqishi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussshiwuqishiEntity discussshiwuqishi, 
		HttpServletRequest request){
        EntityWrapper<DiscussshiwuqishiEntity> ew = new EntityWrapper<DiscussshiwuqishiEntity>();

		PageUtils page = discussshiwuqishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussshiwuqishi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussshiwuqishiEntity discussshiwuqishi){
       	EntityWrapper<DiscussshiwuqishiEntity> ew = new EntityWrapper<DiscussshiwuqishiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussshiwuqishi, "discussshiwuqishi")); 
        return R.ok().put("data", discussshiwuqishiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussshiwuqishiEntity discussshiwuqishi){
        EntityWrapper< DiscussshiwuqishiEntity> ew = new EntityWrapper< DiscussshiwuqishiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussshiwuqishi, "discussshiwuqishi")); 
		DiscussshiwuqishiView discussshiwuqishiView =  discussshiwuqishiService.selectView(ew);
		return R.ok("查询失物启事评论表成功").put("data", discussshiwuqishiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussshiwuqishiEntity discussshiwuqishi = discussshiwuqishiService.selectById(id);
        return R.ok().put("data", discussshiwuqishi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussshiwuqishiEntity discussshiwuqishi = discussshiwuqishiService.selectById(id);
        return R.ok().put("data", discussshiwuqishi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussshiwuqishiEntity discussshiwuqishi, HttpServletRequest request){
    	discussshiwuqishi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussshiwuqishi);
        discussshiwuqishiService.insert(discussshiwuqishi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussshiwuqishiEntity discussshiwuqishi, HttpServletRequest request){
    	discussshiwuqishi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussshiwuqishi);
        discussshiwuqishiService.insert(discussshiwuqishi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussshiwuqishiEntity discussshiwuqishi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussshiwuqishi);
        discussshiwuqishiService.updateById(discussshiwuqishi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussshiwuqishiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
