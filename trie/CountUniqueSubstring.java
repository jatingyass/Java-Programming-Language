public class CountUniqueSubstring{
    static class Node {
    Node children[] = new Node[26];
    boolean eow = false;

    Node() {
        for (int i = 0; i <26; i++) {
            children[i] = null;
        }
    }
        
    }

   public static Node root = new Node();   

   public static void insert(String word){
    Node curr = root;
    for(int level=0; level<word.length(); level++){
        int idx = word.charAt(level) - 'a';
        if(curr.children[idx] == null){
            curr.children[idx] = new Node();
        }
        curr = curr.children[idx];
    }
    curr.eow = true;
   }

   public static boolean search(String key){//O(L)
    Node curr = root;
    for(int level=0; level<key.length(); level++){
        int idx = key.charAt(level) - 'a';
        if(curr.children[idx] == null){
            return false;
        }
        curr = curr.children[idx];
    }
    return curr.eow == true;
   }

   //------count nodes ------
   public static int countNodes(Node root){
    if(root == null){
        return 0;
    }
    int count = 0;
    for(int i=0; i<26; i++){
       if(root.children[i] != null){
        count += countNodes(root.children[i]);
       }
    }
     return count+1;
   }
    public static void main(String[] args) {
       String str = "apple";

       //suffix -> insert in trie
       for (int i=0; i<str.length(); i++) {
          String suffix = str.substring(i);
          insert(suffix);
       }

       System.out.println(countNodes(root));
    }
}