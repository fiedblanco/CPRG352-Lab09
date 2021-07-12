/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.UserDB;
import models.User;

/**
 *
 * @author 854276
 */
public class UserServices {
      public void insert(String email, String firstname, String lastname, String password, Boolean active, int roleNum) throws Exception {
        User user = new User(email,firstname,lastname,password,active,roleNum);
        UserDB userDB = new UserDB();
  userDB.insert(user);
      }
    
    public void update(String email, String firstname, String lastname, String password, Boolean active, int roleNum) throws Exception {
        User user = new User(email,firstname,lastname,password,active,roleNum);
      UserDB userDB = new UserDB();
        userDB.update(user);
    }
    
    public void delete(String email) throws Exception {
         User user = new User();
        user. setEmail(email);
       UserDB userDB = new UserDB();
        userDB.delete(user);
    }

    public void insert(String email, String firstname, String lastname, String password, Boolean active, String roleNum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}



