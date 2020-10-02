package com.fh.mall.utils;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Description: 提取前端发送过来Map数据的工具类
 * Author HueFu
 * Date 2020-8-11 9:24
 */
@Data
public class PageQueryUtil extends LinkedHashMap<String, Object> {

    private int page;

    private int limit;

    public PageQueryUtil(Map<String, Object> params) {
        // 合并两个Map，如果有相同的key那么，后边的key可以覆盖前边的
        this.putAll(params);
        this.page = Integer.parseInt(params.get("page").toString());
        this.limit = Integer.parseInt(params.get("limit").toString());
        this.put("start",( page - 1 )*limit);
        this.put("page",page);
        this.put("limit",limit);
    }
}
