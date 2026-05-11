package lc207_课程表;

import java.util.*;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indgree = new int[numCourses];//入度
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());//初始化图
        }
        for (int[] p : prerequisites) {//创建图
            int a = p[0];
            int b = p[1];
            graph.get(b).add(a);//b的list里面加入a  表示b的下一个节点list
            indgree[a]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();//放入度为0的节点
        for (int i = 0; i < numCourses; i++) {//初始化queue
            if (indgree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;//可以学的课程
        while (!queue.isEmpty()) {
            int c = queue.poll();
            count++;
            for (int next : graph.get(c)) {//每个入度为0的下个节点  入度--
                indgree[next]--;
                if (indgree[next] == 0) {//如果入度减为零 入队
                    queue.offer(next);
                }
            }
        }

        return count == numCourses;
    }
}
