package com.controller;

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

import com.utils.ValidatorUtils;
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
import com.annotation.IgnoreAuth;

import com.entity.DiscussqiyeEntity;
import com.entity.view.DiscussqiyeView;

import com.service.DiscussqiyeService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 企业评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-08 13:41:25
 */
@RestController
@RequestMapping("/discussqiye")
public class DiscussqiyeController {
    @Autowired
    private DiscussqiyeService discussqiyeService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussqiyeEntity discussqiye,
		HttpServletRequest request){
        EntityWrapper<DiscussqiyeEntity> ew = new EntityWrapper<DiscussqiyeEntity>();

		PageUtils page = discussqiyeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussqiye), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussqiyeEntity discussqiye, 
		HttpServletRequest request){
        EntityWrapper<DiscussqiyeEntity> ew = new EntityWrapper<DiscussqiyeEntity>();

		PageUtils page = discussqiyeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussqiye), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussqiyeEntity discussqiye){
       	EntityWrapper<DiscussqiyeEntity> ew = new EntityWrapper<DiscussqiyeEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussqiye, "discussqiye")); 
        return R.ok().put("data", discussqiyeService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussqiyeEntity discussqiye){
        EntityWrapper< DiscussqiyeEntity> ew = new EntityWrapper< DiscussqiyeEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussqiye, "discussqiye")); 
		DiscussqiyeView discussqiyeView =  discussqiyeService.selectView(ew);
		return R.ok("查询企业评论表成功").put("data", discussqiyeView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussqiyeEntity discussqiye = discussqiyeService.selectById(id);
        return R.ok().put("data", discussqiye);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussqiyeEntity discussqiye = discussqiyeService.selectById(id);
        return R.ok().put("data", discussqiye);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussqiyeEntity discussqiye, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussqiye);
        discussqiyeService.insert(discussqiye);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussqiyeEntity discussqiye, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussqiye);
        discussqiyeService.insert(discussqiye);
        return R.ok();
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscussqiyeEntity discussqiye = discussqiyeService.selectOne(new EntityWrapper<DiscussqiyeEntity>().eq("", username));
        return R.ok().put("data", discussqiye);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussqiyeEntity discussqiye, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussqiye);
        discussqiyeService.updateById(discussqiye);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussqiyeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussqiyeEntity discussqiye, HttpServletRequest request,String pre){
        EntityWrapper<DiscussqiyeEntity> ew = new EntityWrapper<DiscussqiyeEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = discussqiyeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussqiye), params), params));
        return R.ok().put("data", page);
    }










}
