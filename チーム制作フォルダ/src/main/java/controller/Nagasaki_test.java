package controller;

import entities.DepositData;
import entities.DepositDataList;
import repositories.ShopRepository;

public class Nagasaki_test {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		ShopRepository shopRepository=new ShopRepository();
		DepositDataList depositDataList=shopRepository.messageDatas();
		DepositData depositData=null;
		while(depositDataList.hasNext()) {
			depositData=depositDataList.next();
			System.out.println(depositData.getFactoryMessage());
		}
		
	}

}
