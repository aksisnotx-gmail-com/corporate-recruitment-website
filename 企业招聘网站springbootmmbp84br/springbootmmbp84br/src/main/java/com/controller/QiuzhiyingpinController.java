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

import com.entity.QiuzhiyingpinEntity;
import com.entity.view.QiuzhiyingpinView;

import com.service.QiuzhiyingpinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 求职应聘
 * 后端接口
 * @author 
 * @email 
 * @date 2024-12-08 13:41:24
 */
@RestController
@RequestMapping("/qiuzhiyingpin")
public class QiuzhiyingpinController {
    @Autowired
    private QiuzhiyingpinService qiuzhiyingpinService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QiuzhiyingpinEntity qiuzhiyingpin,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qiye")) {
			qiuzhiyingpin.setQiyezhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			qiuzhiyingpin.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<QiuzhiyingpinEntity> ew = new EntityWrapper<QiuzhiyingpinEntity>();

		PageUtils page = qiuzhiyingpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qiuzhiyingpin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QiuzhiyingpinEntity qiuzhiyingpin, 
		HttpServletRequest request){
        EntityWrapper<QiuzhiyingpinEntity> ew = new EntityWrapper<QiuzhiyingpinEntity>();

		PageUtils page = qiuzhiyingpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qiuzhiyingpin), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QiuzhiyingpinEntity qiuzhiyingpin){
       	EntityWrapper<QiuzhiyingpinEntity> ew = new EntityWrapper<QiuzhiyingpinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( qiuzhiyingpin, "qiuzhiyingpin")); 
        return R.ok().put("data", qiuzhiyingpinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QiuzhiyingpinEntity qiuzhiyingpin){
        EntityWrapper< QiuzhiyingpinEntity> ew = new EntityWrapper< QiuzhiyingpinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( qiuzhiyingpin, "qiuzhiyingpin")); 
		QiuzhiyingpinView qiuzhiyingpinView =  qiuzhiyingpinService.selectView(ew);
		return R.ok("查询求职应聘成功").put("data", qiuzhiyingpinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QiuzhiyingpinEntity qiuzhiyingpin = qiuzhiyingpinService.selectById(id);
        return R.ok().put("data", qiuzhiyingpin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QiuzhiyingpinEntity qiuzhiyingpin = qiuzhiyingpinService.selectById(id);
        return R.ok().put("data", qiuzhiyingpin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QiuzhiyingpinEntity qiuzhiyingpin, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(qiuzhiyingpin);
        qiuzhiyingpinService.insert(qiuzhiyingpin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QiuzhiyingpinEntity qiuzhiyingpin, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(qiuzhiyingpin);
        qiuzhiyingpinService.insert(qiuzhiyingpin);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody QiuzhiyingpinEntity qiuzhiyingpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qiuzhiyingpin);
        qiuzhiyingpinService.updateById(qiuzhiyingpin);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<QiuzhiyingpinEntity> list = new ArrayList<QiuzhiyingpinEntity>();
        for(Long id : ids) {
            QiuzhiyingpinEntity qiuzhiyingpin = qiuzhiyingpinService.selectById(id);
            qiuzhiyingpin.setSfsh(sfsh);
            qiuzhiyingpin.setShhf(shhf);
            list.add(qiuzhiyingpin);
        }
        qiuzhiyingpinService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        qiuzhiyingpinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	






    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<QiuzhiyingpinEntity> ew = new EntityWrapper<QiuzhiyingpinEntity>();
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qiye")) {
            ew.eq("qiyezhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
            ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
		}
        List<Map<String, Object>> result = qiuzhiyingpinService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<QiuzhiyingpinEntity> ew = new EntityWrapper<QiuzhiyingpinEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiye")) {
            ew.eq("qiyezhanghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("yonghu")) {
            ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = qiuzhiyingpinService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<QiuzhiyingpinEntity> ew = new EntityWrapper<QiuzhiyingpinEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiye")) {
            ew.eq("qiyezhanghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("yonghu")) {
            ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = qiuzhiyingpinService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<QiuzhiyingpinEntity> ew = new EntityWrapper<QiuzhiyingpinEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiye")) {
            ew.eq("qiyezhanghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("yonghu")) {
            ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = qiuzhiyingpinService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<QiuzhiyingpinEntity> ew = new EntityWrapper<QiuzhiyingpinEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("qiye")) {
            ew.eq("qiyezhanghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("yonghu")) {
            ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = qiuzhiyingpinService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }







}
