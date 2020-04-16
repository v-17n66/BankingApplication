package mybeans;

import java.sql.*;


public class SearchAccount
{
	private int acnumber;
	private String acname;
	
	private double balance;

	
	public SearchAccount()
	{
	acnumber=0;
	acname="not found";
	
    balance=0.00;
	}

	

	public String getAcname() {
		return acname;
	}

	public double getBalance() {
		return balance;
	}

	public void setAcnumber(int acnumber) {
		this.acnumber = acnumber;
		onAccountNumberChange();
	}

	private void onAccountNumberChange() {
		// TODO Auto-generated method stub
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		
		try
		{
			DBConnector dbc=new DBConnector();
			con=dbc.getDbconnection();
			
			pst=con.prepareStatement("select *from accounts where accno=?;" );
    		pst.setInt(1, acnumber);
    		rs=pst.executeQuery();
    		if(rs.next())
    		{
    			acname=rs.getString("accnm");
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

