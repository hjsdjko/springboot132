package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YufaxuexiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YufaxuexiView;


/**
 * 语法学习
 *
 * @author 
 * @email 
 * @date 2024-03-26 10:05:10
 */
public interface YufaxuexiService extends IService<YufaxuexiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YufaxuexiView> selectListView(Wrapper<YufaxuexiEntity> wrapper);
   	
   	YufaxuexiView selectView(@Param("ew") Wrapper<YufaxuexiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YufaxuexiEntity> wrapper);
   	

}

