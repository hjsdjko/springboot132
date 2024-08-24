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


import com.cl.dao.RenwudakaDao;
import com.cl.entity.RenwudakaEntity;
import com.cl.service.RenwudakaService;
import com.cl.entity.view.RenwudakaView;

@Service("renwudakaService")
public class RenwudakaServiceImpl extends ServiceImpl<RenwudakaDao, RenwudakaEntity> implements RenwudakaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RenwudakaEntity> page = this.selectPage(
                new Query<RenwudakaEntity>(params).getPage(),
                new EntityWrapper<RenwudakaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<RenwudakaEntity> wrapper) {
		  Page<RenwudakaView> page =new Query<RenwudakaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<RenwudakaView> selectListView(Wrapper<RenwudakaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public RenwudakaView selectView(Wrapper<RenwudakaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
