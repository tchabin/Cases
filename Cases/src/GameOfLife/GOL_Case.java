package GameOfLife;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map.Entry;

import core.Case;

public class GOL_Case extends Case<GOL_State> {

	private GOL_State state;
	
	
	
	public GOL_State getState() {
		return state;
	}
	public GOL_Case(GOL_State state) {
		super();
		this.state = state;
	}
	public void run() {
		// TODO Auto-generated method stub
		int nbAlive = CountAliveNeighbour();
		System.out.print("I was :"+state+ "   nbNeighbourAlive: "+nbAlive);
		if(nbAlive==3){
			state=GOL_State.ALIVE;
			this.setCaseColor(Color.WHITE);
		}else if(nbAlive!=2){
			state=GOL_State.DEAD;
			this.setCaseColor(Color.BLACK);
		}
		System.out.println("  I am :"+state);
		for( Entry<Case<GOL_State>, Enum> i : this.getOutCases().entrySet()){
			i.getKey().addMsg(this, state);
		}
	}
	protected int CountAliveNeighbour(){
		int nbAlive=0;
		HashMap<Enum, GOL_State>  msgs = getInMsg();
		for(Entry<Enum, GOL_State> i : msgs.entrySet()){
			if(i.getValue() == GOL_State.ALIVE)
				nbAlive++;
		}		
		return nbAlive;
	}
}
