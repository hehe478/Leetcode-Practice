package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p){
        List<Integer> result = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        if(sLen < pLen) return result;

        int[] pFreq = new int[26];
        int[] winFreq = new int[26];

        for(int i = 0; i < pLen; i++){
            pFreq[p.charAt(i) - 'a']++;
            winFreq[s.charAt(i) - 'a']++;
        }
        if(Arrays.equals(pFreq,winFreq)){
            result.add(0);
        }

        for(int i = pLen; i < sLen; i++){
            winFreq[s.charAt(i) - 'a']++;
            winFreq[s.charAt(i - pLen) - 'a']--;
            if(Arrays.equals(pFreq,winFreq)){
                result.add(i - pLen + 1);
            }
        }
        
        return result;
    }
}
