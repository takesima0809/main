package service;

import java.sql.SQLException;

import repositories.ShopRepository;

public class DeleteService {
	private final ShopRepository shopRepository;

	public DeleteService() {
		this.shopRepository=new ShopRepository();
	}

	//データ削除
	public void deleteData(int[] depositNumber) throws SQLException {
		this.shopRepository.DeleteDepositData(depositNumber);
	}
}
