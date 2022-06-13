package view;

import java.util.List;
import java.util.Scanner;

import entities.NewFactoryMessage;

public class MenuView {
	// 店舗業務を選ぶ１～６
	public void viewMessage() {
		// メッセージ一覧表示
		//System.out.println("メッセージ一覧\n");
	}

	public int selectShopBusiness(List<NewFactoryMessage>list) {

		System.out.println("行う業務を選択してください\n1.会員登録\n2.受付依頼\n3.お渡し\n4.預かり一覧表示\n5.処理を終了する");
		
		
		System.out.println();
		System.out.println("工場からのメッセージ");
		System.out.println("ユーザ名       　　工場からのメッセージ");
		for(int i=0;i<list.size();i++) {
			NewFactoryMessage newFactoryMessage=list.get(i);
			System.out.print(String.format("%-14s",newFactoryMessage.getUserName()));
			System.out.print(String.format("%3s",newFactoryMessage.getFactoryMessage()));
			//System.out.print(String.format("%10d",depositData.getClothesId()));

			
			//System.out.print("　　　　　　　"+depositData.getFactoryMessage());
			


			System.out.println();
		}

		Scanner scan = new Scanner(System.in);
		String scanS = scan.next();
		while(scanS.matches("[+-]?\\d*(\\.\\d+)?")==false) {
			System.out.println("行う業務を選択してください\n1.会員登録\n2.受付依頼\n3.お渡し\n4.預かり一覧表示\n5.処理を終了する");
			scanS=scan.next();
		}
		int scanInt = Integer.parseInt(scanS);
		return scanInt;
	}



}
