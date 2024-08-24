package com.cl.dao;

import com.cl.entity.RenwupingjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.RenwupingjiaView;


/**
 * 任务评价
 * 
 * @author 
 * @email 
 * @date 2024-03-26 10:05:10
 */
public interface RenwupingjiaDao extends BaseMapper<RenwupingjiaEntity> {
	
	List<RenwupingjiaView> selectListView(@Param("ew") Wrapper<RenwupingjiaEntity> wrapper);

	List<RenwupingjiaView> selectListView(Pagination page,@Param("ew") Wrapper<RenwupingjiaEntity> wrapper);
	
	RenwupingjiaView selectView(@Param("ew") Wrapper<RenwupingjiaEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<RenwupingjiaEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<RenwupingjiaEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<RenwupingjiaEntity> wrapper);



}
