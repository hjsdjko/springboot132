package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.WenzhangyueduEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WenzhangyueduView;


/**
 * 文章阅读
 *
 * @author 
 * @email 
 * @date 2024-03-26 10:05:10
 */
public interface WenzhangyueduService extends IService<WenzhangyueduEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WenzhangyueduView> selectListView(Wrapper<WenzhangyueduEntity> wrapper);
   	
   	WenzhangyueduView selectView(@Param("ew") Wrapper<WenzhangyueduEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WenzhangyueduEntity> wrapper);
   	

}

