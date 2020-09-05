package com.fh.mall.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.fh.mall.dao.MallUserTokenMapper;
import java.util.List;
import com.fh.mall.entity.MallUserToken;
import com.fh.mall.service.MallUserTokenService;
/** 
 * Description: TODO(这里用一句话描述这个类的作用) 
 * @Author: HueFu
 * @Date: 2020-8-31 9:15 
 */
@Service
public class MallUserTokenServiceImpl implements MallUserTokenService{

    @Resource
    private MallUserTokenMapper mallUserTokenMapper;

    @Override
    public int insert(MallUserToken record) {
        return mallUserTokenMapper.insert(record);
    }

    @Override
    public MallUserToken selectByPrimaryKey(Integer userId) {
        return mallUserTokenMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKey(MallUserToken record) {
        return mallUserTokenMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<MallUserToken> list) {
        return mallUserTokenMapper.updateBatch(list);
    }

}
