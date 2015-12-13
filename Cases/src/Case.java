import java.awt.Color;
import java.util.HashMap;

public abstract class Case {

	HashMap<Case,Integer> InCases;
	HashMap<Case,Integer> OutCases;
	Color caseColor;
	boolean useless;
	boolean tryagain;
	
	HashMap<Integer,Object> InMsg;
	
	public abstract void run();
	
	public void addMsg(Case c,Object msg){
		Integer i = InCases.get(c);
		InMsg.put(i, msg);
	}
	
	
}
