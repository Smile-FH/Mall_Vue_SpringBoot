package com.fh.mall.service.impl;

import com.fh.mall.dao.JqGridTestMapper;
import com.fh.mall.entity.TestUser;
import com.fh.mall.utils.PageQueryUtil;
import com.fh.mall.utils.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author HueFu
 * @Date 2020-8-11 20:44
 */
@Service
public class TestUserImpl {

    @Resource
    private JqGridTestMapper jqGridTestMapper;

    public PageResult getListMallUser(PageQueryUtil pageQueryUtil) {
        List<TestUser> pageUser = jqGridTestMapper.getPageUser(pageQueryUtil);
        int totalUser = jqGridTestMapper.getTotalUser();
        return new PageResult(totalUser, pageUser, pageQueryUtil.getLimit(), pageQueryUtil.getCurrentPage());
    }

}
