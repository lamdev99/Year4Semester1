<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Insert title here</title>
    </head>
    <body>
        <div align="center">
            <h1>Employee Register Form</h1>
            <form action="<%= request.getContextPath()%>/registerz" method="post">
                <table style="with: 80%">
                    <tr>
                        <td>First Name</td>
                        <td><input type="text" name="firstName" /></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input type="text" name="lastName" /></td>
                    </tr>
                    <tr>
                        <td>UserName</td>
                        <td><input type="text" name="username" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" /></td>
                    </tr>
                    <tr>
                        <td>Home's number</td>
                        <td><input type="text" name="numhome" /></td>
                    </tr>
                    <tr>
                        <td>Street</td>
                        <td><input type="text" name="street" /></td>
                    </tr>
                    <tr>
                        <td>District</td>
                        <td><input type="text" name="district" /></td>
                    </tr>
                </table>
                <input type="submit" value="Submit" />
            </form>
        </div>
    </body>
</html>