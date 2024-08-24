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


import com.cl.dao.XuexirenwuDao;
import com.cl.entity.XuexirenwuEntity;
import com.cl.service.XuexirenwuService;
import com.cl.entity.view.XuexirenwuView;

@Service("xuexirenwuService")
public class XuexirenwuServiceImpl extends ServiceImpl<XuexirenwuDao, XuexirenwuEntity> implements XuexirenwuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XuexirenwuEntity> page = this.selectPage(
                new Query<XuexirenwuEntity>(params).getPage(),
                new EntityWrapper<XuexirenwuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XuexirenwuEntity> wrapper) {
		  Page<XuexirenwuView> page =new Query<XuexirenwuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XuexirenwuView> selectListView(Wrapper<XuexirenwuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XuexirenwuView selectView(Wrapper<XuexirenwuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
