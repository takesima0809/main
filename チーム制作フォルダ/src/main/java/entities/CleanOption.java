package entities;

import clothesValues.WaitDay;

public class CleanOption {
	//特急仕上げ
	public int washHurryFinish(WaitDay waitDay) {
		return 1;
	}
	
	//デラックス仕上げ
	public int washDeluxeFinish(int price) {
		price*=1.5;
		return (int)Math.round(price);
	}
	
	//染抜き
	public int washStainRemoval(int price,int count) {
		return price+(count*200);
	}
		
}