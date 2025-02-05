package com.dao;

import com.entity.JianliEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JianliVO;
import com.entity.view.JianliView;


/**
 * 简历
 * 
 * @author 
 * @email 
 * @date 2024-12-08 13:41:23
 */
public interface JianliDao extends BaseMapper<JianliEntity> {
	
	List<JianliVO> selectListVO(@Param("ew") Wrapper<JianliEntity> wrapper);
	
	JianliVO selectVO(@Param("ew") Wrapper<JianliEntity> wrapper);
	
	List<JianliView> selectListView(@Param("ew") Wrapper<JianliEntity> wrapper);

	List<JianliView> selectListView(Pagination page,@Param("ew") Wrapper<JianliEntity> wrapper);

	
	JianliView selectView(@Param("ew") Wrapper<JianliEntity> wrapper);
	

}
