package com.cl.entity.view;

import com.cl.entity.WenzhangyueduEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 文章阅读
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-26 10:05:10
 */
@TableName("wenzhangyuedu")
public class WenzhangyueduView  extends WenzhangyueduEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public WenzhangyueduView(){
	}
 
 	public WenzhangyueduView(WenzhangyueduEntity wenzhangyueduEntity){
 	try {
			BeanUtils.copyProperties(this, wenzhangyueduEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
