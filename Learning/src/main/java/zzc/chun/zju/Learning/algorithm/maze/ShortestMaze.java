package zzc.chun.zju.Learning.algorithm.maze;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Captain on 2017/10/25.
 * 给定一个大小为N*M的迷宫，由通道('.')和墙壁('#')组成，其中通道S表示起点，通道G表示终点，每一步移动可以达到上下左右中不是墙壁的位置。
 * 试求出起点到终点的最小步数。（本题假定迷宫是有解的）(N,M<=100)
 样例输入：
 10 10

 样例输出：
 22
 这道题目以及解法均来自《挑战程序设计竞赛（第2版）》第34页-36页；
 个人觉得这个例题很好地表现了广度优先搜索是如何与队列先进先出（FIFO）的思想联系起来的，通过不断取得某个状态后能够达到的所有状态并将其加入
 队列， 并且由于队列本身的特性先加入队列的状态总是先得到处理，这样就达到了一个目的：总是先将需要转移次数更少的状态进行分析处理，换句话说就
 是总是取得了这个状态的树中更接近根部的节点，又或者是总是让搜索树的广度得到尽可能增加。

 在这个问题中，找到从起点到终点的最短路径其实就是一个建立队列的过程：
 1.从起点开始，先将其加入队列，设置距离为0；
 2.从队列首端取出位置，将从这个位置能够到达的位置加入队列，并且让这些位置的距离为上一个位置的距离加上1；
 3.循环2直到将终点添加到队列中，这说明我们已经找到了路径；
 注意到在这个过程中，每次处理的位置所对应的距离是严格递增的，因此一旦找到终点，当时的距离就是最短距离；
 同样基于这个原因，搜索可移动到的位置所使用的判断条件中不仅仅是不碰墙壁、不超过边界，还有一个就是没有到达过，因为如果已经到达了这个位置，
 这说明已经有更短的路径到达这个位置，这次到达这个位置的路径是更差的，不可能得到更好的最终解。

 样例：
 #   S   #   #   #   #   #   #   o   #
 o   o   o   o   o   o   #   o   o   #
 o   #   o   #   #   o   #   #   o   #
 o   #   o   o   o   o   o   o   o   o
 #   #   o   #   #   o   #   #   #   #
 o   o   o   o   #   o   o   o   o   #
 #   #   #   #   #   #   #   #   o   #
 o   o   o   #   o   o   o   o   o   o
 o   #   #   #   #   o   #   #   #   o
 o   o   o   o   #   o   o   o   G   #

 输出：
 shortest length is : 22

 100000  0       100000  100000  100000  100000  100000  100000  13      100000
 2       1       2       3       4       5       100000  13      12      100000
 3       100000  3       100000  100000  6       100000  100000  11      100000
 4       100000  4       5       6       7       8       9       10      11
 100000  100000  5       100000  100000  8       100000  100000  100000  100000
 8       7       6       7       100000  9       10      11      12      100000
 100000  100000  100000  100000  100000  100000  100000  100000  13      100000
 100000  100000  100000  100000  18      17      16      15      14      15
 100000  100000  100000  100000  100000  18      100000  100000  100000  16
 100000  100000  100000  100000  100000  19      20      21      22      100000

 */
public class ShortestMaze {
    private static final int INF = 10000;
    private static final int N = 10;
    private static final int M = 10;
    private static char[][] mazeMatrix = {
            {'#', 'S', '#', '#', '#', '#', '#', '#', 'o', '#'},
            {'o', 'o', 'o', 'o', 'o', 'o', '#', 'o', 'o', '#'},
            {'o', '#', 'o', '#', '#', 'o', '#', '#', 'o', '#'},
            {'o', '#', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o'},
            {'#', '#', 'o', '#', '#', 'o', '#', '#', '#', '#'},
            {'o', 'o', 'o', 'o', '#', 'o', 'o', 'o', 'o', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', 'o', '#'},
            {'o', 'o', 'o', '#', 'o', 'o', 'o', 'o', 'o', 'o'},
            {'o', '#', '#', '#', '#', 'o', '#', '#', '#', 'o'},
            {'o', 'o', 'o', 'o', '#', 'o', 'o', 'o', 'G', '#'}
    };

    private static int xs = 0;
    private static int ys = 1;
    private static int gx = 9;
    private static int gy = 8;
    private static int[][] distance = new int[N][M];

    private static int[] xd = {1, 0, -1, 0};
    private static int[] yd = {0, 1, 0, -1};

    private int bfs() {
        initDistance();
        Queue<Point> queue = new ConcurrentLinkedQueue<>();
        queue.add(new Point(xs, ys));
        distance[xs][ys] = 0;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.getX() == gx && p.getY() == gy) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                int px = p.getX() + xd[i];
                int py = p.getY() + yd[i];
                if (0 <= px && px <N && 0 <= py && py < M
                        && mazeMatrix[px][py] != '#' && distance[px][py] == INF) {
                    queue.add(new Point(px, py));
                    distance[px][py] = distance[p.getX()][p.getY()] + 1;
                }
            }
        }
        return distance[gx][gy];
    }

    private void initDistance() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                distance[i][j] = INF;
            }
        }
    }
    private static void printDistance() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.printf("\t" + distance[i][j]);
            }
            System.out.println();
        }
    }
    class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
        public void setX(int x) {
            this.x = x;
        }
        public void setY(int y) {
            this.y = y;
        }
    }
    public static void main(String[] args) {
        ShortestMaze maze = new ShortestMaze();
        int dis = maze.bfs();
        System.out.println("Shortest length is :" + dis);
        printDistance();
    }
}
