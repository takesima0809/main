package view;

import java.util.Scanner;

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

		int scanInt = Integer.parseInt(scanS);
		return scanInt;
	}

	// １．お客情報会員登録
	public void viewMemberRegistration() {
		Scanner scan = new Scanner(System.in);
		System.out.println("例にしたがってお客様の情報を入力してください\nお客様氏名,お客様電話番号");
		System.out.println("戻りたい場合は「0」と入力して下さい");
		String nametoPhone = scan.next();
		try {
			System.out.println("情報入力を完了しました\nメインメニュー画面へ戻ります");
		} catch (NumberFormatException e) {
			
		}

	}

	// ２．衣類受付依頼
	public void viewReception() {
		Scanner scan = new Scanner(System.in);

		System.out.println(
				"種類  料金(円)  仕上がり日数\n1.ワイシャツ  150  3\n2.スラックス  200  3\n3.ジャケット  350  3\n4.シャツ一般  200  5\n5.パンツ・スカート  300  5\n6.アウター一般  1200  5\n7.アウターダウン  2500  14\n8.毛布  1200  14\n");
		System.out.println("オプション１：特急仕上げ　　　：スーツ、ワイシャツのみに対応。翌日の仕上がりになります。追加料金は発生しません。");
		System.out.println("オプション２：デラックス仕上げ：高級仕上げ、金額は通常料金の1.5倍になります。");
		System.out.println("オプション３：染み抜き　　　　：衣類に関係なく、一か所につき200円かかります。複数個数の時はその数だけ加算します。\n\n");

		System.out.println("例に従って衣類の登録最大十件行ってください");
//		System.out.println("十件以下の場合「0」と入力してください");
		System.out.println("服は番号で指定してください");
		System.out.println("オプションに関しては「0」なし「1」あり、として入力してください");
		System.out.println("染み抜きオプションは染み抜き箇所入力してください");
		System.out.println("\n入力順服の種類,オプション１,オプション２,オプション３");
		System.out.println("\n例：1,1,1,4");
		int addCount=Integer.parseInt(scan.next());
		for (int i = 0; i < addCount; i++) {
			String scanS2 = scan.next();
			if(scanS2.length()==7) {
				String[] strSplit = scanS2.split(",");
				//その情報をDBに追加（service）
			}else {
				System.out.println("エラーのため再入力お願いします");
				i--;
			}
			
			System.out.println("登録終了の際は0を入力してエンターを押してください");
		}
		System.out.println("こちらの衣類を登録しますか？");
		System.out.println("1.取り消し\n2.確定");
		String judgment = scan.next();
		if (Integer.parseInt(judgment) == 1) {
			System.out.println("依頼を取り消し、メニューへ戻ります");
		} else if (Integer.parseInt(judgment) == 0) {
			System.out.println("依頼を確定し、メニューへ戻ります");
		}

	}

	// ３．お渡し
	public void viewHandOver() {
		Scanner scan = new Scanner(System.in);

		System.out.println("仕上がり済みのお預かり番号を最大十件入力してください");
		System.out.println("お預かり番号が見つからない場合エラーとなります");
		System.out.println("十件以下の場合「0」と入力してください");
		for (int i = 0; i < 10; i++) {
			String request;
			request = scan.next();

			if (Integer.parseInt(request) == 0) {
				break;
			} else if (1000 <= Integer.parseInt(request) && Integer.parseInt(request) <= 9999) {
				System.out.println("成功");
			} else {
				System.out.println("エラー：見つかりませんでした");
				i--;
			}
		}

		System.out.println("こちらの一覧をお客様にお渡ししますか？");
		System.out.println("1.取り消し\n2.確定");
		String judgment2 = scan.next();
		if (Integer.parseInt(judgment2) == 1) {
			System.out.println("お渡しを取り消し、メニューへ戻ります");
		} else if (Integer.parseInt(judgment2) == 0) {
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
		System.out.println("絞り込み条件を入力してください");
		String squeeze = scan.next();
		// 絞り込み後の預かり一覧の表示
		System.out.println("絞り込み一覧表だと思ってね");
		System.out.println("検索結果を表示しました");
		System.out.println();
	}

	// メッセージ入力画面
	public void writeMassage() {
		System.out.println("メッセージを記入する衣類のお預かり番号とメッセージを入力してください");
		System.out.println("例：お預かり番号(四桁),メッセージ内容");
		Scanner scan = new Scanner(System.in);
		String scanStr = scan.next();
		System.out.println("1.確定\n2.戻る");
		String select = scan.next();

		if (Integer.parseInt(select) == 1) {
			System.out.println("メッセージを追記しました。");
			System.out.println();
		} else if (Integer.parseInt(select) == 2) {
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

}
