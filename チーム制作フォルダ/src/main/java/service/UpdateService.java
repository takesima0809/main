package service;


import repositories.ShopRepository;

public class UpdateService {
	private final ShopRepository shopRepository;
	public UpdateService() {
		this.shopRepository = new ShopRepository();
	}
	public boolean updataFinishDate(int depositId,String day) {
		return this.shopRepository.updateDay(depositId, day);
	}
	public boolean updataMessage(int depositId,String message){
		return this.shopRepository.addMessage(depositId, message);
	}
}