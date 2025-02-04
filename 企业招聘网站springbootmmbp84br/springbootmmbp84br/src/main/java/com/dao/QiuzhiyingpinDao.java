package com.dao;

import com.entity.QiuzhiyingpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.QiuzhiyingpinVO;
import com.entity.view.QiuzhiyingpinView;


/**
 * 求职应聘
 * 
 * @author 
 * @email 
 * @date 2024-12-08 13:41:24
 */
public interface QiuzhiyingpinDao extends BaseMapper<QiuzhiyingpinEntity> {
	
	List<QiuzhiyingpinVO> selectListVO(@Param("ew") Wrapper<QiuzhiyingpinEntity> wrapper);
	
	QiuzhiyingpinVO selectVO(@Param("ew") Wrapper<QiuzhiyingpinEntity> wrapper);
	
	List<QiuzhiyingpinView> selectListView(@Param("ew") Wrapper<QiuzhiyingpinEntity> wrapper);

	List<QiuzhiyingpinView> selectListView(Pagination page,@Param("ew") Wrapper<QiuzhiyingpinEntity> wrapper);

	
	QiuzhiyingpinView selectView(@Param("ew") Wrapper<QiuzhiyingpinEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<QiuzhiyingpinEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<QiuzhiyingpinEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<QiuzhiyingpinEntity> wrapper);



}
