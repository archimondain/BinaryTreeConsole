import java.io.*;
import java.util.*;

/**
 * The class to handle a binary tree with an integer value in the nodes.
 */
public class Node{
	private int val;

	private Node leftChild;
	private Node rightChild;
	
  /**
   * The class to handle position informations to display the tree
   */
  private class DisplayInfos {
    int posx;
    int posy;
    //Whether the node is left or right child
    boolean left;
    //The size of the branch to display the node
    int nbbranche;
    //The node to display
    Node node;
    
    DisplayInfos(Node node, int posx, 
                 int posy, int nbbranche, boolean left) {
      this.node = node;
      this.posx = posx;
      this.posy = posy;
      this.nbbranche = nbbranche;
      this.left = left;
    }	
    
    //the horizontal size it takes to display the node.
    //if nbbranche > 0 the size is merely 1 for '/' or '\'
    int width() {
      if (nbbranche == 0)
        return node.width();
      else
        return 1;
    }
  }
  
  
  
	public Node(int val) {
		this.val = val;
		this.rightChild = null;
		this.leftChild = null;		
	}

	public Node(int val, Node lc, Node rc) {
		this.val = val;
		this.leftChild = lc;
		this.rightChild = rc;
	}

	private int width() {
		return (Integer.valueOf(val)).toString().length();
	}
	
	private int widthSubtree() {
		int nb = width();
		if (leftChild != null)
			nb += 1 + leftChild.widthSubtree();
		if (rightChild != null)
			nb += 1 + rightChild.widthSubtree();
		
		return nb;
	}	
	
	private int countLeftOffset() {
		int nb = 0;
		if (leftChild != null) {
			nb += 1 + leftChild.widthSubtree();
		}
		
		return nb;
	}
	
	private int countRightOffset() {
		int nb = 0;
		if (rightChild != null) {
			nb += 1 + rightChild.widthSubtree();
		}
		
		return nb;		
	}
		
  public int getVal() {
    return val;
  }    

  public Node getLeftChild() {
    return leftChild;
  }    

  public Node getRightChild() {
    return rightChild;
  }    
    
	public void display() {
		LinkedList<DisplayInfos> list = new LinkedList<DisplayInfos>();
		
		list.add(new DisplayInfos(this, this.countLeftOffset(), 0, 0, true));
		int cur_offset = 0;		
		int lastposy = 0;
		while (!list.isEmpty()) {
			DisplayInfos n = list.poll();
			if (n.posy != lastposy) {
				System.out.println("");
				cur_offset = 0;
				lastposy = n.posy;
			}
			if (n.left)
				n.posx = n.posx - (n.width()-1)/2;
			else
				n.posx = n.posx - n.width()/2;
			
			int tmp = cur_offset;
			for (int i = 0; i < n.posx - tmp; ++i) {
				System.out.print(" ");
				cur_offset++;
			}
			
			if (n.nbbranche == 0) {
				System.out.print(n.node.val);
				if (n.node.leftChild != null) {
					int nbbranche = n.node.leftChild.countRightOffset()+Math.max(n.node.leftChild.width()/2, 1);
					list.add(new DisplayInfos(n.node.leftChild, n.posx - 1, n.posy+1, nbbranche, true));
				}
				
				if (n.node.rightChild != null) {
					int nbbranche = n.node.rightChild.countLeftOffset()+Math.max(n.node.rightChild.width()/2, 1);
					list.add(new DisplayInfos(n.node.rightChild, n.posx + n.width(), n.posy+1, nbbranche, false));
				}
			} else {
				if (n.left) {
					System.out.print("/");
					list.add(new DisplayInfos(n.node, n.posx - 1, n.posy+1, n.nbbranche - 1, n.left));
				} else {
					System.out.print("\\");
					list.add(new DisplayInfos(n.node, n.posx + 1, n.posy+1, n.nbbranche - 1, n.left));
				}				
			}
			cur_offset += n.width();
		}
		System.out.println("");
	}
}
