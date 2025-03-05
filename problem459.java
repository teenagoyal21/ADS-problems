public class problem459 {
    //string x = "abab";
    // return true or false if we can get same string after concating a substring of given one
    public static boolean repeat(String s){
        String doubled = s + s;
        return doubled.substring(1, doubled.length()-1).contains(s);
    }
    public static void main(String args[]){
        System.out.print(repeat("abab"));
    }
}
