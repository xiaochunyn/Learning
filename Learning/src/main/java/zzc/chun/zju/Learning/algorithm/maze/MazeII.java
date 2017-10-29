package zzc.chun.zju.Learning.algorithm.maze;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by chun on 17-10-29.
 *
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down,
 * left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

 Given the ball's start position, the destination and the maze, find the shortest distance for the ball to stop at the
 destination. The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded)
 to the destination (included). If the ball cannot stop at the destination, return -1.

 The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the
 borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.

 Example 1

 Input 1: a maze represented by a 2D array

 0 0 1 0 0
 0 0 0 0 0
 0 0 0 1 0
 1 1 0 1 1
 0 0 0 0 0

 Input 2: start coordinate (rowStart, colStart) = (0, 4)
 Input 3: destination coordinate (rowDest, colDest) = (4, 4)

 Output: 12
 Explanation: One shortest way is : left -> down -> left -> down -> right -> down -> right.
 The total distance is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.

 Example 2
 Input 1: a maze represented by a 2D array

 0 0 1 0 0
 0 0 0 0 0
 0 0 0 1 0
 1 1 0 1 1
 0 0 0 0 0

 Input 2: start coordinate (rowStart, colStart) = (0, 4)
 Input 3: destination coordinate (rowDest, colDest) = (3, 2)

 Output: -1
 Explanation: There is no way for the ball to stop at the destination.

 Note:
 There is only one ball and one destination in the maze.
 Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
 The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the
 border of the maze are all walls.
 The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.

 这道题是之前那道The Maze的拓展，那道题只让我们判断能不能在终点位置停下，而这道题让我们求出到达终点的最少步数。其实本质都是一样的，
 难点还是在于对于一滚到底的实现方法，唯一不同的是，这里我们用一个二位数组dists，其中dists[i][j]表示到达(i,j)这个位置时需要的最小步数，
 我们都初始化为整型最大值，在后在遍历的过程中不断用较小值来更新每个位置的步数值，最后我们来看终点位置的步数值，如果还是整型最大值的话，
 说明没法在终点处停下来，返回-1，否则就返回步数值。注意在压入栈的时候，我们对x和y进行了判断，只有当其不是终点的时候才压入栈，这样是做了优化，
 因为如果小球已经滚到终点了，我们就不要让它再滚了，就不把终点位置压入栈，免得它还滚，参见代码如下：
 */
public class MazeII {
    class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 广度优先
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int m = maze.length, n = maze[0].length;
        if (m == 0 || n == 0) {
            return -1;
        }
        int[][] distance = new int[m][n];
        initDistance(distance);
        int[][] dir = {{0,1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<Point> queue = new ConcurrentLinkedQueue<>();
        queue.add(new Point(start[0], start[1]));
        distance[start[0]][start[1]] = 0;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int d = distance[p.x][p.y];
                int cx = p.x, cy = p.y;
                while (0 <= cx && cx < m && 0 <= cy && cy < n && maze[cx][cy] == 0) {
                    cx += dir[i][0];
                    cy += dir[i][1];
                    d++;
                }
                cx -= dir[i][0];
                cy -= dir[i][1];
                d--;
                if (distance[cx][cy] > d) {
                    distance[cx][cy] = d;
                    if (cx != dest[0] || cy != dest[1]) {
                        queue.add(new Point(cx, cy));
                    }
                }
            }
        }
        int res = distance[dest[0]][dest[1]];
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public void initDistance(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        System.out.println(new MazeII().shortestDistance(maze, new int[]{0,4}, new int[]{4,4}));
        System.out.println(new MazeII().shortestDistance(maze, new int[]{0,4}, new int[]{3,2}));
    }
}
