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


import com.dao.ZhaolingqishiDao;
import com.entity.ZhaolingqishiEntity;
import com.service.ZhaolingqishiService;
import com.entity.vo.ZhaolingqishiVO;
import com.entity.view.ZhaolingqishiView;

@Service("zhaolingqishiService")
public class ZhaolingqishiServiceImpl extends ServiceImpl<ZhaolingqishiDao, ZhaolingqishiEntity> implements ZhaolingqishiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhaolingqishiEntity> page = this.selectPage(
                new Query<ZhaolingqishiEntity>(params).getPage(),
                new EntityWrapper<ZhaolingqishiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhaolingqishiEntity> wrapper) {
		  Page<ZhaolingqishiView> page =new Query<ZhaolingqishiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhaolingqishiVO> selectListVO(Wrapper<ZhaolingqishiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhaolingqishiVO selectVO(Wrapper<ZhaolingqishiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhaolingqishiView> selectListView(Wrapper<ZhaolingqishiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhaolingqishiView selectView(Wrapper<ZhaolingqishiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
