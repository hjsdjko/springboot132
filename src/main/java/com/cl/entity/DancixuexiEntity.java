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
 * 单词学习
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-26 10:05:09
 */
@TableName("dancixuexi")
public class DancixuexiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public DancixuexiEntity() {
		
	}
	
	public DancixuexiEntity(T t) {
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
	 * 学生时长
	 */
					
	private Double xueshengshizhang;
	
	/**
	 * 学习内容
	 */
					
	private String xuexineirong;
	
	/**
	 * 学号
	 */
					
	private String xuehao;
	
	/**
	 * 学生姓名
	 */
					
	private String xueshengxingming;
	
	/**
	 * 教师工号
	 */
					
	private String jiaoshigonghao;
	
	/**
	 * 教师姓名
	 */
					
	private String jiaoshixingming;
	
	/**
	 * 学习时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date xuexishijian;
	
	
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
	 * 设置：学生时长
	 */
	public void setXueshengshizhang(Double xueshengshizhang) {
		this.xueshengshizhang = xueshengshizhang;
	}
	/**
	 * 获取：学生时长
	 */
	public Double getXueshengshizhang() {
		return xueshengshizhang;
	}
	/**
	 * 设置：学习内容
	 */
	public void setXuexineirong(String xuexineirong) {
		this.xuexineirong = xuexineirong;
	}
	/**
	 * 获取：学习内容
	 */
	public String getXuexineirong() {
		return xuexineirong;
	}
	/**
	 * 设置：学号
	 */
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	/**
	 * 获取：学号
	 */
	public String getXuehao() {
		return xuehao;
	}
	/**
	 * 设置：学生姓名
	 */
	public void setXueshengxingming(String xueshengxingming) {
		this.xueshengxingming = xueshengxingming;
	}
	/**
	 * 获取：学生姓名
	 */
	public String getXueshengxingming() {
		return xueshengxingming;
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
	/**
	 * 设置：学习时间
	 */
	public void setXuexishijian(Date xuexishijian) {
		this.xuexishijian = xuexishijian;
	}
	/**
	 * 获取：学习时间
	 */
	public Date getXuexishijian() {
		return xuexishijian;
	}

}
