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

import com.cl.entity.DancileixingEntity;
import com.cl.entity.view.DancileixingView;

import com.cl.service.DancileixingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 单词类型
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-26 10:05:09
 */
@RestController
@RequestMapping("/dancileixing")
public class DancileixingController {
    @Autowired
    private DancileixingService dancileixingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DancileixingEntity dancileixing,
		HttpServletRequest request){
        EntityWrapper<DancileixingEntity> ew = new EntityWrapper<DancileixingEntity>();

		PageUtils page = dancileixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dancileixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DancileixingEntity dancileixing, 
		HttpServletRequest request){
        EntityWrapper<DancileixingEntity> ew = new EntityWrapper<DancileixingEntity>();

		PageUtils page = dancileixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dancileixing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DancileixingEntity dancileixing){
       	EntityWrapper<DancileixingEntity> ew = new EntityWrapper<DancileixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dancileixing, "dancileixing")); 
        return R.ok().put("data", dancileixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DancileixingEntity dancileixing){
        EntityWrapper< DancileixingEntity> ew = new EntityWrapper< DancileixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dancileixing, "dancileixing")); 
		DancileixingView dancileixingView =  dancileixingService.selectView(ew);
		return R.ok("查询单词类型成功").put("data", dancileixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DancileixingEntity dancileixing = dancileixingService.selectById(id);
		dancileixing = dancileixingService.selectView(new EntityWrapper<DancileixingEntity>().eq("id", id));
        return R.ok().put("data", dancileixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DancileixingEntity dancileixing = dancileixingService.selectById(id);
		dancileixing = dancileixingService.selectView(new EntityWrapper<DancileixingEntity>().eq("id", id));
        return R.ok().put("data", dancileixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DancileixingEntity dancileixing, HttpServletRequest request){
    	dancileixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dancileixing);
        dancileixingService.insert(dancileixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DancileixingEntity dancileixing, HttpServletRequest request){
    	dancileixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dancileixing);
        dancileixingService.insert(dancileixing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DancileixingEntity dancileixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dancileixing);
        dancileixingService.updateById(dancileixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dancileixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
