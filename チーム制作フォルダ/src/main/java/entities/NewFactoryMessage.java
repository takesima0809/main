package entities;

public class NewFactoryMessage {
	private final String userName;
	private final String factoryMessage;
	public NewFactoryMessage(String userName,String factoryMessage) {
		this.userName=userName;
		this.factoryMessage=factoryMessage;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public String getFactoryMessage(){
		return this.factoryMessage;
	}
}
