package com.cl.dao;

import com.cl.entity.YingyuwenzhangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YingyuwenzhangView;


/**
 * 英语文章
 * 
 * @author 
 * @email 
 * @date 2024-03-26 10:05:10
 */
public interface YingyuwenzhangDao extends BaseMapper<YingyuwenzhangEntity> {
	
	List<YingyuwenzhangView> selectListView(@Param("ew") Wrapper<YingyuwenzhangEntity> wrapper);

	List<YingyuwenzhangView> selectListView(Pagination page,@Param("ew") Wrapper<YingyuwenzhangEntity> wrapper);
	
	YingyuwenzhangView selectView(@Param("ew") Wrapper<YingyuwenzhangEntity> wrapper);
	

}
