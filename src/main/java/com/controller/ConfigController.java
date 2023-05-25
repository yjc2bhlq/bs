
package com.controller;


import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.ConfigEntity;
import com.service.ConfigService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 登录相关
 */
@RequestMapping("config")
@RestController
public class ConfigController{
	
	@Autowired
	private ConfigService configService;

	/**
     * 列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ConfigEntity config){
        EntityWrapper<ConfigEntity> ew = new EntityWrapper<ConfigEntity>();
    	PageUtils page = configService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, config), params), params));
        return R.ok().put("data", page);
    }
    
	/**
     * 列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ConfigEntity config){
        EntityWrapper<ConfigEntity> ew = new EntityWrapper<ConfigEntity>();
    	PageUtils page = configService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, config), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        ConfigEntity config = configService.selectById(id);
        return R.ok().put("data", config);
    }
    
    /**
     * 详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        ConfigEntity config = configService.selectById(id);
        return R.ok().put("data", config);
    }
    
    /**
     * 根据name获取信息
     */
    @RequestMapping("/info")
    public R infoByName(@RequestParam String name){
        ConfigEntity config = configService.selectOne(new EntityWrapper<ConfigEntity>().eq("name", "faceFile"));
        return R.ok().put("data", config);
    }
    
    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody ConfigEntity config){
//    	ValidatorUtils.validateEntity(config);
    	configService.insert(config);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ConfigEntity config){
//        ValidatorUtils.validateEntity(config);
        configService.updateById(config);//全部更新
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
    	configService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}
/**
 * page: 分页查询配置列表。通过请求参数进行分页查询，并返回分页结果。
 * list: 查询配置列表。与 page 方法类似，但不进行分页，返回所有符合
 * info/{id}: 根据ID获取配置信息。根据传入的ID参数查询对应的配置信息，并返回结果。
 * detail/{id}: 根据ID获取配置详情。与 info/{id} 方法相似，用于获取配置的详细信息。
 * info: 根据名称获取配置信息。根据传入的名称参数查询对应的配置信息，并返回结果。
 * save: 保存配置。将传入的配置实体保存到数据库中。
 * update: 修改配置。根据传入的配置实体进行更新操作，将修改后的配置保存到数据库中。
 * delete: 删除配置。根据传入的ID数组，批量删除对应的配置信息。
 */