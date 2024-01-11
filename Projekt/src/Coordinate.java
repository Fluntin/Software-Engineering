//--------------------------------------------------------------------------------------------
// This class creates a coordinate object that has two integer values, xCoord and yCoord.
// The class also has a method that compares two coordinates and returns an integer value
// Where the integer value is returned depends on the coordinates' relation to each other.
//--------------------------------------------------------------------------------------------
public class Coordinate {
    int xCoord, yCoord;

    Coordinate(int xCoord, int yCoord){
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    //--------------------------------------------------------------------------------------------
    // compareCoordinates ->  Compares the coordinates of two coordinates
    //
    // Thre are 4 possible return values:
    //
    // 3: The coordinates are the same
    // 2: The coordinates are diagonal to each other
    // 1 and -1: The coordinates are next to each other
    // 0: The coordinates are not next to each other
    //--------------------------------------------------------------------------------------------
    public int compareCoordinates(Coordinate other) {
        if((this.xCoord == other.yCoord) && (this.yCoord == other.yCoord)){
            return 3; // 3 means that the coordinates are the same
        } else if ((this.xCoord == other.yCoord) && (Math.abs(this.yCoord - other.yCoord)) == 1){
            return -1; // -1 means that the coordinates are next to each other
        } else if ((this.yCoord == other.yCoord) && (Math.abs(this.xCoord - other.xCoord)) == 1){
            return 1; // 1 means that the coordinates are next to each other
        } else if((Math.abs(this.yCoord - other.yCoord) == 1) && (Math.abs(this.xCoord - other.xCoord) == 1)){
            return 2; // 2 means that the coordinates are diagonal to each other
        }
        return 0;
    }
}