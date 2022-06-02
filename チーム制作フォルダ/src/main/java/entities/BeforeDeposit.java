package entities;

import values.FinishDay;
import values.TotalPrice;

public class BeforeDeposit {
	private final UserData userData;
	private final ClothesData clothesData;
	private final CleanOption cleanOption;
	private final TotalPrice totalPrice;
	private final FinishDay finishDay;
	
	public BeforeDeposit(UserData userData,ClothesData clothesData,CleanOption cleanOption,TotalPrice totalPrice,FinishDay finishDay) {
		this.userData=userData;
		this.cleanOption=cleanOption;
		this.clothesData=clothesData;
		this.totalPrice=totalPrice;
		this.finishDay=finishDay;
	}
	
	public UserData getUserData() {
		return this.userData;
	}
	
	public ClothesData getClothesData() {
		return this.clothesData;
	}
	
	public CleanOption getCleanOption() {
		return this.cleanOption;
	}
	
	public TotalPrice geTotalPrice() {
		return this.totalPrice;
	}
	
	public FinishDay getFinishDay() {
		return this.finishDay;
	}
}
