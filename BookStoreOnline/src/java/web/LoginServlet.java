/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.LoginImpl;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;


/**
 * @email Ramesh Fadatare
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private LoginImpl loginImpl =new LoginImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Account account = new Account(username,password);

        try {
            if (loginImpl.login(account)!=null) {
                //HttpSession session = request.getSession();
                // session.setAttribute("username",username);
                response.sendRedirect("successful.jsp");
            } else {
//                HttpSession session = request.getSession();
                response.sendRedirect("error.jsp");
                //session.setAttribute("user", username);
                //response.sendRedirect("login.jsp");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
