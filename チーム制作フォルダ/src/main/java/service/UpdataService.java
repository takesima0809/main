package service;

import repositories.ShopRepository;
import values.FinishDay;

public class UpdataService {
	ShopRepository shopRepository;
	public UpdataService() {
		this.shopRepository = new ShopRepository();
	}
	public void UpdataFinishDate(String day) {
		FinishDay finishDay1 = new FinishDay(day);
	}
}
