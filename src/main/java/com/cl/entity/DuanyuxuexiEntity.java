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
 * 短语学习
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-26 10:05:10
 */
@TableName("duanyuxuexi")
public class DuanyuxuexiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public DuanyuxuexiEntity() {
		
	}
	
	public DuanyuxuexiEntity(T t) {
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
	 * 短语
	 */
					
	private String duanyu;
	
	/**
	 * 翻译
	 */
					
	private String fanyi;
	
	/**
	 * 用法
	 */
					
	private String yongfa;
	
	/**
	 * 例句
	 */
					
	private String liju;
	
	/**
	 * 发音
	 */
					
	private String fayin;
	
	/**
	 * 教师工号
	 */
					
	private String jiaoshigonghao;
	
	/**
	 * 教师姓名
	 */
					
	private String jiaoshixingming;
	
	/**
	 * 学号
	 */
					
	private String xuehao;
	
	/**
	 * 学生姓名
	 */
					
	private String xueshengxingming;
	
	/**
	 * 学习时长
	 */
					
	private Double xuexishizhang;
	
	/**
	 * 学习内容
	 */
					
	private String xuexineirong;
	
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
	 * 设置：短语
	 */
	public void setDuanyu(String duanyu) {
		this.duanyu = duanyu;
	}
	/**
	 * 获取：短语
	 */
	public String getDuanyu() {
		return duanyu;
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
	 * 设置：用法
	 */
	public void setYongfa(String yongfa) {
		this.yongfa = yongfa;
	}
	/**
	 * 获取：用法
	 */
	public String getYongfa() {
		return yongfa;
	}
	/**
	 * 设置：例句
	 */
	public void setLiju(String liju) {
		this.liju = liju;
	}
	/**
	 * 获取：例句
	 */
	public String getLiju() {
		return liju;
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
	 * 设置：学习时长
	 */
	public void setXuexishizhang(Double xuexishizhang) {
		this.xuexishizhang = xuexishizhang;
	}
	/**
	 * 获取：学习时长
	 */
	public Double getXuexishizhang() {
		return xuexishizhang;
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
