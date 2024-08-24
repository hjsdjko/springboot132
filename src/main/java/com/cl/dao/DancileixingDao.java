package com.cl.dao;

import com.cl.entity.DancileixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DancileixingView;


/**
 * 单词类型
 * 
 * @author 
 * @email 
 * @date 2024-03-26 10:05:09
 */
public interface DancileixingDao extends BaseMapper<DancileixingEntity> {
	
	List<DancileixingView> selectListView(@Param("ew") Wrapper<DancileixingEntity> wrapper);

	List<DancileixingView> selectListView(Pagination page,@Param("ew") Wrapper<DancileixingEntity> wrapper);
	
	DancileixingView selectView(@Param("ew") Wrapper<DancileixingEntity> wrapper);
	

}
