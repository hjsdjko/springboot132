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


import com.cl.dao.YingyuyufaDao;
import com.cl.entity.YingyuyufaEntity;
import com.cl.service.YingyuyufaService;
import com.cl.entity.view.YingyuyufaView;

@Service("yingyuyufaService")
public class YingyuyufaServiceImpl extends ServiceImpl<YingyuyufaDao, YingyuyufaEntity> implements YingyuyufaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YingyuyufaEntity> page = this.selectPage(
                new Query<YingyuyufaEntity>(params).getPage(),
                new EntityWrapper<YingyuyufaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YingyuyufaEntity> wrapper) {
		  Page<YingyuyufaView> page =new Query<YingyuyufaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YingyuyufaView> selectListView(Wrapper<YingyuyufaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YingyuyufaView selectView(Wrapper<YingyuyufaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
