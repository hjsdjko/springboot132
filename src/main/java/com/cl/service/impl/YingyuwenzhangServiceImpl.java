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


import com.cl.dao.YingyuwenzhangDao;
import com.cl.entity.YingyuwenzhangEntity;
import com.cl.service.YingyuwenzhangService;
import com.cl.entity.view.YingyuwenzhangView;

@Service("yingyuwenzhangService")
public class YingyuwenzhangServiceImpl extends ServiceImpl<YingyuwenzhangDao, YingyuwenzhangEntity> implements YingyuwenzhangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YingyuwenzhangEntity> page = this.selectPage(
                new Query<YingyuwenzhangEntity>(params).getPage(),
                new EntityWrapper<YingyuwenzhangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YingyuwenzhangEntity> wrapper) {
		  Page<YingyuwenzhangView> page =new Query<YingyuwenzhangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YingyuwenzhangView> selectListView(Wrapper<YingyuwenzhangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YingyuwenzhangView selectView(Wrapper<YingyuwenzhangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
