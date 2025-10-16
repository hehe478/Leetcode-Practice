package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge {
    public int[][] merge(int[][] intervals){
        if(intervals.length <= 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int[] currentInterval = intervals[i];
            int[] lastInterval = result.get(result.size() - 1);
            if(currentInterval[0] <= lastInterval[1]){
                lastInterval[1] = Math.max(lastInterval[1], currentInterval[1]);
            }else{
                result.add(currentInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
