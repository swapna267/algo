package Design;

import java.util.HashMap;
import java.util.Map;

public class OOneMap {
  //Map - Intger -> Integer,
  //LinkedList<>
  Map<Integer, ListNode> hashMap = new HashMap<>();
  DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

  public OOneMap() {

  }

  public void inc(int key) {
    ListNode valNode = hashMap.get(key);
    if (valNode == null) {
      valNode = new ListNode(key, 1);
      doubleLinkedList.addToHead(valNode);
      return;
    }

    valNode.val += 1;
    ListNode pos = valNode;
    while(valNode.next!= null && valNode.next.val < valNode.val) {
      pos = valNode.next;
    }

    if (pos != valNode) {
      doubleLinkedList.remove(valNode);
      doubleLinkedList.insertAt(pos, valNode);
    }
  }

  public void decr(int key) {
    ListNode valNode = hashMap.get(key);
    //throw error if null

    valNode.val -= 1;
    ListNode pos = valNode;
    while(valNode.prev!= null && valNode.prev.val > valNode.val) {
      pos = valNode.prev;
    }

    if (pos != valNode) {
      doubleLinkedList.remove(valNode);
      doubleLinkedList.insertAt(pos, valNode);
    }
  }

  public int getMaxKey() {
      return doubleLinkedList.tailNode.key;
  }

  public int getMinKey() {
    return doubleLinkedList.headNode.key;
  }

  class DoubleLinkedList {
    ListNode headNode;
    ListNode tailNode;

    public ListNode addToHead(ListNode n) {
      if (headNode == null) {
        headNode = n;
        tailNode = n;
      } else {
        n.next = headNode;
        headNode = n;
      }
      return headNode;
    }

    public ListNode insertAt(ListNode position,ListNode n) {
      n.next = position.next;
      n.prev = position;
      position.next = n;

      if (tailNode == position) {
        tailNode = n;
      }
      return n;
    }

    public ListNode remove(ListNode n) {
      ListNode prev = n.prev;
      if (prev != null) {
        prev.next = n.next;
        if (n.next != null) {
          n.next.prev = prev;
        } else {
          tailNode = prev;
        }
      } else {
        headNode = n.next;
      }
      return n;
    }

    public ListNode head() {
      return headNode;
    }

    public ListNode tail() {
      return tailNode;
    }

  }

  class ListNode {
    int key;
    int val;
    ListNode prev;
    ListNode next;

    public ListNode(int k, int v) {
      key = k;
      val = v;
    }
  }
}


