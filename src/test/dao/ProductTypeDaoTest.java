package dao;

import com.lcvc.ebuy_maven_ssm.dao.ProductTypeDao;
import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.model.ProductType;
import com.lcvc.ebuy_maven_ssm.test.SpringJunitTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


public class ProductTypeDaoTest  extends SpringJunitTest {
    @Resource
    private ProductTypeDao productTypeDao;

    @Test
    public void testGetProductTypeList() {
        List<ProductType> list = productTypeDao.getProductTypeList();
        for (int i = 0; i < list.size(); i++) {
            ProductType productType = list.get(i);
            System.out.println(productType.getName());
        }
    }

    @Test
    public void testDeleteProductType() {
        System.out.println(productTypeDao.deleteProductType(23));//1
        System.out.println(productTypeDao.deleteProductType(26));//0
    }
    @Test
    public void testSaveProductType() {
        ProductType productType = new ProductType();
       productType.setId(5);
        productType.setName("你回家房管局");
        productType.setImageUrl("222");
        productType.setLinkUrl("22");
        productType.setIntro("555");
        productType.setOrderNum(100);

        productTypeDao.saveProductType(productType);
    }
}