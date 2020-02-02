package offerV2.common;


/**
 * @author liyazhou1
 * @date 2020/2/2
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(){}
    public ListNode(int value){ this.val = value; }
    public ListNode(int value, ListNode nextNode){
        this.val = value;
        this.next = nextNode;
    }

    public int getVal(){ return this.val; }
    public ListNode nextNode(){ return this.next; }
    public ListNode next() { return this.next; }
    public void setNext(ListNode node){ this.next = node; }
}
