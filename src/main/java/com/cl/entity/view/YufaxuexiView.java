package com.cl.entity.view;

import com.cl.entity.YufaxuexiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 语法学习
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-26 10:05:10
 */
@TableName("yufaxuexi")
public class YufaxuexiView  extends YufaxuexiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YufaxuexiView(){
	}
 
 	public YufaxuexiView(YufaxuexiEntity yufaxuexiEntity){
 	try {
			BeanUtils.copyProperties(this, yufaxuexiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
