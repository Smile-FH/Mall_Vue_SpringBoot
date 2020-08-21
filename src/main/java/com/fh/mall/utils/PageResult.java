package com.fh.mall.utils;

import lombok.Data;

import java.util.List;

/**
 * @Description: 封装Mapper中查询出分页数据的实体类
 * @Author HueFu
 * @Date 2020-8-11 11:17
 */
@Data
public class PageResult {

    private int totalCount;

    private int pageSize;

    private int totalPage;

    private int currPage;

    private List<?> list;

    public PageResult(int totalCount, List<?> list, int pageSize, int currPage) {
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.currPage = currPage;
        this.list = list;
        this.totalPage = (int) Math.ceil((double)totalCount/pageSize);
    }
}
