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


import com.dao.DiscussshiwuqishiDao;
import com.entity.DiscussshiwuqishiEntity;
import com.service.DiscussshiwuqishiService;
import com.entity.vo.DiscussshiwuqishiVO;
import com.entity.view.DiscussshiwuqishiView;

@Service("discussshiwuqishiService")
public class DiscussshiwuqishiServiceImpl extends ServiceImpl<DiscussshiwuqishiDao, DiscussshiwuqishiEntity> implements DiscussshiwuqishiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussshiwuqishiEntity> page = this.selectPage(
                new Query<DiscussshiwuqishiEntity>(params).getPage(),
                new EntityWrapper<DiscussshiwuqishiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussshiwuqishiEntity> wrapper) {
		  Page<DiscussshiwuqishiView> page =new Query<DiscussshiwuqishiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussshiwuqishiVO> selectListVO(Wrapper<DiscussshiwuqishiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussshiwuqishiVO selectVO(Wrapper<DiscussshiwuqishiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussshiwuqishiView> selectListView(Wrapper<DiscussshiwuqishiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussshiwuqishiView selectView(Wrapper<DiscussshiwuqishiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
