package com.fh.mall.service.impl;

import com.fh.mall.common.MallCategoryLevelEnum;
import com.fh.mall.controller.api.vo.MallClassifyFirstLevelVo;
import com.fh.mall.controller.api.vo.MallClassifySecondLevelVo;
import com.fh.mall.controller.api.vo.MallClassifyThirdLevelVo;
import com.fh.mall.dao.MallGoodsCategoryMapper;
import com.fh.mall.entity.MallGoodsCategory;
import com.fh.mall.service.MallGoodsCategoryService;
import com.fh.mall.utils.PageQueryUtil;
import com.fh.mall.utils.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Description: 商品分类业务实现类
 * @Author: HueFu
 * @Date: 2020-9-7 17:10 
 */
@Service
public class MallGoodsCategoryServiceImpl implements MallGoodsCategoryService{

    @Resource
    private MallGoodsCategoryMapper mallGoodsCategoryMapper;

    public MallGoodsCategoryServiceImpl() {
    }

    @Override
    public int deleteByPrimaryKey(Integer categoryId) {
        return this.mallGoodsCategoryMapper.deleteByPrimaryKey(categoryId);
    }

    @Override
    public MallGoodsCategory selectByCategoryId(Integer categoryId){
        return this.mallGoodsCategoryMapper.selectByCategoryId(categoryId);
    }

    @Override
    public int insert(MallGoodsCategory record) {
        return this.mallGoodsCategoryMapper.insert(record);
    }

    @Override
    public int insertSelective(MallGoodsCategory record) {
        return this.mallGoodsCategoryMapper.insertSelective(record);
    }

    @Override
    public List<MallGoodsCategory> selectByLevelParentId(Map<String, Object> param) {
        return this.mallGoodsCategoryMapper.selectByLevelParentId(param);
    }

    @Override
    public int updateByPrimaryKeySelective(MallGoodsCategory record) {
        return this.mallGoodsCategoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MallGoodsCategory record) {
        return this.mallGoodsCategoryMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<MallGoodsCategory> list) {
        return this.mallGoodsCategoryMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<MallGoodsCategory> list) {
        return this.mallGoodsCategoryMapper.batchInsert(list);
    }

    @Override
    public PageResult getCategoryList(PageQueryUtil params) {
        int totalCategory = this.mallGoodsCategoryMapper.getTotalCategory();
        List<MallGoodsCategory> mallGoodsCategories = this.mallGoodsCategoryMapper.getCategoryList(params);
        PageResult pageResult = new PageResult(totalCategory, mallGoodsCategories, params.getLimit(), params.getPage());
        return pageResult;
    }

