package com.cl.entity.view;

import com.cl.entity.WenzhangleixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 文章类型
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-26 10:05:10
 */
@TableName("wenzhangleixing")
public class WenzhangleixingView  extends WenzhangleixingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public WenzhangleixingView(){
	}
 
 	public WenzhangleixingView(WenzhangleixingEntity wenzhangleixingEntity){
 	try {
			BeanUtils.copyProperties(this, wenzhangleixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
