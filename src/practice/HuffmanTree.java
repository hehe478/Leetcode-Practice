package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree {
    private static class Node implements Comparable<Node>{
        Character ch;
        int freq;
        Node left;
        Node right;

        public Node(Character ch,int freq){
            this(ch,freq,null,null);
        }

        public Node(Character ch,int freq,Node left,Node right){
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        public boolean isLeaf(){
            return left == null && right == null;
        }

        @Override
        public int compareTo(Node other){
            return this.freq - other.freq;
        }
    }

    private Node buildTree(String text){
        Map<Character,Integer> freqMap = new HashMap<>();
        for(char c : text.toCharArray()){
            freqMap.put(c,freqMap.getOrDefault(c,0) + 1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(Map.Entry<Character,Integer> entry : freqMap.entrySet()){
            pq.add(new Node(entry.getKey(),entry.getValue()));
        }

        while(pq.size() > 1){
            Node left = pq.poll();
            Node right = pq.poll();

            Node parent = new Node(null, left.freq + right.freq,left,right);
            pq.add(parent);
        }
        return pq.poll();
    }
    private void generateCodes(Node node, String code, Map<Character, String> huffmanCodes){
        if(node == null) return;
        if(node.isLeaf()) huffmanCodes.put(node.ch, code);

        generateCodes(node.left, code + "0", huffmanCodes);
        generateCodes(node.right, code + "1", huffmanCodes);
    }

    // 对外接口：输入字符串，输出压缩后的编码表
    public void encode(String text) {
        System.out.println("Original Text: " + text);

        // 1. 建树
        Node root = buildTree(text);

        // 2. 生成编码
        Map<Character, String> huffmanCodes = new HashMap<>();
        generateCodes(root, "", huffmanCodes);

        // 3. 打印结果
        System.out.println("Huffman Codes:");
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            System.out.println("'" + entry.getKey() + "' : " + entry.getValue());
        }

        // 4. 打印编码后的字符串
        System.out.print("Encoded String: ");
        for(char c : text.toCharArray()){
            System.out.print(huffmanCodes.get(c));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        HuffmanTree huffman = new HuffmanTree();

        // 测试文本：频率不同 (a出现最多，应该编码最短)
        String text = "aaabbcdddd";
        // 预期：d 最多，a 次之，b和c最少
        // d 的编码应该最短（可能是1位），b和c最长

        huffman.encode(text);
    }
}