    @Override
    public List<MallClassifyFirstLevelVo> getCategoryListByLevel(){
        // 查询了所有的一级分类
        List<MallGoodsCategory> firstCategories = this.mallGoodsCategoryMapper.getCategoryListByLevel(MallCategoryLevelEnum.LEVEL_ONE.getLevel(), Collections.emptyList());
        // 获得了所有的一级分类id
        List<Integer> firstCategoryIdList = firstCategories.stream().map(MallGoodsCategory::getCategoryId).collect(Collectors.toList());
        // 查询了所有的二级分类
        List<MallGoodsCategory> secondCategories = this.mallGoodsCategoryMapper.getCategoryListByLevel(MallCategoryLevelEnum.LEVEL_TWO.getLevel(), firstCategoryIdList);
        // 获得了所有的二级分类id
        List<Integer> secondCategoryIdList = secondCategories.stream().map(MallGoodsCategory::getCategoryId).collect(Collectors.toList());
        //对所有二级列表进行parentId分类组合
        Map<Integer, List<MallGoodsCategory>> secondCategoryGroupMap = secondCategories.stream().collect(Collectors.groupingBy(MallGoodsCategory::getParentId));
        // 查询所有的三级分类
        List<MallGoodsCategory> thirdCategories = this.mallGoodsCategoryMapper.getCategoryListByLevel(MallCategoryLevelEnum.LEVEL_THREE.getLevel(), secondCategoryIdList);
        // 对所有的三级列表进行parentId分类
        Map<Integer, List<MallGoodsCategory>> thirdCategoryGroupMap = thirdCategories.stream().collect(Collectors.groupingBy(MallGoodsCategory::getParentId));
        // 把三级分类塞到二级分类里去
            // 循环到每一个二级对象中去
        List<MallClassifySecondLevelVo> mallClassifySecondLevelVos = new ArrayList<MallClassifySecondLevelVo>(secondCategories.size());
        MallClassifySecondLevelVo mallClassifySecondLevelVo = null;
        for (MallGoodsCategory secondCategory :
                secondCategories) {
            mallClassifySecondLevelVo = new MallClassifySecondLevelVo();
            mallClassifySecondLevelVo.setCategoryId(secondCategory.getCategoryId());
            mallClassifySecondLevelVo.setCategoryLevel(secondCategory.getCategoryLevel());
            mallClassifySecondLevelVo.setCategoryName(secondCategory.getCategoryName());
            mallClassifySecondLevelVo.setParentId(secondCategory.getParentId());
            // 判断当前的三级对象分组集合中是否有二级对象的id分组
            if (thirdCategoryGroupMap.containsKey(secondCategory.getCategoryId())) {
                // 如果有三级对象分组就取出
                List<MallGoodsCategory> secondGroup = thirdCategoryGroupMap.get(secondCategory.getCategoryId());
                // 转换三级商品对象成为三级vo对象
                List<MallClassifyThirdLevelVo> thirdLevelVos = new ArrayList<MallClassifyThirdLevelVo>(secondGroup.size());
                MallClassifyThirdLevelVo thirdLevelVo = null;
                // for循环对单个三级vo对象赋值
                for (MallGoodsCategory thirdCategory :
                        secondGroup) {
                    thirdLevelVo = new MallClassifyThirdLevelVo();
                    thirdLevelVo.setCategoryId(thirdCategory.getCategoryId());
                    thirdLevelVo.setCategoryLevel(thirdCategory.getCategoryLevel());
                    thirdLevelVo.setCategoryName(thirdCategory.getCategoryName());
                    thirdLevelVo.setParentId(thirdCategory.getParentId());
                    thirdLevelVos.add(thirdLevelVo);
                }
                mallClassifySecondLevelVo.setMallClassifyThirdLevelVoList(thirdLevelVos);
            } else {
                mallClassifySecondLevelVo.setMallClassifyThirdLevelVoList(null);
            }
            mallClassifySecondLevelVos.add(mallClassifySecondLevelVo);
        }
        Map<Integer, List<MallClassifySecondLevelVo>> secondCollect = mallClassifySecondLevelVos.stream().collect(Collectors.groupingBy(MallClassifySecondLevelVo::getParentId));
        // 接下来循环每个封装好的二级对象去一级vo对象中去
        List<MallClassifyFirstLevelVo> mallClassifyFirstLevelVos = new ArrayList<MallClassifyFirstLevelVo>(firstCategories.size());
        MallClassifyFirstLevelVo mallClassifyFirstLevelVo = null;
        for (MallGoodsCategory firstCategory :
                firstCategories) {
            mallClassifyFirstLevelVo = new MallClassifyFirstLevelVo();
            mallClassifyFirstLevelVo.setCategoryId(firstCategory.getCategoryId());
            mallClassifyFirstLevelVo.setCategoryLevel(firstCategory.getCategoryLevel());
            mallClassifyFirstLevelVo.setCategoryName(firstCategory.getCategoryName());
            mallClassifyFirstLevelVo.setParentId(firstCategory.getParentId());
            // 设置一级vo对象中的二级vo对象
            if (secondCollect.containsKey(firstCategory.getCategoryId())) {
                List<MallClassifySecondLevelVo> firstGroup = secondCollect.get(firstCategory.getCategoryId());
                mallClassifyFirstLevelVo.setMallClassifySecondLevelVoList(firstGroup);
            } else {
                mallClassifyFirstLevelVo.setMallClassifySecondLevelVoList(null);
            }
            mallClassifyFirstLevelVos.add(mallClassifyFirstLevelVo);
        }
        return mallClassifyFirstLevelVos;
    }

}
