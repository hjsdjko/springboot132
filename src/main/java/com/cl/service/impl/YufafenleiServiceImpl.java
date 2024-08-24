package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.YufafenleiDao;
import com.cl.entity.YufafenleiEntity;
import com.cl.service.YufafenleiService;
import com.cl.entity.view.YufafenleiView;

@Service("yufafenleiService")
public class YufafenleiServiceImpl extends ServiceImpl<YufafenleiDao, YufafenleiEntity> implements YufafenleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YufafenleiEntity> page = this.selectPage(
                new Query<YufafenleiEntity>(params).getPage(),
                new EntityWrapper<YufafenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YufafenleiEntity> wrapper) {
		  Page<YufafenleiView> page =new Query<YufafenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YufafenleiView> selectListView(Wrapper<YufafenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YufafenleiView selectView(Wrapper<YufafenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
