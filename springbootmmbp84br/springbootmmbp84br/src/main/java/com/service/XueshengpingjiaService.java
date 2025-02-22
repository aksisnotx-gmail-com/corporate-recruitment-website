package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XueshengpingjiaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XueshengpingjiaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XueshengpingjiaView;


/**
 * 学生评价
 *
 * @author 
 * @email 
 * @date 2024-12-08 13:41:24
 */
public interface XueshengpingjiaService extends IService<XueshengpingjiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XueshengpingjiaVO> selectListVO(Wrapper<XueshengpingjiaEntity> wrapper);
   	
   	XueshengpingjiaVO selectVO(@Param("ew") Wrapper<XueshengpingjiaEntity> wrapper);
   	
   	List<XueshengpingjiaView> selectListView(Wrapper<XueshengpingjiaEntity> wrapper);
   	
   	XueshengpingjiaView selectView(@Param("ew") Wrapper<XueshengpingjiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XueshengpingjiaEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<XueshengpingjiaEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<XueshengpingjiaEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<XueshengpingjiaEntity> wrapper);



}

