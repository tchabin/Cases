import java.awt.Color;
import java.util.HashMap;

public abstract class Case<E> {

	private HashMap<Case<E>,Integer> InCases, OutCases;
	private HashMap<Integer,E> InMsg;
	private Color caseColor;
	
	public Color getCaseColor() {
		return caseColor;
	}

	protected void setCaseColor(Color caseColor) {
		this.caseColor = caseColor;
	}

	protected HashMap<Integer, E> getInMsg() {
		return InMsg;
	}

	public abstract void run();
	
	public void addMsg(Case<E> c,E msg){
		Integer i = InCases.get(c);
		InMsg.put(i, msg);
	}
	
}
