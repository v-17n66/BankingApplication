package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mybeans.OpenNewAccount;

/**
 * Servlet implementation class NewAccount
 */
@WebServlet("/NewAccount")
public class NewAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String acnm,acty;
		int acno;
		double bal;
		
		PrintWriter out=response.getWriter();
		acno=Integer.parseInt(request.getParameter("acno"));
		acnm=request.getParameter("acnm");
		acty=request.getParameter("actype");
		bal=Float.parseFloat(request.getParameter("bal"));
		
		OpenNewAccount obj=new OpenNewAccount();
	    obj.setAccno(acno);
	    obj.setAccnm(acnm);
	    obj.setAcctype(acty);
	    obj.setBalance(bal);
	    
	    if(obj.isInsertstatus())
	    {
	    	out.println("<h3 style='color:voilet'>Account open Successfully</h3>");
			out.println("<br>");

	    	out.println("<a href='manager.jsp'>Back</a>");
	    }
	    else
	    {
	    	out.println("<h3 style='color:red'>Account open Failed...</h3>");
	    	out.println("<a href='manager.jsp'>Back</a>");

	    }
		
	}

}
