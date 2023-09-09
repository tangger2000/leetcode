
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean[] visited;
    boolean[] onPath;
    boolean hasCycle = false;
    List<Integer> postorder = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // DFS
        List<Integer>[] graph = buildgraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        for (int i=0; i<numCourses;i++){
            traverse(graph, i);
        }

        if(hasCycle)
            return new int[]{};

        Collections.reverse(postorder);
        int[] res = new int[numCourses];
        for (int i = 0; i<numCourses; i++){
            res[i] = postorder.get(i);
        }
        return res;

        // BFS
//        List<Integer>[] graph = buildgraph(numCourses, prerequisites);
//        int[] indegree = new int[numCourses];
//        // indegree arr
//        for (int[] edge: prerequisites){
//            int from = edge[1], to = edge[0];
//            indegree[to] ++;
//        }
//
//        // queue
//        Queue<Integer> q = new LinkedList<>();
//        for(int i=0;i<numCourses;i++){
//            if(indegree[i] == 0)
//                q.offer(i);
//        }
//
//        int[] res = new int[numCourses];
//        int count = 0;
//        while (!q.isEmpty()){
//            int cur = q.poll();
//            res[count] = cur;
//            count ++;
//            for (int next: graph[cur]){
//                indegree[next] --;
//                if(indegree[next] == 0)
//                    q.offer(next);
//            }
//        }
//
//        if(count != numCourses)
//            return new int[]{};
//        return res;
    }

    public void traverse(List<Integer>[] graph, int s){
        if(onPath[s])
            hasCycle = true;

        if(visited[s] || hasCycle)
            return;

        visited[s] = true;
        onPath[s] = true;
        for (int t: graph[s]){
            traverse(graph, t);
        }
        postorder.add(s);
        onPath[s] = false;
    }

    // build graph
    public List<Integer>[] buildgraph(int numCourses, int[][] prerequisites){
        List<Integer>[] graph = new LinkedList[numCourses];

        for(int i=0; i < numCourses; i++){
            graph[i] = new LinkedList<>();
        }

        for(int[] edge: prerequisites){
            int from = edge[1], to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
