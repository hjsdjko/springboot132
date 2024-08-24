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

import com.cl.entity.YingyuduanyuEntity;
import com.cl.entity.view.YingyuduanyuView;

import com.cl.service.YingyuduanyuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 英语短语
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-26 10:05:10
 */
@RestController
@RequestMapping("/yingyuduanyu")
public class YingyuduanyuController {
    @Autowired
    private YingyuduanyuService yingyuduanyuService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YingyuduanyuEntity yingyuduanyu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			yingyuduanyu.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YingyuduanyuEntity> ew = new EntityWrapper<YingyuduanyuEntity>();

		PageUtils page = yingyuduanyuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yingyuduanyu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YingyuduanyuEntity yingyuduanyu, 
		HttpServletRequest request){
        EntityWrapper<YingyuduanyuEntity> ew = new EntityWrapper<YingyuduanyuEntity>();

		PageUtils page = yingyuduanyuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yingyuduanyu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YingyuduanyuEntity yingyuduanyu){
       	EntityWrapper<YingyuduanyuEntity> ew = new EntityWrapper<YingyuduanyuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yingyuduanyu, "yingyuduanyu")); 
        return R.ok().put("data", yingyuduanyuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YingyuduanyuEntity yingyuduanyu){
        EntityWrapper< YingyuduanyuEntity> ew = new EntityWrapper< YingyuduanyuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yingyuduanyu, "yingyuduanyu")); 
		YingyuduanyuView yingyuduanyuView =  yingyuduanyuService.selectView(ew);
		return R.ok("查询英语短语成功").put("data", yingyuduanyuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YingyuduanyuEntity yingyuduanyu = yingyuduanyuService.selectById(id);
		yingyuduanyu = yingyuduanyuService.selectView(new EntityWrapper<YingyuduanyuEntity>().eq("id", id));
        return R.ok().put("data", yingyuduanyu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YingyuduanyuEntity yingyuduanyu = yingyuduanyuService.selectById(id);
		yingyuduanyu = yingyuduanyuService.selectView(new EntityWrapper<YingyuduanyuEntity>().eq("id", id));
        return R.ok().put("data", yingyuduanyu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YingyuduanyuEntity yingyuduanyu, HttpServletRequest request){
    	yingyuduanyu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yingyuduanyu);
        yingyuduanyuService.insert(yingyuduanyu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YingyuduanyuEntity yingyuduanyu, HttpServletRequest request){
    	yingyuduanyu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yingyuduanyu);
        yingyuduanyuService.insert(yingyuduanyu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YingyuduanyuEntity yingyuduanyu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yingyuduanyu);
        yingyuduanyuService.updateById(yingyuduanyu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yingyuduanyuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
