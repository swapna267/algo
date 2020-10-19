package Medium.Medium;

public class DeepCopy {

  public static void main(String[] args) {
    Node head = new Node(1);
    Node tmp = head;

    //create cloned node

    while (tmp != null) {
      Node newNode = new Node(tmp.val);
      newNode.next = tmp.next;
      tmp.next = newNode;
      tmp = tmp.next;
    }

    // update random
    tmp = head;
    while (tmp != null) {
      Node clonedNode = tmp.next;
      if (tmp.random != null) {
        clonedNode.random = tmp.random.next;
      }
      tmp = tmp.next.next;
    }

    // only get the cloned one's
    Node clonedHead = head.next;
    tmp = clonedHead;
    while(tmp.next != null) {
      tmp.next = tmp.next.next;
      tmp = tmp.next.next;
    }

  }

  static class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }
}
