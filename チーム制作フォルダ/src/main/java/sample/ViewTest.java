package sample;

import view.MenuView;

public class ViewTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		MenuView menu=new MenuView();
		int a=menu.viewMenu();
		
		if(a==1)
		{
			menu.viewShop();
		}
		else if(a==2)
		{
			menu.viewFactory();
		}
	}

}
