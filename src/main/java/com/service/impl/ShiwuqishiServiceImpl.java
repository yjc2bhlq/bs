package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ShiwuqishiDao;
import com.entity.ShiwuqishiEntity;
import com.service.ShiwuqishiService;
import com.entity.vo.ShiwuqishiVO;
import com.entity.view.ShiwuqishiView;

@Service("shiwuqishiService")
public class ShiwuqishiServiceImpl extends ServiceImpl<ShiwuqishiDao, ShiwuqishiEntity> implements ShiwuqishiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShiwuqishiEntity> page = this.selectPage(
                new Query<ShiwuqishiEntity>(params).getPage(),
                new EntityWrapper<ShiwuqishiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShiwuqishiEntity> wrapper) {
		  Page<ShiwuqishiView> page =new Query<ShiwuqishiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShiwuqishiVO> selectListVO(Wrapper<ShiwuqishiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShiwuqishiVO selectVO(Wrapper<ShiwuqishiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShiwuqishiView> selectListView(Wrapper<ShiwuqishiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShiwuqishiView selectView(Wrapper<ShiwuqishiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
