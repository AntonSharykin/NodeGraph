package com.sharykin.anton;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	GNode[] gNodes = {new Graph("B"), new Graph("C"),new Graph("D")};
    GNode[] gNodes2 = {new Graph("E"), new Graph("F"),new Graph("G")};
    GNode[] gNodes3 = {new Graph("J",gNodes), new Graph("K"),new Graph("L",gNodes2)};
    GNode gNode = new Graph("A",gNodes3);
    ((Graph) gNode).printGraphNodes(((Graph) gNode).walkGraph(gNode));
    System.out.println("---------------------------------------------");
    ArrayList<ArrayList<GNode>>arrayLists = ((Graph) gNode).paths(gNode);
    for(ArrayList<GNode> arrayList : arrayLists){
        for (GNode gNode2: arrayList) {
            System.out.print(gNode2+" -> ");
        }
        System.out.println();
    }
    }
}
