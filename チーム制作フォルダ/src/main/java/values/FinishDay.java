package values;

public class FinishDay {
	private final String finishDay;
	
	public FinishDay(String finishDay) {
		this.finishDay=finishDay;
	}
	
	public String toString() {
		return this.finishDay;
	}
	
	public int toInt() {
		return Integer.parseInt(finishDay);
	}
}
