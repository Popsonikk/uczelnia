package com.company;

public class Main {

    public static void main(String[] args) {
	Papieryw p1= new Obligacje(1000,1,(float)1.05);
	Papieryw p2= new Obligacje(500,2,(float)1.03);
	Papieryw p3= new Obligacje(800,3,(float)1.08);
	Papieryw p4= new Akcje(100,4);
	Papieryw p5= new Akcje(200,5);
	Papieryw [] table={p1,p2,p3,p4,p5};
	Portfel portfel=new Portfel(table);
	portfel.step();
	System.out.println(portfel.cost());
    }
}
