package com.example.bai_tap_ve_nha.controller;

import com.example.bai_tap_ve_nha.model.Product;
import com.example.bai_tap_ve_nha.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService productService;
@GetMapping
    public String findAll(Model model){
    List<Product> products=productService.findAll();
    model.addAttribute("product",products);
    return "/product/list";
}
@GetMapping("/create")
    public String createForm(Model model){
    model.addAttribute("product",new Product());
    return "/product/form";
}
@PostMapping("/create")
    public String create(@ModelAttribute Product product){

    productService.save(product);
    return "redirect:/products";
}
@GetMapping("/update/{id}")
    public String updateForm(Model model, @PathVariable Long id){
    Product product=productService.findById(id);
    model.addAttribute("product",product);
    return "/product/form";
}
@PostMapping("/update/{id}")
    public String update(@ModelAttribute Product product){
    productService.save(product);
    return "redirect:/products";
}
@GetMapping("/delete/{id}")
    public String delete (@PathVariable Long id){
    productService.delete(id);
    return "redirect:/products";
}
}
