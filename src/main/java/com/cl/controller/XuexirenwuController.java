package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.XuexirenwuEntity;
import com.cl.entity.view.XuexirenwuView;

import com.cl.service.XuexirenwuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 学习任务
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-26 10:05:10
 */
@RestController
@RequestMapping("/xuexirenwu")
public class XuexirenwuController {
    @Autowired
    private XuexirenwuService xuexirenwuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XuexirenwuEntity xuexirenwu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			xuexirenwu.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			xuexirenwu.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XuexirenwuEntity> ew = new EntityWrapper<XuexirenwuEntity>();

		PageUtils page = xuexirenwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuexirenwu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XuexirenwuEntity xuexirenwu, 
		HttpServletRequest request){
        EntityWrapper<XuexirenwuEntity> ew = new EntityWrapper<XuexirenwuEntity>();

		PageUtils page = xuexirenwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuexirenwu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XuexirenwuEntity xuexirenwu){
       	EntityWrapper<XuexirenwuEntity> ew = new EntityWrapper<XuexirenwuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xuexirenwu, "xuexirenwu")); 
        return R.ok().put("data", xuexirenwuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XuexirenwuEntity xuexirenwu){
        EntityWrapper< XuexirenwuEntity> ew = new EntityWrapper< XuexirenwuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xuexirenwu, "xuexirenwu")); 
		XuexirenwuView xuexirenwuView =  xuexirenwuService.selectView(ew);
		return R.ok("查询学习任务成功").put("data", xuexirenwuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XuexirenwuEntity xuexirenwu = xuexirenwuService.selectById(id);
		xuexirenwu = xuexirenwuService.selectView(new EntityWrapper<XuexirenwuEntity>().eq("id", id));
        return R.ok().put("data", xuexirenwu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XuexirenwuEntity xuexirenwu = xuexirenwuService.selectById(id);
		xuexirenwu = xuexirenwuService.selectView(new EntityWrapper<XuexirenwuEntity>().eq("id", id));
        return R.ok().put("data", xuexirenwu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XuexirenwuEntity xuexirenwu, HttpServletRequest request){
    	xuexirenwu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xuexirenwu);
        xuexirenwuService.insert(xuexirenwu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XuexirenwuEntity xuexirenwu, HttpServletRequest request){
    	xuexirenwu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xuexirenwu);
        xuexirenwuService.insert(xuexirenwu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XuexirenwuEntity xuexirenwu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xuexirenwu);
        xuexirenwuService.updateById(xuexirenwu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xuexirenwuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
