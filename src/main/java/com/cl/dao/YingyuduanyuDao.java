package com.cl.dao;

import com.cl.entity.YingyuduanyuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YingyuduanyuView;


/**
 * 英语短语
 * 
 * @author 
 * @email 
 * @date 2024-03-26 10:05:10
 */
public interface YingyuduanyuDao extends BaseMapper<YingyuduanyuEntity> {
	
	List<YingyuduanyuView> selectListView(@Param("ew") Wrapper<YingyuduanyuEntity> wrapper);

	List<YingyuduanyuView> selectListView(Pagination page,@Param("ew") Wrapper<YingyuduanyuEntity> wrapper);
	
	YingyuduanyuView selectView(@Param("ew") Wrapper<YingyuduanyuEntity> wrapper);
	

}
