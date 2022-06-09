package service;

import repositories.ShopRepository;

public class UpdataService {
	private final ShopRepository shopRepository;
	public UpdataService() {
		this.shopRepository = new ShopRepository();
	}
	public void updataFinishDate(int depositId,String day) {
		this.shopRepository.updateDay(depositId, day);
	}
	public void updataMessage(int depositId,String message) {
		this.shopRepository.addMessage(depositId, message);
	}
}