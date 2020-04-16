package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybeans.TransAmt;

/**
 * Servlet implementation class TransferAmt
 */
@WebServlet("/TransferAmt")
public class TransferAmt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferAmt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#dopost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int sacc,dacc;
		Double amt;
		PrintWriter out=response.getWriter();
		sacc=Integer.parseInt(request.getParameter("sano"));
		dacc=Integer.parseInt(request.getParameter("dano"));
		amt=Double.parseDouble(request.getParameter("bal"));
		
		TransAmt tm=new TransAmt();
		tm.setSourceacc(sacc);
		tm.setDestinationacc(dacc);
		tm.setAmount(amt);
		
		
		 if(tm.isTransferstatus())
		 {
			 out.println("<br>");
			 out.println("<h2>Transfer Status:</h2>");
			 out.println("<br>");
			 out.println("<hr>");
			 
			 
			out.println("<h3 style='color:green'>Amount Transfer Successfully</h3>");
			out.println("<br>");
			out.println("<a href='manager.jsp'>Back</a>");
			
		 }
		else
		{
			out.println("<h3  style='color:red'>Amount Transfer Failed...</h3>");
		    out.println("<a href='manager.jsp'>Back</a>");
		}
	}

}
