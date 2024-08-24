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


import com.cl.dao.YingyuduanyuDao;
import com.cl.entity.YingyuduanyuEntity;
import com.cl.service.YingyuduanyuService;
import com.cl.entity.view.YingyuduanyuView;

@Service("yingyuduanyuService")
public class YingyuduanyuServiceImpl extends ServiceImpl<YingyuduanyuDao, YingyuduanyuEntity> implements YingyuduanyuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YingyuduanyuEntity> page = this.selectPage(
                new Query<YingyuduanyuEntity>(params).getPage(),
                new EntityWrapper<YingyuduanyuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YingyuduanyuEntity> wrapper) {
		  Page<YingyuduanyuView> page =new Query<YingyuduanyuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YingyuduanyuView> selectListView(Wrapper<YingyuduanyuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YingyuduanyuView selectView(Wrapper<YingyuduanyuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
