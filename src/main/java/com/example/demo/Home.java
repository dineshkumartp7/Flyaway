package com.example.demo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/HomePage")
public class Home extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String origin=request.getParameter("origin");
        String Destination=request.getParameter("destination");
        String date=request.getParameter("date");
        String totalPerson=request.getParameter("totalPerson");


        String url="jdbc:mysql://localhost:3306/flyaway";
        String username="root";
        String password="abcd1234";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,username,password);
            String sql="select * from flightdetails where origin=? and destination=?";
            PreparedStatement pstmt=con.prepareStatement(sql);
            pstmt.setString(1, origin);
            pstmt.setString(2, Destination);

            ResultSet rs=pstmt.executeQuery();
            PrintWriter out=response.getWriter();


            con.close();
            //	request.setAttribute("origin", origin);
            //request.setAttribute("destination", Destination);
            Entity flightdetail=new Entity();
            request.setAttribute("origin", origin);
            request.setAttribute("destination", Destination);
            request.setAttribute("date", date);
            request.setAttribute("totalPerson", totalPerson);

            //request.setAttribute("destination", Destination);
            //request.getParameter("origin");
            //	request.getParameter("destination");
            //	request.getParameter("date");
            //	request.getParameter("totalPerson");


            //HttpSession session =request.getSession();
            //	session.setAttribute("flight", flightdetail);

            //	response.sendRedirect("FlightDetails.jsp");
            RequestDispatcher dispatcher=request.getRequestDispatcher("/FlightDetails.jsp");
            dispatcher.forward(request, response);

        }catch (Exception e) {
            System.out.println("Some Error occured in connection"+e);
        }
    }

}
