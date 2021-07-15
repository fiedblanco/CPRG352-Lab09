<%-- 
    Document   : users
    Created on : Jun 24, 2021, 9:04:22 PM
    Author     : 854276
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="CSS/userDesign.css">
        <title>Users</title>
    </head>
    <body>

        <div id="addBox">  
            <h1>Add Users</h1>
            <form method="post" action="user">
                <label>Email:</label>
                <input type="text" name="email" value="" >
                <br>
                <label>First Name:</label>
                <input type="text" name="fname" value="">
                <br>
                <label>Last Name:</label>
                <input type="text" name="lname" value="" >
                <br>
                <label>Password:</label>
                <input type="password" name="pass" value="" >
                <br>
                <label>Role</label>
                <select name="roles">
                    <option value="0">System Admin</option>
                    <option value="1">Regular User</option>
                    <option value="2">Company Admin</option>
                </select>
                <br>
                <input type="submit" value="Add" name="action">

            </form>
        </div>

        <div id="manageBox">  
            <h1>Manage Users</h1>

            <form method="post" action="user">
           
              
                    <table>
                        <tr>
                            <th>Email</th>
                            <th>First Name</th>
                            <th>Last Name</th>

                        </tr>
                          <c:forEach var="user" items="${usersInList}">
                        <tr>
                            <td>${user.email}</td>
                            <td>${user.firstName}</td>
                            <td>${user.lastName}</td>

                           
                        </tr>
                        
                         </c:forEach>
                    </table>
               



            </form>

        </div>

        <div id="editBox">          
            <h1>Edit/Delete Users</h1>
            <form method="post" action="user">
                <input type="text" name="emailE" value="" placeholder="email">
                <br>
                <input type="text" name="fnameE" value=""  placeholder="first name">
                <br>
                <input type="text" name="lnameE" value=""  placeholder="last name">
                <br>
                <input type="password" name="passwordE" value=""  placeholder="password">
                <br>
                <select name="roles">
                    <option value="1">System Admin</option>
                    <option value="2">Regular User</option>
                    <option value="3">Company Admin</option>
                </select>
                <br>
                <input type="submit" value="Edit" name="action">
                <input type="submit" value="Delete" name="action">
            </form>
        </div>
    </body>
</html>
