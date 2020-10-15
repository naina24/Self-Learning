package com.lab4;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;
import com.lab4.RegisterJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.http.HttpServlet;

@WebServlet(name="regServlet", urlPatterns= {"/register"})
public class RegisterServlet extends HttpServlet{
protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	try {
		Connection con=RegisterJDBC.initializeDatadase();
		PreparedStatement st=con.prepareStatement("insert into user values(?,?,?,?,?)");
		st.setInt(1, Integer.valueOf(req.getParameter("sid")));
		st.setString(2, req.getParameter("fname"));
		st.setString(3, req.getParameter("email"));
		st.setLong(4, Long.valueOf(req.getParameter("phone")));
		st.setString(5, req.getParameter("dob"));
		st.executeUpdate();
		st.close();
		con.close();
		/*res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<h1>Succesful");*/
		RequestDispatcher rs=req.getRequestDispatcher("login");
	}
	catch(Exception e){
		e.printStackTrace();
	}
	/*System.out.println("service()");
	String fn=req.getParameter("fname");
	String id=req.getParameter("sid");
	String em=req.getParameter("email");
	String ph=req.getParameter("phone");
	String dob=req.getParameter("dob");*/
	/*System.out.println("Full name:"+fn);
	System.out.println("Id: "+id);
	System.out.println("Email id:"+em);
	System.out.println("Phone no:"+ph);
	System.out.println("Password:"+dob);*/
	
}
}
