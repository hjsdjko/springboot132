package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YingyuyufaEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YingyuyufaView;


/**
 * 英语语法
 *
 * @author 
 * @email 
 * @date 2024-03-26 10:05:09
 */
public interface YingyuyufaService extends IService<YingyuyufaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YingyuyufaView> selectListView(Wrapper<YingyuyufaEntity> wrapper);
   	
   	YingyuyufaView selectView(@Param("ew") Wrapper<YingyuyufaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YingyuyufaEntity> wrapper);
   	

}

