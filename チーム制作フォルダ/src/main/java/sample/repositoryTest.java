package sample;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import entities.BeforeDeposit;
import entities.DepositData;
import entities.DepositDataList;
import entities.UserData;
import repositories.ShopRepository;
import userValues.PhoneNumber;
import userValues.UserId;
import userValues.UserName;



public class repositoryTest {

	public static void main(String[] args) throws ParseException{
		// TODO 自動生成されたメソッド・スタブ
		UserName userName=new UserName("小山　風香");
		PhoneNumber phoneNumber=new PhoneNumber("0489555104");
		UserId userId=new UserId(3);
		UserData userData=new UserData(phoneNumber,userId,userName);
		BeforeDeposit beforeDeposit=new BeforeDeposit(userData, 1, true, true, false,225,"1");
		ShopRepository shopRepository=new ShopRepository();
		//RegisterInfo registerInfo=shopRepository.showAddDatas(beforeDeposit, 1).next();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// Date型変換
		Date formatDate=null;
		DepositDataList depositDataList=shopRepository.findDepositDataAll(3);
		DepositData depositData=null;
		while(depositDataList.hasNext()) {
			depositData=depositDataList.next();
			formatDate=sdf.parse(depositData.getDepositDay());
		}
		//カレンダー型
		Calendar cdr =Calendar.getInstance();
		cdr.setTime(formatDate);
		cdr.add(Calendar.HOUR_OF_DAY, 9);
		formatDate=cdr.getTime();
		//str変換
		String string=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(formatDate);
		System.out.println(string);
		
		//shopRepository.addMessage(1, "シャツが破けてしまいました");
		//shopRepository.UpdateDay(1, "お渡し可");
		//System.out.println(registerInfo.getdepositNumber());
		//System.out.println(registerInfo.getregistrationDate());
		//shopRepository.findDepositDataAll(3).next().getDepositDay();
		//shopRepository.witeUserDatas(userData);
	}

}
