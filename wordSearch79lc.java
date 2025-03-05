public class wordSearch79lc {
    //recursion and backtracking are powerful teach used to solve
    //complex problems on matrice and grids

    //given m*n grid of characters and string word, return true if word exists in grid
    //the word can be constructed from letters in adj cells 
    //same letter cell cannot be used more than once

    //approach:
    //dfs with backtracking
    //start from each cell, try to match first letter of word.
    //explore in all possible directions
    //if the characetrs of word matches return true
    //if path is incorrect backtrck and mark all the cells as unvisited

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
        char[][] brd= {
            {'a', 'b', 'c', 'e'},
            {'s', 'f', 'c', 's'},
            {'a', 'd', 'e', 'e'}
        };

        String word = "abcced";
        System.out.println(exist(brd, word));
    }
}
