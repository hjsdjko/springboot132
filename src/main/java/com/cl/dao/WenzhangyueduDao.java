package com.cl.dao;

import com.cl.entity.WenzhangyueduEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WenzhangyueduView;


/**
 * 文章阅读
 * 
 * @author 
 * @email 
 * @date 2024-03-26 10:05:10
 */
public interface WenzhangyueduDao extends BaseMapper<WenzhangyueduEntity> {
	
	List<WenzhangyueduView> selectListView(@Param("ew") Wrapper<WenzhangyueduEntity> wrapper);

	List<WenzhangyueduView> selectListView(Pagination page,@Param("ew") Wrapper<WenzhangyueduEntity> wrapper);
	
	WenzhangyueduView selectView(@Param("ew") Wrapper<WenzhangyueduEntity> wrapper);
	

}
