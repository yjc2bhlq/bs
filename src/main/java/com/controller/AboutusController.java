package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.AboutusEntity;
import com.entity.view.AboutusView;
import com.service.AboutusService;
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
 * 关于我们
 * 后端接口
 * 控制器类，处理关于我们相关的后端请求。
 * 包含关于我们的列表、详情、保存、修改和删除等接口。
 * 使用Spring框架的RestController注解将类标记为控制器，
 * 使用RequestMapping注解定义请求的URL路径。
 * @author 
 * @email 
 * @date 2023-05-10 11:49:04
 */
@RestController
@RequestMapping("/aboutus")
public class AboutusController {
    @Autowired
    private AboutusService aboutusService;


    


    /**
     * 后端列表
     * 根据传入的参数进行查询，并返回关于我们的分页结果。
     * 使用@RequestParam注解将参数映射到请求中的查询参数。
     * 使用EntityWrapper构建查询条件，包括模糊查询和排序等。
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,AboutusEntity aboutus,
		HttpServletRequest request){
        EntityWrapper<AboutusEntity> ew = new EntityWrapper<AboutusEntity>();

		PageUtils page = aboutusService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, aboutus), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     * 根据传入的参数进行查询，并返回关于我们的分页结果。
     * 使用@RequestParam注解将参数映射到请求中的查询参数。
     * 使用EntityWrapper构建查询条件，包括模糊查询和排序等。
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,AboutusEntity aboutus, 
		HttpServletRequest request){
        EntityWrapper<AboutusEntity> ew = new EntityWrapper<AboutusEntity>();

		PageUtils page = aboutusService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, aboutus), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     * 根据传入的参数进行查询，并返回关于我们的列表结果。
     * 使用EntityWrapper构建查询条件，包括模糊查询和排序等。
     */
    @RequestMapping("/lists")
    public R list( AboutusEntity aboutus){
       	EntityWrapper<AboutusEntity> ew = new EntityWrapper<AboutusEntity>();
      	ew.allEq(MPUtil.allEQMapPre( aboutus, "aboutus")); 
        return R.ok().put("data", aboutusService.selectListView(ew));
    }

	 /**
     * 查询
      * 根据传入的参数进行查询，并返回关于我们的详细信息。
      * 使用EntityWrapper构建查询条件，包括模糊查询和排序等。
      * 查询结果封装为AboutusView对象，并返回给前端。
     */
    @RequestMapping("/query")
    public R query(AboutusEntity aboutus){
        EntityWrapper< AboutusEntity> ew = new EntityWrapper< AboutusEntity>();
 		ew.allEq(MPUtil.allEQMapPre( aboutus, "aboutus")); 
		AboutusView aboutusView =  aboutusService.selectView(ew);
		return R.ok("查询关于我们成功").put("data", aboutusView);
    }
	
    /**
     * 后端详情
     * 后端详情
     * 根据传入的id参数，查询关于我们的详细信息，并返回给前端。
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        AboutusEntity aboutus = aboutusService.selectById(id);
        return R.ok().put("data", aboutus);
    }

    /**
     * 前端详情
     * 根据传入的id参数，查询关于我们的详细信息，并返回给前端。
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        AboutusEntity aboutus = aboutusService.selectById(id);
        return R.ok().put("data", aboutus);
    }
    



    /**
     * 后端保存
     * 将传入的关于我们对象保存到数据库中。
     * 使用ValidatorUtils对关于我们对象进行校验。
     */
    @RequestMapping("/save")
    public R save(@RequestBody AboutusEntity aboutus, HttpServletRequest request){
    	aboutus.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(aboutus);
        aboutusService.insert(aboutus);
        return R.ok();
    }
    
    /**
     * 前端保存
     * 将传入的关于我们对象保存到数据库中。
     * 使用ValidatorUtils对关于我们对象进行校验。
     */
    @RequestMapping("/add")
    public R add(@RequestBody AboutusEntity aboutus, HttpServletRequest request){
    	aboutus.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(aboutus);
        aboutusService.insert(aboutus);
        return R.ok();
    }



    /**
     * 修改
     * 根据传入的关于我们对象的id，更新数据库中对应的记录。
     * 使用ValidatorUtils对关于我们对象进行校验。
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody AboutusEntity aboutus, HttpServletRequest request){
        //ValidatorUtils.validateEntity(aboutus);
        aboutusService.updateById(aboutus);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     * 根据传入的id数组，删除数据库中对应的记录。
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        aboutusService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
