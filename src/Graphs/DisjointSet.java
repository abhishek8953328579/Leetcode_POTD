package Graphs;

import java.util.ArrayList;

class Disjoint_set{

    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();

    public Disjoint_set(int n){
        for(int i=0;i<=n;i++){
            rank.add(0);
            parent.add(i);
            size.add(0);
        }
    }

    public int findUPar(int node){
        if(node==parent.get(node)){
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node , ulp);
        return parent.get(node);
    }

    public void unionByRank(int u , int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(ulp_u == ulp_v) return;

        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u , ulp_v);
        }

        else if(rank.get(ulp_v) < rank.get(ulp_u)){
            parent.set(ulp_v , ulp_u);
        }
        else {
            parent.set(ulp_v , ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u , rankU+1);
        }
    }

    public void unionBySize(int u , int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(ulp_u == ulp_v) return ;

        if(size.get(ulp_u) > size.get(ulp_v)){
            parent.set(ulp_v , ulp_u);
            size.set(ulp_u , size.get(ulp_u)+size.get(ulp_v));
        }

        else{
            parent.set(ulp_u , ulp_v);
            size.set(ulp_v , size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
public class DisjointSet {
    public static void main(String[] args) {
        Disjoint_set ds = new Disjoint_set(7);


        ds.unionBySize(1,2);
        ds.unionBySize(2,3);
        ds.unionBySize(4,5);
        ds.unionBySize(6,7);
        ds.unionBySize(5,6);

        // ex :- finding the ultimate parent of 3 and 7 before inserting
        if(ds.findUPar(3) == ds.findUPar(7)){
            System.out.println("same");
        }
        else {
            System.out.println("not same");

        }

        // inserting node 3 - 7;
        ds.unionBySize(3,7);



        // ex :- finding the ultimate parent of 3 and 7 after inserting

        if(ds.findUPar(3) == ds.findUPar(7)){
            System.out.println("same");
        }
        else {
            System.out.println("not same");
        }
    }


}
