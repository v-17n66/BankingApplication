package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybeans.Transaction;

/**
 * Servlet implementation class AccTransaction
 */
@WebServlet("/AccTransaction")
public class AccTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccTransaction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int acn;
		String trty;
		double amt;
		
		
		PrintWriter out=response.getWriter();
		acn=Integer.parseInt(request.getParameter("ano"));
		trty=request.getParameter("type");
		amt=Double.parseDouble(request.getParameter("amt"));
		
		Transaction tr=new Transaction();
		tr.setTranstype(trty);
		tr.setAccno(acn);
		tr.setAmount(amt);
		
		if(tr.isTransstatus())
		{
			out.println("<br>");
			out.println("<h2> Status</h2>");
			 out.println("<hr>");

			out.println("<h3  style='color:green'>Balance update Successfully</h3>");
			out.println("<br>");

	    	out.println("<a href='manager.jsp'>Back</a>");
		}
		else
		{
			out.println("<h3  style='color:red'>Transaction Failed...</h3>");
			out.println("<br>");

			out.println("<a href='manager.jsp'>Back</a>");
		}
		
	}

}
