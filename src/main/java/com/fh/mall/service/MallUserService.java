package com.fh.mall.service;

import com.fh.mall.utils.PageQueryUtil;
import com.fh.mall.utils.PageResult;

/**
 * @Description: MallUser业务层接口
 * @Author HueFu
 * @Date 2020-8-11 10:18
 */
public interface MallUserService {


    /**
     * @Description: 得到MallUser分页数据的业务接口
     * @Author: HueFu
     * @Date: 2020-8-11 14:59
     * @MethodName: getListMallUser
     * @Param: [queryUtil]
     * @Return: com.fh.mall.utils.PageResult
     */
    PageResult getListMallUser(PageQueryUtil queryUtil);

    /**
     * @Description: 得到MallUser的数据总数的业务接口
     * @Author: HueFu
     * @Date: 2020-8-11 15:01
     * @MethodName: getTotalUser
     * @Param: []
     * @Return: int
     */
    int getTotalUser();

    /**
     * 锁定-1，解锁-0，用户账户
     * @param ids
     * @param lockStatus
     * @return
     */
    int lockUser(Integer[] ids, int lockStatus);


}
