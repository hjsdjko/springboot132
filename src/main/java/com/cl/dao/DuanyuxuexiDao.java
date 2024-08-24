package com.cl.dao;

import com.cl.entity.DuanyuxuexiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DuanyuxuexiView;


/**
 * 短语学习
 * 
 * @author 
 * @email 
 * @date 2024-03-26 10:05:10
 */
public interface DuanyuxuexiDao extends BaseMapper<DuanyuxuexiEntity> {
	
	List<DuanyuxuexiView> selectListView(@Param("ew") Wrapper<DuanyuxuexiEntity> wrapper);

	List<DuanyuxuexiView> selectListView(Pagination page,@Param("ew") Wrapper<DuanyuxuexiEntity> wrapper);
	
	DuanyuxuexiView selectView(@Param("ew") Wrapper<DuanyuxuexiEntity> wrapper);
	

}
