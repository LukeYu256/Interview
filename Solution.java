package project.inteee;

import java.util.ArrayList;
import java.util.List;



public class Solution{
    public static void main(String[] arg){
//        int[] input = {23,36,98,333,24,12,15,16,39,45};
        int[] input = {23,36,98,333,24,12,15,16,39,45,45};
        BinarySearchTree bst = new BinarySearchTree(input);
//        List<Integer> idxRes = bst.search(24);
//        List<Integer> idxRes = bst.search(45);
        List<Integer> idxRes = bst.search(1);
        if(idxRes == null || idxRes.size() == 0){
            System.out.println(-1);
        }
        else {
            for (int i : idxRes) {
                System.out.println(i);
            }
        }
    }
}



class BinarySearchTree {
    Node root;
    public BinarySearchTree(int[] arr){
        if(arr == null || arr.length == 0){
            root = null;
        }
        else {
            root = new Node(arr[0], 0);
            for(int i = 1; i < arr.length; i++){
                arrToBST(arr, i, root);
            }
        }
    }


    private void arrToBST(int[] arr, int i, Node subroot){
        if(subroot.key == arr[i]){
            subroot.val.add(i);
            return;
        }
        if(subroot.key > arr[i]){
            if(subroot.left == null){
                subroot.left = new Node(arr[i], i);
                return;
            }
            arrToBST(arr, i, subroot.left);
        }
        else{
            if(subroot.right == null){
                subroot.right = new Node(arr[i], i);
                return;
            }
            arrToBST(arr, i, subroot.right);
        }
    }



    public List<Integer> search(int key){
        return search(key, root);
    }



    private List<Integer> search(int key, Node subroot){
        if(subroot == null){
            return null;
        }
        if(key == subroot.key){
            return subroot.val;
        }
        if(key > subroot.key){
            return search(key, subroot.right);
        }
        return search(key, subroot.left);
    }
}

class Node{
    int key;
    List<Integer> val = new ArrayList<>();
    Node left;
    Node right;

    public Node() {}

    public Node(int key, int idx){
        this.key = key;
        this.val.add(idx);
    }
}
