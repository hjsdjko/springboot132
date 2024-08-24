package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DancileixingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DancileixingView;


/**
 * 单词类型
 *
 * @author 
 * @email 
 * @date 2024-03-26 10:05:09
 */
public interface DancileixingService extends IService<DancileixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DancileixingView> selectListView(Wrapper<DancileixingEntity> wrapper);
   	
   	DancileixingView selectView(@Param("ew") Wrapper<DancileixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DancileixingEntity> wrapper);
   	

}

