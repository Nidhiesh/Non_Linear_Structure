package bst;
import java.util.*;
public class BinarySearchTree {
	
	class Node
	   {
	        int data;
	        Node left;
	        Node right;
	        public Node(int d){
	            data = d;
	            left = null;
	            right = null;
	        }
	   }
	   Node root = null;
	   
	    public void insert(int data){
	        Node nn = new Node(data);
	        
	        if(root == null){
	            root = nn;
	            return;
	        }
	        else{
	            Node currentNode = root,parentNode = null;
	            while(true){
	                parentNode = currentNode;
	                if(data < currentNode.data){
	                    currentNode = currentNode.left;
	                    if(currentNode == null){
	                        parentNode.left = nn;
	                        return;
	                    }
	                }
	                else{
	                    currentNode = currentNode.right;
	                    if(currentNode == null){
	                        parentNode.right = nn;
	                        return;
	                    }
	                }
	            }
	        }
	    }
	    public Node delete(Node node, int value) {
	    if (node == null)
	        return null;

	    if (value < node.data)
	        node.left = delete(node.left, value);
	    else if (value > node.data)
	        node.right = delete(node.right, value);
	    else {
	        if (node.left == null && node.right == null)
	            return null;
	        else if (node.left == null)
	            return node.right;
	        else if (node.right == null)
	            return node.left;
	        else {
	            Node temp = minNode(node.right);
	            node.data = temp.data;
	            node.right = delete(node.right, temp.data);
	        }
	    }
	    return node;
	}

	Node minNode(Node node) {
	    while (node.left != null)
	        node = node.left;
	    return node;
	}


	    void display(Node r) {
	    if (r == null)
	        return;
	    display(r.left);
	    System.out.print(r.data + " ");
	    display(r.right);
	    
	}

	

	 public void inOrderTraversal(Node node) {
	        if (root == null) {
	            System.out.println("Tree is Empty!");
	            return;
	        } else {
	            if (node.left != null) {
	                inOrderTraversal(node.left);
	            }
	            System.out.print(node.data + " ");
	            if (node.right != null) {
	                inOrderTraversal(node.right);
	            }
	        }
	    }
	 
	 public void preOrderTraversal(Node node) {
	        if (root == null) {
	            System.out.println("Tree is Empty!");
	            return;
	        } else {
	            System.out.print(node.data + " ");
	            if (node.left != null) {
	                preOrderTraversal(node.left);
	            }
	            if (node.right != null) {
	                preOrderTraversal(node.right);
	            }
	        }
	    }
	 
	 public void postOrderTraversal(Node node) {
	        if (root == null) {
	            System.out.println("Tree is Empty!");
	            return;
	        } else {
	            if (node.left != null) {
	                postOrderTraversal(node.left);
	            }
	            if (node.right != null) {
	                postOrderTraversal(node.right);
	            }
	            System.out.print(node.data + " ");
	        }
	    }

	    
	    public static void main(String [] args){
	        BinarySearchTree n = new BinarySearchTree ();
	        boolean flag = true;
	        int a;
	        try(Scanner sc = new Scanner(System.in)){
	        while (flag) {
	            System.out.println("****************************************");
	            System.out.println("1. Insert\n2. Delete\n3. Inorder\n4. Preorder\n5. Postorder\n6. Exit\n");
	            System.out.println("Enter your choice : ");
	            int choice = sc.nextInt();
	            switch(choice) {
	            
	            case 1:
	            	
	            	System.out.print("Enter the value to insert : ");
	            	a = sc.nextInt();
	            	n.insert(a);
	            	System.out.println(a+" is inserted..");
	            	break;
	            	
	            case 2:
	            	
	            	System.out.print("Enter the value to delete : ");
	            	a = sc.nextInt();
	            	n.delete(n.root,a);
	            	System.out.println(a+" is deleted..");
	            	break;
	            	
	            case 3:
	            	
	            	n.preOrderTraversal(n.root);
	            	System.out.println("Tree is traversed preorderly..");
	            	break;
	            	
	            case 4:
	            	
	            	n.inOrderTraversal(n.root);
	            	System.out.println("Tree is traversed inorderly..");
	            	break;
	            	
	            case 5:
	            	
	            	n.postOrderTraversal(n.root);
	            	System.out.println("Tree is traversed postorderly..");
	            	break;
	            	
	            case 6:
	            	
	            	System.out.println("Program is exiting..");
	            	break;
	            	
	            default:
	            	
	            	System.out.println("Invalid choice..");
	            	break;
	            }
	            }
	        }
	    }
	   
	}