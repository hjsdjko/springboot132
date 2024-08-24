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

import com.cl.entity.WenzhangleixingEntity;
import com.cl.entity.view.WenzhangleixingView;

import com.cl.service.WenzhangleixingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 文章类型
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-26 10:05:10
 */
@RestController
@RequestMapping("/wenzhangleixing")
public class WenzhangleixingController {
    @Autowired
    private WenzhangleixingService wenzhangleixingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WenzhangleixingEntity wenzhangleixing,
		HttpServletRequest request){
        EntityWrapper<WenzhangleixingEntity> ew = new EntityWrapper<WenzhangleixingEntity>();

		PageUtils page = wenzhangleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wenzhangleixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WenzhangleixingEntity wenzhangleixing, 
		HttpServletRequest request){
        EntityWrapper<WenzhangleixingEntity> ew = new EntityWrapper<WenzhangleixingEntity>();

		PageUtils page = wenzhangleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wenzhangleixing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WenzhangleixingEntity wenzhangleixing){
       	EntityWrapper<WenzhangleixingEntity> ew = new EntityWrapper<WenzhangleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( wenzhangleixing, "wenzhangleixing")); 
        return R.ok().put("data", wenzhangleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WenzhangleixingEntity wenzhangleixing){
        EntityWrapper< WenzhangleixingEntity> ew = new EntityWrapper< WenzhangleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( wenzhangleixing, "wenzhangleixing")); 
		WenzhangleixingView wenzhangleixingView =  wenzhangleixingService.selectView(ew);
		return R.ok("查询文章类型成功").put("data", wenzhangleixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WenzhangleixingEntity wenzhangleixing = wenzhangleixingService.selectById(id);
		wenzhangleixing = wenzhangleixingService.selectView(new EntityWrapper<WenzhangleixingEntity>().eq("id", id));
        return R.ok().put("data", wenzhangleixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WenzhangleixingEntity wenzhangleixing = wenzhangleixingService.selectById(id);
		wenzhangleixing = wenzhangleixingService.selectView(new EntityWrapper<WenzhangleixingEntity>().eq("id", id));
        return R.ok().put("data", wenzhangleixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WenzhangleixingEntity wenzhangleixing, HttpServletRequest request){
    	wenzhangleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wenzhangleixing);
        wenzhangleixingService.insert(wenzhangleixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WenzhangleixingEntity wenzhangleixing, HttpServletRequest request){
    	wenzhangleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wenzhangleixing);
        wenzhangleixingService.insert(wenzhangleixing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WenzhangleixingEntity wenzhangleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wenzhangleixing);
        wenzhangleixingService.updateById(wenzhangleixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        wenzhangleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
