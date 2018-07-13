package com.sharykin.anton;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;


public class Graph implements GNode {
    private String name;
    private GNode[] children;
    private ArrayList<GNode> gNodeList;
    private Stack<GNode> gNodeStack = new Stack<>();
    private ArrayList<GNode>singleNodeList = new ArrayList<>();
    private ArrayList<ArrayList<GNode>> pathsNodeList = new ArrayList<>();

    public Graph(String name, GNode[] children) {
        this.name = name;
        this.children = children;
        gNodeList = new ArrayList<>();
    }

    public Graph(String name) {
        this.name = name;
        this.children = new GNode[0];
        gNodeList = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return null;
    }

    public void setChildren(GNode[] children) {
        this.children = children;
    }

    public ArrayList walkGraph(GNode gNode){
        gNodeList.add(gNode);
        for(GNode gNode2 : gNode.getChildren()){
            walkGraph(gNode2);
        }
        gNodeList = (ArrayList) gNodeList.stream().distinct().collect(Collectors.toList());
        return gNodeList;
    }

    public ArrayList paths(GNode gNode) {
        gNodeStack.push(gNode);
        singleNodeList.add(gNode);

        while (!gNodeStack.isEmpty()) {
            GNode currentNode = gNodeStack.peek();

            GNode[] children = currentNode.getChildren();

            if (children.length == 0) {

                pathsNodeList.add(new ArrayList<GNode>(singleNodeList));
            }

            for(GNode childNode : children) {

                paths(childNode);


                gNodeStack.pop();
                singleNodeList.remove(singleNodeList.size() - 1);
            }

            break;
        }

        return pathsNodeList;
    }


    public void printGraphNodes(ArrayList<GNode> arrayList){
        for(GNode gNode2 : arrayList){
            System.out.println(gNode2);
        }
    }

    @Override
    public GNode[] getChildren() {
        if(children == null){
            this.children = new GNode[0];
        }
        return children;
    }

    @Override
    public String toString() {
        return  "Node :" + name ;
    }
}
