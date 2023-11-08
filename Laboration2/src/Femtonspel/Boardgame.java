package Femtonspel;

public interface Boardgame {
  public boolean move(int i, int j);
  public String getStatus(int i, int j);
  public String getMessage(); 
}

// Interface is a reference type, similar to a class, that:
// can contain only constants, method signatures, default methods, static methods, and nested types.
// cannot be instantiated directly.
// its implementation is provided by another class.

// An interface is a contract between a class and the outside world.
// When a class implements an interface, it promises to provide the behavior published by that interface.
// If your class claims to implement an interface, all methods defined by that interface must appear 
// in its source code before the class will successfully compile.