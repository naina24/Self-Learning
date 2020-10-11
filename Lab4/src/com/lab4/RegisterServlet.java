package com.lab4;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet(name="regServlet", urlPatterns= {"/register"})
public class RegisterServlet extends HttpServlet{
protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	System.out.println("service()");
	String fn=req.getParameter("fname");
	String em=req.getParameter("email");
	String ph=req.getParameter("phone");
	String ge=req.getParameter("gender");
	String ti=req.getParameter("timings");
	String co=req.getParameter("course");
	String cous[]=req.getParameterValues("course");
	String re=req.getParameter("remarks");
	System.out.println("Full name:"+fn);
	System.out.println("Email id:"+em);
	System.out.println("Phone no:"+ph);
	System.out.println("Gender:"+ge);
	System.out.println("Timings:"+ti);
	System.out.println("Course:"+co);
	System.out.println("All courses");
	if(cous!=null)
		for(String c:cous) {
			System.out.println(c);
		}
	System.out.println("Remarks:"+re);
	res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	out.println("<h1>Full Name:"+fn);
	out.println("<h1>Email:"+em);
	out.println("<h1>Phone:"+ph);
	out.println("<h1>Gender:"+ge);
	out.println("<h1>Timings:"+ti);
	out.println("<h1>Course:"+co);
	out.println("<h1>All Courses");
	if(cous!=null)
		for(String c:cous) {
			out.println("<br/>"+c);
		}
	out.println("<h1>Remarks:"+re);
}
}
