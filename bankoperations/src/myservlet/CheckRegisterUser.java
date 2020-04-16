package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import mybeans.Register;

/**
 * Servlet implementation class CheckRegisterUser
 */
@WebServlet("/CheckRegisterUser")
public class CheckRegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckRegisterUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =response.getWriter();
		int id=Integer.parseInt(request.getParameter("uid"));
		
		
		
		Register r = new Register();
		r.setId(id);

		 
		 int temp = r.getId1();
		 
		
        if(id==temp)
        {  
        	
        	out.print("<br>");
        	out.print("<h2>'Welcome Sir!'  You are a authorise member of our Branch.</h2>");
        	
        	out.print("<h3>Click here for a Registration Page.</h3>");
        	
        	out.print("<a href='registration.html'> <u> Register Now </u></a>");
        	}
        else
        {
        	out.print("<br>");
        	out.print("<h2>You are not valid customer of our branch. For Register you have to be account in our branch. Kindly create account to register.</h2>");
        	out.print("<br>");
        	out.print("<a href='index.jsp'> <u> HOME </u></a>");
       
        }
        
		
		
	}

}
