package com.cl.entity.view;

import com.cl.entity.RenwudakaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 任务打卡
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-26 10:05:10
 */
@TableName("renwudaka")
public class RenwudakaView  extends RenwudakaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public RenwudakaView(){
	}
 
 	public RenwudakaView(RenwudakaEntity renwudakaEntity){
 	try {
			BeanUtils.copyProperties(this, renwudakaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
