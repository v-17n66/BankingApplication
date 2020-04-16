package mybeans;

import java.sql.*;

public class OpenNewAccount
{
	private int accno;
	private String accnm;
	private String acctype;
	private double balance;
	private boolean insertstatus;
	
	public OpenNewAccount()
	{
		accno=0;
		accnm="";
		acctype="";
		balance=0.0;
		insertstatus=false;
	}

	public boolean isInsertstatus() {
		return insertstatus;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public void setAccnm(String accnm) {
		this.accnm = accnm;
	}

	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}

	public void setBalance(double balance) {
		this.balance = balance;
		insertAccount();
	}
	private void insertAccount()
	{
		Connection con;
		PreparedStatement cst;
		try
		{
			DBConnector dbc=new DBConnector();
			con=dbc.getDbconnection();
			
		    cst=con.prepareStatement("insert into accounts values(?,?,?,?,now());");
		    cst.setInt(1, accno);
		    cst.setString(2, accnm);
		    cst.setString(3, acctype);
		    cst.setDouble(4, balance);
		    
		    cst.execute();
		    insertstatus=true;
		       
		     
		       
		   con.close();
		    
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
}
