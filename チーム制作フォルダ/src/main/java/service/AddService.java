package service;

import java.util.List;

import entities.BeforeDeposit;
import entities.CleanOption;
import entities.RegisterList;
import entities.UserData;
import repositories.ShopRepository;
import userValues.PhoneNumber;
import userValues.UserName;
import values.FinishDay;
import values.TotalPrice;


public class AddService {
	private final ShopRepository shopRepository;
	public AddService() {
		this.shopRepository = new ShopRepository();
	}

	//ユーザー登録
	public void UserSignUp(String name,String PhoneNamber) {
		UserName username = new UserName(name);
		PhoneNumber usernamber = new PhoneNumber(PhoneNamber);
		UserData userData = new UserData(usernamber, null, username);
		this.shopRepository.witeUserDatas(userData);
	}

	//受付登録
	public RegisterList ClothesReception(List<BeforeDeposit>list) { 
		RegisterList registerList=new RegisterList();
		for(int i=0;i<list.size();i++) {
			BeforeDeposit beforeDeposit=list.get(i);
			
			//計算(price.ext)
			this.shopRepository.getClothesData(beforeDeposit.getClothesData());
			TotalPrice totalPrice=new TotalPrice(this.shopRepository.getClothesData(beforeDeposit.getClothesData()).getPrice().toInt());
			FinishDay finishDay=new FinishDay(this.shopRepository.getClothesData(beforeDeposit.getClothesData()).getDay().toString());
			int finishDate=finishDay.toInt();
			double price=0;
			
			//オプション計算
			CleanOption cleanOption=new CleanOption();
			
			//1
			if(beforeDeposit.getCleanOption1()) {
				finishDate=1;
			}
			//2
			if(beforeDeposit.getCleanOption2()) {
				totalPrice=new TotalPrice(cleanOption.washDeluxeFinish(totalPrice.toInt()));
			}
			
			//3
			totalPrice=new TotalPrice(cleanOption.washStainRemoval(totalPrice,beforeDeposit.getCleanOption3()));
			
			beforeDeposit.setFinishDay(String.valueOf(finishDate));
			beforeDeposit.setTotalPrice(totalPrice.toInt());
			
			registerList.add(this.shopRepository.showAddDatas(beforeDeposit));
		}
		return registerList;
	}
}
