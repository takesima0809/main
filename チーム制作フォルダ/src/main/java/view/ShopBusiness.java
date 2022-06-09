package view;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entities.BeforeDeposit;
import entities.CleanOption;
import entities.DepositData;
import entities.DepositDataList;
import entities.RegisterInfo;
import entities.RegisterList;
import entities.UserData;
import entities.viewClothesData;
import userValues.PhoneNumber;
import userValues.UserId;
import userValues.UserName;

public class ShopBusiness {
	// １．お客情報会員登録
	public UserData viewMemberRegistration() {
		Scanner scan = new Scanner(System.in);
		//お客様の名前入力
		System.out.println("例　氏名,123456789(電話番号)");
		System.out.println("例にしたがってお客様の情報を入力してください");
		String userDataString = scan.next();
		String[]userDataArray=userDataString.split(",");


		//電話番号を正しく入力するまで繰り返す
		while(userDataArray.length!=2||userDataArray[1].matches("[+-]?\\d*(\\.\\d+)?")==false||userDataArray[1].length()<10) {
			System.out.println("お客様情報を正しく入力してください");
			userDataString = scan.next();
			userDataArray=userDataString.split(",");
		}

		UserName userName=new UserName(userDataArray[0]);
		PhoneNumber phoneNumber=new PhoneNumber(userDataArray[1]);

		UserData userData=new UserData(phoneNumber, null, userName);


		System.out.println("情報入力を完了しました\nメインメニュー画面へ戻ります");
		return userData;
	}



