package com.example.demo;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/ChangePass")
public class ChangePass extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public ChangePass() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newPassword=	(String) request.getParameter("password");
        String email=request.getParameter("email");
        PrintWriter out=response.getWriter();

        HttpSession session=request.getSession(false);



        String url = "jdbc:mysql://localhost:3306/flyaway";
        String dbusername = "root";
        String dbpassword = "Rocky@4121";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, dbusername, dbpassword);

            String sqlQuery = "update Admindetails set password=? where email_id=?";
            PreparedStatement pstmt = connection.prepareStatement(sqlQuery);


            pstmt.setString(1, newPassword);
            pstmt.setString(2, email);

            pstmt.executeUpdate();

            request.setAttribute("newPass", newPassword);
            request.setAttribute("msg", "Password changed Succcessfully");
            RequestDispatcher rd=request.getRequestDispatcher("changePassword.jsp");
            rd.forward(request, response);



        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
