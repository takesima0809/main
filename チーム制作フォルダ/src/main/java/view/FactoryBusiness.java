package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import entities.DepositData;
import entities.DepositDataList;

public class FactoryBusiness {

	// 工場業務
	public int selectFactoryBusiness() {
		Scanner scan = new Scanner(System.in);
		String selectSrt;
		System.out.println("行う業務を選択してください");
		System.out.println("1.衣類一覧表示");
		System.out.println("2.衣類一覧を絞り込んで表示");
		System.out.println("3.お渡し予定日の変更");
		System.out.println("4.メッセージの記入");
		System.out.println("5.終了します");
		selectSrt = scan.next();

		if(!(selectSrt.matches("[+-]?\\d*(\\.\\d+)?"))) {
			System.out.println("エラーです。正常ではない値が入力されました");
			return 0;
		}

		return Integer.parseInt(selectSrt);
	}

	// 工場の預かり一覧表示画面
	public void viewClothesList(DepositDataList depositDataList) {
		while(depositDataList.hasNext()) {
			DepositData depositData=depositDataList.next();
			System.out.print(depositData.getdepositNumber()+" ");
			System.out.print(depositData.getDepositDay()+" ");
			System.out.print(depositData.getUserId()+" ");
			System.out.print(depositData.getClothesId()+" ");
			System.out.print(depositData.getOption1()+" ");
			System.out.print(depositData.getOption2()+" ");
			System.out.print(depositData.getOption3()+" ");
			System.out.print(depositData.getFinishDay()+" ");
			System.out.print(depositData.getTotalPrice()+" ");
			System.out.print(depositData.getFactoryMessage()+" ");
			System.out.println();
		}

		System.out.println("検索結果を表示しました");
		System.out.println();
	}

	public String selectDate() {
		Scanner scan = new Scanner(System.in);
		System.out.println("絞り込む日にちを入力してください");
		System.out.println("例　2022-01-01");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		boolean formatCheck=false;
		String date=null;

		while(!formatCheck) {   	
			date = scan.next();//入力    
			try{
				sdf.parse(date);//正しい日付
				formatCheck=true;
			} catch (ParseException e){
				System.out.println("正しい日付を入力してください");
				System.out.println("絞り込む日にちを入力してください");
				System.out.println("例　2022-01-01");
			}
		}
		return date;
	}
	// 絞り込み預かり一覧の表示画面
	public void viewSelectClothesList(DepositDataList depositDataList) {
		if(depositDataList.size()!=0) {

			while(depositDataList.hasNext()) {
				DepositData depositData=depositDataList.next();
				System.out.print(depositData.getdepositNumber()+" ");
				System.out.print(depositData.getDepositDay()+" ");
				System.out.print(depositData.getUserId()+" ");
				System.out.print(depositData.getClothesId()+" ");
				System.out.print(depositData.getOption1()+" ");
				System.out.print(depositData.getOption2()+" ");
				System.out.print(depositData.getOption3()+" ");
				System.out.print(depositData.getFinishDay()+" ");
				System.out.print(depositData.getTotalPrice()+" ");
				System.out.print(depositData.getFactoryMessage()+" ");
				System.out.println();
			}
			// 絞り込み後の預かり一覧の表示
			System.out.println("検索結果を表示しました");
			System.out.println();
		}else {
			System.out.println("データが存在しません");
		}
	}

	// メッセージ入力画面
	public String[] writeMassage() {
		System.out.println("メッセージを記入する衣類のお預かり番号とメッセージを入力してください");
		try (Scanner scan = new Scanner(System.in)) {
			String scanStr = scan.next();
			String[]strings=scanStr.split(",");
			if(strings.length!=2) {
				return null;
			}

			System.out.println("1.確定\n2.戻る");
			String select = scan.next();

			if (select.equals("1")) {
				System.out.println("メッセージを入力しました");
			}else if (select.equals("2")) {
				System.out.println("メッセージを変更せずに戻ります。");
				return null;
			}else {
				System.out.println("エラーです。メニューに戻ります");
				return null;
			}

			return strings;
		}
	}

	// お渡し予定日の変更画面
	public String[] cangeHandOverDay() {
		System.out.println("メッセージを記入する衣類のお預かり番号と変更後の日時を入力してください");
		System.out.println("例：お預かり番号(四桁),変更後のお渡し日(YYYY-MM-DD)");
		
		Scanner scan = new Scanner(System.in);
		String scanStr = scan.next();
		String[]strings=scanStr.split(",");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		boolean formatCheck=false;

		while(!formatCheck) {   
			scanStr = scan.next();
			strings=scanStr.split(",");
		
			try{
				sdf.parse(strings[1]);//正しい日付
				Integer.parseInt(strings[0]);//正しい番号
				formatCheck=true;
			} catch (ParseException e){
				System.out.println("正しい値を入力してください");
				System.out.println("メッセージを記入する衣類のお預かり番号と変更後の日時を入力してください");
				System.out.println("例：お預かり番号(四桁),変更後のお渡し日(2022-01-01)");
			}
		}

		System.out.println("1.確定\n2.戻る");
		String select = scan.next();

		if (select.equals("1")) {
			System.out.println("メッセージを入力しました");
		}else if (select.equals("2")) {
			System.out.println("メッセージを変更せずに戻ります。");
			return null;
		}else {
			System.out.println("エラーです。メニューに戻ります");
			return null;
		}

		return strings;

	}

}
