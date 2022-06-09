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
		while(scanS.matches("[+-]?\\d*(\\.\\d+)?")==false) {
			System.out.println("行う業務を選択してください\n1.会員登録\n2.受付依頼\n3.お渡し\n4.預かり一覧表示\n5.処理を終了する");
			scanS=scan.next();
		}

		int scanInt = Integer.parseInt(scanS);
		return scanInt;
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
