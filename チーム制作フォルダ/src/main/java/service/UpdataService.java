package service;

import repositories.ShopRepository;

public class UpdataService {
<<<<<<< HEAD
	ShopRepository shopRepository;
//	public AddService() {
//		this.shopRepository = new ShopRepository();
//	}
}
=======
	private final ShopRepository shopRepository;
	public UpdataService() {
		this.shopRepository = new ShopRepository();
	}
	public void updataFinishDate(int depositId,String day) {
		this.shopRepository.UpdateDay(depositId, day);
	}
	public void updataMessage(int depositId,String message) {
		this.shopRepository.addMessage(depositId, message);
	}
}
>>>>>>> main
