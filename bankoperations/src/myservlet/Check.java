package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mybeans.DBConnector;

/**
 * Servlet implementation class Check
 */
@WebServlet("/Check")
public class Check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Check() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id,psw,ty;
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		
		PrintWriter out=response.getWriter();
		  id=request.getParameter("uid");
		  psw=request.getParameter("psw");
		
		try
		{
			DBConnector dbc=new DBConnector();
			con=dbc.getDbconnection();
			
			pst=con.prepareStatement("select *from users where userid=? and pswd=? and userstatus='active';");
			pst.setString(1, id);
			pst.setString(2,psw);
			rs=pst.executeQuery();
			
			if(rs.next())
			{
				HttpSession ses=request.getSession();
				ses.setAttribute("userid", id);
				
				
				ty=rs.getString("usertype");
				if(ty.equals("Manager"))
					response.sendRedirect("manager.jsp");
				
				 else if(ty.equals("cashier"))
					response.sendRedirect("cashier.jsp");
				
				 else if(ty.equals("customer"))
				    response.sendRedirect("customer.jsp");  
				 
			}
			else
				response.sendRedirect("failure.jsp");
			con.close();
			
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

}
