package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.RenwudakaEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.RenwudakaView;


/**
 * 任务打卡
 *
 * @author 
 * @email 
 * @date 2024-03-26 10:05:10
 */
public interface RenwudakaService extends IService<RenwudakaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<RenwudakaView> selectListView(Wrapper<RenwudakaEntity> wrapper);
   	
   	RenwudakaView selectView(@Param("ew") Wrapper<RenwudakaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<RenwudakaEntity> wrapper);
   	

}

