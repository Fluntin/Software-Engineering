import java.util.*;

class TicTocToe {
    private String[][] gamePlan;
    private final static int SIZE = 3;
        
    public TicTocToe(){
	gamePlan= new String[SIZE][SIZE];
    }

    public boolean update(String tkn, int rad,int  kol){
	if (gamePlan[rad][kol]==null){
	    gamePlan[rad][kol]=tkn;
	    return true;
	}
	return false;
    
    }

    public boolean lookForWinner(String tkn){
	int[][][] indx={{{0,0},{0,1},{0,2}},
			{{1,0},{1,1},{1,2}},
			{{2,0},{2,1},{2,2}},
			{{0,0},{1,0},{2,0}},
			{{0,1},{1,1},{2,1}},
			{{0,2},{1,2},{2,2}},
			{{0,0},{1,1},{2,2}},
			{{0,2},{1,1},{2,1}}
	};
	
	for(int i=0;i<indx.length; i++){
	    boolean winner=true;
	    for(int j=0;j<indx[i].length; j++){
		int rad=indx[i][j][0];
		int kol=indx[i][j][1];
		if (! tkn.equals(gamePlan[rad][kol]))
		    winner=false;
	    }
	    if (winner)
		return true;
	}
	return false;
	    
	/*	if (tkn.equals(gamePlan[0][0]) && tkn.equals(gamePlan[0][1]) && tkn.equals(gamePlan[0][2]))
	    return true;
	
	else if (tkn.equals(gamePlan[0][1]) && tkn.equals(gamePlan[1][1]) && tkn.equals(gamePlan[2][1]))
	    return true;
	    return false;*/
    }

    public static void main(String[] args){
	TicTocToe ttt=new TicTocToe();
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


    /*    public ArrayList createIndexMatrix(){
	ArrayList checkMatrix = new ArrayList();
	ArrayList checkList = null;
	for (int i=0; i<3; i++){
	    checkList = new ArrayList();
	    for(int j=0; j<3; j++)
		checkList.add(new int[]{i,j});
	    //System.out.println(i+" "+j);
	    checkMatrix.add(checkList);
	}
	/*	
	for (int i=0; i<3;i++){
	    for(int j=0; j<3;j++)
		checkList.add(new int[]{i,j});
	   //System.out.println(j+" "+i);
	    checkMatrix.add(checkList);
	}

	for (int i=0; i<3;i++)
	    checkMatrix.add(checkList);
		    System.out.println(i+" "+i);

	for (int i=0,j=2; i<3;i++,j--)
	    System.out.println(i+" "+j);
	
	return checkMatrix;
    }*/
}