	// ２．衣類受付依頼
	public List<BeforeDeposit> viewReception(List<viewClothesData>list) {
		Scanner scan = new Scanner(System.in);


		//ユーザデータ
		UserData userData = null;
		//服のID
		String clothesId=null;
		int clothesIdInt;
		//オプション1,2の有無を表すboolean配列
		boolean[] optionJudgment = {false,false};
		String optionJudgmentStr = "0";
		//オプション3の個所数を表す
		String stainNumStr = null;
		int stainNum;
		//合計金額
		int totalPrice=1000;
		//工場メッセージを表す
		String factoryMessage="aaaa";

		BeforeDeposit beforeDeposit=null;
		int price=0;
		List<BeforeDeposit> beforeDepositList=new ArrayList<>();


		System.out.println("服番号  服の名前          値段     仕上がり日数");

		for(int i=0;i<list.size();i++) {
			viewClothesData viewClothesData=list.get(i);
			System.out.print(String.format("%-8d",viewClothesData.getClothesId()));
			System.out.print(format(viewClothesData.getClothesName(),16));
			System.out.print(String.format("%6d",viewClothesData.getPrice())+"円");
			System.out.print(String.format("%7d",viewClothesData.getFinishDay())+"日");
			System.out.println();
		}

		System.out.println(format("オプション１：",25)+format("特急仕上げ：",15)+"スーツ、ワイシャツのみに対応。翌日の仕上がりになります。追加料金は発生しません。");
		System.out.println(format("オプション２：",25)+format("豪華仕上げ：",15)+"高級仕上げ、金額は通常料金の1.5倍になります。");
		System.out.println(format("オプション３：",25)+format("染み抜き：",15)+"衣類に関係なく、一か所につき200円かかります。複数個数の時はその数だけ加算します。\n\n");

		System.out.println("例に従って衣類の登録最大十件行ってください");
		System.out.println("服は番号で指定してください");
		System.out.println("オプションに関しては「0」なし「1」あり、として入力してください");
		System.out.println("染み抜きオプションは染み抜き箇所入力してください");


		//回数分依頼を受け付ける
		for(int i=0;i<10;i++)
		{
			try
			{
				//useridの番号を入力
				System.out.println("ユーザIDを入力してください");
				String id=scan.next();
				CleanOption cleanOption=new CleanOption();

				while(id.matches("[+-]?\\d*(\\.\\d+)?")==false) {
					System.out.println("ユーザIDを入力してください");
					id=scan.next();
				}

				UserId userId=new UserId(Integer.parseInt(id));
				userData=new UserData(null, userId, null);

				//服の番号を入力
				System.out.println("服の番号を１～８までで入力してください");
				clothesId=scan.next();


				while(Integer.parseInt(clothesId)<=0||9<=Integer.parseInt(clothesId)||clothesId.matches("[+-]?\\d*(\\.\\d+)?")==false)
				{
					System.out.println("服の番号を１～８の番号を入力してください");
					clothesId=scan.next();
				}

				clothesIdInt=Integer.parseInt(clothesId);
				price+=list.get(Integer.parseInt(clothesId)).getPrice();
				
				if(clothesId.equals("1")||clothesId.equals("2"))
				{

					//オプション１の有り無しを判断
					System.out.println("オプション１をつけるか入力してください\n1.はい\n2.いいえ");
					optionJudgmentStr=scan.next();

					if(optionJudgmentStr.equals("1"))
					{
						optionJudgment[0]=true;
					}

					else if(optionJudgmentStr.equals("2"))
					{
						optionJudgment[0]=false;
					}

					while(!(optionJudgmentStr.equals("1")||optionJudgmentStr.equals("2"))||!(optionJudgmentStr.matches("[+-]?\\d*(\\.\\d+)?")))//訂正
					{

						System.out.println("正しい値を入力してください\n1.はい\n2.いいえ");
						optionJudgmentStr=scan.next();

						if(optionJudgmentStr.equals("1"))
						{
							optionJudgment[0]=true;
						}

						else if(optionJudgmentStr.equals("2"))
						{
							optionJudgment[0]=false;
						}
					}
				}
				//オプション２の有り無しを判断

				System.out.println("オプション２をつけるか入力してください\n1.はい\n2.いいえ");
				optionJudgmentStr=scan.next();

				if(optionJudgmentStr.equals("1"))
				{
					optionJudgment[1]=true;
					price=cleanOption.washDeluxeFinish(price);
				}

				else if(optionJudgmentStr.equals("2"))
				{
					optionJudgment[1]=false;
				}

				while(!(optionJudgmentStr.equals("1")||optionJudgmentStr.equals("2"))||!(optionJudgmentStr.matches("[+-]?\\d*(\\.\\d+)?")))//訂正
				{

					System.out.println("正しい値を入力してください\n1.はい\n2.いいえ");
					optionJudgmentStr=scan.next();

					if(optionJudgmentStr.equals("1"))
					{
						optionJudgment[1]=true;
					}

					else if(optionJudgmentStr.equals("2"))
					{
						optionJudgment[1]=false;
					}
				}

				
				//オプション３の数をシミの数を入力する
				System.out.println("オプション３によるシミの数を入力してください。\nない場合は0と入力してください");
				stainNum=Integer.parseInt(scan.next());
				price=cleanOption.washStainRemoval(price,stainNum);

				//入力情報を引数の該当するものに追加
				beforeDeposit = new BeforeDeposit(userData,clothesIdInt,optionJudgment[0],optionJudgment[1],stainNum,totalPrice,factoryMessage);
				beforeDepositList.add(beforeDeposit);
				System.out.println((i+1)+"件目をリストに追加しました\n");


			}
			catch(InputMismatchException e)
			{
				System.out.println("エラーが発生したのでもう一度入力してください");
				i--;
			}
			catch(NumberFormatException e)
			{
				System.out.println("エラーが発生したのでもう一度入力してください");
				i--;
			}
			System.out.println("追加の受け付けをしますか？\n1.はい\nいいえの場合はそれ以外の値を入力してください");


			if(!(scan.next().equals("1")))
			{
				break;
			}
		}
		//登録した衣類リストを確認用に表示
		//ヘッダーを記入する
		System.out.println("衣類番号  オプション１  オプション２  オプション３");
		for(int i=0;i<beforeDepositList.size();i++) 
		{
			beforeDeposit=beforeDepositList.get(i);
			System.out.print(beforeDeposit.getClothesData());
			System.out.print(String.format("%13b",beforeDeposit.getCleanOption1()));
			System.out.print(String.format("%14b",beforeDeposit.getCleanOption2()));
			System.out.println(String.format("%14b",beforeDeposit.getCleanOption3()));		
		}
		System.out.println("合計金額"+price);
		
		System.out.println("上記を登録しました");

		return beforeDepositList;
	}

	public void showDepositInfo(RegisterList registerList) {
		System.out.println("預かり番号  預かり日時");
		int price=0;
		while(registerList.hasNext()) {
			RegisterInfo registerInfo=registerList.next();
			price+=registerInfo.getTotalPrice();
			System.out.println(String.format("%04d",registerInfo.getdepositNumber())+"          "+registerInfo.getregistrationDate());//0埋めする
		}
		System.out.println("合計金額"+price);
		System.out.println("戻る場合はキーを入力してください");
		Scanner scanner =new Scanner(System.in);
		scanner.next();
	}

