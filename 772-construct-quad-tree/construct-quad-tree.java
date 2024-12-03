/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int target = row * col;

        return getQuadTree(0, 0, row-1, col-1, grid);
    }

    public Node getQuadTree(int x, int y, int row, int col, int[][] grid) {
        if (x>=row || y>=col) {
            Node n = new Node(grid[x][y] == 1, true);
            return n;
        }

        if (sameValue(x, y, row, col, grid)) {
            Node n = new Node(grid[x][y] == 1, true);
            return n;
        } else {
            int midX = (row+x)/2;
            int midY = (col+y)/2;

            Node n = new Node(grid[x][y] == 1, false);
            n.topLeft = getQuadTree(x, y, midX, midY, grid);
            n.topRight = getQuadTree(x, midY+1, midX, col,grid);
            n.bottomLeft = getQuadTree(midX+1, y, row, midY, grid);
            n.bottomRight = getQuadTree(midX+1, midY+1, row, col, grid);

            return n;
        }
    }

    public boolean sameValue(int x, int y, int row, int col, int[][] grid) {
        for (int i=x; i<=row; i++) {
            for (int j=y; j<=col; j++) {
                if (grid[i][j] != grid[x][y]) {
                    return false;
                }
            }
        }

        return true;
    }

    public void display(int[][] prefixArray, int row, int col) {
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                System.out.print(prefixArray[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

        return;
    }
}