package BinarySearchTrees;

public class BST<Key extends Comparable<Key>, Value> {
    private Node<Key, Value> root;

    private static class Node<Key, Value> {
        Key key;
        Value value;
        Node<Key, Value> left, right;

        Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }
    public key min(){

    }
    public key  max(){
        
    }
    public key floor(key k){

    }
    public key ceil(key k){

    }
    public int rank(key k){
        return rank(root, k);
    }
    // ✅ Get method
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node<Key, Value> x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x.value;
        } else if (cmp < 0) {
            return get(x.left, key);
        } else {
            return get(x.right, key);
        }
    }

    // ✅ Public put() — used by user
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    // ✅ Private recursive put() — handles insertion
    private Node<Key, Value> put(Node<Key, Value> x, Key key, Value value) {
        if (x == null) {
            return new Node<>(key, value);
        }

        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            x.value = value;
        } else if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else {
            x.right = put(x.right, key, value);
        }

        return x;
    }
}


public static void main(String[] args) {
    BST<Integer, String> bst = new BST<>();
    bst.put(5, "Five");
    bst.put(1, "One");
    bst.put(3, "Three");
    bst.put(4, "Four");
    bst.put(7, "Seven");
    bst.put(6, "Six");
    assert bst.get(5).equals("Five") : "Test case 1 failed";
    assert bst.get(1).equals("One") : "Test case 2 failed";
    assert bst.get(3).equals("Three") : "Test case 3 failed";
    assert bst.get(4).equals("Four") : "Test case 4 failed";
    assert bst.get(7).equals("Seven") : "Test case 5 failed";
    assert bst.get(6).equals("Six") : "Test case 6 failed";
    assert bst.get(10) == null : "Test case 7 failed";
    System.out.println("All test cases passed!");   
}
