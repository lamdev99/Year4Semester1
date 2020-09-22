<%@page import="model.User"%>
<%@page import="data.UserIO"%>
<!DOCTYPE HTML PUBLIC
    "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Murach's Java Servlets and JSP</title>
    </head>
    <body>
        <h1>Thanks for joining our email list, 
            <%
                // get parameters from the request
                String firstName
                        = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String emailAddress = request.getParameter("emailAddress");
            %>
            <%= firstName + " "%> 
            <%= lastName%>
        </h1>
        <p>We'll use this email to notify you whenever we have new releases for these types of music:</p><br>
        <%
            StringBuilder sb = new StringBuilder();
            String listMusic[] = request.getParameterValues("music");
            for (int i = 0; i < listMusic.length; i++) {
        %>
        <%= listMusic[i]%><br>
        <%
            }
            ServletContext sc = getServletContext();
            String path = sc.getRealPath("/WEB-INF/EmailList.txt");
            User user = new User(firstName, lastName, emailAddress, sb.toString());
//            ServletContext sc = this.getServletContext();
//            String path = sc.getRealPath("/WEB-INF/EmailList.txt");
            UserIO.add(user, path);
        %>


    </body>
</html>