	// ３．お渡し入力
	public List<Integer> viewHandOver() {
		Scanner scan = new Scanner(System.in);
		String[] handOverCount;
		List<Integer>list=new ArrayList<>();
		System.out.println("仕上がり済みの4桁のお預かり番号をカンマ区切りで最大十件入力してください");
		System.out.println("例・・・");
		System.out.println("仕上がり済みのお預かり番号が見つからない場合エラーとなります");

		handOverCount=scan.next().split(",");
		int[] depositNumbers= {0,0,0,0,0,0,0,0,0,0};

		for (int i = 0; i <handOverCount.length; i++) {
			if(handOverCount[i].matches("[+-]?\\d*(\\.\\d+)?")==false||!(handOverCount[i].length()==4))
			{
				System.out.println("エラー：見つかりませんでした");
				return null;
			}
		}

		for(int i=0;i<handOverCount.length;i++) {
			String str = handOverCount[i];
			Pattern p = Pattern.compile("^0+([0-9]+.*)");
			Matcher m = p.matcher(str);
			if (m.matches()) {
				list.add(Integer.parseInt(m.group(1)));
			}
		}

		return list;
	}

	public boolean viewDepositList(DepositDataList depositDataList) {
		if(depositDataList!=null) {
			while(depositDataList.hasNext()) {
				System.out.println("データの数は"+depositDataList.size());
				DepositData depositData=depositDataList.next();
				System.out.print(depositData.getdepositNumber());
				System.out.print(depositData.getDepositDay());
				System.out.print(depositData.getUserId());
				System.out.print(depositData.getClothesId());
				System.out.println();

				System.out.println("こちらの一覧をお客様にお渡ししますか？");
				System.out.println("1.確定\n2.取り消し");
				Scanner scan=new Scanner(System.in);
				String judgment = scan.next();

				if (judgment.equals("1")) {
					System.out.println("お渡しして、メニューへ戻ります");
					return true;
				}
				else if (judgment.equals("2")) {
					System.out.println("取り消します。メニューへ戻ります");
					return false;
				}
				System.out.println("値が不正です。取り消ししメニューに戻ります");
			}
		}else {
			System.out.println("存在しない預かり番号またはお渡し状態ではない預かり番号が含まれています");
		}

		return false;
	}

	// ４．預かり一覧(ユーザID入力)
	public UserId inputUserId() {
		System.out.println("ユーザIDを入力してください");
		Scanner scan = new Scanner(System.in);
		UserId userId=null;
		try {
			userId=new UserId(scan.nextInt());
		}
		catch(Exception e) {
			System.out.println("値が不正です");
		}

		return userId;
	}

	public void viewDepositListToUserId(DepositDataList depositDataList) {
		System.out.println("ユーザID  お預かり日  お預かり時間  オプション1,2,3の有無  お渡し予定日  工場からのメッセージ");
		if(depositDataList.size()!=0) {
			while(depositDataList.hasNext()) {
				DepositData depositData=depositDataList.next();
				System.out.print(String.format("%2d",depositData.getdepositNumber())+"  ");
				System.out.print(depositData.getDepositDay()+"  ");
				System.out.print(depositData.getUserId()+"  ");
				System.out.print(depositData.getClothesId()+"  ");
				System.out.print(String.format("%5s",depositData.getOption1())+"  ");
				System.out.print(String.format("%5s",depositData.getOption2())+"  ");
				System.out.print(String.format("%5s",depositData.getOption3())+"  ");
				System.out.print(depositData.getFinishDay()+"  ");
				System.out.print(depositData.getFactoryMessage());
				System.out.println();
			}
		}else {
			System.out.println("データが存在しません");
		}
	}

	//メソッド使用用
	public String format(String target, int length){
		int byteDiff = (getByteLength(target, Charset.forName("UTF-8"))-target.length())/2;
		return String.format("%-"+(length-byteDiff)+"s", target);
	}
	//メソッド使用用
	public int getByteLength(String string, Charset charset) {
		return string.getBytes(charset).length;
	}
	// 文字列が数値かどうか判定する関数
	public boolean checkString(String text) {

		boolean res = true;

		// 受け取った文字列を先頭から1文字ずつ判定する
		for(int i = 0; i < text.length(); i++) {

			// もし数値だったら次の処理へ
			if(Character.isDigit(text.charAt(i))) {
				continue;
			} else {
				// 変数にfalseを代入して処理を終了する
				res =  false;
				break;
			}
		}

		return res;
	}

}
