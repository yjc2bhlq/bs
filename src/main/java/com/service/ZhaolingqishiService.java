package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhaolingqishiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhaolingqishiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhaolingqishiView;


/**
 * 招领启事
 *
 * @author 
 * @email 
 * @date 2023-05-10 11:49:03
 */
public interface ZhaolingqishiService extends IService<ZhaolingqishiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhaolingqishiVO> selectListVO(Wrapper<ZhaolingqishiEntity> wrapper);
   	
   	ZhaolingqishiVO selectVO(@Param("ew") Wrapper<ZhaolingqishiEntity> wrapper);
   	
   	List<ZhaolingqishiView> selectListView(Wrapper<ZhaolingqishiEntity> wrapper);
   	
   	ZhaolingqishiView selectView(@Param("ew") Wrapper<ZhaolingqishiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhaolingqishiEntity> wrapper);
   	

}

