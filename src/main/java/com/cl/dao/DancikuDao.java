package com.cl.dao;

import com.cl.entity.DancikuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DancikuView;


/**
 * 单词库
 * 
 * @author 
 * @email 
 * @date 2024-03-26 10:05:09
 */
public interface DancikuDao extends BaseMapper<DancikuEntity> {
	
	List<DancikuView> selectListView(@Param("ew") Wrapper<DancikuEntity> wrapper);

	List<DancikuView> selectListView(Pagination page,@Param("ew") Wrapper<DancikuEntity> wrapper);
	
	DancikuView selectView(@Param("ew") Wrapper<DancikuEntity> wrapper);
	

}
