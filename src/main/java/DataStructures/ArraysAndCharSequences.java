package DataStructures;

public class ArraysAndCharSequences {
    public static boolean uniqueCharacters(String str){
        if(str.length() > 256){
            return false;
        }
        boolean[] temp = new boolean[256];
        for(int i = 0; i <str.length() ; i++){
            if(temp[str.charAt(i)]){
                return false;
            }
            temp[str.charAt(i)] = true;
        }

        return true;
    }
}
