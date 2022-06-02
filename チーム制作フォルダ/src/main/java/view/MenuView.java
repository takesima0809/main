package view;

import java.util.Scanner;

public class MenuView {
//メニュー画面
	public int viewMenu()
	{
		System.out.println("どちらの業務を行いますか？\n1.店舗業務\n2.工場業務");
		Scanner scan = new Scanner(System.in);
		String scanS=scan.next();
		
		return Integer.parseInt(scanS);
	}
	
	public void viewShop()
	{
		System.out.println("行う業務を選択してください\n1.会員登録\n2.受付依頼\n3.お渡し\n4.預かり一覧表示\n5.メッセージ表示");
		Scanner scan = new Scanner(System.in);
		String scanS=scan.next();
		
		int scanInt=Integer.parseInt(scanS);
		
		switch(scanInt)
		{
		case 1:
			System.out.println("例にしたがってお客様の情報を入力してください\nお客様氏名,お客様電話番号");
			
			String nametoPhone=scan.next();
			
			System.out.println("情報入力を完了しました\nメインメニュー画面へ戻ります");
			break;
		
		case 2:
			System.out.println("種類  料金(円)  仕上がり日数\n1.ワイシャツ  150  3\n2.スラックス  200  3\n3.ジャケット  350  3\n4.シャツ一般  200  5\n5.パンツ・スカート  300  5\n6.アウター一般  1200  5\n7.アウターダウン  2500  14\n8.毛布  1200  14");
			System.out.println("オプション１：特急仕上げ　　　：スーツ、ワイシャツのみに対応。翌日の仕上がりになります。\n追加料金は発生しません。");
			System.out.println("オプション２：デラックス仕上げ：高級仕上げ、金額は通常料金の1.5倍になります。");
			System.out.println("オプション３：染み抜き　　　　：衣類に関係なく、一か所につき200円かかります。\n複数個数の時はその数だけ加算します。");
			
			
			System.out.println("例に従って衣類の登録最大十件行ってください");
			System.out.println("十件以下の場合「0」と入力してください");
			System.out.println("オプションに関しては「0」なし「1」あり、として入力してください");
			System.out.println("服の種類,オプション１,オプション２,オプション３");
			for(int i=0;i<10;i++)
			{
				String scanS2=scan.next();
				String[] strSplit= scanS2.split(",");
				if(Integer.parseInt(strSplit[0])==0)
				{
					break ;
				}
			}
			System.out.println("こちらの衣類を登録しますか？");
			System.out.println("1.取り消し\n2.確定");
			String judgment =scan.next();
			if(Integer.parseInt(judgment)==1)
			{
				System.out.println("依頼を取り消し、メニューへ戻ります");
			}
			else if(Integer.parseInt(judgment)==0)
			{
				System.out.println("依頼を確定し、メニューへ戻ります");
			}
			
			break;
			
		case 3:
			System.out.println("仕上がり済みのお預かり番号を最大十件入力してください");
			System.out.println("お預かり番号が見つからない場合エラーとなります");
			System.out.println("十件以下の場合「0」と入力してください");
			for(int i=0;i<10;i++)
			{
				String aaa;
				aaa=scan.next();
				
				if(Integer.parseInt(aaa)==0)
				{
					break;
				}
				else if(1000<=Integer.parseInt(aaa)&&Integer.parseInt(aaa)<=9999)
				{
					System.out.println("成功");
				}
				else
				{
					System.out.println("エラー：見つかりませんでした");
					i--;
				}
			}
			
			System.out.println("こちらの一覧をお客様にお渡ししますか？");
			System.out.println("1.取り消し\n2.確定");
			String judgment2 =scan.next();
			if(Integer.parseInt(judgment2)==1)
			{
				System.out.println("お渡しを取り消し、メニューへ戻ります");
			}
			else if(Integer.parseInt(judgment2)==0)
			{
				System.out.println("お渡しして、メニューへ戻ります");
			}
			
			break;
			
		case 4:
			System.out.println("預かり一覧だと思ってね");
			System.out.println("よろしければエンターを押してください");
			scan.next();
			System.out.println("メニューへ戻ります");
			break;
			
		case 5:
			System.out.println("メッセージ一覧だと思ってね");
			System.out.println("よろしければエンターを押してください");
			scan.next();
			System.out.println("メニューへ戻ります");
			
			break;

		case 6:
			System.out.println("システムを終了します");
			break;
		}
		viewShop();
	}
	
	public void viewFactory()
	{
		Scanner scan = new Scanner(System.in);
		String str=new String();
		
		System.out.println("絞り込む日にちを選んでください");
		scan.next();
		
		System.out.println("仕上がり予定の変更、およびメッセージ記入を行う衣類を選んでください");
		scan.next();
		
		System.out.println("変更してください");
		scan.next();
		System.out.println("変更完了です！");
		
		viewFactory();
	}
}
