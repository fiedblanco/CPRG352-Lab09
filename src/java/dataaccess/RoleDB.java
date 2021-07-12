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
import models.Role;
import models.User;

/**
 *
 * @author 854276
 */
public class RoleDB {
      public List<User> getAll(String role) throws Exception {
        List<User> allUsers = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT email,first_name,last_name,password,active,role FROM `user` ";

        try {
            ps = con.prepareStatement(sql);
         
            rs = ps.executeQuery();
            while (rs.next()) {
              String email = rs.getString(1);
              String firstname = rs.getString(2);
              String lastname = rs.getString(3);
              String password = rs.getString(4);
              Boolean active = rs.getBoolean(5);
              int rolen = rs.getInt(6);
              User user = new User(email,firstname,lastname,password,active,rolen);
              allUsers.add(user);
            }
        } 
        
       
        finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }

        return allUsers;
    }
  
}
