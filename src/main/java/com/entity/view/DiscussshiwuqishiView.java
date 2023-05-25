package com.entity.view;

import com.entity.DiscussshiwuqishiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 失物启事评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-10 11:49:04
 */
@TableName("discussshiwuqishi")
public class DiscussshiwuqishiView  extends DiscussshiwuqishiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussshiwuqishiView(){
	}
 
 	public DiscussshiwuqishiView(DiscussshiwuqishiEntity discussshiwuqishiEntity){
 	try {
			BeanUtils.copyProperties(this, discussshiwuqishiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
