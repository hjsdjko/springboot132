package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XuexirenwuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XuexirenwuView;


/**
 * 学习任务
 *
 * @author 
 * @email 
 * @date 2024-03-26 10:05:10
 */
public interface XuexirenwuService extends IService<XuexirenwuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XuexirenwuView> selectListView(Wrapper<XuexirenwuEntity> wrapper);
   	
   	XuexirenwuView selectView(@Param("ew") Wrapper<XuexirenwuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XuexirenwuEntity> wrapper);
   	

}

