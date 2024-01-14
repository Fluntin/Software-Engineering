import java.util.function.*;
import java.util.stream.*;
import java.util.*;

class Streams{

    public static void main(String[] args){

	String[] allaOrd = {"Jag", "heter", "Olle"};
	List<String> list = Arrays.asList(allaOrd);
    Stream<String> stream1 = list.stream();
    stream1.forEach(ord ->System.out.print(ord+" "));
    System.out.println();
    Stream<String> stream2 = list.stream();
    stream2.map(ord->ord.replace('O','a')).forEach(ord ->System.out.print(ord.replace('e','a')+" "));
    
    }

    
}
