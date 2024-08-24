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


import com.cl.dao.YufaxuexiDao;
import com.cl.entity.YufaxuexiEntity;
import com.cl.service.YufaxuexiService;
import com.cl.entity.view.YufaxuexiView;

@Service("yufaxuexiService")
public class YufaxuexiServiceImpl extends ServiceImpl<YufaxuexiDao, YufaxuexiEntity> implements YufaxuexiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YufaxuexiEntity> page = this.selectPage(
                new Query<YufaxuexiEntity>(params).getPage(),
                new EntityWrapper<YufaxuexiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YufaxuexiEntity> wrapper) {
		  Page<YufaxuexiView> page =new Query<YufaxuexiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YufaxuexiView> selectListView(Wrapper<YufaxuexiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YufaxuexiView selectView(Wrapper<YufaxuexiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
