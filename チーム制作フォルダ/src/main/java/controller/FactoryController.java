package controller;

import view.MenuView;

public class FactoryController {
	private final  MenuView menuView;
	
	public FactoryController()
	{
		this.menuView=new MenuView();
	}
	
	public void run() 
	{
		//請け負う業務を選択
		int selectMethod=this.menuView.selectFactoryBusiness();
		//
		switch(selectMethod)
		{
		case 1:
			this.menuView.viewClothesList();
			break;
		case 2:
			this.menuView.viewSelectClothesList();
			break;
		case 3:
			this.menuView.writeMassage();
			break;
		case 4:
			this.menuView.cangeHandOverDay();
			break;
		case 5:
			this.menuView.finishCode();
			break;
		}
		run();
	}
}
