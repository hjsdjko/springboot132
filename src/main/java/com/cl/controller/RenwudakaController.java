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

import com.cl.entity.RenwudakaEntity;
import com.cl.entity.view.RenwudakaView;

import com.cl.service.RenwudakaService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 任务打卡
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-26 10:05:10
 */
@RestController
@RequestMapping("/renwudaka")
public class RenwudakaController {
    @Autowired
    private RenwudakaService renwudakaService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,RenwudakaEntity renwudaka,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			renwudaka.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			renwudaka.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<RenwudakaEntity> ew = new EntityWrapper<RenwudakaEntity>();

		PageUtils page = renwudakaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, renwudaka), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,RenwudakaEntity renwudaka, 
		HttpServletRequest request){
        EntityWrapper<RenwudakaEntity> ew = new EntityWrapper<RenwudakaEntity>();

		PageUtils page = renwudakaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, renwudaka), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( RenwudakaEntity renwudaka){
       	EntityWrapper<RenwudakaEntity> ew = new EntityWrapper<RenwudakaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( renwudaka, "renwudaka")); 
        return R.ok().put("data", renwudakaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(RenwudakaEntity renwudaka){
        EntityWrapper< RenwudakaEntity> ew = new EntityWrapper< RenwudakaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( renwudaka, "renwudaka")); 
		RenwudakaView renwudakaView =  renwudakaService.selectView(ew);
		return R.ok("查询任务打卡成功").put("data", renwudakaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        RenwudakaEntity renwudaka = renwudakaService.selectById(id);
		renwudaka = renwudakaService.selectView(new EntityWrapper<RenwudakaEntity>().eq("id", id));
        return R.ok().put("data", renwudaka);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        RenwudakaEntity renwudaka = renwudakaService.selectById(id);
		renwudaka = renwudakaService.selectView(new EntityWrapper<RenwudakaEntity>().eq("id", id));
        return R.ok().put("data", renwudaka);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RenwudakaEntity renwudaka, HttpServletRequest request){
    	renwudaka.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(renwudaka);
        renwudakaService.insert(renwudaka);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody RenwudakaEntity renwudaka, HttpServletRequest request){
    	renwudaka.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(renwudaka);
        renwudakaService.insert(renwudaka);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody RenwudakaEntity renwudaka, HttpServletRequest request){
        //ValidatorUtils.validateEntity(renwudaka);
        renwudakaService.updateById(renwudaka);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        renwudakaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
