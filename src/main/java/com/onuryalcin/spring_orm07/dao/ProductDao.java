package com.onuryalcin.spring_orm07.dao;

import com.onuryalcin.spring_orm07.entity.Product;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class ProductDao {

    @PersistenceContext
    private EntityManager em;

    public void persist(Product product){
        em.persist(product);
    }

    public List<Product> findAll(){

        return em.createQuery("SELECT p FROM Product p").getResultList();
    }


}
