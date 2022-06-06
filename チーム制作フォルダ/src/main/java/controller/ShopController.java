package controller;

import view.MenuView;

public class ShopController {
 private final MenuView menuView;
 
 public ShopController()
 {
	 this.menuView=new MenuView();
 }
 public void run()
 {

	 this.menuView.viewMessage();
	 
	 int selectBusiness=this.menuView.selectShopBusiness();
	 
	 switch(selectBusiness)
	 {
	 case 1:
		 this.menuView.viewMemberRegistration();
		 break;
	 case 2:
		 this.menuView.viewReception();
		 break;
	 case 3:
		 this.menuView.viewHandOver();
		 break;
	 case 4:
		 this.menuView.viewClothesList();
		 break;
	 case 5:
		 this.menuView.finishCode();
		 break;
	 }
	 run();
 }
}
