package core;
import java.awt.Color;
import java.util.HashMap;

public abstract class Case<E> {

	private HashMap<Case<E>,Enum> InCases = new HashMap<Case<E>,Enum>();
	private HashMap<Case<E>,Enum> OutCases = new HashMap<Case<E>,Enum>();
	private HashMap<Enum,E> InMsg = new HashMap<Enum,E>();
	private Color caseColor;
	
	public Color getCaseColor() {
		return caseColor;
	}

	public void setCaseColor(Color caseColor) {
		this.caseColor = caseColor;
	}

	protected HashMap<Enum, E> getInMsg() {
		return InMsg;
	}
	
	
	public HashMap<Case<E>, Enum> getInCases() {
		return InCases;
	}

	public void setInCases(HashMap<Case<E>, Enum> inCases) {
		InCases = inCases;
	}

	public HashMap<Case<E>, Enum> getOutCases() {
		return OutCases;
	}

	public void setOutCases(HashMap<Case<E>, Enum> outCases) {
		OutCases = outCases;
	}

	protected E getInMsg(int i) {
		return InMsg.get(i);
	}

	public abstract void run();
	
	public void addMsg(Case<E> c,E msg){
		Enum i = InCases.get(c);
		InMsg.put(i, msg);
	}
	
}
