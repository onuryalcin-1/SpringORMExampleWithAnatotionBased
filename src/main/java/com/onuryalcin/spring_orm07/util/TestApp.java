package com.onuryalcin.spring_orm07.util;


import com.onuryalcin.spring_orm07.Service.ProductService;
import com.onuryalcin.spring_orm07.entity.Product;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import java.util.Arrays;

public class TestApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        ProductService productService = context.getBean(ProductService.class);
        productService.add(new Product(1,"Television"));
        productService.add(new Product(2,"Mobile Phone"));
        productService.add(new Product(3,"Computer"));

        System.out.println("First List Products " + productService.listAll());

        try {
            productService.addAll(Arrays.asList(new Product(4,"Mouse"), new Product(5,"Blackboard"),new Product(6,"Camera")));
        }catch (DataAccessException e){
            e.printStackTrace();
        }

        System.out.println("Second List Products" + productService.listAll());
    }


}
