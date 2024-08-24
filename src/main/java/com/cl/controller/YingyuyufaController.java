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

import com.cl.entity.YingyuyufaEntity;
import com.cl.entity.view.YingyuyufaView;

import com.cl.service.YingyuyufaService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 英语语法
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-26 10:05:09
 */
@RestController
@RequestMapping("/yingyuyufa")
public class YingyuyufaController {
    @Autowired
    private YingyuyufaService yingyuyufaService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YingyuyufaEntity yingyuyufa,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			yingyuyufa.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YingyuyufaEntity> ew = new EntityWrapper<YingyuyufaEntity>();

		PageUtils page = yingyuyufaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yingyuyufa), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YingyuyufaEntity yingyuyufa, 
		HttpServletRequest request){
        EntityWrapper<YingyuyufaEntity> ew = new EntityWrapper<YingyuyufaEntity>();

		PageUtils page = yingyuyufaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yingyuyufa), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YingyuyufaEntity yingyuyufa){
       	EntityWrapper<YingyuyufaEntity> ew = new EntityWrapper<YingyuyufaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yingyuyufa, "yingyuyufa")); 
        return R.ok().put("data", yingyuyufaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YingyuyufaEntity yingyuyufa){
        EntityWrapper< YingyuyufaEntity> ew = new EntityWrapper< YingyuyufaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yingyuyufa, "yingyuyufa")); 
		YingyuyufaView yingyuyufaView =  yingyuyufaService.selectView(ew);
		return R.ok("查询英语语法成功").put("data", yingyuyufaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YingyuyufaEntity yingyuyufa = yingyuyufaService.selectById(id);
		yingyuyufa = yingyuyufaService.selectView(new EntityWrapper<YingyuyufaEntity>().eq("id", id));
        return R.ok().put("data", yingyuyufa);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YingyuyufaEntity yingyuyufa = yingyuyufaService.selectById(id);
		yingyuyufa = yingyuyufaService.selectView(new EntityWrapper<YingyuyufaEntity>().eq("id", id));
        return R.ok().put("data", yingyuyufa);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YingyuyufaEntity yingyuyufa, HttpServletRequest request){
    	yingyuyufa.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yingyuyufa);
        yingyuyufaService.insert(yingyuyufa);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YingyuyufaEntity yingyuyufa, HttpServletRequest request){
    	yingyuyufa.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yingyuyufa);
        yingyuyufaService.insert(yingyuyufa);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YingyuyufaEntity yingyuyufa, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yingyuyufa);
        yingyuyufaService.updateById(yingyuyufa);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yingyuyufaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
