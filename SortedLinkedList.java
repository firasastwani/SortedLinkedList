import java.util.HashSet;

public class SortedLinkedList{

    private NodeType head;

    // constructor
    public SortedLinkedList(){
        head = null;
    }

    // returns the head of the list
    public NodeType getHead(){
        return head;
    }


    // returns length
    public int getLength(){

        int len = 0;
        NodeType curr = head;

        while(curr != null){
            len++;
            curr = curr.next;
        }

        //System.out.println(len);
        return len;
    }


    // inserts item into list
    public void insertItem(ItemType item){

        NodeType curr = head;
        NodeType node = new NodeType(item);


        if(head == null){
            head = node;
            return;
        }


        if(curr.info.compareTo(node.info) == 1){

            node.next = curr;
            head = node;
        } else if(curr.info.compareTo(node.info)  == 0){
            System.out.println("Cannot insert duplicate items in list");
            return;
        } else {

            while(curr.next != null){

                if(curr.next.info.compareTo(node.info) == 0){

                    System.out.println("cannot insert duplicate items in list");
                    return;
                }

                if(curr.next.info.compareTo(node.info) > 0){
                    break;
                }


            curr = curr.next;
        }



        if(curr.next != null){
            node.next = curr.next;
            curr.next = node;

        } else if(curr.next == null){
            curr.next = node;
        }

       }
    }



    // prints everything in the list
    public void printList(){

        NodeType curr = head;

        if(head == null){
            System.out.println("list is emtpy");
            return;
        }


        while(curr != null){
            System.out.print(curr.info.getValue() + "  ");
            curr = curr.next;
        }

        System.out.println();

    }

    //delets an item of users choice
    public void deleteItem(ItemType item){

        NodeType curr = head;

        if(head == null){

            System.out.println("Cannot delete from empty list");
            return;
        }


        if(head.info.compareTo(item) == 0 && head.next != null){

            head = head.next;
        } else if(head.info.compareTo(item) == 0 && head.next == null){
            head = null;
        } else {

        while(curr.next != null && curr.next.info.compareTo(item) < 0) {

            curr = curr.next;
        }


        if(curr.next != null && curr.next.info.compareTo(item) == 0){

            if(curr.next != null){
            curr.next = curr.next.next;
            }
        } else {
            System.out.println("item is not in list");
            return;
        }

    }
    }


    // returns the index of an inputted item
    public int searchItem(ItemType item){


        if(head == null){
            System.out.println("list is empty");
            return -1;
        }

        NodeType curr = head;
        int count = 1;


        while(curr != null && curr.info.compareTo(item) != 0){

            if(curr.next != null){
                curr = curr.next;
            } else {
                break;
            }
            count++;
        }

        if(curr.info.compareTo(item) == 0){
            //System.out.println("The item is present at index: " + count);
            return count;
        } else {
            System.out.println("item was not found in list");
            return -1;
        }
    }


    // deletes alternate nodes
    public void deleteAlternate(){

        if(head == null){
            System.out.println("List is empty");
            return;
        }

        NodeType curr = head;

        while(curr.next != null){

            curr.next = curr.next.next;
            if(curr.next != null){

            curr = curr.next;
            } else {
                return;
            }
        }
    }

    // returns the intersection between the original list and the user inputted list
    public SortedLinkedList intersection(SortedLinkedList list2){

        if(list2.getHead() == null || head == null){

            System.out.println("One of the lists is empty");
        }


        SortedLinkedList inter = new SortedLinkedList();

        HashSet<Integer> set = new HashSet<>();

        NodeType curr1 = head;
        NodeType curr2 = list2.getHead();

        //NodeType new = null;

        while(curr1 != null) {


            set.add(curr1.info.getValue());
            curr1 = curr1.next;
        }
        //set.add(curr1.info.getValue());

        while(curr2 != null){

            if(set.contains(curr2.info.getValue())) {

                inter.insertItem(curr2.info);
            }

            curr2 = curr2.next;
        }

        return inter;
        // System.out.println();
    }


    // combines the original list with the user inputted list
    public SortedLinkedList mergeList(SortedLinkedList list2){


        SortedLinkedList merge = new SortedLinkedList();

        HashSet<Integer> set = new HashSet<>();

        NodeType curr1 = head;
        NodeType curr2 = list2.getHead();


        while(curr1 != null){
            set.add(curr1.info.getValue());
            merge.insertItem(curr1.info);
            curr1 = curr1.next;
        }

        while(curr2 != null){

            if(!set.contains(curr2.info.getValue())){

            merge.insertItem(curr2.info);
            curr2 = curr2.next;
            } else {
                curr2 = curr2.next;
            }
        }

        return merge;

        //head = merge.getHead();

        //merge.printList();
    }

}
