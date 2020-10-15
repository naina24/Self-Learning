package com.lab4;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
import com.lab4.LoginJDBC;

@WebServlet(name="loginServlet", urlPatterns= {"/login"})
public class LoginServlet extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		String n=req.getParameter("email");
		String p=req.getParameter("password");
		LoginJDBC obj=new LoginJDBC();
		
			if(obj.checkLogin(n, p)) {
				out.write("<h1>Welcome");
			}
			else {
				out.println("Sorry Username or password error");
				RequestDispatcher rd=req.getRequestDispatcher("login.html");
				rd.include(req,res);
			}
		out.close();
	}
}
