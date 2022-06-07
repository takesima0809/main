package view;


import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.BeforeDeposit;

public class MenuView {
	// 店舗業務を選ぶ１～６
	public void viewMessage() {
		// メッセージ一覧表示
		System.out.println("メッセージ一覧\n");
	}

	public int selectShopBusiness() {

		System.out.println("行う業務を選択してください\n1.会員登録\n2.受付依頼\n3.お渡し\n4.預かり一覧表示\n5.処理を終了する");
		Scanner scan = new Scanner(System.in);
		String scanS = scan.next();
		int scanInt = 0;
		try {
			scanInt = Integer.parseInt(scanS);
		}
		catch(NumberFormatException e) {
			selectShopBusiness();
		}
		return scanInt;
	}

	// １．お客情報会員登録
	public void viewMemberRegistration() {
		Scanner scan = new Scanner(System.in);
		System.out.println("例にしたがってお客様の情報を登録します\nお客様氏名を入力してください\n");
		String nametoPhone = scan.next();
		System.out.println("情報入力を完了しました\nメインメニュー画面へ戻ります");

	}

	// ２．衣類受付依頼
	public void viewReception(BeforeDeposit beforeDeposit) {
		Scanner scan = new Scanner(System.in);
		//オプションの有無を表すboolean配列
		boolean[] optionOnOff = {false,false,false};
		//工場メッセージを表す
		String factoryMessage="";
		//ユーザID
		int userId=1;
		//合計金額
		int totalPrice=1000;
		//服のID
		int clothesId=0;
		//オプションを登録する際に使うカウント用変数
		int optionCount=1;

		List<BeforeDeposit> beforeDepositList=new ArrayList<>();


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
		String addCountS=scan.next();//登録回数を入力
		int addCountInt = 0;

		if(addCountS.matches("[+-]?\\d*(\\.\\d+)?")) {
			addCountInt=Integer.parseInt(addCountS);
		}
		for (int i = 0; i < addCountInt; i++) {

			//衣類id、オプション１、２、３の有無を入力
			String scanS;

			//服の種類を選ぶ
			System.out.println("服の種類を選んでください");
			scanS = scan.next();

			//服コードの取得
			if(scanS.matches("[+-]?\\d*(\\.\\d+)?")==true&&0<=clothesId&&clothesId<=8) {
				clothesId = Integer.parseInt(scanS);
			}

			//服コードが無効の値の場合
			else {
				while(scanS.matches("[+-]?\\d*(\\.\\d+)?")==false||clothesId<1||8<clothesId) {
					System.out.println("エラー：洋服のコードが見つかりません\n\n1～8までの洋服の種類で選んでください");
					scanS = scan.next();
				}
				clothesId = Integer.parseInt(scanS);
			}

			//衣類IDが1,2の場合はオプションの１を追加させないためにカウントをアップする
			if(clothesId==1||clothesId==2) {
				optionCount=0;
			}

			//オプションの有無をboolean型に直す
			for(int j=optionCount;j<3;j++) {
				System.out.println("オプション"+(j+1)+"を追加しますか？");
				scanS = scan.next();

				if(scanS.matches("[+-]?\\d*(\\.\\d+)?")) {
					if(Integer.parseInt(scanS)==1) {
						optionOnOff[j]=true;
						System.out.println("オプション"+(j+1)+"を追加しました\n");
					}
					else if(Integer.parseInt(scanS)==0) {}
				}

				else {
					System.out.println("入力ミスのためもう一度追加してください");
					j--;
				}
			}
			//ユーザID、合計金額、仕上がり日取得


			//入力情報を引数の該当するものに追加
			beforeDeposit = new BeforeDeposit(userId,clothesId,optionOnOff[0],optionOnOff[1],optionOnOff[2],totalPrice,factoryMessage);
			beforeDepositList.add(beforeDeposit);
			System.out.println((i+1)+"件目をリストに追加しました");
		}
		//登録した衣類リストを確認用に表示
		for(int i=0;i<addCountInt;i++) {
			System.out.println("衣類リストだと思ってね");
		}

		System.out.println("こちらの衣類リストを登録しますか？");
		System.out.println("1.取り消し\n2.確定");
		int judgment = scan.nextInt();

		if (judgment == 1) {
			System.out.println("依頼を取り消し、メニューへ戻ります");
		}

		else if (judgment == 0) {
			System.out.println("依頼を確定し、メニューへ戻ります");
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

	// 工場業務
	public int selectFactoryBusiness() {
		Scanner scan = new Scanner(System.in);
		String selectSrt;
		int select;
		System.out.println("行う業務を選択してください");
		System.out.println("1.衣類一覧表示");
		System.out.println("2.衣類一覧を絞り込んで表示");
		System.out.println("3.お渡し予定日の変更");
		System.out.println("4.メッセージの記入");
		System.out.println("5.終了します");
		selectSrt = scan.next();
		select = Integer.parseInt(selectSrt);
		return select;
	}

	// 預かり一覧表示画面
	public void viewClothesList() {
		Scanner scan = new Scanner(System.in);
		// 預かり一覧の表示
		System.out.println("一覧表だと思ってね");
		System.out.println("検索結果を表示しました");
		System.out.println();
	}

	// 絞り込み預かり一覧の表示画面
	public void viewSelectClothesList() {
		Scanner scan = new Scanner(System.in);
		System.out.println("絞り込む日にちを入力してください");
		String squeeze = scan.next();
		// 絞り込み後の預かり一覧の表示
		System.out.println("絞り込み一覧表だと思ってね");
		System.out.println("検索結果を表示しました");
		System.out.println();
	}

	// メッセージ入力画面
	public void writeMassage() {
		System.out.println("メッセージを記入する衣類のお預かり番号とメッセージを入力してください");
		Scanner scan = new Scanner(System.in);
		String scanStr = scan.next();

		scanStr=scanStr.format("%06d");

		//見つからない場合の処理


		//見つかった場合の処理

		String Message=scan.next();

		System.out.println("1.確定\n2.戻る");
		int select = scan.nextInt();

		if (select == 1) {
			System.out.println("メッセージを追記しました。");
			System.out.println();
		}

		else if (select == 2) {
			System.out.println("メッセージを変更せずに戻ります。");
			System.out.println();
		}
	}

	// お渡し予定日の変更画面
	public void cangeHandOverDay() {
		System.out.println("メッセージを記入する衣類のお預かり番号と変更後の日時を入力してください");
		System.out.println("例：お預かり番号(四桁),変更後のお渡し日(YYYY/MM/DD)");
		Scanner scan = new Scanner(System.in);
		String scanStr = scan.next();
		System.out.println("1.確定\n2.戻る");
		String select = scan.next();

		if (Integer.parseInt(select) == 1) {
			System.out.println("お渡し予定日を変更しました\n");
		}

		else if (Integer.parseInt(select) == 2) {
			System.out.println("お渡し予定日を変更せず戻ります\n");
		}

	}

	public void finishCode() {
		System.out.println("処理を終了します");
		System.exit(0);
	}



	public String format(String target, int length){
		int byteDiff = (getByteLength(target, Charset.forName("UTF-8"))-target.length())/2;
		return String.format("%-"+(length-byteDiff)+"s", target);
	}

	public int getByteLength(String string, Charset charset) {
		return string.getBytes(charset).length;
	}

}
