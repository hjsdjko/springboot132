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


import com.cl.dao.DancileixingDao;
import com.cl.entity.DancileixingEntity;
import com.cl.service.DancileixingService;
import com.cl.entity.view.DancileixingView;

@Service("dancileixingService")
public class DancileixingServiceImpl extends ServiceImpl<DancileixingDao, DancileixingEntity> implements DancileixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DancileixingEntity> page = this.selectPage(
                new Query<DancileixingEntity>(params).getPage(),
                new EntityWrapper<DancileixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DancileixingEntity> wrapper) {
		  Page<DancileixingView> page =new Query<DancileixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DancileixingView> selectListView(Wrapper<DancileixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DancileixingView selectView(Wrapper<DancileixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
