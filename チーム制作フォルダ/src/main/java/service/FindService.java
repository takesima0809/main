package service;

import java.sql.SQLException;
import java.util.List;

import entities.DepositDataList;
import entities.viewClothesData;
import repositories.ShopRepository;
import userValues.UserId;

public class FindService {
	private final ShopRepository shopRepository;
	public FindService() {
		this.shopRepository = new ShopRepository();
	}
	
	//衣服データを返す(いらないかも)
//	public void findClothesDatas(ClothesId clothesId) {
//		this.shopRepository.getClothesData(clothesId.toInt());
//	}
	
	public List<viewClothesData> findClothesDatas() {
		return this.shopRepository.getClothesData();
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
	public DepositDataList deliveryDatas(List<Integer>list) throws SQLException {
		DepositDataList depositDataList=this.shopRepository.findDepositDataList(list);
		if(list.size()==depositDataList.size()) {
			return depositDataList;
		}
		return null;
	}
	
	public DepositDataList findAllData() {
		return this.shopRepository.findAll();
	}
	
	public DepositDataList getFactoryMes() {
		return this.shopRepository.messageDatas();
	}
}
