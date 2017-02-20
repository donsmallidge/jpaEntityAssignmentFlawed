package com.dogeatdogenterprises.controllers;

import com.dogeatdogenterprises.domain.Product;
import com.dogeatdogenterprises.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by donaldsmallidge on 9/14/16.
 */
@Controller
// removed: @RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {

        this.productService = productService;
    }

    @RequestMapping("/product/list")
    // removed: @RequestMapping({"/list", "/"})
    public String listProducts(Model model) {

        model.addAttribute("products", productService.listAll());

        return "product/list";
    }

    @RequestMapping("/product/show/{id}")
    // removed: @RequestMapping("/show/{id}")
    public String getProduct(@PathVariable Integer id, Model model) {

        model.addAttribute("product", productService.getById(id));

        return "product/show";
    }

    @RequestMapping("product/edit/{id}")
    // removed: @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {

        model.addAttribute("product", productService.getById(id));

        return "product/productform";
    }

    @RequestMapping("/product/new")
    // removed: @RequestMapping("/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "product/productform";
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    // removed: @RequestMapping(value = "/", method = RequestMethod.POST)
    public String saveOrUpdateProduct(Product product) {
        Product savedProduct = productService.saveOrUpdate(product);
        return "redirect:/product/show/" + savedProduct.getId();
    }

    @RequestMapping("/product/delete/{id}")
    // removed: @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {

        productService.delete(id);
        return "redirect:/product/list";
    }
}
