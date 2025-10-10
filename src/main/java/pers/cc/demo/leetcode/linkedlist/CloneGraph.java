package pers.cc.demo.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {


    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    HashMap<Node, Node> visited = new HashMap<Node, Node>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if(visited.containsKey(node)) {
            return visited.get(node);
        }
        Node newNode = new Node(node.val, new ArrayList());
        visited.put(node, newNode);
        for(Node neighbor : node.neighbors) {
            newNode.neighbors.add(cloneGraph(neighbor));
        }
        return newNode;
    }


    public static void main(String[] args) {
        Node node=new Node(2);
        node.neighbors.add(new Node(4));
        Node node1 = new Node(1);
        node1.neighbors.add(new Node(3));
        node.neighbors.add(node1);
        CloneGraph cg = new CloneGraph();
        cg.cloneGraph(node);

    }


}
