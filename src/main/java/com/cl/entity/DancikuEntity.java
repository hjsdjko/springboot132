package com.cl.entity;

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
 * 单词库
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-26 10:05:09
 */
@TableName("danciku")
public class DancikuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public DancikuEntity() {
		
	}
	
	public DancikuEntity(T t) {
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
	 * 单词名称
	 */
					
	private String dancimingcheng;
	
	/**
	 * 单词类型
	 */
					
	private String dancileixing;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 字母
	 */
					
	private String zimu;
	
	/**
	 * 音标
	 */
					
	private String yinbiao;
	
	/**
	 * 翻译
	 */
					
	private String fanyi;
	
	/**
	 * 发音
	 */
					
	private String fayin;
	
	/**
	 * 收藏数量
	 */
					
	private Integer storeupnum;
	
	/**
	 * 标签
	 */
					
	private String biaoqian;
	
	/**
	 * 教师工号
	 */
					
	private String jiaoshigonghao;
	
	/**
	 * 教师姓名
	 */
					
	private String jiaoshixingming;
	
	
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
	 * 设置：单词名称
	 */
	public void setDancimingcheng(String dancimingcheng) {
		this.dancimingcheng = dancimingcheng;
	}
	/**
	 * 获取：单词名称
	 */
	public String getDancimingcheng() {
		return dancimingcheng;
	}
	/**
	 * 设置：单词类型
	 */
	public void setDancileixing(String dancileixing) {
		this.dancileixing = dancileixing;
	}
	/**
	 * 获取：单词类型
	 */
	public String getDancileixing() {
		return dancileixing;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：字母
	 */
	public void setZimu(String zimu) {
		this.zimu = zimu;
	}
	/**
	 * 获取：字母
	 */
	public String getZimu() {
		return zimu;
	}
	/**
	 * 设置：音标
	 */
	public void setYinbiao(String yinbiao) {
		this.yinbiao = yinbiao;
	}
	/**
	 * 获取：音标
	 */
	public String getYinbiao() {
		return yinbiao;
	}
	/**
	 * 设置：翻译
	 */
	public void setFanyi(String fanyi) {
		this.fanyi = fanyi;
	}
	/**
	 * 获取：翻译
	 */
	public String getFanyi() {
		return fanyi;
	}
	/**
	 * 设置：发音
	 */
	public void setFayin(String fayin) {
		this.fayin = fayin;
	}
	/**
	 * 获取：发音
	 */
	public String getFayin() {
		return fayin;
	}
	/**
	 * 设置：收藏数量
	 */
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	/**
	 * 获取：收藏数量
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
	/**
	 * 设置：标签
	 */
	public void setBiaoqian(String biaoqian) {
		this.biaoqian = biaoqian;
	}
	/**
	 * 获取：标签
	 */
	public String getBiaoqian() {
		return biaoqian;
	}
	/**
	 * 设置：教师工号
	 */
	public void setJiaoshigonghao(String jiaoshigonghao) {
		this.jiaoshigonghao = jiaoshigonghao;
	}
	/**
	 * 获取：教师工号
	 */
	public String getJiaoshigonghao() {
		return jiaoshigonghao;
	}
	/**
	 * 设置：教师姓名
	 */
	public void setJiaoshixingming(String jiaoshixingming) {
		this.jiaoshixingming = jiaoshixingming;
	}
	/**
	 * 获取：教师姓名
	 */
	public String getJiaoshixingming() {
		return jiaoshixingming;
	}

}
