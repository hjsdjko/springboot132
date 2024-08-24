package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DancixuexiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DancixuexiView;


/**
 * 单词学习
 *
 * @author 
 * @email 
 * @date 2024-03-26 10:05:09
 */
public interface DancixuexiService extends IService<DancixuexiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DancixuexiView> selectListView(Wrapper<DancixuexiEntity> wrapper);
   	
   	DancixuexiView selectView(@Param("ew") Wrapper<DancixuexiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DancixuexiEntity> wrapper);
   	

}

