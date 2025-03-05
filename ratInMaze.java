
import java.util.ArrayList;
import java.util.List;

public class ratInMaze {
    //given an n*n grid where some cells are blocked(0)
    //other are not blocked(1)
    //rat starts at top-left(0,0) to reach (n-1,n-1)bottom-right
    //can move d r l u, but not on 0
    //find all possible paths

    //approach:
    //start at (0,0) mark it visited
    //try moving in all 4  dir(d, l, r, u)
    //if dest reached, add curr path to res
    //if moving leads to invalid, backtrack
    //using boolean array to keep track of visited cells.
    private static void fP(int[][] maze, int x, int y, int n, boolean[][] visited, String path, List<String> paths){
        if(x == n-1 && y == n-1){
            paths.add(path);
            return;
        }

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        char[] move = {'D', 'R', 'U', 'L'};
        for(int i = 0;i<4;i++){
            int newX = x+dx[i];
            int newY = y+dy[i];

            if(isSafe(newX, newY, n, maze, visited)){
                visited[newX][newY] = true;
                fP(maze, newX, newY, n, visited, path+move[i], paths);
                visited[newX][newY] = false;
            }
        }

    }

    private static boolean isSafe(int x, int y, int n, int[][] maze, boolean[][] visited){
        return x>=0 && y>=0 && x<n && y<n && maze[x][y] == 1 && !visited[x][y];
    }

    public static List<String> FPIM(int[][] maze){
        List<String> paths = new ArrayList<>();
        int n = maze.length;
        if(maze[0][0] == 0 || maze[n-1][n-1] == 0){
            return paths;
        }
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        fP(maze, 0, 0, n, visited, "", paths);
        return paths;
    }
    public static void main(String[] args) {
        int n = 4;
        int[][] maze = {{1,0,0,0},{1,1,0,1},{0,1,0,1},{1,1,1,1}};
        List<String> res = FPIM(maze);
        System.out.println("All possible paths are:"+ res);
    }
}
