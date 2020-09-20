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
            <h1>Employee Login Form</h1>
            <form  method="post">
                <table style="with: 100%">
                    <tr>
                        <td>UserName</td>
                        <td><input type="text" name="username" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Login" onclick="form.action = '<%=request.getContextPath()%>/login'"></td>
                    <td>
                        <input type="submit" value="Register" onclick="form.action = '<%=request.getContextPath()%>/register.jsp'"></td>
                
                    </tr>

                </table>
            </form>
        </div>
    </body>
</html>