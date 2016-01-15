package GameOfLife;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map.Entry;

import core.Case;

public class GOL_Case extends Case<GOL_State> {

	GOL_State state;
	
	public void run() {
		// TODO Auto-generated method stub
		int nbAlive = CountAliveNeighbour();
		if(nbAlive==3){
			state=GOL_State.ALIVE;
			this.setCaseColor(Color.WHITE);
		}else if(nbAlive!=2){
			state=GOL_State.DEAD;
			this.setCaseColor(Color.BLACK);
		}
		
		for( Entry<Case<GOL_State>, Integer> i : this.getOutCases().entrySet()){
			i.getKey().addMsg(this, state);
		}
	}
	protected int CountAliveNeighbour(){
		int nbAlive=0;
		HashMap<Integer, GOL_State>  msgs = getInMsg();
		for(Entry<Integer, GOL_State> i : msgs.entrySet()){
			if(i.getValue() == GOL_State.ALIVE)
				nbAlive++;
		}		
		return nbAlive;
	}
}
