package com.cl.dao;

import com.cl.entity.DancixuexiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DancixuexiView;


/**
 * 单词学习
 * 
 * @author 
 * @email 
 * @date 2024-03-26 10:05:09
 */
public interface DancixuexiDao extends BaseMapper<DancixuexiEntity> {
	
	List<DancixuexiView> selectListView(@Param("ew") Wrapper<DancixuexiEntity> wrapper);

	List<DancixuexiView> selectListView(Pagination page,@Param("ew") Wrapper<DancixuexiEntity> wrapper);
	
	DancixuexiView selectView(@Param("ew") Wrapper<DancixuexiEntity> wrapper);
	

}
