/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import models.Role;
import models.User;

/**
 *
 * @author 854276
 */
public class RoleDB {
    
      public List<User> getAll(String role) throws Exception {
       
        
         EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            
           List<User> user = em.createNamedQuery("User.findAll",User.class).getResultList();
           return user;

        } finally { 
            em.close();
        }
}
      
      
}
