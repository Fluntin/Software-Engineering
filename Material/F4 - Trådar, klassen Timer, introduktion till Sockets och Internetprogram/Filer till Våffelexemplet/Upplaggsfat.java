public class Upplaggsfat {
    private int vaffla=0;
    private boolean vafflorSlut = false;

    public boolean vafflorSlut () {
	return vafflorSlut;
    }

    public synchronized int tag(){
	while (vaffla==0 && !vafflorSlut()) {
	    try{
		wait();
	    } catch(Exception e){};
	}
	int vafflan = vaffla;
	vaffla=0;
	notify();
	if (vafflan == Vaffelkalas.ANTAL_VAFFLOR)
	    vafflorSlut = true;
	return vafflan;
    }

    public synchronized void lagg(int nyVaffla){
	while (vaffla>0) {
	    try{
		wait();
	    } catch(Exception e){};
	}
	vaffla = nyVaffla;
	notify();
    }
}

