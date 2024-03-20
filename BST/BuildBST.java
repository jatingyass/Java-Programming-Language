import java.util.*;
public class BuildBST{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){
            //left subtree
            root.left = insert(root.left, val);
        }else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

//----------Search node in BST---------------
    public static boolean search(Node root, int key){ //O(H)
        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        }

        if(root.data > key){
            return search(root.left, key);
        }

        else{
            return search(root.right, key);
        }
    }

    //----------Delete node in BST-------------

    public static Node delete(Node root, int val){
        if(root.data < val){
            root.right = delete(root.right, val);
        }
        else if(root.data > val){
            root.left = delete(root.left, val);
        }
        else{//voila means jhn hume wo value mil gyi h jise hume delete krna h
            
            //case 1 - leaf node
            if(root.left == null && root.right == null){
                return null;
            }

            //case 2 - single child
            if(root.left == null) {
                return root.right;
            }
            else if(root.right == null) {
                return root.left;
            }

            //case 3 - both children
          Node IS = findInorderSuccessor(root.right);
          root.data = IS.data;
          root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node findInorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    } 

    //----------print in range like 5-12 ke bich ke no.s-----
    public static void printInRange(Node root, int k1, int k2){
        if(root == null){
            return;
        }
        if(root.data >= k1 && root.data <=k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        }
        else if(root.data < k1){
            printInRange(root.left, k1, k2);
        }
        else {
            printInRange(root.right, k1, k2);
        }
    }

    //--------print root to leaf -------
    public static void printPath(ArrayList<Integer> path){
        for (int i = 0; i < path.size(); i++) {
           System.out.print(path.get(i)+"->");            
        }
        System.out.println("Null");
    }

    public static void printRoot2Leaf(Node root, ArrayList<Integer> path){
          if(root == null){
            return;
          }

          path.add(root.data);
          if(root.left == null && root.right == null){
           printPath(path);
          }

          printRoot2Leaf(root.left, path);
          printRoot2Leaf(root.right, path);
          path.remove(path.size()-1);
    }

   //------Check BST is vaild or not------
   public static boolean isVaildBST(Node root, Node min, Node max){
    if(root == null){
        return true;
    }

    if(min != null && root.data <= min.data){
        return false;
    }
    else if(max != null && root.data >= max.data){
        return false;
    }

    return isVaildBST(root.left, min, root) && isVaildBST(root.right, root, max);
   } 

    public static void main(String args[]){
        int values[] = {10, 5, 3, 7, 15, 18};
        Node root = null;

        for(int i=0; i<values.length; i++){
            root = insert(root, values[i]);
        }
        inorder(root);
        System.out.println();

    //-------Search node in bst------------
        // if(search(root, 11)){
        //     System.out.println("found");
        // }
        // else{
        //     System.out.println("no found");
        // }

//---------Delete node in bst-------
    //    root = delete(root, 5);
    //    System.out.println();
       
    //    inorder(root);

//-------print in range call-------
    printInRange(root, 5, 12);

 //-----print root 2 path call------
    // printRoot2Leaf(root, new ArrayList<>());

//------check BST is vaild or not calls------
//    if(isVaildBST(root, null, null)){
//     System.out.println("vaild");
//    }
//    else{
//     System.out.println("not vaild");
//    }

    }
}