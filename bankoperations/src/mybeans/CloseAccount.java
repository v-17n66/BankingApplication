package mybeans;

import java.sql.*;

public class CloseAccount
{
	private int accno;
	private boolean closestatus;
	
	public CloseAccount()
	{
		accno=0;
		closestatus=false;
	}

	public boolean isClosestatus() {
		return closestatus;
	}

	public void setAccno(int accno) {
		this.accno = accno;
		onChangeAccno();
	}

	private void onChangeAccno() 
	{
		Connection con;
		PreparedStatement pst;
	
		try
		{
		DBConnector dbc=new DBConnector();
		con=dbc.getDbconnection();
		pst=con.prepareStatement("delete from accounts where accno=?;");
		pst.setInt(1,accno);
		pst.executeUpdate();
		
		closestatus=true;
		con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
