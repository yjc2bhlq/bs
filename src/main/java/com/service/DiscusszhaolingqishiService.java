package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusszhaolingqishiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusszhaolingqishiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusszhaolingqishiView;


/**
 * 招领启事评论表
 *
 * @author 
 * @email 
 * @date 2023-05-10 11:49:04
 */
public interface DiscusszhaolingqishiService extends IService<DiscusszhaolingqishiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusszhaolingqishiVO> selectListVO(Wrapper<DiscusszhaolingqishiEntity> wrapper);
   	
   	DiscusszhaolingqishiVO selectVO(@Param("ew") Wrapper<DiscusszhaolingqishiEntity> wrapper);
   	
   	List<DiscusszhaolingqishiView> selectListView(Wrapper<DiscusszhaolingqishiEntity> wrapper);
   	
   	DiscusszhaolingqishiView selectView(@Param("ew") Wrapper<DiscusszhaolingqishiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusszhaolingqishiEntity> wrapper);
   	

}

