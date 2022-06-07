package service;

import clothesValues.ClothesId;
import entities.DepositDataList;
import repositories.ShopRepository;
import userValues.UserId;

public class FindService {
	private final ShopRepository shopRepository;
	public FindService() {
		this.shopRepository = new ShopRepository();
	}
	
	//衣服データを返す(いらないかも)
	public void findClothesDatas(ClothesId clothesId) {
		this.shopRepository.getClothesData(clothesId.toInt());
	}
	
	//受付時の追加データ表示
	
	//ユーザidの該当する預かりデータを返す
	public DepositDataList findDepositDatas(UserId userId) {
		return this.shopRepository.findDepositDataAll(userId.toInt());
	}
	
	//絞り込み検索（預かり日）
	public DepositDataList FilteringList(String depositDate) {
		return this.shopRepository.getFilteringList(depositDate);
	}
	
	//お渡しする（削除する）データ
	public DepositDataList deliveryDatas(int[] depositNumber) {
		return this.shopRepository.findDepositDataList(depositNumber);
	}
}
