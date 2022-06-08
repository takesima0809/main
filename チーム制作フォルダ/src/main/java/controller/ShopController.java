package controller;

import java.sql.SQLException;
import java.text.ParseException;

import entities.UserData;
import service.AddService;
import service.DeleteService;
import service.FindService;
import view.MenuView;
import view.ShopBusiness;

public class ShopController {
	private final MenuView menuView;
	private final ShopBusiness shopBusiness;
	private final AddService addService;
	private final FindService findService;
	private final DeleteService deleteService;
	
	public ShopController()
	{
		this.menuView=new MenuView();
		this.shopBusiness=new ShopBusiness();
		this.addService=new AddService();
		this.findService=new FindService();
		this.deleteService=new DeleteService();
	}
	public void run() throws ParseException, SQLException
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
				this.shopBusiness.showDepositInfo(this.addService.ClothesReception(this.shopBusiness.viewReception(findService.findClothesDatas())));
				break;
			case 3:
				int[] deleteNumber=shopBusiness.viewHandOver();
				if(this.shopBusiness.viewDepositList(findService.deliveryDatas(deleteNumber))) {
					deleteService.deleteData(deleteNumber);
				}
				break;
			case 4:
				this.shopBusiness.viewDepositListToUserId(this.findService.findDepositDatas(this.shopBusiness.inputUserId()));
				break;
			case 5:
				this.menuView.finishCode();
				break;
			}
		}
	}
}
