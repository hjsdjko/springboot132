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


import com.cl.dao.WenzhangyueduDao;
import com.cl.entity.WenzhangyueduEntity;
import com.cl.service.WenzhangyueduService;
import com.cl.entity.view.WenzhangyueduView;

@Service("wenzhangyueduService")
public class WenzhangyueduServiceImpl extends ServiceImpl<WenzhangyueduDao, WenzhangyueduEntity> implements WenzhangyueduService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WenzhangyueduEntity> page = this.selectPage(
                new Query<WenzhangyueduEntity>(params).getPage(),
                new EntityWrapper<WenzhangyueduEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WenzhangyueduEntity> wrapper) {
		  Page<WenzhangyueduView> page =new Query<WenzhangyueduView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<WenzhangyueduView> selectListView(Wrapper<WenzhangyueduEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WenzhangyueduView selectView(Wrapper<WenzhangyueduEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
