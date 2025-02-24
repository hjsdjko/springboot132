package com.cl.entity.view;

import com.cl.entity.RenwupingjiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 任务评价
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-26 10:05:10
 */
@TableName("renwupingjia")
public class RenwupingjiaView  extends RenwupingjiaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public RenwupingjiaView(){
	}
 
 	public RenwupingjiaView(RenwupingjiaEntity renwupingjiaEntity){
 	try {
			BeanUtils.copyProperties(this, renwupingjiaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
