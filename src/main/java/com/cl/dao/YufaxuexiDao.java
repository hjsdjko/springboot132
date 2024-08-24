package com.cl.dao;

import com.cl.entity.YufaxuexiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YufaxuexiView;


/**
 * 语法学习
 * 
 * @author 
 * @email 
 * @date 2024-03-26 10:05:10
 */
public interface YufaxuexiDao extends BaseMapper<YufaxuexiEntity> {
	
	List<YufaxuexiView> selectListView(@Param("ew") Wrapper<YufaxuexiEntity> wrapper);

	List<YufaxuexiView> selectListView(Pagination page,@Param("ew") Wrapper<YufaxuexiEntity> wrapper);
	
	YufaxuexiView selectView(@Param("ew") Wrapper<YufaxuexiEntity> wrapper);
	

}
