package com.entity.view;

import com.entity.ShiwuqishiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 失物启事
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-10 11:49:03
 */
@TableName("shiwuqishi")
public class ShiwuqishiView  extends ShiwuqishiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShiwuqishiView(){
	}
 
 	public ShiwuqishiView(ShiwuqishiEntity shiwuqishiEntity){
 	try {
			BeanUtils.copyProperties(this, shiwuqishiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
