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

import com.cl.entity.YufaxuexiEntity;
import com.cl.entity.view.YufaxuexiView;

import com.cl.service.YufaxuexiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 语法学习
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-26 10:05:10
 */
@RestController
@RequestMapping("/yufaxuexi")
public class YufaxuexiController {
    @Autowired
    private YufaxuexiService yufaxuexiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YufaxuexiEntity yufaxuexi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			yufaxuexi.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiaoshi")) {
			yufaxuexi.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YufaxuexiEntity> ew = new EntityWrapper<YufaxuexiEntity>();

		PageUtils page = yufaxuexiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yufaxuexi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YufaxuexiEntity yufaxuexi, 
		HttpServletRequest request){
        EntityWrapper<YufaxuexiEntity> ew = new EntityWrapper<YufaxuexiEntity>();

		PageUtils page = yufaxuexiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yufaxuexi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YufaxuexiEntity yufaxuexi){
       	EntityWrapper<YufaxuexiEntity> ew = new EntityWrapper<YufaxuexiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yufaxuexi, "yufaxuexi")); 
        return R.ok().put("data", yufaxuexiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YufaxuexiEntity yufaxuexi){
        EntityWrapper< YufaxuexiEntity> ew = new EntityWrapper< YufaxuexiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yufaxuexi, "yufaxuexi")); 
		YufaxuexiView yufaxuexiView =  yufaxuexiService.selectView(ew);
		return R.ok("查询语法学习成功").put("data", yufaxuexiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YufaxuexiEntity yufaxuexi = yufaxuexiService.selectById(id);
		yufaxuexi = yufaxuexiService.selectView(new EntityWrapper<YufaxuexiEntity>().eq("id", id));
        return R.ok().put("data", yufaxuexi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YufaxuexiEntity yufaxuexi = yufaxuexiService.selectById(id);
		yufaxuexi = yufaxuexiService.selectView(new EntityWrapper<YufaxuexiEntity>().eq("id", id));
        return R.ok().put("data", yufaxuexi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YufaxuexiEntity yufaxuexi, HttpServletRequest request){
    	yufaxuexi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yufaxuexi);
        yufaxuexiService.insert(yufaxuexi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YufaxuexiEntity yufaxuexi, HttpServletRequest request){
    	yufaxuexi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yufaxuexi);
        yufaxuexiService.insert(yufaxuexi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YufaxuexiEntity yufaxuexi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yufaxuexi);
        yufaxuexiService.updateById(yufaxuexi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yufaxuexiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
