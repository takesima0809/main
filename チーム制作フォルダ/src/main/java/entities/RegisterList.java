package entities;

import java.util.ArrayList;

public class RegisterList {
	private ArrayList<RegisterInfo> registerInfoList;
	private int cursol = 0;
	public RegisterList() {
		this.registerInfoList = new ArrayList<RegisterInfo>();
	}
	public void add(RegisterInfo registerInfo) {
		this.registerInfoList.add(registerInfo);
	}
	public boolean hasNext() {
		if(this.cursol < this.registerInfoList.size()) {
			return true;
		}else {
			return false;	
		}	
	}
	public RegisterInfo next() {
		RegisterInfo get = this.registerInfoList.get(this.cursol);
		this.cursol++;
		return get;
	}
	public void reset() {
		this.cursol =0;
	}

	public int size() {
		return  this.registerInfoList.size();
	}
}


