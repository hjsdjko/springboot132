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

import com.cl.entity.YufafenleiEntity;
import com.cl.entity.view.YufafenleiView;

import com.cl.service.YufafenleiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 语法分类
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-26 10:05:09
 */
@RestController
@RequestMapping("/yufafenlei")
public class YufafenleiController {
    @Autowired
    private YufafenleiService yufafenleiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YufafenleiEntity yufafenlei,
		HttpServletRequest request){
        EntityWrapper<YufafenleiEntity> ew = new EntityWrapper<YufafenleiEntity>();

		PageUtils page = yufafenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yufafenlei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YufafenleiEntity yufafenlei, 
		HttpServletRequest request){
        EntityWrapper<YufafenleiEntity> ew = new EntityWrapper<YufafenleiEntity>();

		PageUtils page = yufafenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yufafenlei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YufafenleiEntity yufafenlei){
       	EntityWrapper<YufafenleiEntity> ew = new EntityWrapper<YufafenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yufafenlei, "yufafenlei")); 
        return R.ok().put("data", yufafenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YufafenleiEntity yufafenlei){
        EntityWrapper< YufafenleiEntity> ew = new EntityWrapper< YufafenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yufafenlei, "yufafenlei")); 
		YufafenleiView yufafenleiView =  yufafenleiService.selectView(ew);
		return R.ok("查询语法分类成功").put("data", yufafenleiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YufafenleiEntity yufafenlei = yufafenleiService.selectById(id);
		yufafenlei = yufafenleiService.selectView(new EntityWrapper<YufafenleiEntity>().eq("id", id));
        return R.ok().put("data", yufafenlei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YufafenleiEntity yufafenlei = yufafenleiService.selectById(id);
		yufafenlei = yufafenleiService.selectView(new EntityWrapper<YufafenleiEntity>().eq("id", id));
        return R.ok().put("data", yufafenlei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YufafenleiEntity yufafenlei, HttpServletRequest request){
    	yufafenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yufafenlei);
        yufafenleiService.insert(yufafenlei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YufafenleiEntity yufafenlei, HttpServletRequest request){
    	yufafenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yufafenlei);
        yufafenleiService.insert(yufafenlei);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YufafenleiEntity yufafenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yufafenlei);
        yufafenleiService.updateById(yufafenlei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yufafenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
