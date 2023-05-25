package com.entity.model;

import com.entity.RenlingxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 认领信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-05-10 11:49:03
 */
public class RenlingxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 标题
	 */
	
	private String biaoti;
		
	/**
	 * 分类
	 */
	
	private String fenlei;
		
	/**
	 * 拾得地点
	 */
	
	private String shidedidian;
		
	/**
	 * 用户账号
	 */
	
	private String yonghuzhanghao;
		
	/**
	 * 用户姓名
	 */
	
	private String yonghuxingming;
		
	/**
	 * 联系方式
	 */
	
	private String lianxifangshi;
		
	/**
	 * 认领时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date renlingshijian;
		
	/**
	 * 认领账号
	 */
	
	private String renlingzhanghao;
		
	/**
	 * 认领姓名
	 */
	
	private String renlingxingming;
		
	/**
	 * 认领手机
	 */
	
	private String renlingshouji;
		
	/**
	 * 备注
	 */
	
	private String beizhu;
				
	
	/**
	 * 设置：标题
	 */
	 
	public void setBiaoti(String biaoti) {
		this.biaoti = biaoti;
	}
	
	/**
	 * 获取：标题
	 */
	public String getBiaoti() {
		return biaoti;
	}
				
	
	/**
	 * 设置：分类
	 */
	 
	public void setFenlei(String fenlei) {
		this.fenlei = fenlei;
	}
	
	/**
	 * 获取：分类
	 */
	public String getFenlei() {
		return fenlei;
	}
				
	
	/**
	 * 设置：拾得地点
	 */
	 
	public void setShidedidian(String shidedidian) {
		this.shidedidian = shidedidian;
	}
	
	/**
	 * 获取：拾得地点
	 */
	public String getShidedidian() {
		return shidedidian;
	}
				
	
	/**
	 * 设置：用户账号
	 */
	 
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
				
	
	/**
	 * 设置：用户姓名
	 */
	 
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
				
	
	/**
	 * 设置：联系方式
	 */
	 
	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	
	/**
	 * 获取：联系方式
	 */
	public String getLianxifangshi() {
		return lianxifangshi;
	}
				
	
	/**
	 * 设置：认领时间
	 */
	 
	public void setRenlingshijian(Date renlingshijian) {
		this.renlingshijian = renlingshijian;
	}
	
	/**
	 * 获取：认领时间
	 */
	public Date getRenlingshijian() {
		return renlingshijian;
	}
				
	
	/**
	 * 设置：认领账号
	 */
	 
	public void setRenlingzhanghao(String renlingzhanghao) {
		this.renlingzhanghao = renlingzhanghao;
	}
	
	/**
	 * 获取：认领账号
	 */
	public String getRenlingzhanghao() {
		return renlingzhanghao;
	}
				
	
	/**
	 * 设置：认领姓名
	 */
	 
	public void setRenlingxingming(String renlingxingming) {
		this.renlingxingming = renlingxingming;
	}
	
	/**
	 * 获取：认领姓名
	 */
	public String getRenlingxingming() {
		return renlingxingming;
	}
				
	
	/**
	 * 设置：认领手机
	 */
	 
	public void setRenlingshouji(String renlingshouji) {
		this.renlingshouji = renlingshouji;
	}
	
	/**
	 * 获取：认领手机
	 */
	public String getRenlingshouji() {
		return renlingshouji;
	}
				
	
	/**
	 * 设置：备注
	 */
	 
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	
	/**
	 * 获取：备注
	 */
	public String getBeizhu() {
		return beizhu;
	}
			
}
