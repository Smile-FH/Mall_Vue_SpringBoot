package com.fh.mall.service;

import com.fh.mall.utils.PageQueryUtil;
import com.fh.mall.utils.PageResult;

/**
 * @Description: TODO(MallUser业务层接口)
 * @Author HueFu
 * @Date 2020-8-11 10:18
 */
public interface MallUserService {


    /**
     * @Description: TODO(得到MallUser数据的业务接口)
     * @Author: HueFu
     * @Date: 2020-8-11 14:59
     * @MethodName: getListMallUser
     * @Param: [queryUtil]
     * @Return: com.fh.mall.utils.PageResult
     */
    PageResult getListMallUser(PageQueryUtil queryUtil);

    /**
     * @Description: TODO(得到MallUser的数据总数的业务接口)
     * @Author: HueFu
     * @Date: 2020-8-11 15:01
     * @MethodName: getTotalUser
     * @Param: []
     * @Return: int
     */
    int getTotalUser();


}
