package view;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entities.BeforeDeposit;
import entities.UserData;

public class ShopBusiness {
	// １．お客情報会員登録
	public void viewMemberRegistration() {
		Scanner scan = new Scanner(System.in);
		//お客様の名前入力
		System.out.println("例にしたがってお客様の情報を登録します\nお客様氏名を入力してください\n");
		String name = scan.next();

		//お客様の電話番号入力
		System.out.println("お客様の電話番号を入力してください");
		String phoneNumber = scan.next();

		if(phoneNumber.matches("[+-]?\\d*(\\.\\d+)?")==false){
			//電話番号を正しく入力するまで繰り返す
			while(phoneNumber.matches("[+-]?\\d*(\\.\\d+)?")==false) {
				System.out.println("電話番号を正しく入力してください");
				phoneNumber=scan.next();
			}
		}
		System.out.println("情報入力を完了しました\nメインメニュー画面へ戻ります");

	}

	// ２．衣類受付依頼
	public void viewReception(BeforeDeposit beforeDeposit) {
		Scanner scan = new Scanner(System.in);


		//ユーザデータ
		UserData userData = new UserData(null,null,null);
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

		List<BeforeDeposit> beforeDepositList=new ArrayList<>();

		try
		{
			//ここに値段表をsysoで書く
			System.out.println(
					format("種類",25) + format("料金(円)",10) + "仕上がり日数\n"
							+ format("1.ワイシャツ",25)+  format("150",10) + "3\n"
							+ format("2.スラックス",25)+  format("200",10)  +"3\n"
							+ format("3.ジャケット",25)+ format("350",10) + "3\n"
							+ format("4.シャツ一般",25)+  format("200",10) + "5\n"
							+ format("5.パンツ・スカート",25)+  format("300",10) + "5\n"
							+ format("6.アウター一般",25)+  format("1200",10)+ "5\n"
							+ format("7.アウターダウン",25)+  format("2500",10)+ "14\n"
							+ format("8.毛布",25)+  format("1200",10)+ "14\n");
			System.out.println(format("オプション１：",25)+format("特急仕上げ：",15)+"スーツ、ワイシャツのみに対応。翌日の仕上がりになります。追加料金は発生しません。");
			System.out.println(format("オプション２：",25)+format("豪華仕上げ：",15)+"高級仕上げ、金額は通常料金の1.5倍になります。");
			System.out.println(format("オプション３：",25)+format("染み抜き：",15)+"衣類に関係なく、一か所につき200円かかります。複数個数の時はその数だけ加算します。\n\n");

			System.out.println("例に従って衣類の登録最大十件行ってください");
			//		System.out.println("十件以下の場合「0」と入力してください");
			System.out.println("服は番号で指定してください");
			System.out.println("オプションに関しては「0」なし「1」あり、として入力してください");
			System.out.println("染み抜きオプションは染み抜き箇所入力してください");
			System.out.println("登録回数を入力してください");

			//依頼回数を表す変数
			String addCountstr;
			int addCount=0;

			addCountstr=scan.next();//登録回数を入力
			addCount=Integer.parseInt(addCountstr);
			
			
			if(addCount<=0||9<=addCount)
			{
				while(1<=addCount&&addCount<=8)
				{
					addCountstr=scan.next();
					addCount=Integer.parseInt(addCountstr);
				}
			}
			
			
			//回数分依頼を受け付ける
			for(int i=0;i<addCount;i++)
			{
				//服の番号を入力
				System.out.println("服の番号を１～８までで入力してください");
				clothesIdStr=scan.next();
				clothesId=Integer.parseInt(clothesIdStr);


				//服番号が正しいか判断して正しく整数を入力するまで繰り返す
				//				while(Integer.parseInt(clothesIdStr)<0||8<Integer.parseInt(clothesIdStr))
				//				{
				//					System.out.println("服の番号を１～８までで入力してください");
				//					clothesIdStr=scan.next();
				//				}
				//入力された服の番号をintに代入
				//				clothesId=Integer.parseInt(clothesIdStr);

				if(clothesId==1||clothesId==2)
				{

					//オプション１の有り無しを判断

					System.out.println("オプション１をつけるか入力してください\n1.不要\n2.必要");
					optionJudgmentStr=scan.next();

					if(Integer.parseInt(optionJudgmentStr)==1)
					{
						optionJudgment[0]=true;
					}

					else if(Integer.parseInt(optionJudgmentStr)==0)
					{
						optionJudgment[0]=false;
					}
				}
				//オプション２の有り無しを判断

				System.out.println("オプション２をつけるか入力してください\n1.不要\n2.必要");
				optionJudgmentStr=scan.next();

				if(Integer.parseInt(optionJudgmentStr)==1)
				{
					optionJudgment[1]=true;
				}

				else if(Integer.parseInt(optionJudgmentStr)==0)
				{
					optionJudgment[1]=false;
				}


				//オプション３の数をシミの数を入力する
				System.out.println("オプション３によるシミの数を入力してください。\nない場合は0と入力してください");
				stainNumStr=scan.next();


				stainNum=Integer.parseInt(stainNumStr);

				//入力情報を引数の該当するものに追加
				beforeDeposit = new BeforeDeposit(userData,clothesId,optionJudgment[0],optionJudgment[1],stainNum,totalPrice,factoryMessage);
				beforeDepositList.add(beforeDeposit);
				System.out.println((i+1)+"件目をリストに追加しました");
			}
			//登録した衣類リストを確認用に表示
			for(int i=0;i<addCount;i++) 
			{
				System.out.println("衣類リスト");
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("エラーが発生したのでメニューに戻ります");
			beforeDepositList.clear();;
		}
		catch(NumberFormatException e)
		{
			System.out.println("数値でないためエラーが発生したのでメニューに戻ります");
			beforeDepositList.clear();
		}


	}

	// ３．お渡し
	public void viewHandOver() {
		Scanner scan = new Scanner(System.in);
		String handOverCount;

		System.out.println("仕上がり済みのお預かり番号を最大十件入力してください");
		System.out.println("仕上がり済みのお預かり番号が見つからない場合エラーとなります");
		System.out.println("入力回数を入力してください");
		handOverCount=scan.next();


		for (int i = 0; i < Integer.parseInt(handOverCount); i++) {

			String clothesNamber = null;

			if(clothesNamber.matches("[+-]?\\d*(\\.\\d+)?")==false&&Integer.parseInt(clothesNamber)<10000)
			{

			}
			System.out.println("エラー：見つかりませんでした");


		}

		System.out.println("こちらの一覧をお客様にお渡ししますか？");
		System.out.println("1.取り消し\n2.確定");
		int judgment = scan.nextInt();

		if (judgment == 1) {
			System.out.println("お渡しを取り消し、メニューへ戻ります");
		}

		else if (judgment == 0) {
			System.out.println("お渡しして、メニューへ戻ります");
		}

	}

	// ４．預かり一覧表示
	public void viewCustodyList() {
		Scanner scan = new Scanner(System.in);
		// 預かり一覧表示処理
		System.out.println("預かり一覧だと思ってね");
		System.out.println("よろしければエンターを押してください");
		scan.nextLine();
		System.out.println("メニューへ戻ります");

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
