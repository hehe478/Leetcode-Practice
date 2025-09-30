package basic;

public class MinWindow {
    public String minWindow(String s, String t) {
        // 边界条件判断
        if (s.length() < t.length()) {
            return "";
        }

        // 使用大小为 128 的数组来覆盖所有 ASCII 字符
        // needs 数组记录 t 中所需字符的频率
        // window 数组记录当前窗口中字符的频率
        int[] needs = new int[128];
        int[] window = new int[128];

        // required 记录 t 中不重复字符的总数
        int required = 0;
        for (char c : t.toCharArray()) {
            // 如果某个字符是第一次被统计，说明遇到了一个新的不重复字符
            if (needs[c] == 0) {
                required++;
            }
            needs[c]++;
        }

        int left = 0, right = 0;
        // valid 记录窗口中已满足 needs 条件的字符种类数
        int valid = 0;

        // 用于记录最小覆盖子串的起始索引和长度
        int start = 0;
        int minLen = Integer.MAX_VALUE;

        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;

            // --- 扩张阶段 ---
            // 只有当 c 是 t 中需要的字符时，才进行处理
            if (needs[c] > 0) {
                window[c]++;
                // 如果窗口中 c 的数量正好等于 t 中需要的数量
                // 说明 c 这个字符种类已经满足要求，valid 计数加 1
                if (window[c] == needs[c]) {
                    valid++;
                }
            }

            // --- 收缩阶段 ---
            // 当 valid == required 时，说明当前窗口已满足所有条件，开始收缩
            while (valid == required) {
                // 如果当前窗口长度小于已记录的最小长度，则更新记录
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }

                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;

                // 只有当 d 是 t 中需要的字符时，才进行处理
                if (needs[d] > 0) {
                    // 如果窗口中 d 的数量正好等于 t 中需要的数量
                    // 说明在移出 d 之后，d 这个字符种类将不再满足要求，valid 计数减 1
                    if (window[d] == needs[d]) {
                        valid--;
                    }
                    window[d]--;
                }
            }
        }

        // 如果 minLen 从未被更新过，说明没有找到符合条件的子串
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
