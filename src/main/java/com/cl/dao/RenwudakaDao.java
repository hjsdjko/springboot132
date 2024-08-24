package com.cl.dao;

import com.cl.entity.RenwudakaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.RenwudakaView;


/**
 * 任务打卡
 * 
 * @author 
 * @email 
 * @date 2024-03-26 10:05:10
 */
public interface RenwudakaDao extends BaseMapper<RenwudakaEntity> {
	
	List<RenwudakaView> selectListView(@Param("ew") Wrapper<RenwudakaEntity> wrapper);

	List<RenwudakaView> selectListView(Pagination page,@Param("ew") Wrapper<RenwudakaEntity> wrapper);
	
	RenwudakaView selectView(@Param("ew") Wrapper<RenwudakaEntity> wrapper);
	

}
