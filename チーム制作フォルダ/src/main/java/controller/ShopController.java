package controller;

import java.text.ParseException;

import entities.UserData;
import service.AddService;
import view.MenuView;
import view.ShopBusiness;

public class ShopController {
	private final MenuView menuView;
	private final ShopBusiness shopBusiness;
	private final AddService addService;

	public ShopController()
	{
		this.menuView=new MenuView();
		this.shopBusiness=new ShopBusiness();
		this.addService=new AddService();
	}
	public void run() throws ParseException
	{

		while(true) {
			this.menuView.viewMessage();

			int selectBusiness=this.menuView.selectShopBusiness();

			switch(selectBusiness)
			{
			case 1:
				UserData userData=this.shopBusiness.viewMemberRegistration();
				addService.UserSignUp(userData.getUserName().toStr(), userData.getPhoneNumber().toStr());
				break;
			case 2:
				this.shopBusiness.showDepositInfo(this.addService.ClothesReception(this.shopBusiness.viewReception()));
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
		}
	}
}
