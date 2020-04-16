package mybeans;

import java.sql.*;

public class Transaction
{
   private String transtype;
   private int accno;
   private double amount;
   private boolean transstatus;
   
   public Transaction()
   {
	   transtype="";
	   accno=0;
	   amount=0.0;
	   transstatus=false;
   }

public boolean isTransstatus() {
	return transstatus;
}

public void setTranstype(String transtype) {
	this.transtype = transtype;
}

public void setAccno(int accno) {
	this.accno = accno;
}

public void setAmount(double amount) {
	this.amount = amount;
	OnAmountChange();
}

private void OnAmountChange()
{
	Connection con;
	PreparedStatement pst;
	try
	{
	DBConnector dbc=new DBConnector();
	con=dbc.getDbconnection();
	
	
	  
	pst=con.prepareStatement("insert into acctransaction values(transno,now(),?,?,?);");
	  
       pst.setInt(1,accno);
       pst.setString(2,transtype);
       pst.setDouble(3,amount);
       
      pst.executeUpdate();
      
	
		transstatus=true;
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	
	
}

}
