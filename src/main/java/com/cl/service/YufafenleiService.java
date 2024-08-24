package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YufafenleiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YufafenleiView;


/**
 * 语法分类
 *
 * @author 
 * @email 
 * @date 2024-03-26 10:05:09
 */
public interface YufafenleiService extends IService<YufafenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YufafenleiView> selectListView(Wrapper<YufafenleiEntity> wrapper);
   	
   	YufafenleiView selectView(@Param("ew") Wrapper<YufafenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YufafenleiEntity> wrapper);
   	

}

