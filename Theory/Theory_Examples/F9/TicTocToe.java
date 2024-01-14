import java.util.*;
class TicTocToe implements GameInterface{
    private static final long serialVersionUID = 1L;
    private String[][] gamePlan;
    private final static int SIZE = 5;
    private boolean gameIsOn=true;
    private int turn=0;
    private String winner = "Ingen";
    
    public static void main(String args[]){
	TicTocToe gp=new TicTocToe();
	while(gp.isOn())
	    gp.play();
	
	    }
    
    public TicTocToe(){
	gamePlan= new String[SIZE][SIZE];
    }

    public String getWinner(){
	return winner;
    }

    public String toString(){
	String retStr="  ";
	for(int i = 0; i< gamePlan.length; i++)
	    retStr += i+" ";
	retStr+="\n";
	for(int i = 0; i< gamePlan.length; i++){
	    retStr+=i+" ";
	    for(int j = 0; j< gamePlan[i].length; j++)
		if(gamePlan[i][j]==null)
		    retStr+="- ";
		else
		    retStr+= gamePlan[i][j]+" ";
	    retStr=retStr+"\n";
	}
	return retStr;
    }



    public boolean isPlanOccupied(){
	for(int i = 0; i< gamePlan.length; i++)
	    for(int j = 0; j< gamePlan[i].length; j++)
		if(gamePlan[i][j]==null)
		    return false;
	return true;
    }
    
	
    public boolean update(String sign, int r, int c){
	
	if (c>=0 && c< SIZE &&r>=0 &&r<SIZE && gamePlan[r][c]==null){
	    gamePlan[r][c]=sign;
	    return true;
	}
	return false;
    }


    private int count(int x,int y, int xr, int yr, String tecken){
        if (-1<x+xr && x+xr < gamePlan.length && -1<y+yr && y+yr < gamePlan.length){
	    if (!tecken.equals(gamePlan[x+xr][y+yr]))
		return 0;
	    else
		return 1 + count(x+xr,y+yr,xr,yr,tecken);
	}else
	    return 0;
	
    }

    public void shutdown(){
	gameIsOn=false;
    }
    
    public boolean isOn(){
	return gameIsOn;
    }
    
    public boolean lookForWinner(int x,int y){
	int u=1,h=1,v=-1,n=-1, __=0;
        String t = gamePlan[x][y];
	if (count(x,y,h,__,t) + count(x,y,v,__,t)+1>= SIZE)
	    return true;
	if (count(x,y,__,u,t) + count(x,y,__,n,t)+1>= SIZE)
	    return true;
	if (count(x,y,h,u,t) + count(x,y,v,n,t)+1>= SIZE)
	    return true;
        if (count(x,y,v,u,t) + count(x,y,h,n,t)+1>= SIZE)
            return true;
	return false;

    }

    public void play(){
	gameIsOn = !isPlanOccupied();
	if (gameIsOn){
	    int rad, kolumn;
	    System.out.println(this);
	    String[] signs={"X","O"};
	    boolean done=false;
	    Scanner scanner=new Scanner(System.in);
	    System.out.println("Din tur, "+signs[turn]+", att spela!");
	    do{
		System.out.print("Ange rad: ");
		rad= scanner.nextInt();
		System.out.print("Ange kolumn: ");
		kolumn=scanner.nextInt();
		done = update(signs[turn],rad,kolumn);
		if(!done)
		    System.out.println("Rutan är redan upptagen, försök igen!");
	    }while(!done);
	    System.out.println(this);
	    gameIsOn = !lookForWinner(rad,kolumn);
	    
	    if (!gameIsOn){
		winner = signs[turn];
	    }
	    
	    turn = ++turn%2;
	    if(gameIsOn && winner.equals("Ingen"))
		System.out.println("\n\nAndra spelarens tur, dröj...\n\n");
	}
    }
}
