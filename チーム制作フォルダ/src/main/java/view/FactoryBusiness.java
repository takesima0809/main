package view;

import java.util.Scanner;

public class FactoryBusiness {

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

	// 工場の預かり一覧表示画面
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

}
