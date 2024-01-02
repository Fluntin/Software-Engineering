class Sinusmodel {

    double a = 50;     // amplitude
    double p = 100;    // period
    double alfa = 0.5; // phase

    void changePer (double dp) {
	p += dp;
    }

    void changePha (double dalfa) {
	alfa += dalfa;
    }

    void changeAmp (double da) {
	a += da;
    }

    double sin (double x) {
	return a*Math.sin(Math.PI*2/p*x + alfa);
    }
}
