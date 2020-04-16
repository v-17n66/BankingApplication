package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybeans.BillCalc;

/**
 * Servlet implementation class CalcBill
 */
@WebServlet("/CalcBill")
public class CalcBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcBill() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cnm;
	     int unt;
	     double net;
	     PrintWriter out=response.getWriter();
	        cnm=request.getParameter("custnm");
	        unt=Integer.parseInt(request.getParameter("units"));
	      
	        BillCalc bc=new BillCalc();
	        bc.setUnits(unt);
	        net=bc.getNetbill();
	        
	        out.println("Customer Name:"+cnm);
	        out.println("<br>Net Bill:"+net);
	        out.println("<br>"); 
	        out.println("<hr>");
	        out.println("<br>You have to pay Rs:"+net);
	        out.println("<br><a href=PaymentOption.html>Pay Now</a>");
	}

}
