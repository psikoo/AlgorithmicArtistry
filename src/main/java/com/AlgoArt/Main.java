package com.AlgoArt;

public class Main {
    public static void main( String[] args ) { // mvn clean validate compile site assembly:assembly -DdescriptorId=jar-with-dependencies exec:exec
        new App(args);
    }
}
