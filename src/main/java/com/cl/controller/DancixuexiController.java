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

import com.cl.entity.DancixuexiEntity;
import com.cl.entity.view.DancixuexiView;

import com.cl.service.DancixuexiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 单词学习
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-26 10:05:09
 */
@RestController
@RequestMapping("/dancixuexi")
public class DancixuexiController {
    @Autowired
    private DancixuexiService dancixuexiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DancixuexiEntity dancixuexi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			dancixuexi.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiaoshi")) {
			dancixuexi.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<DancixuexiEntity> ew = new EntityWrapper<DancixuexiEntity>();

		PageUtils page = dancixuexiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dancixuexi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DancixuexiEntity dancixuexi, 
		HttpServletRequest request){
        EntityWrapper<DancixuexiEntity> ew = new EntityWrapper<DancixuexiEntity>();

		PageUtils page = dancixuexiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dancixuexi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DancixuexiEntity dancixuexi){
       	EntityWrapper<DancixuexiEntity> ew = new EntityWrapper<DancixuexiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dancixuexi, "dancixuexi")); 
        return R.ok().put("data", dancixuexiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DancixuexiEntity dancixuexi){
        EntityWrapper< DancixuexiEntity> ew = new EntityWrapper< DancixuexiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dancixuexi, "dancixuexi")); 
		DancixuexiView dancixuexiView =  dancixuexiService.selectView(ew);
		return R.ok("查询单词学习成功").put("data", dancixuexiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DancixuexiEntity dancixuexi = dancixuexiService.selectById(id);
		dancixuexi = dancixuexiService.selectView(new EntityWrapper<DancixuexiEntity>().eq("id", id));
        return R.ok().put("data", dancixuexi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DancixuexiEntity dancixuexi = dancixuexiService.selectById(id);
		dancixuexi = dancixuexiService.selectView(new EntityWrapper<DancixuexiEntity>().eq("id", id));
        return R.ok().put("data", dancixuexi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DancixuexiEntity dancixuexi, HttpServletRequest request){
    	dancixuexi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dancixuexi);
        dancixuexiService.insert(dancixuexi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DancixuexiEntity dancixuexi, HttpServletRequest request){
    	dancixuexi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dancixuexi);
        dancixuexiService.insert(dancixuexi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DancixuexiEntity dancixuexi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dancixuexi);
        dancixuexiService.updateById(dancixuexi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dancixuexiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
