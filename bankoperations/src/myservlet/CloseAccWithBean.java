package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybeans.CloseAccount;

/**
 * Servlet implementation class CloseAccWithBean
 */
@WebServlet("/CloseAccWithBean")
public class CloseAccWithBean extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CloseAccWithBean() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int acn;
		PrintWriter out=response.getWriter();
		acn=Integer.parseInt(request.getParameter("accno"));
		
		CloseAccount obj=new CloseAccount();
		obj.setAccno(acn);
		if(obj.isClosestatus())
		{
			out.println("<h3 style='color:green'>Account close Successfully</h3>");
			out.println("<br>");
		      out.println("<a href='manager.jsp'>Back</a>");
		}
		else
		{
			out.println("<h3>Please type correct account number</h3>");
		}
	}

}
