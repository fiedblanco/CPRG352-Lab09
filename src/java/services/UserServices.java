/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.UserDB;
import java.util.List;
import models.User;
import models.Role;

/**
 *
 * @author 854276
 */
public class UserServices {

    public void insert(String email, boolean active, String firstName, String lastName, String password, int roleN) throws Exception {

        Role role = new Role();

        List<Role> roles = role.GetAllRoles();

        Object[] rolesArr = roles.toArray();

        Object roleObj = rolesArr[roleN];

        User user = new User(email, active, firstName, lastName, password, (Role) roleObj);
        UserDB userDB = new UserDB();
        userDB.insert(user);
    }

    public void update(String email, boolean active, String firstName, String lastName, String password, int roleN) throws Exception {

        Role role = new Role();

        List<Role> roles = role.GetAllRoles();
        Object[] rolesArr = roles.toArray();

        Object roleObj = rolesArr[roleN];
        
        User user = new User(email, active, firstName, lastName, password, (Role) roleObj);
        UserDB userDB = new UserDB();
        userDB.update(user);
    }

    public void delete(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        userDB.delete(user);
    }

    public void insert(String email, String firstname, String lastname, String password, Boolean active, String roleNum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
