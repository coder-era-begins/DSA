// User function Template for Java
class DisjointSetUnion{
    int capacity;
    ArrayList<Integer> rank;
    ArrayList<Integer> parent;
    DisjointSetUnion(int capacity){
        rank=new ArrayList<>();
        parent=new ArrayList<>();
        this.capacity=capacity;
        Initialize();
    }
    void Initialize(){
        for(int cnt=0;cnt<capacity;cnt++){
            parent.add(cnt);
            rank.add(0);
        }
    }
    int parentFind(int node){
        if(node==parent.get(node)){
            return node;
        }
        parent.set(node, parentFind(parent.get(node)));
        return parent.get(node);
    }
    void UnionByRank(int u,int v){
        int parentU=parentFind(u);
        int parentV=parentFind(v);
        if(rank.get(parentU)>rank.get(parentV)){
            parent.set(parentV,parentU);
        }
        else if(rank.get(parentV)>rank.get(parentU)){
            parent.set(parentU,parentV);
        }
        else{
            parent.set(parentU,parentV);
            rank.set(parentV,rank.get(parentV)+1);
        }
    }
}
class Solution {
    static int kruskalsMST(int V, int[][] edges) {
        // code here
        Arrays.sort(edges, Comparator.comparingInt(edge -> edge[2]));
        DisjointSetUnion ds=new DisjointSetUnion(V);
        int sum=0;
        for(int edge[]:edges){
            if(ds.parentFind(edge[0])!=ds.parentFind(edge[1])){
            ds.UnionByRank(edge[0],edge[1]);
            sum+=edge[2];
            }
        }
        return sum;
    }
}
