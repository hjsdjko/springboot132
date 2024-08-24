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


import com.cl.dao.DancixuexiDao;
import com.cl.entity.DancixuexiEntity;
import com.cl.service.DancixuexiService;
import com.cl.entity.view.DancixuexiView;

@Service("dancixuexiService")
public class DancixuexiServiceImpl extends ServiceImpl<DancixuexiDao, DancixuexiEntity> implements DancixuexiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DancixuexiEntity> page = this.selectPage(
                new Query<DancixuexiEntity>(params).getPage(),
                new EntityWrapper<DancixuexiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DancixuexiEntity> wrapper) {
		  Page<DancixuexiView> page =new Query<DancixuexiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DancixuexiView> selectListView(Wrapper<DancixuexiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DancixuexiView selectView(Wrapper<DancixuexiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
