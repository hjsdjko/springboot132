package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.RenwupingjiaEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.RenwupingjiaView;


/**
 * 任务评价
 *
 * @author 
 * @email 
 * @date 2024-03-26 10:05:10
 */
public interface RenwupingjiaService extends IService<RenwupingjiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<RenwupingjiaView> selectListView(Wrapper<RenwupingjiaEntity> wrapper);
   	
   	RenwupingjiaView selectView(@Param("ew") Wrapper<RenwupingjiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<RenwupingjiaEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<RenwupingjiaEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<RenwupingjiaEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<RenwupingjiaEntity> wrapper);



}

