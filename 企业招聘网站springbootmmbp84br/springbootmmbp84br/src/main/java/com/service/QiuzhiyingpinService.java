package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.QiuzhiyingpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.QiuzhiyingpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.QiuzhiyingpinView;


/**
 * 求职应聘
 *
 * @author 
 * @email 
 * @date 2024-12-08 13:41:24
 */
public interface QiuzhiyingpinService extends IService<QiuzhiyingpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QiuzhiyingpinVO> selectListVO(Wrapper<QiuzhiyingpinEntity> wrapper);
   	
   	QiuzhiyingpinVO selectVO(@Param("ew") Wrapper<QiuzhiyingpinEntity> wrapper);
   	
   	List<QiuzhiyingpinView> selectListView(Wrapper<QiuzhiyingpinEntity> wrapper);
   	
   	QiuzhiyingpinView selectView(@Param("ew") Wrapper<QiuzhiyingpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QiuzhiyingpinEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<QiuzhiyingpinEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<QiuzhiyingpinEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<QiuzhiyingpinEntity> wrapper);



}

