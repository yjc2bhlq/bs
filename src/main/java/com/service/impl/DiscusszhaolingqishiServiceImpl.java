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


import com.dao.DiscusszhaolingqishiDao;
import com.entity.DiscusszhaolingqishiEntity;
import com.service.DiscusszhaolingqishiService;
import com.entity.vo.DiscusszhaolingqishiVO;
import com.entity.view.DiscusszhaolingqishiView;

@Service("discusszhaolingqishiService")
public class DiscusszhaolingqishiServiceImpl extends ServiceImpl<DiscusszhaolingqishiDao, DiscusszhaolingqishiEntity> implements DiscusszhaolingqishiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusszhaolingqishiEntity> page = this.selectPage(
                new Query<DiscusszhaolingqishiEntity>(params).getPage(),
                new EntityWrapper<DiscusszhaolingqishiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusszhaolingqishiEntity> wrapper) {
		  Page<DiscusszhaolingqishiView> page =new Query<DiscusszhaolingqishiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusszhaolingqishiVO> selectListVO(Wrapper<DiscusszhaolingqishiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusszhaolingqishiVO selectVO(Wrapper<DiscusszhaolingqishiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusszhaolingqishiView> selectListView(Wrapper<DiscusszhaolingqishiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusszhaolingqishiView selectView(Wrapper<DiscusszhaolingqishiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
