package entities;

import java.util.ArrayList;
import java.util.List;

public class DepositDataList {
	private final List<DepositData>depositList;
	private int cursol=0;
	public DepositDataList(){
		this.depositList=new ArrayList<>();
	}
	
	public void addData(DepositData depositData) {
		depositList.add(depositData);
	}
	
	public boolean hasNext() {
		return depositList.size()>cursol;
	}
	
	public DepositData next() {
		return depositList.get(cursol++);
	}
	
	public int size() {
		return this.depositList.size();
	}
}
