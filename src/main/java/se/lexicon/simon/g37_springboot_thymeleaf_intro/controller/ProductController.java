package se.lexicon.simon.g37_springboot_thymeleaf_intro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import se.lexicon.simon.g37_springboot_thymeleaf_intro.model.Product;


import java.math.BigDecimal;
import java.util.*;


@Controller
public class ProductController {

    private List<Product> products = new ArrayList<>(
            Arrays.asList(
                    new Product("FirstOne", "Frideborg", BigDecimal.TEN),
                    new Product("Second", "Debbie", BigDecimal.valueOf(20))
            )
    );

/*
    /products == findAll
    /products/add == create
    /products/{id} == findById
    /products/{id}/update == UpdateById
    /products/{id}/delete == DeleteById
     */

    //PathVariable
    @GetMapping("/products/{id}")
    public String findProductById(@PathVariable("id") String id, Model model){

//        repo.findById(id);
        Optional<Product> foundProduct = products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();

        if (foundProduct.isPresent()){
            model.addAttribute("product", foundProduct.get());
        } else{
            return "redirect:/products";
        }

        return "product_view";

    }

    @GetMapping("/products")
    public String findAll(Model model){

        //repo.findAll()
        model.addAttribute("products", products);

        return "products";
    }

    // 1. For the create view (the look)

    @GetMapping("/products/add")
    public String getCreateForm(Model model){

        model.addAttribute("product", new Product());

        return "product_create_form";
    }


    // 2. Processing the product to, actually save the data.
    @PostMapping("/products/add/process")
    public String processCreateForm(@ModelAttribute(name = "product") Product product){

        product.setId(UUID.randomUUID().toString());
        products.add(product);

        return "redirect:/products/" + product.getId();

    }








}
