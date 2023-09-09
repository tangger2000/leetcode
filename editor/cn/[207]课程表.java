
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean[] visited;
    boolean[] onPath;
    boolean hasCycle = false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // DFS
//        List<Integer>[] graph = buildgraph(numCourses, prerequisites);
//        visited = new boolean[numCourses];
//        onPath = new boolean[numCourses];
//
//        for (int i=0; i< numCourses; i++){
//            traverse(graph, i);
//        }
//        return !hasCycle;

        // BFS
        List<Integer>[] graph = buildgraph(numCourses, prerequisites);
        int[] indegree = new int[numCourses];
        // indegree arr
        for (int[] edge: prerequisites){
            int from = edge[0], to = edge[1];
            indegree[to] ++;
        }

        // queue
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0)
                q.offer(i);
        }

        int count=0;
        while (!q.isEmpty()){
            int cur = q.poll();
            count++;
            for(int next: graph[cur]){
                indegree[next]--;
                if(indegree[next] == 0)
                    q.offer(next);
            }
        }
        return count == numCourses;
    }

    // build graph
    public List<Integer>[] buildgraph(int numCourses, int[][] prerequisites){
        List<Integer>[] graph = new LinkedList[numCourses];
        for(int i=0; i<numCourses; i++){
            graph[i] = new LinkedList<>();
        }

        for(int[] edge: prerequisites){
            int from = edge[0], to = edge[1];
            graph[from].add(to);
        }
        return graph;
    }

    void traverse(List<Integer>[] graph, int s){
        if(onPath[s])
            hasCycle = true;

        if(visited[s] || hasCycle)
            return;

        visited[s] = true;
        onPath[s] = true;

        for (int t : graph[s]){
            traverse(graph, t);
        }
        onPath[s] = false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
