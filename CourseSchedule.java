package queue;

import java.util.*;

public class CourseSchedule {
    
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prerequisite = prereq[1];
            adjList.get(prerequisite).add(course);
            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int completedCourses = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            completedCourses++;
            
            for (int neighbor : adjList.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return completedCourses == numCourses;
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = { {1, 0}, {2, 1}, {3, 2} };

        if (canFinish(numCourses, prerequisites)) {
            System.out.println("All courses can be finished.");
        } else {
            System.out.println("Not all courses can be finished.");
        }
    }
}

