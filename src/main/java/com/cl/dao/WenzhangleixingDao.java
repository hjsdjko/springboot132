package com.cl.dao;

import com.cl.entity.WenzhangleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WenzhangleixingView;


/**
 * 文章类型
 * 
 * @author 
 * @email 
 * @date 2024-03-26 10:05:10
 */
public interface WenzhangleixingDao extends BaseMapper<WenzhangleixingEntity> {
	
	List<WenzhangleixingView> selectListView(@Param("ew") Wrapper<WenzhangleixingEntity> wrapper);

	List<WenzhangleixingView> selectListView(Pagination page,@Param("ew") Wrapper<WenzhangleixingEntity> wrapper);
	
	WenzhangleixingView selectView(@Param("ew") Wrapper<WenzhangleixingEntity> wrapper);
	

}
