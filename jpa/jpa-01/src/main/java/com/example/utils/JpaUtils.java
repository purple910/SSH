package com.example.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @program: jpa-01 com.JpaUtils
 * @description:
 * @author: fate
 * @create: 2019-10-14 18:42
 **/
public class JpaUtils {

    private static EntityManagerFactory factory = null;
    static {

        factory= Persistence.createEntityManagerFactory("myJpa");
    }

    public static EntityManager getManager(){
        return factory.createEntityManager();
    }
}
