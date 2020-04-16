package mybeans;

import java.sql.*;
import mybeans.DBConnector;

public class Register
{
	private int id,id1;

	public Register()
	{
		id=0;
		id1=0;
	}
	public int getId1() {
		return id1;
	}

	public void setId(int id) {
		this.id = id;
		onIdChange();
		
	}
	private void onIdChange()
	{
		
		PreparedStatement pst;
		Connection con;
		ResultSet rs;
		try
		{
			DBConnector dbc=new DBConnector();
			con=dbc.getDbconnection();
			
		   pst=con.prepareStatement("select accno from accounts where accno=?;");
		   pst.setInt(1, id);
		   rs=pst.executeQuery();
		
		if(rs.next())
		{
		   id1=rs.getInt("accno");
		}
		
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		
		
	}
}
