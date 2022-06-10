package entities;

public class DepositData {
	private final int depositNumber;
	private final String depositDay;
	private final int userId;
	private final int clothesId;
	private final boolean option1;
	private final boolean option2;
	private final int option3;
	private final int totalPrice;
	private final String finishDay;
	private final String factoryMessage;
	
	public DepositData(int depositNumber,String depositDay,int userId,int clothesId,
			boolean option1,boolean option2,int option3,int totalPrice,String finishDay,String factoryMessage){
		
		this.depositNumber=depositNumber;
		this.depositDay=depositDay;
		this.userId=userId;
		this.clothesId=clothesId;
		this.option1=option1;
		this.option2=option2;
		this.option3=option3;
		this.totalPrice=totalPrice;
		this.finishDay=finishDay;
		this.factoryMessage=factoryMessage;
	}
	
	public int getdepositNumber() {
		return this.depositNumber;
	}
	
	public String getDepositDay() {
		return this.depositDay;
	}
	
	public int getUserId() {
		return this.userId;
	}
	
	public int getClothesId() {
		return this.clothesId;
	}
	
	public boolean getOption1() {
		return this.option1;
	}
	
	public boolean getOption2() {
		return this.option2;
	}
	
	public int getOption3() {
		return this.option3;
	}
	
	public int getTotalPrice() {
		return this.totalPrice;
	}
	
	public String getFinishDay() {
		return this.finishDay;
	}
	
	public String getFactoryMessage() {
		return this.factoryMessage;
	}
}
