package entities;

public class viewClothesData {
	private final int clothesId;
	private final String clothesName;
	private final int price;
	private final int finishDay;
	
	public viewClothesData(int clothesId,String clothesName,int price,int finishDay) {
		this.clothesId=clothesId;
		this.clothesName=clothesName;
		this.price=price;
		this.finishDay=finishDay;
	}
	
	public int getClothesId() {
		return this.clothesId;
	}
	
	public String getClothesName() {
		return this.clothesName;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public int getFinishDay() {
		return this.finishDay;
	}
}
