
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return res;
    }

    void traverse(int[][] graph, int s, LinkedList<Integer> path){
        path.addLast(s);

        int n = graph.length;
        if(s == n-1)
            res.add(new LinkedList<>(path));

        for(int v : graph[s]){
            traverse(graph, v, path);
        }

        path.removeLast();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
