package com.dao;

import com.entity.DiscussshiwuqishiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussshiwuqishiVO;
import com.entity.view.DiscussshiwuqishiView;


/**
 * 失物启事评论表
 * 
 * @author 
 * @email 
 * @date 2023-05-10 11:49:04
 */
public interface DiscussshiwuqishiDao extends BaseMapper<DiscussshiwuqishiEntity> {
	
	List<DiscussshiwuqishiVO> selectListVO(@Param("ew") Wrapper<DiscussshiwuqishiEntity> wrapper);
	
	DiscussshiwuqishiVO selectVO(@Param("ew") Wrapper<DiscussshiwuqishiEntity> wrapper);
	
	List<DiscussshiwuqishiView> selectListView(@Param("ew") Wrapper<DiscussshiwuqishiEntity> wrapper);

	List<DiscussshiwuqishiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussshiwuqishiEntity> wrapper);
	
	DiscussshiwuqishiView selectView(@Param("ew") Wrapper<DiscussshiwuqishiEntity> wrapper);
	

}
