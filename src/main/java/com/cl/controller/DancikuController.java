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

import com.cl.entity.DancikuEntity;
import com.cl.entity.view.DancikuView;

import com.cl.service.DancikuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 单词库
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-26 10:05:09
 */
@RestController
@RequestMapping("/danciku")
public class DancikuController {
    @Autowired
    private DancikuService dancikuService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DancikuEntity danciku,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			danciku.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<DancikuEntity> ew = new EntityWrapper<DancikuEntity>();

		PageUtils page = dancikuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, danciku), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DancikuEntity danciku, 
		HttpServletRequest request){
        EntityWrapper<DancikuEntity> ew = new EntityWrapper<DancikuEntity>();

		PageUtils page = dancikuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, danciku), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DancikuEntity danciku){
       	EntityWrapper<DancikuEntity> ew = new EntityWrapper<DancikuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( danciku, "danciku")); 
        return R.ok().put("data", dancikuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DancikuEntity danciku){
        EntityWrapper< DancikuEntity> ew = new EntityWrapper< DancikuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( danciku, "danciku")); 
		DancikuView dancikuView =  dancikuService.selectView(ew);
		return R.ok("查询单词库成功").put("data", dancikuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DancikuEntity danciku = dancikuService.selectById(id);
		danciku = dancikuService.selectView(new EntityWrapper<DancikuEntity>().eq("id", id));
        return R.ok().put("data", danciku);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DancikuEntity danciku = dancikuService.selectById(id);
		danciku = dancikuService.selectView(new EntityWrapper<DancikuEntity>().eq("id", id));
        return R.ok().put("data", danciku);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DancikuEntity danciku, HttpServletRequest request){
    	danciku.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(danciku);
        dancikuService.insert(danciku);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DancikuEntity danciku, HttpServletRequest request){
    	danciku.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(danciku);
        dancikuService.insert(danciku);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DancikuEntity danciku, HttpServletRequest request){
        //ValidatorUtils.validateEntity(danciku);
        dancikuService.updateById(danciku);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dancikuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
