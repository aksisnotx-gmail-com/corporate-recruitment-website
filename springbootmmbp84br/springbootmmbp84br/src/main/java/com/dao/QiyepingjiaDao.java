package com.dao;

import com.entity.QiyepingjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.QiyepingjiaVO;
import com.entity.view.QiyepingjiaView;


/**
 * 企业评价
 * 
 * @author 
 * @email 
 * @date 2024-12-08 13:41:24
 */
public interface QiyepingjiaDao extends BaseMapper<QiyepingjiaEntity> {
	
	List<QiyepingjiaVO> selectListVO(@Param("ew") Wrapper<QiyepingjiaEntity> wrapper);
	
	QiyepingjiaVO selectVO(@Param("ew") Wrapper<QiyepingjiaEntity> wrapper);
	
	List<QiyepingjiaView> selectListView(@Param("ew") Wrapper<QiyepingjiaEntity> wrapper);

	List<QiyepingjiaView> selectListView(Pagination page,@Param("ew") Wrapper<QiyepingjiaEntity> wrapper);

	
	QiyepingjiaView selectView(@Param("ew") Wrapper<QiyepingjiaEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<QiyepingjiaEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<QiyepingjiaEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<QiyepingjiaEntity> wrapper);



}
