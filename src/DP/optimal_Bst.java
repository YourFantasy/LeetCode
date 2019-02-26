package DP;

import org.junit.Test;


public class optimal_Bst {
    @Test
    public void Test() {
        double[] p = {0, 0.15, 0.1, 0.05, 0.1, 0.2};  //n=5关键字有5个
        double[] q = {0.05, 0.1, 0.05, 0.05, 0.05, 0.1};  //叶子结点有n+1 = 6个
        ///这里的关键字长度为5
        int n = p.length;

        System.out.println("输出根节点辅助表");
        int[][] root = Optimal_BST(p, q, n - 1);
        int temp = root.length - 1;
        for (int i = 1; i < temp; i++) {
            for (int j = 1; j < temp; j++) {
                System.out.print(root[i][j] + "-");
            }
            System.out.println();
        }

        printOptimalBST(root, 1, 5, root[1][5]);
    }

    /**
     * DP在计算最优二叉树的辅助表的算法实现
     *
     * @param p
     * @param q
     * @param n
     * @return
     */
    private static int[][] Optimal_BST(double[] p, double[] q, int n) {
        double[][] e = new double[n + 2][n + 2];//
        double[][] w = new double[n + 2][n + 2];
        int[][] root = new int[n + 2][n + 2];

        //初始化叶子结点的值
        for (int i = 1; i <= n + 1; i++) {
            e[i][i - 1] = q[i - 1];
            w[i][i - 1] = q[i - 1];
        }
        for (int l = 1; l <= n; l++) {///最外层循环是逐渐的将关键字个数从一个扩展到n个,类似于矩阵链乘法
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                e[i][j] = Double.MAX_VALUE;
                w[i][j] = w[i][j - 1] + p[j] + q[j];
                for (int r = i; r <= j; r++) {
                    double t = e[i][r - 1] + e[r + 1][j] + w[i][j];
                    if (t < e[i][j]) {
                        e[i][j] = t;
                        root[i][j] = r;///存储根节点的位置
                    }
                }
            }

        }

        System.out.println("输出当前的最小代价：" + e[1][n]);
        return root;

    }

    /**
     * 构建最优二叉搜索树
     *
     * @param root
     * @param i
     * @param j
     * @param r
     */
    private static void printOptimalBST(int[][] root, int i, int j, int r) {
        int rootChild = root[i][j];
        if (rootChild == r) {
            System.out.println("K" + rootChild + "是根");
            printOptimalBST(root, i, rootChild - 1, rootChild);
            printOptimalBST(root, rootChild + 1, j, rootChild);
            return;
        }
        if (j < i - 1) {
            return;
        } else if (j == i - 1)//遇到虚拟键
        {
            if (j < r) {
                System.out.println("d" + j + "是" + "k" + r + "的左孩子");
            } else {//j>=r
                System.out.println("d" + j + "是" + "k" + r + "的右孩子");
            }
            return;
        } else//遇到内部结点
        {
            if (rootChild < r) {
                System.out.println("k" + rootChild + "是" + "k" + r + "的左孩子");
            } else {
                System.out.println("k" + rootChild + "是" + "k" + r + "的右孩子");
            }

        }

        printOptimalBST(root, i, rootChild - 1, rootChild);
        printOptimalBST(root, rootChild + 1, j, rootChild);

    }


}

