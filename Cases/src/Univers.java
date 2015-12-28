import java.util.Arrays;

public class Univers {
	private int taille = 2;
	private CaseSimple[][] univers=new CaseSimple[taille][taille];
	public Univers() {}
	
	public CaseSimple remplacerCase(CaseSimple nouvelle,int i,int j){
		CaseSimple c;
		if (i<0||i>=taille||j<0||j>=taille)
			return null;
		else {
			c=univers[i][j];
			univers[i][j]=nouvelle;
			return c;//renvoie l'ancienne case
		}
	}
	
	@Override
	public String toString() {
		String msg="";
		
		for(CaseSimple[] ligne:univers){
			
			for(CaseSimple c:ligne){
				if (c==null)
					msg+=" 0";
				else
					msg+=" "+c.getChar();
			}
			msg+="\n";
			
			
		}
		
		return msg;
	}
	
	public static void main(String[] args){
		Univers u = new Univers();
		u.remplacerCase(new FeuCase(50), 0, 0);
		u.remplacerCase(new FeuCase(50), 0, 1);
		u.remplacerCase(new FeuCase(50), 1, 0);
		System.out.println(u);
	}
	
	
}
