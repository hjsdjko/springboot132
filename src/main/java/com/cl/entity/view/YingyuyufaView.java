package com.cl.entity.view;

import com.cl.entity.YingyuyufaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 英语语法
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-26 10:05:09
 */
@TableName("yingyuyufa")
public class YingyuyufaView  extends YingyuyufaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YingyuyufaView(){
	}
 
 	public YingyuyufaView(YingyuyufaEntity yingyuyufaEntity){
 	try {
			BeanUtils.copyProperties(this, yingyuyufaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
