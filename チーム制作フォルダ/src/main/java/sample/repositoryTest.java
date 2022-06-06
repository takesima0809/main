package sample;

import entities.BeforeDeposit;
import entities.RegisterInfo;
import entities.UserData;
import repositories.ShopRepository;
import userValues.PhoneNumber;
import userValues.UserId;
import userValues.UserName;

public class repositoryTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		UserName userName=new UserName("小山　風香");
		PhoneNumber phoneNumber=new PhoneNumber("0489555104");
		UserId userId=new UserId(3);
		UserData userData=new UserData(phoneNumber,userId,userName);
		BeforeDeposit beforeDeposit=new BeforeDeposit(userData, 1, true, true, false,225,"1");
		ShopRepository shopRepository=new ShopRepository();
		RegisterInfo registerInfo=shopRepository.showAddDatas(beforeDeposit, 1).next();
		System.out.println(registerInfo.getdepositNumber());
		System.out.println(registerInfo.getregistrationDate());
		
		shopRepository.witeUserDatas(userData);
	}

}
