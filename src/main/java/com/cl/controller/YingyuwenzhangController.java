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

import com.cl.entity.YingyuwenzhangEntity;
import com.cl.entity.view.YingyuwenzhangView;

import com.cl.service.YingyuwenzhangService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 英语文章
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-26 10:05:10
 */
@RestController
@RequestMapping("/yingyuwenzhang")
public class YingyuwenzhangController {
    @Autowired
    private YingyuwenzhangService yingyuwenzhangService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YingyuwenzhangEntity yingyuwenzhang,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			yingyuwenzhang.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YingyuwenzhangEntity> ew = new EntityWrapper<YingyuwenzhangEntity>();

		PageUtils page = yingyuwenzhangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yingyuwenzhang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YingyuwenzhangEntity yingyuwenzhang, 
		HttpServletRequest request){
        EntityWrapper<YingyuwenzhangEntity> ew = new EntityWrapper<YingyuwenzhangEntity>();

		PageUtils page = yingyuwenzhangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yingyuwenzhang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YingyuwenzhangEntity yingyuwenzhang){
       	EntityWrapper<YingyuwenzhangEntity> ew = new EntityWrapper<YingyuwenzhangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yingyuwenzhang, "yingyuwenzhang")); 
        return R.ok().put("data", yingyuwenzhangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YingyuwenzhangEntity yingyuwenzhang){
        EntityWrapper< YingyuwenzhangEntity> ew = new EntityWrapper< YingyuwenzhangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yingyuwenzhang, "yingyuwenzhang")); 
		YingyuwenzhangView yingyuwenzhangView =  yingyuwenzhangService.selectView(ew);
		return R.ok("查询英语文章成功").put("data", yingyuwenzhangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YingyuwenzhangEntity yingyuwenzhang = yingyuwenzhangService.selectById(id);
		yingyuwenzhang = yingyuwenzhangService.selectView(new EntityWrapper<YingyuwenzhangEntity>().eq("id", id));
        return R.ok().put("data", yingyuwenzhang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YingyuwenzhangEntity yingyuwenzhang = yingyuwenzhangService.selectById(id);
		yingyuwenzhang = yingyuwenzhangService.selectView(new EntityWrapper<YingyuwenzhangEntity>().eq("id", id));
        return R.ok().put("data", yingyuwenzhang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YingyuwenzhangEntity yingyuwenzhang, HttpServletRequest request){
    	yingyuwenzhang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yingyuwenzhang);
        yingyuwenzhangService.insert(yingyuwenzhang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YingyuwenzhangEntity yingyuwenzhang, HttpServletRequest request){
    	yingyuwenzhang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yingyuwenzhang);
        yingyuwenzhangService.insert(yingyuwenzhang);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YingyuwenzhangEntity yingyuwenzhang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yingyuwenzhang);
        yingyuwenzhangService.updateById(yingyuwenzhang);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yingyuwenzhangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
