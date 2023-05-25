package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 认领信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-05-10 11:49:03
 */
@TableName("renlingxinxi")
public class RenlingxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public RenlingxinxiEntity() {
		
	}
	
	public RenlingxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 认领编号
	 */
					
	private String renlingbianhao;
	
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
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：认领编号
	 */
	public void setRenlingbianhao(String renlingbianhao) {
		this.renlingbianhao = renlingbianhao;
	}
	/**
	 * 获取：认领编号
	 */
	public String getRenlingbianhao() {
		return renlingbianhao;
	}
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
