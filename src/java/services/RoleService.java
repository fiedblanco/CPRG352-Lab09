/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.RoleDB;
import java.util.List;
import models.Role;
import models.User;

/**
 *
 * @author 854276
 */
public class RoleService {
       public List<User> getAll(String role) throws Exception {
        RoleDB roleDB = new RoleDB();
        List<User> roles = roleDB.getAll(role);
        return roles;
    }
}
