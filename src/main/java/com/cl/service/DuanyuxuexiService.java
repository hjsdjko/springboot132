package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DuanyuxuexiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DuanyuxuexiView;


/**
 * 短语学习
 *
 * @author 
 * @email 
 * @date 2024-03-26 10:05:10
 */
public interface DuanyuxuexiService extends IService<DuanyuxuexiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DuanyuxuexiView> selectListView(Wrapper<DuanyuxuexiEntity> wrapper);
   	
   	DuanyuxuexiView selectView(@Param("ew") Wrapper<DuanyuxuexiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DuanyuxuexiEntity> wrapper);
   	

}

