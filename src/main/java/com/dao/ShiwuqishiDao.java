package com.dao;

import com.entity.ShiwuqishiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShiwuqishiVO;
import com.entity.view.ShiwuqishiView;


/**
 * 失物启事
 * 
 * @author 
 * @email 
 * @date 2023-05-10 11:49:03
 */
public interface ShiwuqishiDao extends BaseMapper<ShiwuqishiEntity> {
	
	List<ShiwuqishiVO> selectListVO(@Param("ew") Wrapper<ShiwuqishiEntity> wrapper);
	
	ShiwuqishiVO selectVO(@Param("ew") Wrapper<ShiwuqishiEntity> wrapper);
	
	List<ShiwuqishiView> selectListView(@Param("ew") Wrapper<ShiwuqishiEntity> wrapper);

	List<ShiwuqishiView> selectListView(Pagination page,@Param("ew") Wrapper<ShiwuqishiEntity> wrapper);
	
	ShiwuqishiView selectView(@Param("ew") Wrapper<ShiwuqishiEntity> wrapper);
	

}
