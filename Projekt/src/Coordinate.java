// This class is responsible for the movement of the particles in the simulation
// and the simulation time of the program (how many times the particles move)
public class Coordinate {
    int xCoord, yCoord;

    Coordinate(int xCoord, int yCoord){
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public int compareCoordinates(Coordinate other) {
        if((this.xCoord == other.yCoord) && (this.yCoord == other.yCoord)){
            return 3;
        } else if ((this.xCoord == other.yCoord) && (Math.abs(this.yCoord - other.yCoord)) == 1){
            return -1;
        } else if ((this.yCoord == other.yCoord) && (Math.abs(this.xCoord - other.xCoord)) == 1){
            return 1;
        } else if((Math.abs(this.yCoord - other.yCoord) == 1) && (Math.abs(this.xCoord - other.xCoord) == 1)){
            return 2;
        }
        return 0;
    }
}