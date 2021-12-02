package com.geekbrains.springwebhomework.data;

public class MainApp {
    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        try {
            Dao productDao = new ProductDao(sessionFactoryUtils);
            System.out.println(productDao.findByIdBuyer(1L));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shutdown();
        }
    }
}
