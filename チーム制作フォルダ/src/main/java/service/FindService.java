package service;

import clothesValues.ClothesId;
import entities.DepositDataList;
import entities.RegisterInfo;
import entities.UserData;
import repositories.ShopRepository;
import userValues.UserId;

public class FindService {
	private final ShopRepository shopRepository;
	public FindService() {
		this.shopRepository = new ShopRepository();
	}
	
	public void findClothesDatas(ClothesId clothesId) {
		shopRepository.getClothesData(clothesId.toInt());
	}
	
	public DepositDataList findDepositDatas(UserId userId) {
		return this.shopRepository.findDepositDataAll(userId.toInt());
	}
}
