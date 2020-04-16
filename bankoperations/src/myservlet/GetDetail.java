package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybeans.DBConnector;

/**
 * Servlet implementation class GetDetail
 */
@WebServlet("/GetDetail")
public class GetDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String  ps,unm,gen,mob,em,ct,sq,an;
		int id,age;
		Connection con;
		PreparedStatement pst;
		
		
		PrintWriter out=response.getWriter();
		id=Integer.parseInt(request.getParameter("uid"));
		ps=request.getParameter("psw");
		unm=request.getParameter("unm");
		try
		{
			DBConnector dbc=new DBConnector();
			con=dbc.getDbconnection();
			
			
			 pst=con.prepareStatement ("insert into users values(?,?,?,default,default);");
			   pst.setInt(1,id);
			   pst.setString(2,ps);
			   pst.setString(3,unm);
			   
			   pst.executeUpdate();
			   
			   gen=request.getParameter("gen");
			   mob=request.getParameter("mob");
			   age=Integer.parseInt(request.getParameter("age"));
			   em=request.getParameter("eml");
			   ct=request.getParameter("city");
			   sq=request.getParameter("sec");
				an=request.getParameter("ans");
			   
			   pst=con.prepareStatement("insert into userpersonal values(?,now(),?,?,?,?,?,?,?);");
			   pst.setInt(1, id);
			
			   pst.setString(2, gen);
			   pst.setString(3, mob);
			   pst.setString(4, em);
			   pst.setInt(5, age);
			   pst.setString(6, ct);
			   pst.setString(7, sq);
				pst.setString(8, an);
			   
			   pst.executeUpdate();
			   
			       out.println("<br>");
			       out.println("<h2>Account Created Successfully</h2>");
			       out.println("<br>");
			       
			       out.println("<h3> <a href='index.jsp'>login into account</a></h3>");
			       
			   con.close();
			   }
			catch(Exception e)
			   {
			     out.println(e);
			   }
			

		
	}

}
