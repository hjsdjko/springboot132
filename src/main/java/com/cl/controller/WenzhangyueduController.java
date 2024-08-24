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

import com.cl.entity.WenzhangyueduEntity;
import com.cl.entity.view.WenzhangyueduView;

import com.cl.service.WenzhangyueduService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 文章阅读
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-26 10:05:10
 */
@RestController
@RequestMapping("/wenzhangyuedu")
public class WenzhangyueduController {
    @Autowired
    private WenzhangyueduService wenzhangyueduService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WenzhangyueduEntity wenzhangyuedu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			wenzhangyuedu.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			wenzhangyuedu.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<WenzhangyueduEntity> ew = new EntityWrapper<WenzhangyueduEntity>();

		PageUtils page = wenzhangyueduService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wenzhangyuedu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WenzhangyueduEntity wenzhangyuedu, 
		HttpServletRequest request){
        EntityWrapper<WenzhangyueduEntity> ew = new EntityWrapper<WenzhangyueduEntity>();

		PageUtils page = wenzhangyueduService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wenzhangyuedu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WenzhangyueduEntity wenzhangyuedu){
       	EntityWrapper<WenzhangyueduEntity> ew = new EntityWrapper<WenzhangyueduEntity>();
      	ew.allEq(MPUtil.allEQMapPre( wenzhangyuedu, "wenzhangyuedu")); 
        return R.ok().put("data", wenzhangyueduService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WenzhangyueduEntity wenzhangyuedu){
        EntityWrapper< WenzhangyueduEntity> ew = new EntityWrapper< WenzhangyueduEntity>();
 		ew.allEq(MPUtil.allEQMapPre( wenzhangyuedu, "wenzhangyuedu")); 
		WenzhangyueduView wenzhangyueduView =  wenzhangyueduService.selectView(ew);
		return R.ok("查询文章阅读成功").put("data", wenzhangyueduView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WenzhangyueduEntity wenzhangyuedu = wenzhangyueduService.selectById(id);
		wenzhangyuedu = wenzhangyueduService.selectView(new EntityWrapper<WenzhangyueduEntity>().eq("id", id));
        return R.ok().put("data", wenzhangyuedu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WenzhangyueduEntity wenzhangyuedu = wenzhangyueduService.selectById(id);
		wenzhangyuedu = wenzhangyueduService.selectView(new EntityWrapper<WenzhangyueduEntity>().eq("id", id));
        return R.ok().put("data", wenzhangyuedu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WenzhangyueduEntity wenzhangyuedu, HttpServletRequest request){
    	wenzhangyuedu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wenzhangyuedu);
        wenzhangyueduService.insert(wenzhangyuedu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WenzhangyueduEntity wenzhangyuedu, HttpServletRequest request){
    	wenzhangyuedu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wenzhangyuedu);
        wenzhangyueduService.insert(wenzhangyuedu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WenzhangyueduEntity wenzhangyuedu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wenzhangyuedu);
        wenzhangyueduService.updateById(wenzhangyuedu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        wenzhangyueduService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
