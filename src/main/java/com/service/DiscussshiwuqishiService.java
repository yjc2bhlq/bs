package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussshiwuqishiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussshiwuqishiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussshiwuqishiView;


/**
 * 失物启事评论表
 *
 * @author 
 * @email 
 * @date 2023-05-10 11:49:04
 */
public interface DiscussshiwuqishiService extends IService<DiscussshiwuqishiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussshiwuqishiVO> selectListVO(Wrapper<DiscussshiwuqishiEntity> wrapper);
   	
   	DiscussshiwuqishiVO selectVO(@Param("ew") Wrapper<DiscussshiwuqishiEntity> wrapper);
   	
   	List<DiscussshiwuqishiView> selectListView(Wrapper<DiscussshiwuqishiEntity> wrapper);
   	
   	DiscussshiwuqishiView selectView(@Param("ew") Wrapper<DiscussshiwuqishiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussshiwuqishiEntity> wrapper);
   	

}

