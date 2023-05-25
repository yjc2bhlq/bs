package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShiwuqishiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShiwuqishiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShiwuqishiView;


/**
 * 失物启事
 *
 * @author 
 * @email 
 * @date 2023-05-10 11:49:03
 */
public interface ShiwuqishiService extends IService<ShiwuqishiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShiwuqishiVO> selectListVO(Wrapper<ShiwuqishiEntity> wrapper);
   	
   	ShiwuqishiVO selectVO(@Param("ew") Wrapper<ShiwuqishiEntity> wrapper);
   	
   	List<ShiwuqishiView> selectListView(Wrapper<ShiwuqishiEntity> wrapper);
   	
   	ShiwuqishiView selectView(@Param("ew") Wrapper<ShiwuqishiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShiwuqishiEntity> wrapper);
   	

}

