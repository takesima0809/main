package service;

import repositories.ShopRepository;

public class DeleteService {
	private final ShopRepository shopRepository;
	
	public DeleteService() {
		this.shopRepository=new ShopRepository();
	}
	
	public void deleteData(int depositNumber){//お渡し
		this.shopRepository.DeleteDepositData(depositNumber);
	}
}
