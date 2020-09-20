/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;
import dao.RegisterDao;
import dao.RegisterImpl;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.Address;
import model.Customer;


/**
 * @email Ramesh Fadatare
 */

@WebServlet("/registerz")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RegisterImpl registerImpl = new RegisterImpl();

    public void init() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String contact = request.getParameter("contact");
        int numhome = Integer.parseInt(request.getParameter("numhome"));
        String street = request.getParameter("street");
        String district = request.getParameter("district");
        Account account = new Account(username, password);
        Address address = new Address(numhome, street, district);
        Customer customer = new Customer(numhome, firstName, lastName, account, address);

        try {
            registerImpl.registerCustomer(customer);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        response.sendRedirect("successful.jsp");
    }
}
