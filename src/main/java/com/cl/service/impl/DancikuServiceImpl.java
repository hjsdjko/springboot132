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


import com.cl.dao.DancikuDao;
import com.cl.entity.DancikuEntity;
import com.cl.service.DancikuService;
import com.cl.entity.view.DancikuView;

@Service("dancikuService")
public class DancikuServiceImpl extends ServiceImpl<DancikuDao, DancikuEntity> implements DancikuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DancikuEntity> page = this.selectPage(
                new Query<DancikuEntity>(params).getPage(),
                new EntityWrapper<DancikuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DancikuEntity> wrapper) {
		  Page<DancikuView> page =new Query<DancikuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DancikuView> selectListView(Wrapper<DancikuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DancikuView selectView(Wrapper<DancikuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
