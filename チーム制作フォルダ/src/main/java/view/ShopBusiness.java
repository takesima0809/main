package view;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entities.BeforeDeposit;
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

		if(userDataArray[1].matches("[+-]?\\d*(\\.\\d+)?")==false){
			//電話番号を正しく入力するまで繰り返す
			while(userDataArray[1].matches("[+-]?\\d*(\\.\\d+)?")==false) {
				System.out.println("電話番号を正しく入力してください");
				userDataArray[1]=scan.next();
			}
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
		String clothesIdStr=null;
		int clothesId=0;
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

		List<BeforeDeposit> beforeDepositList=new ArrayList<>();


		//ここに値段表をsysoで書く
		for(int i=0;i<list.size();i++) {
			viewClothesData viewClothesData=list.get(i);
			System.out.print(viewClothesData.getClothesId());
			System.out.print(viewClothesData.getClothesName());
			System.out.print(viewClothesData.getPrice());
			System.out.print(viewClothesData.getFinishDay());
			System.out.println();
		}

		//		System.out.println(
		//				format("種類",25) + format("料金(円)",10) + "仕上がり日数\n"
		//						+ format("1.ワイシャツ",25)+  format("150",10) + "3\n"
		//						+ format("2.スラックス",25)+  format("200",10)  +"3\n"
		//						+ format("3.ジャケット",25)+ format("350",10) + "3\n"
		//						+ format("4.シャツ一般",25)+  format("200",10) + "5\n"
		//						+ format("5.パンツ・スカート",25)+  format("300",10) + "5\n"
		//						+ format("6.アウター一般",25)+  format("1200",10)+ "5\n"
		//						+ format("7.アウターダウン",25)+  format("2500",10)+ "14\n"
		//						+ format("8.毛布",25)+  format("1200",10)+ "14\n");
		System.out.println(format("オプション１：",25)+format("特急仕上げ：",15)+"スーツ、ワイシャツのみに対応。翌日の仕上がりになります。追加料金は発生しません。");
		System.out.println(format("オプション２：",25)+format("豪華仕上げ：",15)+"高級仕上げ、金額は通常料金の1.5倍になります。");
		System.out.println(format("オプション３：",25)+format("染み抜き：",15)+"衣類に関係なく、一か所につき200円かかります。複数個数の時はその数だけ加算します。\n\n");

		System.out.println("例に従って衣類の登録最大十件行ってください");
		//		System.out.println("十件以下の場合「0」と入力してください");
		System.out.println("服は番号で指定してください");
		System.out.println("オプションに関しては「0」なし「1」あり、として入力してください");
		System.out.println("染み抜きオプションは染み抜き箇所入力してください");
		System.out.println("登録回数を入力してください");


		//回数分依頼を受け付ける
		for(int i=0;i<10;i++)
		{
			try
			{
				//useridの番号を入力
				System.out.println("ユーザIDを入力してください");
				String id=scan.next();

				UserId userId=new UserId(Integer.parseInt(id));
				userData=new UserData(null, userId, null);

				//服の番号を入力
				System.out.println("服の番号を１～８までで入力してください");
				clothesId=Integer.parseInt(scan.next());


				while(clothesId<=0||9<=clothesId)
				{
					System.out.println("服の番号を１～８の番号を入力してください");
					clothesId=Integer.parseInt(scan.next());
				}


				if(clothesId==1||clothesId==2)
				{

					//オプション１の有り無しを判断
					System.out.println("オプション１をつけるか入力してください\n1.はい\n2.いいえ");
					optionJudgmentStr=scan.next();

					while(!(optionJudgmentStr.equals("1")||optionJudgmentStr.equals("2")))//訂正
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

				if(Integer.parseInt(optionJudgmentStr)==1)
				{
					optionJudgment[1]=true;
				}

				else if(Integer.parseInt(optionJudgmentStr)==0)
				{
					optionJudgment[1]=false;
				}

				while(!(optionJudgmentStr.equals("1")||optionJudgmentStr.equals("2")))//訂正
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


				//入力情報を引数の該当するものに追加
				beforeDeposit = new BeforeDeposit(userData,clothesId,optionJudgment[0],optionJudgment[1],stainNum,totalPrice,factoryMessage);
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
			System.out.println("次の追加をしますか？\n1.はい\nいいえの場合はそれ以外の値を入力してください");


			if(!(scan.next().equals("1")))
			{
				break;
			}
		}
		//登録した衣類リストを確認用に表示
		//ヘッダーを記入する
		for(int i=0;i<beforeDepositList.size();i++) 
		{
			beforeDeposit=beforeDepositList.get(i);

			System.out.print(beforeDeposit.getClothesData()+",");
			System.out.print(beforeDeposit.getCleanOption1()+",");
			System.out.print(beforeDeposit.getCleanOption2()+",");
			System.out.println(beforeDeposit.getCleanOption3());		
		}

		System.out.println("上記を登録しました");

		return beforeDepositList;
	}

	public void showDepositInfo(RegisterList registerList) {
		System.out.println("預かり番号　預かり日");
		while(registerList.hasNext()) {
			RegisterInfo registerInfo=registerList.next();
			System.out.println(registerInfo.getdepositNumber()+","+registerInfo.getregistrationDate());//0埋めする
		}
		System.out.println("戻る場合はキーを入力してください");
		Scanner scanner =new Scanner(System.in);
		scanner.next();
	}

	// ３．お渡し入力
	public int[] viewHandOver() {
		Scanner scan = new Scanner(System.in);
		String[] handOverCount;

		System.out.println("仕上がり済みの4桁のお預かり番号をカンマ区切りで最大十件入力してください");
		System.out.println("例・・・");
		System.out.println("仕上がり済みのお預かり番号が見つからない場合エラーとなります");

		handOverCount=scan.next().split(",");
		int[] depositNumbers= {0,0,0,0,0,0,0,0,0,0};

		for (int i = 0; i <handOverCount.length; i++) {
			

			if(handOverCount[i].matches("[+-]?\\d*(\\.\\d+)?")==false&&!(handOverCount[i].length()==4))
			{
				System.out.println("エラー：見つかりませんでした");
				return depositNumbers;
			}
		}
		
		for(int i=0;i<handOverCount.length;i++) {
			String str = handOverCount[i];
			Pattern p = Pattern.compile("^0+([0-9]+.*)");
			Matcher m = p.matcher(str);
			if (m.matches()) {
				depositNumbers[i]=Integer.parseInt(m.group(1));
			}
		}
		
		return depositNumbers;

	}
	
	public boolean viewDepositList(DepositDataList depositDataList) {
		while(depositDataList.hasNext()) {
			DepositData depositData=depositDataList.next();
			System.out.print(depositData.getdepositNumber());
			System.out.print(depositData.getDepositDay());
			System.out.print(depositData.getUserId());
			System.out.print(depositData.getClothesId());
			System.out.println();
		}
		
		System.out.println("こちらの一覧をお客様にお渡ししますか？");
		System.out.println("1.確定\n2.取り消し");
		Scanner scan=new Scanner(System.in);
		int judgment = scan.nextInt();

		if (judgment == 1) {
			System.out.println("お渡しして、メニューへ戻ります");
			return true;
		}
		else if (judgment == 0) {
			System.out.println("取り消します。メニューへ戻ります");
			return false;
		}
		System.out.println("値が不正です。取り消ししメニューに戻ります");
		return false;
	}

	// ４．預かり一覧(ユーザID入力)
	public UserId inputUserId() {
		System.out.println("ユーザIDを入力してください");
		Scanner scan = new Scanner(System.in);
		UserId userId=new UserId(scan.nextInt());
		return userId;
	}
	
	public void viewDepositListToUserId(DepositDataList depositDataList) {
		while(depositDataList.hasNext()) {
			DepositData depositData=depositDataList.next();
			System.out.print(depositData.getdepositNumber());
			System.out.print(depositData.getDepositDay());
			System.out.print(depositData.getUserId());
			System.out.print(depositData.getClothesId());
			System.out.print(depositData.getOption1());
			System.out.print(depositData.getOption2());
			System.out.print(depositData.getOption3());
			System.out.print(depositData.getFinishDay());
			System.out.print(depositData.getFactoryMessage());
			System.out.println();
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
