package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
	public RegisterList ClothesReception(List<BeforeDeposit>list) throws ParseException { 
		RegisterList registerList=new RegisterList();
		for(int i=0;i<list.size();i++) {
			BeforeDeposit beforeDeposit=list.get(i);
			
			//計算(price.ext)
			this.shopRepository.getClothesData(beforeDeposit.getClothesData());
			TotalPrice totalPrice=new TotalPrice(this.shopRepository.getClothesData(beforeDeposit.getClothesData()).getPrice().toInt());
			FinishDay finishDay=new FinishDay(this.shopRepository.getClothesData(beforeDeposit.getClothesData()).getDay().toString());	
			
			//処理
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			// Date型変換
			Date date=new Date();
			Date formatDate=sdf.parse(beforeDeposit.getFinishDay());
			
			//カレンダー型
			Calendar cdr =Calendar.getInstance();
			cdr.setTime(date);
			
			//オプション1
			if(beforeDeposit.getCleanOption1()) {
				cdr.add(Calendar.DAY_OF_MONTH,1);
			}else {
				cdr.add(Calendar.DAY_OF_MONTH,Integer.parseInt(beforeDeposit.getFinishDay()));
			}
			date=cdr.getTime();
			//str変換
			String string=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			
			//オプション
			CleanOption cleanOption=new CleanOption();
			
			//2
			if(beforeDeposit.getCleanOption2()) {
				totalPrice=new TotalPrice(cleanOption.washDeluxeFinish(totalPrice.toInt()));
			}
			
			//3
			totalPrice=new TotalPrice(cleanOption.washStainRemoval(totalPrice,beforeDeposit.getCleanOption3()));
			
			beforeDeposit.setFinishDay(String.valueOf(string));
			beforeDeposit.setTotalPrice(totalPrice.toInt());
			
			registerList.add(this.shopRepository.showAddDatas(beforeDeposit));
		}
		return registerList;
	}
}
