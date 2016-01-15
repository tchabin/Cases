package GameOfLife;

public class GOL_Main {

	static GOL_Case[][] map; 
	
	public static void main(String args[]){
		initmap(50);
		
	}
	
	private static void initmap(int size)
	{
		map=new GOL_Case[size][size];
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				map[i][j]=new GOL_Case();
			}
		}
		
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){	
				map[i][j].getInCases().put(map[(i-1)%size][(j-1)%size], GOL_Link.TOPLEFT);
				map[i][j].getInCases().put(map[(i-1)%size][(j-1)%size], GOL_Link.TOPLEFT);
				map[i][j].getInCases().put(map[(i-1)%size][(j-1)%size], GOL_Link.TOPLEFT);
				map[i][j].getInCases().put(map[(i-1)%size][(j-1)%size], GOL_Link.TOPLEFT);
				map[i][j].getInCases().put(map[(i-1)%size][(j-1)%size], GOL_Link.TOPLEFT);
				map[i][j].getInCases().put(map[(i-1)%size][(j-1)%size], GOL_Link.TOPLEFT);
				map[i][j].getInCases().put(map[(i-1)%size][(j-1)%size], GOL_Link.TOPLEFT);
				map[i][j].getInCases().put(map[(i-1)%size][(j-1)%size], GOL_Link.TOPLEFT);
			}
		}
		
	}
	
}
