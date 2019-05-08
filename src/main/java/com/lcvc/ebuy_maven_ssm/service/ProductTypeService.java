package com.lcvc.ebuy_maven_ssm.service;

import com.lcvc.ebuy_maven_ssm.dao.ProductTypeDao;
import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.model.ProductType;
import com.lcvc.ebuy_maven_ssm.util.SHA;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class ProductTypeService {
    @Resource
    private ProductTypeDao productTypeDao;

    /**
     * 返回所有的管理账户集合
     *
     * @return 以List方式返回
     */
    public List<ProductType> getProductTypeList() {
        return productTypeDao.getProductTypeList();
    }

    /**
     * 删除指定账户
     *
     * @param id 被删除的账户id
     * @return true表示删除成功
     */

    public boolean deleteProductType(Integer id) {
        boolean status = false;//存储修改结果
        /*if (id != null && ProductTypeId != null) {
            if (ProductTypeId != id.intValue()) {//如果不是自己删除自己*/
                int n = productTypeDao.deleteProductType(id);
                if (n == 1) {
                    status = true;
                }
         /*   }
        }*/
        return status;

    }
    /**
     * 将账户信息存入数据库
     * @param productType
     * @return true表示保存成功，false表示保存失败
     */
    public boolean saveProductType(ProductType productType){
        boolean judge=false;
        int i=productTypeDao.saveProductType(productType);
        if(i>0){
            judge=true;
        }
        return judge;
    }

    /**
     * 修改账户的基本信息
     * 说明：
     * 1、修改后的账户名不能与其他账户的账户名重名
     * @param  productType
     * @return false表示修改失败，true表示修改成功
     */
    public boolean updateProductType(ProductType productType){
        boolean status=false; //存储修改结果
     /*  if(productTypeDao.existsAdmin(admin.getUsername(),admin.getId())==0){//如果不重名*/
            if(productTypeDao.updateProductType(productType)==1){
                status=true;
            }else{
                status=false;
            }

        return status;
    }
}