package com.example.JPAjoinPactice001;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//import org.junit.Assert;
//import org.junit.BeforeClass;
//import org.junit.Test

public class EqualityUnitTest {
    private static EntityManagerFactory factory;

    private static EntityManager entityManager;  
    
    public static void setup() {
        factory = Persistence.createEntityManagerFactory("jpa-h2-equality");
        entityManager = factory.createEntityManager();
    }
}
