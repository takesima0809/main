package service;

import java.sql.SQLException;
import java.util.List;

import repositories.ShopRepository;

public class DeleteService {
	private final ShopRepository shopRepository;

	public DeleteService() {
		this.shopRepository=new ShopRepository();
	}

	//データ削除
	public void deleteData(List<Integer>list) throws SQLException {
		this.shopRepository.deleteDepositData(list);
	}
}
