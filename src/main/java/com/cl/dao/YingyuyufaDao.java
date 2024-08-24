package com.cl.dao;

import com.cl.entity.YingyuyufaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YingyuyufaView;


/**
 * 英语语法
 * 
 * @author 
 * @email 
 * @date 2024-03-26 10:05:09
 */
public interface YingyuyufaDao extends BaseMapper<YingyuyufaEntity> {
	
	List<YingyuyufaView> selectListView(@Param("ew") Wrapper<YingyuyufaEntity> wrapper);

	List<YingyuyufaView> selectListView(Pagination page,@Param("ew") Wrapper<YingyuyufaEntity> wrapper);
	
	YingyuyufaView selectView(@Param("ew") Wrapper<YingyuyufaEntity> wrapper);
	

}
