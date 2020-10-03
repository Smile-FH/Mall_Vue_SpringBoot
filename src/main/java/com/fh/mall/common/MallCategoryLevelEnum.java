package com.fh.mall.common;

/**
 * Description: category的等级枚举类
 *
 * @Author: HueFu
 * @Date: 2020-10-02 19:13
 */
public enum MallCategoryLevelEnum {
    /**
     * 一级分类
     */
    LEVEL_ONE(1),

    /**
     * 二级分类
     */
    LEVEL_TWO(2),

    /**
     * 三级分类
     */
    LEVEL_THREE(3);

    private int level;

    MallCategoryLevelEnum(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
