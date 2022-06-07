package values;

public class FinishDay {
	private final int finishDay;
	
	public FinishDay(int finishDay) {
		this.finishDay=finishDay;
	}
	
	public String toString() {
		return String.valueOf(this.finishDay);
	}
	
	public int toInt() {
		return this.finishDay;
	}
}
