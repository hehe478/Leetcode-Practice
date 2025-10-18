package basic;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int arrows = 1;
        int arrow_pos = points[0][1];
        for(int i = 1; i < points.length; i++){
            if(points[i][0] > arrow_pos){
                arrows++;
                arrow_pos = points[i][1];
            }
        }
        return arrows;
    }
}
