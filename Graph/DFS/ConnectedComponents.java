class Solution {
    static void dfs(int index,ArrayList<Integer> curList,boolean visited[],ArrayList<ArrayList<Integer>> adjlist){
        visited[index]=true;
        curList.add(index);
        for(int next:adjlist.get(index)){
            if(!visited[next])
            dfs(next,curList,visited,adjlist);
        }
    }
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adjlist=new ArrayList<>();
        for(int index=0;index<V;index++){
            adjlist.add(new ArrayList<>());
        }
        for(int edge[]:edges){
            adjlist.get(edge[0]).add(edge[1]);
            adjlist.get(edge[1]).add(edge[0]);
        }
        boolean visited[]=new boolean[V];
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        for(int index=0;index<V;index++){
            if(!visited[index]){
            ArrayList<Integer> curList=new ArrayList<>();
            dfs(index,curList,visited,adjlist);
            result.add(curList);
            }
        }
        return result;
    }
}
