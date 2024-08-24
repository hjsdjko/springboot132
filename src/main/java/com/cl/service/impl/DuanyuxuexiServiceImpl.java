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


import com.cl.dao.DuanyuxuexiDao;
import com.cl.entity.DuanyuxuexiEntity;
import com.cl.service.DuanyuxuexiService;
import com.cl.entity.view.DuanyuxuexiView;

@Service("duanyuxuexiService")
public class DuanyuxuexiServiceImpl extends ServiceImpl<DuanyuxuexiDao, DuanyuxuexiEntity> implements DuanyuxuexiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DuanyuxuexiEntity> page = this.selectPage(
                new Query<DuanyuxuexiEntity>(params).getPage(),
                new EntityWrapper<DuanyuxuexiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DuanyuxuexiEntity> wrapper) {
		  Page<DuanyuxuexiView> page =new Query<DuanyuxuexiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DuanyuxuexiView> selectListView(Wrapper<DuanyuxuexiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DuanyuxuexiView selectView(Wrapper<DuanyuxuexiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
