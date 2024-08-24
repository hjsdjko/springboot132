package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YingyuwenzhangEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YingyuwenzhangView;


/**
 * 英语文章
 *
 * @author 
 * @email 
 * @date 2024-03-26 10:05:10
 */
public interface YingyuwenzhangService extends IService<YingyuwenzhangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YingyuwenzhangView> selectListView(Wrapper<YingyuwenzhangEntity> wrapper);
   	
   	YingyuwenzhangView selectView(@Param("ew") Wrapper<YingyuwenzhangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YingyuwenzhangEntity> wrapper);
   	

}

