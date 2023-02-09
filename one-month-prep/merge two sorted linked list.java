import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the mergeLists function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
   static SinglyLinkedListNode mergeLists(SinglyLinkedListNode currA, SinglyLinkedListNode currB) {
    if (currA == null) {
        return currB;
    } else if (currB == null) {
        return currA;
    }
    
    SinglyLinkedListNode result = new SinglyLinkedListNode(0); // dummy/placeholder ListNode
    SinglyLinkedListNode n = result;
    while (currA != null && currB != null) {
        if (currA.data < currB.data) {
            n.next = currA;
            currA = currA.next;
        } else {
            n.next = currB;
            currB = currB.next;
        }
        n = n.next;
    }
    
    /* Attach the remaining elements */
    if (currA == null) {
        n.next = currB;
    } else {
        n.next = currA;
    }

    return result.next;
}

    private static final Scanner scanner = new Scanner(System.in);
