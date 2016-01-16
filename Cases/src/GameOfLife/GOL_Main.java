package GameOfLife;

import java.awt.Color;
import java.util.Map.Entry;

import core.Case;

public class GOL_Main {

	private static GOL_Case[][] map;
	private static int SIZE=5;
	
	public static void main(String args[]) throws InterruptedException{
		initmap(SIZE);
		System.out.println("beginning");
		for(int f = 0;f<100000;f++){
			System.out.println("f="+f);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("--------------------------------------");
			
			for(int i = 0 ; i < SIZE ; ++i){
				for(int j = 0 ; j < SIZE;j++){
					if(map[i][j].getCaseColor()==Color.BLACK)
						System.out.print(" ");
					else
						System.out.print("O");
				}
				System.out.println();
			}
			Thread.sleep(5000);
			
			for(int i = 0; i < SIZE; i++ ){
				for(int j = 0; j<SIZE;j++){
					System.out.println("run:"+i+" "+j);
					map[i][j].run();
				}
			}

			
		}
	}
	
	private static void initmap(int size)
	{
		System.out.println("(-1)%10 : " + (-1+size) % 15);
		map=new GOL_Case[size][size];
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				//if(Math.random() < 0.1)
				if((i==1 && j==0)||(i==1&&j==1)||(i==1&&j==2)){
					map[i][j]=new GOL_Case(GOL_State.ALIVE);
					map[i][j].setCaseColor(Color.WHITE);
				}else{
					map[i][j]=new GOL_Case(GOL_State.DEAD);
					map[i][j].setCaseColor(Color.BLACK);
				}
			}
		}
		
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){	
				
				map[i][j].getInCases().put(map[(i-1+size)%size][(j-1+size)%size], GOL_Link.TOPLEFT);
				map[i][j].getInCases().put(map[(i-1+size)%size][(j)], GOL_Link.TOP);
				map[i][j].getInCases().put(map[(i-1+size)%size][(j+1)%size], GOL_Link.TOPRIGHT);
				map[i][j].getInCases().put(map[(i)][(j-1+size)%size], GOL_Link.LEFT);
				map[i][j].getInCases().put(map[(i)%size][(j+1)%size], GOL_Link.RIGHT);
				map[i][j].getInCases().put(map[(i+1)%size][(j-1+size)%size], GOL_Link.DOWNLEFT);
				map[i][j].getInCases().put(map[(i+1)%size][(j)], GOL_Link.DOWN);
				map[i][j].getInCases().put(map[(i+1)%size][(j+1)%size], GOL_Link.DOWNRIGHT);
				
				map[i][j].getOutCases().put(map[(i-1+size)%size][(j-1+size)%size], GOL_Link.TOPLEFT);
				map[i][j].getOutCases().put(map[(i-1+size)%size][(j)], GOL_Link.TOP);
				map[i][j].getOutCases().put(map[(i-1+size)%size][(j+1)%size], GOL_Link.TOPRIGHT);
				map[i][j].getOutCases().put(map[(i)][(j-1+size)%size], GOL_Link.LEFT);
				map[i][j].getOutCases().put(map[(i)%size][(j+1)%size], GOL_Link.RIGHT);
				map[i][j].getOutCases().put(map[(i+1)%size][(j-1+size)%size], GOL_Link.DOWNLEFT);
				map[i][j].getOutCases().put(map[(i+1)%size][(j)], GOL_Link.DOWN);
				map[i][j].getOutCases().put(map[(i+1)%size][(j+1)%size], GOL_Link.DOWNRIGHT);
				
				//System.out.println(map[i][j]+" "+ map[i][j].getState());
				for( Entry<Case<GOL_State>, Enum> i1 : map[i][j].getOutCases().entrySet()){
					i1.getKey().addMsg(map[i][j], map[i][j].getState());
				}
				
			}
		}
		
	}
	
}
