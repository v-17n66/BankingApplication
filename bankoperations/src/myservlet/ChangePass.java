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
 * Servlet implementation class ChangePass
 */
@WebServlet("/ChangePass")
public class ChangePass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out=response.getWriter();
		Connection con;
		PreparedStatement pst;
		int cnt;
		
		String id,nwps,crps,cnps;
		id=request.getParameter("uid");
		crps=request.getParameter("CurPass");
		nwps=request.getParameter("NewPass");
		cnps=request.getParameter("ConPass");
		
		if(nwps.equals(cnps))
		{
			try
			{
				DBConnector dbc=new DBConnector();
				con=dbc.getDbconnection();
				pst=con.prepareStatement("update users set pswd=? where userid=? and pswd=?;");
				pst.setString(1, nwps);
				pst.setString(2, id);
				pst.setString(3, crps);
				cnt=pst.executeUpdate();
				if(cnt==0)
				{
					out.println("<h3 style='color:red'>userid/current password incorrect</h3>");
					
				}
				else
				{
					out.println("<h3 style='color:green'>password changed successfully</h3>");
				}
				
			}
			catch(Exception e)
			{
				out.println(e);
			}
			
		}
		else
		{
			out.println("<h3>New passwords mismatched</h3>");
		}
		
		
		
		
	}


}
