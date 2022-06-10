package view;

import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

		if(!(selectSrt.matches("\\d*(\\.\\d+)?"))||Integer.parseInt(selectSrt)>5) {
			System.out.println("エラーです。正常ではない値が入力されました");
			return 0;
		}

		return Integer.parseInt(selectSrt);
	}

	// 工場の預かり一覧表示画面
	public void viewClothesList(DepositDataList depositDataList) {
		System.out.println("お預かり番号　預かり日　　　　　　　　ユーザID　衣服ID　特急仕上げ　デラックス仕上げ　染み抜き個数　仕上がり予定日　 工場からのメッセージ");
		while(depositDataList.hasNext()) {
			DepositData depositData=depositDataList.next();
			System.out.print(String.format("%-14d",depositData.getdepositNumber()));
			System.out.print(String.format("%-24s",depositData.getDepositDay()));
			System.out.print(String.format("%-10d",depositData.getUserId()));
			System.out.print(String.format("%-8d",depositData.getClothesId()));
			System.out.print(String.format("%-12s",depositData.getOption1()));
			System.out.print(String.format("%-18s",depositData.getOption2()));
			System.out.print(String.format("%-13s",depositData.getOption3()+"個"));
			System.out.print(format(depositData.getFinishDay(),15));
			if(depositData.getFactoryMessage()==null) {
				System.out.print(String.format("%6s",depositData.getFactoryMessage()));
			}else {
				System.out.print("　"+depositData.getFactoryMessage());
			}
			System.out.println();
		}

		System.out.println("検索結果を表示しました");
		System.out.println();
	}
//絞り込み日入力画面
	public String selectDate() {
		Scanner scan = new Scanner(System.in);
		System.out.println("絞り込む日にちを入力してください　戻る場合はEXITと入力してください");
		System.out.println("例　2022-01-01");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		boolean formatCheck=false;
		String date=null;

		while(!formatCheck) {   	
			date = scan.next();//入力  
			if(date.equals("EXIT")) {
				return null;
			}
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
			System.out.println("お預かり番号　預かり日　　　　　　　　ユーザID　衣服ID　特急仕上げ　デラックス仕上げ　染み抜き個数　仕上がり予定日　 工場からのメッセージ");
			while(depositDataList.hasNext()) {
				DepositData depositData=depositDataList.next();
				System.out.print(String.format("%-14d",depositData.getdepositNumber()));
				System.out.print(String.format("%-24s",depositData.getDepositDay()));
				System.out.print(String.format("%-10d",depositData.getUserId()));
				System.out.print(String.format("%-8d",depositData.getClothesId()));
				System.out.print(String.format("%-12s",depositData.getOption1()));
				System.out.print(String.format("%-18s",depositData.getOption2()));
				System.out.print(String.format("%-13s",depositData.getOption3()+"個"));
				System.out.print(format(depositData.getFinishDay(),15));
				if(depositData.getFactoryMessage()==null) {
					System.out.print(String.format("%6s",depositData.getFactoryMessage()));
				}else {
					System.out.print("　"+depositData.getFactoryMessage());
				}
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
		System.out.println("4桁のお預かり番号とメッセージを入力してください　戻る場合はEXITと入力してください");
		Scanner scan = new Scanner(System.in);
		String scanStr = scan.next();
		String[]strings=scanStr.split(",");
		if(scanStr.equals("EXIT")) {
			return null;
		}
		if(strings.length!=2) {
			return null;
		}
		
		Pattern p = Pattern.compile("^0+([0-9]+.*)");
		Matcher m = p.matcher(strings[0]);
		if (m.matches()) {
			strings[0]=m.group(1);
		}
		
		System.out.println("1.確定\n2.戻る");
		String select = scan.next();

		if (select.equals("1")) {
			System.out.println("メッセージ入力中");
		}else if (select.equals("2")) {
			System.out.println("メッセージを変更せずに戻ります。");
			return null;
		}else {
			System.out.println("エラーです。メニューに戻ります");
			return null;
		}

		return strings;
	}
	
	public void messageInputFlag(boolean flag) {
		if(flag) {
			System.out.println("メッセージが変更されました");
		}else {
			System.out.println("メッセージ入力失敗");
			System.out.println("存在しない預かり番号です");
		}
		
	}
	
	public void dateInputFlag(boolean flag) {
		if(flag) {
			System.out.println("日付が変更されました");
		}else {
			System.out.println("日付入力失敗");
			System.out.println("存在しない預かり番号です");
		}
		
	}


	// お渡し予定日の変更画面
	public String[] cangeHandOverDay() {
		System.out.println("メッセージを記入する衣類のお預かり番号と変更後の日時を入力してください　戻る場合はEXITと入力してください");
		System.out.println("例：お預かり番号(四桁),変更後のお渡し日(YYYY-MM-DD)");

		Scanner scan = new Scanner(System.in);
		String scanStr = scan.next();
		String[]strings=scanStr.split(",");
		if(scanStr.equals("EXIT")) {
			return null;
		}
		if(strings.length!=2) {
			return null;
		}
		
		Pattern p = Pattern.compile("^0+([0-9]+.*)");
		Matcher m = p.matcher(strings[0]);
		if (m.matches()) {
			strings[0]=m.group(1);
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		boolean formatCheck=false;

		while(!formatCheck) {  
			try{
				if(strings.length!=2) {
					return null;
				}
				if(!(strings[1].equals("お渡し可"))) {
					sdf.parse(strings[1]);//正しい日付
				}
				Integer.parseInt(strings[0]);//正しい番号
				formatCheck=true;

			} catch (ParseException e){
				System.out.println("正しい値を入力してください");
				System.out.println("メッセージを記入する衣類のお預かり番号と変更後の日時を入力してください");
				System.out.println("例：お預かり番号(四桁),変更後のお渡し日(2022-01-01)");
				scanStr = scan.next();
				strings=scanStr.split(",");
			}
		}

		System.out.println("1.確定\n2.戻る");
		String select = scan.next();

		if (select.equals("1")) {
			System.out.println("メッセージを入力中");
		}else if (select.equals("2")) {
			System.out.println("メッセージを変更せずに戻ります。");
			return null;
		}else {
			System.out.println("エラーです。メニューに戻ります");
			return null;
		}

		return strings;

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
}
