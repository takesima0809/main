package entities;

public class BeforeDeposit {
	private final UserData userData;
	private final int clothesId;
	private final boolean option1;
	private final boolean option2;
	private final int option3;
	private int totalPrice;
	private String finishDay;

	public BeforeDeposit(UserData userData,int clothesId,boolean option1,boolean option2,int option3,int totalPrice,String finishDay) {
		this.userData=userData;
		this.option1=option1;
		this.option2=option2;
		this.option3=option3;
		this.clothesId=clothesId;
		this.totalPrice=totalPrice;
		this.finishDay=finishDay;
	}

	public UserData getUserData() {
		return this.userData;
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

	public int getCleanOption3() {
		return this.option3;
	}

	public int geTotalPrice() {
		return this.totalPrice;
	}

	public String getFinishDay() {
		return this.finishDay;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice=totalPrice;
	}

	public void setFinishDay(String finishDay) {
		this.finishDay=finishDay;
	}

}
