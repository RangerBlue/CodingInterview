package recursionanddynamicprogramming;

import util.recursionanddynamicprogramic.Point;

import java.util.ArrayList;

public class RecursionAndDynamicProgramming {
    //9.1
    public static int countWays(int n){
        if(n<0 ){
            return 0;
        }else if(n==0){
            return 1;
        }
        return countWays(n-1) + countWays( n-2) +countWays(n-3);
    }

    public static int countWaysDP(int n, int[] map){
        if(n<0 ){
            return 0;
        }else if(n==0){
            return 1;
        } else if(map[n]>-1){
          map[n] =   countWaysDP(n-1, map) + countWaysDP( n-2, map) +countWaysDP(n-3, map);
        }
        return map[n];
    }

    public static boolean getPath(int x, int y, ArrayList<Point> path){
        Point p = new Point(x, y);
        path.add(p);
        if(x == 0 && y==0){
            return true;
        }

        boolean success = false;
        if(x>=1){
            success = getPath(x-1, y, path);
        }
        if(!success && y>=1){
            success = getPath(x, y-1, path);
        }
        if(success){
            path.add(p);
        }
        return success;
    }
}
