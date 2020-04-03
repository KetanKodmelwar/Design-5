
class Solution {
    HashMap<Node, Node> hp = new HashMap<>();

    public Node copyRandomList(Node head) {

        if (head == null)
            return head;

        Node cursor = head;
        Node copyCursor = new Node(cursor.val);
        hp.put(cursor, copyCursor);
        cursor = cursor.next;

        while (cursor != null) {
            Node newNode = new Node(cursor.val);
            hp.put(cursor, newNode);
            copyCursor.next = newNode;
            copyCursor = copyCursor.next;
            cursor = cursor.next;
        }

        cursor = head;
        copyCursor = hp.get(head);

        while (cursor != null) {
            copyCursor.random = hp.get(cursor.random);
            cursor = cursor.next;
            copyCursor = copyCursor.next;
        }

        return hp.get(head);
    }

}