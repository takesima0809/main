package entities;

import clothesValues.Price;
import clothesValues.WaitDay;

public class CleanOption {
	//特急仕上げ
	public int washHurryFinish(WaitDay waitDay) {
		return 1;
	}
	
	//デラックス仕上げ
	public double washDeluxeFinish(Price price) {
		return price.toInt()*1.5;
	}
	
	//染抜き
	public int washStainRemoval(Price price,int count) {
		return price.toInt()+(count*200);
	}
		
}