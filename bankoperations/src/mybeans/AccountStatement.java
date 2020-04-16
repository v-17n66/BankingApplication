package mybeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountStatement
{
	private int acno;
	private double balance;
	
	public AccountStatement()
	{
		acno=0;
		balance=0.0;
	}

	public double getBalance() {
		return balance;
	}

	public void setAcno(int acno) {
		this.acno = acno;
		onAmountChange();
	}

	private void onAmountChange()
	{
		
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		
		try
		{
			DBConnector dbc=new DBConnector();
			con=dbc.getDbconnection();
			
			pst=con.prepareStatement("select *from accounts where accno=?;" );
    		pst.setInt(1, acno);
    		rs=pst.executeQuery();
    		if(rs.next())
    		{
    			
    			balance=rs.getDouble("balance");
    			
    		}
    		con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
