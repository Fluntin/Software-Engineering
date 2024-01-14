import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class TicTocToeTest{

    TicTocToe gp;

    @Before
    public void skapa(){
	gp = new TicTocToe();
    }

    /*    @Test
    public void testCreateIndexMatrix(){
	int[][] indexMatrix=gp.createIndexMatrix();

	}*/

    @Test
    public void TestLookForWinner1(){
	gp.update("X",0,0);
	assertEquals(false, gp.lookForWinner("X"));
    }

    @Test
    public void TestLookForWinner2(){
	gp.update("X",0,1);
	assertEquals(false,gp.lookForWinner("X"));
    }

    @Test
    public void TestLookForWinner10(){
	gp.update("X",0,0);
	gp.update("X",0,1);
	gp.update("X",0,2);
	assertEquals(true,gp.lookForWinner("X"));
    }


     @Test
    public void TestLookForWinner11(){
	gp.update("X",1,0);
	gp.update("X",1,1);
	gp.update("X",1,2);
	assertEquals(true,gp.lookForWinner("X"));
    }

         @Test
    public void TestLookForWinner17(){
	gp.update("X",2,0);
	gp.update("X",2,1);
	gp.update("X",2,2);
	assertEquals(true,gp.lookForWinner("X"));
    }

    @Test
    public void TestLookForWinner12(){
	gp.update("X",0,0);
	gp.update("X",1,0);
	gp.update("X",2,0);
	assertEquals(true,gp.lookForWinner("X"));
	 }
    @Test
    public void TestLookForWinner13(){
	gp.update("X",0,1);
	gp.update("X",1,1);
	gp.update("X",2,1);
	assertEquals(true,gp.lookForWinner("X"));
	 }

    @Test
    public void TestLookForWinner14(){
	gp.update("X",0,2);
	gp.update("X",1,2);
	gp.update("X",2,2);
	assertEquals(true,gp.lookForWinner("X"));
    }


        @Test
    public void TestLookForWinner15(){
	gp.update("X",0,0);
	gp.update("X",1,1);
	gp.update("X",2,2);
	assertEquals(true,gp.lookForWinner("X"));
    }
    
    @Test
        public void TestLookForWinner16(){
	gp.update("X",0,2);
	gp.update("X",1,1);
	gp.update("X",2,0);
	assertEquals(true,gp.lookForWinner("X"));
    }


    /*
    @Test
    public void TestLookForWinner3(){
	for (int i=0; i<3;i++)
	    gp.update("X",0,i);
	assertEquals(true, gp.lookForWinner("X"));
	skapa();
	for (int i=0; i<3;i++)
	    gp.update("X",1,i);
	assertEquals(true, gp.lookForWinner("X"));
	
	skapa();
	for (int i=0; i<3;i++)
	    gp.update("X",2,i);
	assertEquals(true, gp.lookForWinner("X"));
    }

    @Test
    public void TestLookForWinner4(){
	for (int i=0; i<3;i++)
	    gp.update("X",i,0);
	assertEquals(true, gp.lookForWinner("X"));
	skapa();
	for (int i=0; i<3;i++)
	    gp.update("X",i,0);
	assertEquals(true, gp.lookForWinner("X"));
	
	skapa();
	for (int i=0; i<3;i++)
	    gp.update("X",i,2);
	assertEquals(true, gp.lookForWinner("X"));
    }
    
    */
    
}
