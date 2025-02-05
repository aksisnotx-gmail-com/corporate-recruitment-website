package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.QiyepingjiaDao;
import com.entity.QiyepingjiaEntity;
import com.service.QiyepingjiaService;
import com.entity.vo.QiyepingjiaVO;
import com.entity.view.QiyepingjiaView;

@Service("qiyepingjiaService")
public class QiyepingjiaServiceImpl extends ServiceImpl<QiyepingjiaDao, QiyepingjiaEntity> implements QiyepingjiaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QiyepingjiaEntity> page = this.selectPage(
                new Query<QiyepingjiaEntity>(params).getPage(),
                new EntityWrapper<QiyepingjiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QiyepingjiaEntity> wrapper) {
		  Page<QiyepingjiaView> page =new Query<QiyepingjiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<QiyepingjiaVO> selectListVO(Wrapper<QiyepingjiaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QiyepingjiaVO selectVO(Wrapper<QiyepingjiaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QiyepingjiaView> selectListView(Wrapper<QiyepingjiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QiyepingjiaView selectView(Wrapper<QiyepingjiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<QiyepingjiaEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<QiyepingjiaEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<QiyepingjiaEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
