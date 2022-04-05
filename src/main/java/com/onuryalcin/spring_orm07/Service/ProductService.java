package com.onuryalcin.spring_orm07.Service;

import com.onuryalcin.spring_orm07.dao.ProductDao;
import com.onuryalcin.spring_orm07.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Component
@Transactional
public class ProductService {

    @Autowired
    private ProductDao productDao;

    @Transactional
    public void add(Product product){
        productDao.persist(product);
    }

    @Transactional
    public void addAll(Collection<Product> products){
        for (Product product: products) {
            productDao.persist(product);
        }
    }

    @Transactional(readOnly = true)
    public List<Product> listAll(){
        return productDao.findAll();
    }
}
