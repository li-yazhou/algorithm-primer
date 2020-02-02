package offerV2.common;


/**
 * @author liyazhou1
 * @date 2020/2/2
 */
public class ListNode {
    private int value;
    private ListNode nextNode;

    public ListNode(){}
    public ListNode(int value){ this.value = value; }
    public ListNode(int value, ListNode nextNode){
        this.value = value;
        this.nextNode = nextNode;
    }

    public int getValue(){ return this.value; }
    public ListNode nextNode(){ return this.nextNode; }
    public void setNextNode(ListNode node){ this.nextNode = node; }
}
