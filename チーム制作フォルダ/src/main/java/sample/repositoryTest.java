package sample;

import java.sql.SQLException;
import java.text.ParseException;

import controller.FactoryController;
import entities.BeforeDeposit;
import entities.UserData;
import repositories.ShopRepository;
import service.AddService;
import service.UpdataService;
import userValues.PhoneNumber;
import userValues.UserId;
import userValues.UserName;



public class repositoryTest {

	public static void main(String[] args) throws ParseException, NumberFormatException, SQLException{
		// TODO 自動生成されたメソッド・スタブ
		UserName userName=new UserName("賀川　勇太");
		PhoneNumber phoneNumber=new PhoneNumber("09078345232");
		UserId userId=new UserId(2);
		UserData userData=new UserData(phoneNumber,userId,userName);
		BeforeDeposit beforeDeposit=new BeforeDeposit(userData, 7, false, false,3,0,"0000-00-00 00:00:00");
		ShopRepository shopRepository=new ShopRepository();
		//RegisterInfo registerInfo=shopRepository.showAddDatas(beforeDeposit, 1).next();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		DepositData depositData=null;
		UpdataService updataService=new UpdataService();
		AddService addService=new AddService();
		
		//ユーザ登録
		//addService.UserSignUp("賀川　勇太","09098349746");
		
		//受付
//		List<BeforeDeposit>list=new ArrayList<>();
//		list.add(beforeDeposit);
		//addService.ClothesReception(list);
		
		//変更　
		//updataService.updataFinishDate(7, "お渡し可");
		//updataService.updataMessage(6, "ちょっといいか？");
		
		//削除
//		DeleteService deleteService=new DeleteService();
//		int[] test= {1,2,3};
//		deleteService.deleteData(test);
		
		//取得
//		int[] test= {4,8,7};
//		FindService findService=new FindService();
//		DepositDataList depositDataList=findService.findDepositDatas(userId);
//		depositDataList=findService.deliveryDatas(test);
//		//depositDataList=findService.FilteringList("2022-06-07");
//		while(depositDataList.hasNext()) {
//			DepositData depositData=depositDataList.next();
//			System.out.print(depositData.getdepositNumber()+" ");
//			System.out.print(depositData.getDepositDay()+" ");
//			System.out.print(depositData.getUserId()+" ");
//			System.out.print(depositData.getClothesId()+" ");
//			System.out.print(depositData.getOption1()+" ");
//			System.out.print(depositData.getOption2()+" ");
//			System.out.print(depositData.getOption3()+" ");
//			System.out.print(depositData.getFinishDay()+" ");
//			System.out.print(depositData.getTotalPrice()+" ");
//			System.out.print(depositData.getFactoryMessage()+" ");
//			System.out.println();
//		}
		
		
		FactoryController factoryController=new FactoryController();
		factoryController.run();
		
		
		
		//System.out.println(shopRepository.getClothesData(7).getDay().toInt());
		
//		// Date型変換
//		Date formatDate=null;
//		//DepositDataList depositDataList=shopRepository.findDepositDataAll(3);
//		DepositData depositData=null;
//		
//		//depositData=depositDataList.next();
//		//formatDate=sdf.parse(depositData.getDepositDay());
//
//		//カレンダー型
//		Calendar cdr =Calendar.getInstance();
//		cdr.setTime(formatDate);
//		cdr.add(Calendar.HOUR_OF_DAY, 9);
//		formatDate=cdr.getTime();
//		//str変換
//		String string=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(formatDate);
//		System.out.println(string);

//		DepositDataList depositDataList=shopRepository.getFilteringList("2022-06-03");
//		while(depositDataList.hasNext()) {
//			depositData=depositDataList.next();
//			System.out.println(depositData.getFactoryMessage());
//			System.out.println(depositData.getFinishDay());
//		}
		
		//shopRepository.addMessage(1, "シャツが破けてしまいました");
		//shopRepository.UpdateDay(1, "お渡し可");
		//System.out.println(registerInfo.getdepositNumber());
		//System.out.println(registerInfo.getregistrationDate());
		//shopRepository.findDepositDataAll(3).next().getDepositDay();
		//shopRepository.witeUserDatas(userData);
		//		System.out.println(shopRepository.getClothesData(2).getPrice().toInt());
		//		System.out.println(shopRepository.getClothesData(2).getDay().toInt());

	}

}
