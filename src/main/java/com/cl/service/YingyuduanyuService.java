package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YingyuduanyuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YingyuduanyuView;


/**
 * 英语短语
 *
 * @author 
 * @email 
 * @date 2024-03-26 10:05:10
 */
public interface YingyuduanyuService extends IService<YingyuduanyuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YingyuduanyuView> selectListView(Wrapper<YingyuduanyuEntity> wrapper);
   	
   	YingyuduanyuView selectView(@Param("ew") Wrapper<YingyuduanyuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YingyuduanyuEntity> wrapper);
   	

}

