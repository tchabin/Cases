import java.awt.Color;
import java.util.HashMap;
import java.util.Map.Entry;

public class FeuCase extends Case<Integer> {
	private int temperature;

	public FeuCase(int temperature) {
		this.temperature=temperature;
	}

	@Override
	public void run() {
		int haut,bas,droite,gauche;
		HashMap<Integer,Integer> inMsg=getInMsg();
		
		if(inMsg.get(DirectionsGBDH.HAUT)==null) haut=0;
		else haut =inMsg.get(DirectionsGBDH.HAUT);
		
		if(inMsg.get(DirectionsGBDH.DROITE)==null) droite=0;
		else droite =inMsg.get(DirectionsGBDH.DROITE);
		
		if(inMsg.get(DirectionsGBDH.BAS)==null) bas=0;
		else bas =inMsg.get(DirectionsGBDH.BAS);
		
		if(inMsg.get(DirectionsGBDH.GAUCHE)==null) gauche=0;
		else gauche =inMsg.get(DirectionsGBDH.GAUCHE);
		
		temperature=(2*temperature+haut+bas+droite+gauche)/6;
		if (temperature <20) super.setCaseColor(Color.WHITE);
		else if (temperature <40) super.setCaseColor(Color.YELLOW);
		else if (temperature <60) super.setCaseColor(Color.RED);
		else if (temperature <80) super.setCaseColor(Color.BLUE);
		
		/*for(Entry ent:inMsg.entrySet().iterator()){
			
		}*/
		
		
	}
	
	

}
