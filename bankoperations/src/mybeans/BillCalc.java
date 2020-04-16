package mybeans;

public class BillCalc
{
	private int units;
	private double netbill;
	
	public BillCalc()
	{
		units=0;
		netbill=0.0;
	}

	public double getNetbill() {
		return netbill;
	}

	public void setUnits(int units) {
		this.units = units;
		onAmountChanged();
		}

		private void onAmountChanged() 
		{
			if(units<100)
				netbill=units*1.20;
			else if(units<=300)
				netbill=100*1.20+(units-100)*2;
			else if(units>300)
				netbill=100*1.20+200*2+(units-300)*3;
			
		
	}
}