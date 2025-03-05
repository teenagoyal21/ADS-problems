import java.util.ArrayList;
import java.util.List;

public class wordSearch212LC {
    public static List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for(String word: words){
            if(exist(board, word)){
                res.add(word);
            }
        }
        return res;
    }

    public static boolean exist(char[][] brd, String word){
        int r = brd.length, c=brd[0].length;
        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                if(brd[i][j] == word.charAt(0)  && dfs(brd, i, j, word, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(char brd[][], int i, int j, String wrd, int idx){
        if(idx == wrd.length()){
            return true;
        }
        if(i<0 || j<0 || i>=brd.length || j>=brd[0].length || brd[i][j] != wrd.charAt(idx)){
            return false;
        }
        char temp = brd[i][j];
        brd[i][j] = '#'; //already visited

        boolean fou = dfs(brd, i+1, j, wrd, idx+1) ||
        dfs(brd, i-1, j, wrd, idx+1) ||
        dfs(brd, i, j+1, wrd, idx+1) ||
        dfs(brd, i, j-1, wrd, idx+1); 

        brd[i][j] = temp;
        return fou;
    }

    public static void main(String[] args) {
        char[][] brd = {{'a','b'},{'c','d'}};
        String[] words = {"abd ", "abcb", "absde"};
        System.out.println(findWords(brd, words));
    }
}
