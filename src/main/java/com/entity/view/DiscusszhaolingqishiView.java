package com.entity.view;

import com.entity.DiscusszhaolingqishiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 招领启事评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-10 11:49:04
 */
@TableName("discusszhaolingqishi")
public class DiscusszhaolingqishiView  extends DiscusszhaolingqishiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusszhaolingqishiView(){
	}
 
 	public DiscusszhaolingqishiView(DiscusszhaolingqishiEntity discusszhaolingqishiEntity){
 	try {
			BeanUtils.copyProperties(this, discusszhaolingqishiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
