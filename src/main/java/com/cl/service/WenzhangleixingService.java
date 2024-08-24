package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.WenzhangleixingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WenzhangleixingView;


/**
 * 文章类型
 *
 * @author 
 * @email 
 * @date 2024-03-26 10:05:10
 */
public interface WenzhangleixingService extends IService<WenzhangleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WenzhangleixingView> selectListView(Wrapper<WenzhangleixingEntity> wrapper);
   	
   	WenzhangleixingView selectView(@Param("ew") Wrapper<WenzhangleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WenzhangleixingEntity> wrapper);
   	

}

