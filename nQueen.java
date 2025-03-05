
import java.util.*;

public class nQueen {
    public static List<List<String>> sNQ(int n){
        List<List<String>> res = new ArrayList<>();

        char[][] brd = new char[n][n];

        for(char[] r: brd){
            Arrays.fill(r, '.');
        }

        solve(brd, 0, res);
        return res;
    } 

    private static void solve(char[][] brd, int r, List<List<String>> res){
        if(r == brd.length){
            res.add(constructBoard(brd));
            return;
        }

        for(int col = 0;col<brd.length;col++){
            if(isSafe(brd, r, col)){
                brd[r][col] = 'Q';
                solve(brd, r+1, res);
                brd[r][col] = '.';
            }
        }
    }

    private static boolean isSafe(char[][] brd, int r, int col){
        int n = brd.length;
        for(int i = 0;i<r;i++){
            if(brd[i][col] == 'Q'){
                return false;
            }
        }

        //upper-left
        for(int i = r, j = col;i>=0 && j >= 0 ; i--, j--){
            if(brd[i][j] == 'Q'){
                return false;
            }
        }

        for(int i = r, j = col; i>=0 && j < n; i--, j++){
            if(brd[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    private static List<String> constructBoard(char[][] brd){
        List<String> res = new ArrayList<>();
        for(char[] r: brd){
            res.add(new String(r));
        }
        return res;
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(sNQ(n));
    }
}
