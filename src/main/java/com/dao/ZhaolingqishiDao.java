package com.dao;

import com.entity.ZhaolingqishiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhaolingqishiVO;
import com.entity.view.ZhaolingqishiView;


/**
 * 招领启事
 * 
 * @author 
 * @email 
 * @date 2023-05-10 11:49:03
 */
public interface ZhaolingqishiDao extends BaseMapper<ZhaolingqishiEntity> {
	
	List<ZhaolingqishiVO> selectListVO(@Param("ew") Wrapper<ZhaolingqishiEntity> wrapper);
	
	ZhaolingqishiVO selectVO(@Param("ew") Wrapper<ZhaolingqishiEntity> wrapper);
	
	List<ZhaolingqishiView> selectListView(@Param("ew") Wrapper<ZhaolingqishiEntity> wrapper);

	List<ZhaolingqishiView> selectListView(Pagination page,@Param("ew") Wrapper<ZhaolingqishiEntity> wrapper);
	
	ZhaolingqishiView selectView(@Param("ew") Wrapper<ZhaolingqishiEntity> wrapper);
	

}
