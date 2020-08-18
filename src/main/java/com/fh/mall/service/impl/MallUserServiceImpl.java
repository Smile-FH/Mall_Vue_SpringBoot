package com.fh.mall.service.impl;

import com.fh.mall.dao.MallUserMapper;
import com.fh.mall.entity.MallUser;
import com.fh.mall.service.MallUserService;
import com.fh.mall.utils.PageQueryUtil;
import com.fh.mall.utils.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: TODO(MallUser的业务层实现)
 * @Author HueFu
 * @Date 2020-8-2 9:52
 */
@Service
public class MallUserServiceImpl implements MallUserService {

    @Resource
    private MallUserMapper mallUserMapper;

    @Override
    public int getTotalUser(){
        return mallUserMapper.getTotalUser();
    }

    @Override
    public PageResult getListMallUser(PageQueryUtil pageQueryUtil) {
        List<MallUser> pageUser = mallUserMapper.getPageUser(pageQueryUtil);
        int totalUser = mallUserMapper.getTotalUser();
        return new PageResult(totalUser, pageUser, pageQueryUtil.getLimit(), pageQueryUtil.getCurrentPage());
    }

}
