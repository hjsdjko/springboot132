package com.cl.entity.view;

import com.cl.entity.XuexirenwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 学习任务
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-26 10:05:10
 */
@TableName("xuexirenwu")
public class XuexirenwuView  extends XuexirenwuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XuexirenwuView(){
	}
 
 	public XuexirenwuView(XuexirenwuEntity xuexirenwuEntity){
 	try {
			BeanUtils.copyProperties(this, xuexirenwuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
