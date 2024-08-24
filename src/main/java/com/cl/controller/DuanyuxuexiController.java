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

import com.cl.entity.DuanyuxuexiEntity;
import com.cl.entity.view.DuanyuxuexiView;

import com.cl.service.DuanyuxuexiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 短语学习
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-26 10:05:10
 */
@RestController
@RequestMapping("/duanyuxuexi")
public class DuanyuxuexiController {
    @Autowired
    private DuanyuxuexiService duanyuxuexiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DuanyuxuexiEntity duanyuxuexi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			duanyuxuexi.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			duanyuxuexi.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<DuanyuxuexiEntity> ew = new EntityWrapper<DuanyuxuexiEntity>();

		PageUtils page = duanyuxuexiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, duanyuxuexi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DuanyuxuexiEntity duanyuxuexi, 
		HttpServletRequest request){
        EntityWrapper<DuanyuxuexiEntity> ew = new EntityWrapper<DuanyuxuexiEntity>();

		PageUtils page = duanyuxuexiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, duanyuxuexi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DuanyuxuexiEntity duanyuxuexi){
       	EntityWrapper<DuanyuxuexiEntity> ew = new EntityWrapper<DuanyuxuexiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( duanyuxuexi, "duanyuxuexi")); 
        return R.ok().put("data", duanyuxuexiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DuanyuxuexiEntity duanyuxuexi){
        EntityWrapper< DuanyuxuexiEntity> ew = new EntityWrapper< DuanyuxuexiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( duanyuxuexi, "duanyuxuexi")); 
		DuanyuxuexiView duanyuxuexiView =  duanyuxuexiService.selectView(ew);
		return R.ok("查询短语学习成功").put("data", duanyuxuexiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DuanyuxuexiEntity duanyuxuexi = duanyuxuexiService.selectById(id);
		duanyuxuexi = duanyuxuexiService.selectView(new EntityWrapper<DuanyuxuexiEntity>().eq("id", id));
        return R.ok().put("data", duanyuxuexi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DuanyuxuexiEntity duanyuxuexi = duanyuxuexiService.selectById(id);
		duanyuxuexi = duanyuxuexiService.selectView(new EntityWrapper<DuanyuxuexiEntity>().eq("id", id));
        return R.ok().put("data", duanyuxuexi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DuanyuxuexiEntity duanyuxuexi, HttpServletRequest request){
    	duanyuxuexi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(duanyuxuexi);
        duanyuxuexiService.insert(duanyuxuexi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DuanyuxuexiEntity duanyuxuexi, HttpServletRequest request){
    	duanyuxuexi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(duanyuxuexi);
        duanyuxuexiService.insert(duanyuxuexi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DuanyuxuexiEntity duanyuxuexi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(duanyuxuexi);
        duanyuxuexiService.updateById(duanyuxuexi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        duanyuxuexiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
