package com.lcvc.ebuy_maven_ssm.dao;

import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.model.ProductType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductTypeDao {
    /**
     * 返回所有的管理账户集合
     * @return 以List方式返回
     */
    List<ProductType> getProductTypeList();

    /**
     * 删除指定账户
     * @param id 关键字
     * @return 返回了多少条记录
     */
    int deleteProductType(Integer id);

    /**
     * 保存指定账户金数据库
     * @param productType
     * @return 添加了多少条记录
     */
    int saveProductType(ProductType productType);


    /**
     * 修改账户的基本信息
     * @param productType id不能为空
     * @return 更改了多少条记录
     */
    int updateProductType(ProductType productType);
}
