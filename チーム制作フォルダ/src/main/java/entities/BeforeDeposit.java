package entities;

public class BeforeDeposit {
	private final int userId;
	private final int clothesId;
	private final boolean option1;
	private final boolean option2;
	private final boolean option3;
	private final int totalPrice;
	private final String finishDay;
	
	public BeforeDeposit(int userId,int clothesId,boolean option1,boolean option2,boolean option3,int totalPrice,String finishDay) {
		this.userId=userId;
		this.option1=option1;
		this.option2=option2;
		this.option3=option3;
		this.clothesId=clothesId;
		this.totalPrice=totalPrice;
		this.finishDay=finishDay;
	}
	
	public int getUserId() {
		return this.userId;
	}
	
	public int getClothesData() {
		return this.clothesId;
	}
	
	public boolean getCleanOption1() {
		return this.option1;
	}
	
	public boolean getCleanOption2() {
		return this.option2;
	}
	
	public boolean getCleanOption3() {
		return this.option3;
	}
	
	public int geTotalPrice() {
		return this.totalPrice;
	}
	
	public String getFinishDay() {
		return this.finishDay;
	}
}
