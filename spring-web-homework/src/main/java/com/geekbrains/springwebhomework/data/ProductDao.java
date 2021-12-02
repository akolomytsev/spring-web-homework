package com.geekbrains.springwebhomework.data;

import org.hibernate.Session;

import java.util.List;

public class ProductDao implements Dao {
    private SessionFactoryUtils sessionFactoryUtils;

    public ProductDao(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Product findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            return session.get(Product.class, id);
        }
    }

    @Override
    public List<Product> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Product> productList = session.createQuery("FROM product", Product.class).getResultList();
            session.getTransaction().commit();
            return productList;
        }
    }

    @Override
    public List<Product> findByIdBuyer(Long buyer_id){
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, buyer_id);
            session.getTransaction().commit();
            return buyer.getProducts();
        }
    }

    @Override
    public List<Buyer> findByIdProduct(Long product_id){
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, product_id);
            session.getTransaction().commit();
            return product.getBuyers();
        }
    }

}
