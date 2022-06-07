package view;


import java.nio.charset.Charset;
import java.util.Scanner;

public class MenuView {
	// 店舗業務を選ぶ１～６
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
