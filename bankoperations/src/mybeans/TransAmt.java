package mybeans;

import java.sql.*;

public class TransAmt
{
	private int sourceacc;
	private int destinationacc;
	private double amount;
	private boolean transferstatus;
	
	public TransAmt()
	{
		sourceacc=0;
		destinationacc=0;
		amount=0.00;
		transferstatus=false;
	}

	public boolean isTransferstatus() {
		return transferstatus;
	}

	public void setSourceacc(int sourceacc) {
		this.sourceacc = sourceacc;
	}

	public void setDestinationacc(int destinationacc) {
		this.destinationacc = destinationacc;
	}

	public void setAmount(double amount) {
		this.amount = amount;
		onTransferAmt();
	}
	public void onTransferAmt()
	 {
		Connection con;
		CallableStatement cst;
		int cnt;
		
		
		try
		{
			DBConnector dbc=new DBConnector();
			con=dbc.getDbconnection();
			
			
			cst=con.prepareCall("{call trans(?,?,?)};");
			cst.setInt(1, sourceacc);
			cst.setInt(2, destinationacc);
			cst.setDouble(3, amount);
			cnt=cst.executeUpdate();
			if(cnt>0)
			{
			transferstatus=true;
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}
