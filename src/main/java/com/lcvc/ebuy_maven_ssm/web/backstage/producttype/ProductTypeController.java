package com.lcvc.ebuy_maven_ssm.web.backstage.producttype;

import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.model.ProductType;
import com.lcvc.ebuy_maven_ssm.service.ProductTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ProductTypeController {
    @Resource
    private ProductTypeService productTypeService;

    //跳转到管理员管理页面
    @RequestMapping(value = "/backstage/producttype/toManageProductType", method = RequestMethod.GET)
    public String toManageProductType(HttpServletRequest request) {
        request.setAttribute("list", productTypeService.getProductTypeList());
        return "/jsp/backstage/producttype/producttypeselect.jsp";
    }

    //执行删除管理员操作
    @RequestMapping(value = "/backstage/producttype/doDeleteProductType", method = RequestMethod.GET)
    public String toDeleteProductType(HttpServletRequest request, HttpSession session, Integer id) {
        ProductType productType = (ProductType)session.getAttribute(" productType");
        productTypeService.deleteProductType(id);
        request.setAttribute("list", productTypeService.getProductTypeList());
        return "/backstage/producttype/toManageProductType";
    }
    //跳转到产品分类添加页面
    @RequestMapping(value = "/backstage/producttype/toAddProductType", method = RequestMethod.GET)
    public String toAddProductType(HttpServletRequest request){
        return "/jsp/backstage/producttype/producttypeadd.jsp";
    }
    //执行产品分类添加请求
    @RequestMapping(value = "/backstage/producttype/doAddProductType", method = RequestMethod.POST)
    public String doAddProductType(HttpServletRequest request,ProductType productType){
        productType.setName( productType.getName().trim());
       // productType.setLinkUrl(productType.getLinkUrl().trim());
        if(productType.getName().length()==0){
            request.setAttribute("myMessage","添加:账户名不能为空");
       }else if(productType.getName().length()==0){
            request.setAttribute("myMessage","添加失败:姓名不能为空");
       // }else if(productTypeService.existsName(productType.getname())){
           // request.setAttribute("myMessage","账户创建失败:账户名已存在，请选择其他的账户名");
        }else{
          if (productTypeService.saveProductType(productType)==true){
                request.setAttribute("myMessage","添加成功");
            }else{
                request.setAttribute("myMessage","添加失败");
            }
        }
        return "/jsp/backstage/producttype/producttypeselect.jsp";
    }
    //跳转到管理员编辑页面
    @RequestMapping(value = "/backstage/producttype/toUpdateProductType", method = RequestMethod.GET)
    public String toUpdateProductType(HttpServletRequest request){
        request.setAttribute("producttype", productTypeService.getProductTypeList());
        return "/jsp/backstage/producttype/updateproducttype.jsp";
    }
    //执行管理员编辑请求
    @RequestMapping(value = "/backstage/producttype/doUpdateProductType", method = RequestMethod.POST)
    public String doUpdateProductType(HttpServletRequest request, ProductType productType){
        productType.setName(productType.getName().trim());
      /*  productType.setName(productType.getName().trim());*/
        if(productType.getName().length()==0){
            request.setAttribute("myMessage","账户修改失败:账户名不能为空");
        }else if(productType.getName().length()==0){
            request.setAttribute("myMessage","账户修改失败:姓名不能为空");
       /* }else if(productTypeService.existsAdmin(admin.getUsername(),admin.getId())){
            request.setAttribute("myMessage","账户修改失败:账户名不能重名");*/
        }else{
            if(productTypeService.updateProductType(productType)){
                request.setAttribute("myMessage","账户修改成功");
            }else{
                request.setAttribute("myMessage","账户修改失败");
            }
        }
        return "/jsp/backstage/producttype/producttypeselect.jsp";
    }
}