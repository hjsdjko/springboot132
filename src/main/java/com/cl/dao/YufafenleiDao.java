package com.cl.dao;

import com.cl.entity.YufafenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YufafenleiView;


/**
 * 语法分类
 * 
 * @author 
 * @email 
 * @date 2024-03-26 10:05:09
 */
public interface YufafenleiDao extends BaseMapper<YufafenleiEntity> {
	
	List<YufafenleiView> selectListView(@Param("ew") Wrapper<YufafenleiEntity> wrapper);

	List<YufafenleiView> selectListView(Pagination page,@Param("ew") Wrapper<YufafenleiEntity> wrapper);
	
	YufafenleiView selectView(@Param("ew") Wrapper<YufafenleiEntity> wrapper);
	

}
