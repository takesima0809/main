package controller;

import service.FindService;
import service.UpdataService;
import view.FactoryBusiness;

public class FactoryController {
	private final  FactoryBusiness factoryBusiness;
	private final UpdataService updataService;
	private final FindService findService;

	public FactoryController() {
		this.factoryBusiness=new FactoryBusiness();
		this.updataService=new UpdataService();
		this.findService=new FindService();
	}

	public void run() throws NumberFormatException
	{
		int selectBusiness=0;
		while(selectBusiness!=5) {
			selectBusiness=factoryBusiness.selectFactoryBusiness();
			switch (selectBusiness) {
			case 1: {
				factoryBusiness.viewClothesList(findService.findAllData());
				break;
			}
			case 2: {
				String filteringDate = factoryBusiness.selectDate();
				if(filteringDate!=null) {
					factoryBusiness.viewSelectClothesList(findService.FilteringList(filteringDate));
				}
				break;
			}
			case 3: {
				String[] message= factoryBusiness.cangeHandOverDay();
				if(message!=null) {			
					this.factoryBusiness.dateInputFlag(updataService.updataFinishDate(Integer.parseInt(message[0]),message[1]));
				}
				break;
			}
			case 4: {
				String[] message= factoryBusiness.writeMassage();
				if(message!=null) {
					this.factoryBusiness.messageInputFlag(updataService.updataMessage(Integer.parseInt(message[0]),message[1]));
				}
				break;
			}
			case 5:{
				break;
			}
			default:
				break;
			}
		}

	}
}
