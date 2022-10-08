package Graph;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
*
* PROBLEM STATEMENT
* Given a directed graph design an algorithm to find out whether there is a route between 2 nodes.
*
* */

/*
* Algorithm
* DFS
* Step 1   : if start == end then return true
* Step 2   : Marking All Node as Unvisited (This will prevent from infinite Cycle)
* Step 3   : Creating an empty list q
* Step 4   : Adding "start" Node to the list q
* Step 5   : Iterating until the q become empty
* Step 5.1 : Remove node from the list q and store it in a variable u and mark u state as Visited if u is not null
* Step 5.2 : Iterated over the adjacent node of 'u'. if an adjacent node from u is an end node return true otherwise add Unvisited nodes to q
* Step 6   : return false
* */

public class FindingRouteBetweenTwoNodes {
    public static class Graph {
        public List<Node> nodes;
        public Graph(List<Node> nodes) {
            this.nodes = nodes;
        }
        public List<Node> getNodes() {
            return nodes;
        }
    }
    public static  class Node {
        public int id;
        public State state;
        public List<Node> adjacent;

        public Node(int id) {
            this.id = id;
            this.adjacent = new ArrayList<>();
        }

        public boolean addNeighbour(Node node) {
            return adjacent.add(node);
        }

        public List<Node> getAdjacent() {
            return adjacent;
        }
    }

    public boolean search(Graph g,Node start,Node end) {
        if (start == end) return true;
        LinkedList<Node> q= new LinkedList<>();
        for (Node u : g.getNodes()) {
            u.state = State.Unvisited;
        }
        q.add(start);
        Node u;
        while (!q.isEmpty()) {
            u = q.removeFirst();
            if (u != null) {
                u.state = State.Visited;
                for (Node v : u.getAdjacent()) {
                    if (v.state == State.Unvisited) {
                        if (v == end) {
                            return true;
                        }else {
                            q.add(v);
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //Creating Nodes
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        //Add Neighbours to our nodes
        node0.addNeighbour(node1);
        node1.addNeighbour(node2);
        node2.addNeighbour(node0);
        node3.addNeighbour(node2);

        //List Of All Nodes
        List<Node> allNodes = List.of(node0,node1,node2,node3);

        Graph graph = new Graph(allNodes);

        FindingRouteBetweenTwoNodes route = new FindingRouteBetweenTwoNodes();

        System.out.println("0 -> 3 : " + route.search(graph,node0,node3));
        System.out.println("3 -> 1 : " + route.search(graph,node3,node1));
    }
}

/*
 * Graph Adjacency List
 * Node 0 -> Node 1
 * Node 1 -> Node 2
 * Node 2 -> Node 0
 * Node 3 -> Node 2
 *
 * Dry Run
 *
 * 1. Search start = 0 -> end = 3
 *
 * checking if start = end
 * 0,1,2,3 -> marking All as Unvisited
 * q = {start : 0}
 * Iterate till q is empty
 *      0 > Visited -> Removing 0 from list -> Iterate adjacent nodes of 0 i.e, 1 -> Is 1 is end : false -> adding 1 to q -> {1} since 1 is Unvisited
 *      1 > Visited -> Removing 1 from list -> Iterate adjacent nodes of 1 i.e, 2 -> Is 2 is end : false -> adding 2 to q -> {2} since 1 is Unvisited
 *      2 > Visited -> Removing 2 from list -> Iterate adjacent nodes of 2 i.e, 0 -> Is 0 is end : false -> not adding 0 to q -> {} since 0 is already Visited
 * return false
 *
 * 2. Search start = 3 -> end = 1
 *
 * checking if start = end
 * 0,1,2,3 -> marking All as Unvisited
 * q = {start : 3}
 * Iterate till q is empty
 *      3 > Visited -> Removing 3 from list -> Iterate adjacent nodes of 3 i.e, 2 -> Is 2 is end : false -> adding 2 to q -> {2} since 2 is Unvisited
 *      2 > Visited -> Removing 2 from list -> Iterate adjacent nodes of 2 i.e, 0 -> Is 0 is end : false -> adding 0 to q -> {0} since 0 is Unvisited
 *      0 > Visited -> Removing 0 from list -> Iterate adjacent nodes of 0 i.e, 1 -> Is 1 is end : true -> return true
 *
 * */
