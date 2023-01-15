package com.example.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    Connection connection;
    PreparedStatement pstmt;

    public void dbInit() {
        String url="jdbc:mysql://localhost:3306/flyaway";
        String  username="root";
        String password="Rocky@4121";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(url,username,password);
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Some Error occured :"+ e);
        }
    }



    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Object flight= session.getAttribute("flightno");

        PrintWriter out = response.getWriter();

        dbInit();
        String UserName = request.getParameter("email");
        String Password = request.getParameter("password");

        try {

            String sqlQuery="select * from userdetails where email=? and password=?";
            PreparedStatement pstmt=connection.prepareStatement(sqlQuery);

            pstmt.setString(1, UserName);
            pstmt.setString(2, Password);


            ResultSet rs=pstmt.executeQuery();

            if(rs.next()) {
                request.getSession().setAttribute(UserName, Password);
                out=response.getWriter();
                out.println("Welcome "+ rs.getString("FirstName")+"  "+rs.getString("LastName"));
                session.setAttribute("flightno", flight);
                response.sendRedirect("Payment.jsp");

            }
            else {
                out.println("Please enter valid UserName and Password");
                response.sendRedirect("login.jsp");
            }

        } catch (SQLException e) {
            out.print("something went wrong"+e);
        }
    }

}
