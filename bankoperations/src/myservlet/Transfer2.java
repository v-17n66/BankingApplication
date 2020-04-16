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
 * Servlet implementation class Transfer2
 */
@WebServlet("/Transfer2")
public class Transfer2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transfer2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int sacc,dacc;
		Double amt;
		PrintWriter out=response.getWriter();
		sacc=Integer.parseInt(request.getParameter("sano"));
		dacc=Integer.parseInt(request.getParameter("dano"));
		amt=Double.parseDouble(request.getParameter("bal"));
		
		TransAmt obj=new TransAmt();
		obj.setSourceacc(sacc);
		obj.setDestinationacc(dacc);
		obj.setAmount(amt);
		if(amt<=5000)
		{
		 if(obj.isTransferstatus())
			out.println("<h3>Amount Transfer Successfully</h3>");
		else
			out.println("<h3>Amount Transfer Failed...</h3>");
		}
		else
			out.println("<h3>Amount Transfer Limit Of Customer Is Upto 5000<20000</h3>");
	}

}
