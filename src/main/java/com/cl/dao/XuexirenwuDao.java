package com.cl.dao;

import com.cl.entity.XuexirenwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XuexirenwuView;


/**
 * 学习任务
 * 
 * @author 
 * @email 
 * @date 2024-03-26 10:05:10
 */
public interface XuexirenwuDao extends BaseMapper<XuexirenwuEntity> {
	
	List<XuexirenwuView> selectListView(@Param("ew") Wrapper<XuexirenwuEntity> wrapper);

	List<XuexirenwuView> selectListView(Pagination page,@Param("ew") Wrapper<XuexirenwuEntity> wrapper);
	
	XuexirenwuView selectView(@Param("ew") Wrapper<XuexirenwuEntity> wrapper);
	

}
