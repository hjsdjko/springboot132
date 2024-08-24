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


import com.cl.dao.WenzhangleixingDao;
import com.cl.entity.WenzhangleixingEntity;
import com.cl.service.WenzhangleixingService;
import com.cl.entity.view.WenzhangleixingView;

@Service("wenzhangleixingService")
public class WenzhangleixingServiceImpl extends ServiceImpl<WenzhangleixingDao, WenzhangleixingEntity> implements WenzhangleixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WenzhangleixingEntity> page = this.selectPage(
                new Query<WenzhangleixingEntity>(params).getPage(),
                new EntityWrapper<WenzhangleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WenzhangleixingEntity> wrapper) {
		  Page<WenzhangleixingView> page =new Query<WenzhangleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<WenzhangleixingView> selectListView(Wrapper<WenzhangleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WenzhangleixingView selectView(Wrapper<WenzhangleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
