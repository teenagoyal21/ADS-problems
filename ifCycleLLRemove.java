class LN {
    int val;
    LN next;

    LN(int x){
        this.val = x;
        this.next = null;
    }
}

public class ifCycleLLRemove {
    //approach = floyds cycle
    //we have to move the pointers until they met at the start of the cycle
    //find the last node and remove the cycle

    public static boolean hasCycle(LN head){
        LN slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void removeCycle(LN head){
        LN slow = head, fast = head;
        boolean cycleExi = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                cycleExi = true;
                break;
            }
        }
        if(!cycleExi) return;
        slow = head;
        while(slow!=fast.next){
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
    }
    public static void main(String[] args) {
        LN head = new LN(1);
        head.next = new LN(2);
        head.next.next = new LN(3);
        head.next.next.next = new LN(4);
        head.next.next.next.next = head.next;
        System.out.println("C D" + hasCycle(head));
        removeCycle(head);
        System.out.println("C D" + hasCycle(head));
    }
}
