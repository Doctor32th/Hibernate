/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernatehello;

import models.Alumno;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author LuisRobbeToichoaSaut
 */
public class PrincipalHibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Así se crea el session factory
        //Configuration se encarga de leer el XML 
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        
        Alumno a = new Alumno(0L, "Perori");
        
        Session s = sf.openSession();
        
        s.save(a);
        
        //No hemos hecho la transaccion, pero no se ha guardado en la BD
        
        Transaction t = s.beginTransaction();
        s.save(a);
        t.commit();
        
    }
    
    
    
}
