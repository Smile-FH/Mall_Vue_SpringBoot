package com.fh.mall.service;

import java.util.List;
import com.fh.mall.entity.MallUserToken;
    /** 
 * Description: MallUserTokenService,Token操作业务层接口
 * @Author: HueFu
 * @Date: 2020-8-31 9:15 
 */
public interface MallUserTokenService{


    int insert(MallUserToken record);

    MallUserToken selectByPrimaryKey(Integer userId);

    int updateByPrimaryKey(MallUserToken record);

    int updateBatch(List<MallUserToken> list);

}
