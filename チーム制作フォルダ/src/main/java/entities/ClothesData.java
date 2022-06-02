package entities;

import clothesValues.ClothesId;
import clothesValues.Price;
import clothesValues.WaitDay;

public class ClothesData {
	private final ClothesId clothesId;
	private final Price price;
	private final WaitDay waitDay;
	
	public ClothesData(ClothesId clothesId,Price price,WaitDay waitDay) {
		this.clothesId=clothesId;
		this.price=price;
		this.waitDay=waitDay;
	}
	
	public ClothesId getClothesId() {
		return this.clothesId;
	}
	
	public Price getPrice() {
		return this.price;
	}
	
	public WaitDay getDay() {
		return this.waitDay;
	}
}
