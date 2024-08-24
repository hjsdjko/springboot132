package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DancikuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DancikuView;


/**
 * 单词库
 *
 * @author 
 * @email 
 * @date 2024-03-26 10:05:09
 */
public interface DancikuService extends IService<DancikuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DancikuView> selectListView(Wrapper<DancikuEntity> wrapper);
   	
   	DancikuView selectView(@Param("ew") Wrapper<DancikuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DancikuEntity> wrapper);
   	

}

