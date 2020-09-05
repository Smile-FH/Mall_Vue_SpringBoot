package com.fh.mall.service.impl;

import com.fh.mall.common.ServiceResultEnum;
import com.fh.mall.dao.MallUserMapper;
import com.fh.mall.dao.MallUserTokenMapper;
import com.fh.mall.entity.MallUser;
import com.fh.mall.entity.MallUserToken;
import com.fh.mall.service.MallUserService;
import com.fh.mall.utils.NumUtils;
import com.fh.mall.utils.PageQueryUtil;
import com.fh.mall.utils.PageResult;
import com.fh.mall.utils.TokenUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: MallUser的业务层实现类
 * @Author HueFu
 * @Date 2020-8-2 9:52
 */
@Service
public class MallUserServiceImpl implements MallUserService {

    @Resource
    private MallUserMapper mallUserMapper;

    @Resource
    private MallUserTokenMapper mallUserTokenMapper;

    @Override
    public String userLogin(String loginName, String passwordMD5) {
        MallUser mallUser = mallUserMapper.selectByLoginNameAndPassword(loginName, passwordMD5);
        if (mallUser!=null){
            if (mallUser.getLockedFlag() == 1) {
                return ServiceResultEnum.USER_LOCKED_ERROR.getResult();
            }
            // 制作token
            String token = getNewToken(System.currentTimeMillis()+"", mallUser.getUserId());
            // 接着需要把token存到token对象里
            MallUserToken mallUserToken = mallUserTokenMapper.selectByPrimaryKey(mallUser.getUserId());
            // 当前时间
            Date now = new Date();
            // 过期时间算法
            Date expire = new Date(now.getTime() + 2 * 24 * 3600 * 1000);// 48小时之后过期
            //如果没有查到当前用户的token，就插入
            if (mallUserToken == null){
                mallUserToken = new MallUserToken();
                mallUserToken.setToken(token);
                mallUserToken.setUserId(mallUser.getUserId());
                mallUserToken.setUpdateTime(now);
                mallUserToken.setExpireTime(expire);
                // 要新插入一条token数据
                int insert = mallUserTokenMapper.insert(mallUserToken);
                if (insert>0) {
                    return token;
                }
                // 如果查到了当前用户的token就比对是否过期，然后更新？
            } else {
                mallUserToken.setToken(token);
                mallUserToken.setUpdateTime(now);
                mallUserToken.setExpireTime(expire);
                // 执行更新操作就好
                int i = mallUserTokenMapper.updateByPrimaryKey(mallUserToken);
                if (i>0) {
                    return token;
                }
            }
        }
        return ServiceResultEnum.USER_NULL_ERROR.getResult();
    }

    @Override
    public Boolean userLogout(int loginId) {
        return mallUserTokenMapper.deletedByPrimaryKey(loginId)>0;
    }

    private String getNewToken(String timStr, int userId) {
        String src = timStr+userId+ NumUtils.getRandom(4);
        String token = TokenUtil.getToken(src);
        return token;
    }


    @Override
    public int getTotalUser() {
        return mallUserMapper.getTotalUser();
    }

    @Override
    public PageResult getListMallUser(PageQueryUtil pageQueryUtil) {
        List<MallUser> pageUser = mallUserMapper.getPageUser(pageQueryUtil);
        int totalUser = mallUserMapper.getTotalUser();
        return new PageResult(totalUser, pageUser, pageQueryUtil.getLimit(), pageQueryUtil.getCurrentPage());
    }

    @Override
    public int lockUser(Integer[] ids, int lockStatus) {
        Map<String, Object> lockParams = new HashMap<>();
        lockParams.put("ids", ids);
        lockParams.put("lockStatus", lockStatus);
        int i = mallUserMapper.lockUser(lockParams);
        return i;
    }

    @Override
    public int deleteByPrimaryKey(Integer userId) {
        return mallUserMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int insert(MallUser record) {
        return mallUserMapper.insert(record);
    }

    @Override
    public int insertSelective(MallUser record) {
        return mallUserMapper.insertSelective(record);
    }

    @Override
    public MallUser selectByPrimaryKey(Integer userId) {
        return mallUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(MallUser record) {
        return mallUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MallUser record) {
        return mallUserMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<MallUser> list) {
        return mallUserMapper.updateBatch(list);
    }


}

