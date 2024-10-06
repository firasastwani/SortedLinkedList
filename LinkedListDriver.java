import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class LinkedListDriver{
    public static void main(String[] args){


        if(args.length != 1) {

            System.out.println("no inputted file");
            return;
        }


        String fileName = args[0];

        File file = new File(fileName);

        Scanner scan;


        try{

            scan = new Scanner(file);
        } catch (FileNotFoundException e){

            System.out.println("inputted file was not found");
            return;
        }

        SortedLinkedList list = new SortedLinkedList();

        // reads the inputted file
        while(scan.hasNextInt()) {

            int num = scan.nextInt();
            ItemType item = new ItemType(num);

            list.insertItem(item);
        }

        scan.close();


        System.out.println("Commands:");
        System.out.println("(i) - Insert value");
        System.out.println("(d) - Delete value");
        System.out.println("(s) - Search value");
        System.out.println("(a) - Delete alternate nodes");
        System.out.println("(m) - Merge lists");
        System.out.println("(t) - Find intersection");
        System.out.println("(p) - Print List");
        System.out.println("(l) - Print length");
        System.out.println("(q) - Quit program");


        Scanner scanner = new Scanner(System.in);

        boolean cont = true;


        // handling commands
        while(cont) {

            System.out.println("Enter a command: ");

            String command = scanner.nextLine();

            if(command.equals("p")){

                list.printList();
            } else if(command.equals("i")){

                System.out.print("Enter a number to insert: ");
                int ins = scanner.nextInt();

                scanner.nextLine();

                ItemType insert = new ItemType(ins);
                System.out.println();

                System.out.print("Original List: ");
                list.printList();


                list.insertItem(insert);

                System.out.print("New List: ");
                list.printList();
            } else if(command.equals("d")){

                System.out.print("Enter a number to delete: ");

                int numDel = scanner.nextInt();

                scanner.nextLine();

                ItemType del = new ItemType(numDel);
                System.out.println();

                System.out.print("Original list: ");
                list.printList();

                list.deleteItem(del);

                System.out.print("New List: ");
                list.printList();

            } else if(command.equals("s")){

                System.out.print("Enter a number to search: ");

                int searchNum = scanner.nextInt();
                scanner.nextLine();

                ItemType search = new ItemType(searchNum);
                System.out.println();

                int index = list.searchItem(search);

                //scanner.nextLine();

                if(index != -1){

                System.out.println("The item is present at index: " + index);
                }
                scanner.nextLine();

            } else if(command.equals("l")){

               int len = list.getLength();

               System.out.println("The lenght of the list is: " + len);
            } else if(command.equals("a")){


                System.out.print("Original list: ");
                list.printList();

                //System.out.println();

                list.deleteAlternate();

                System.out.print("New list: ");

                list.printList();


            } else if(command.equals("q")){

                System.out.println("Exiting the program...");
                cont = false;
            } else if(command.equals("m")){

                System.out.print("Input the length of the new list: ");

                int mLength = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter the numbers: ");

                SortedLinkedList newList = new SortedLinkedList();

                while(mLength > 0){

                    int it = scanner.nextInt();

                    ItemType newIt = new ItemType(it);


                    newList.insertItem(newIt);
                    mLength--;
                }

                System.out.print("Merged List: ");

                newList = list.mergeList(newList);

                newList.printList();
                scanner.nextLine();

                list = newList;
            } else if(command.equals("t")){

                System.out.print("Input the lenght of the new list: ");

                int tLength = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter the numbers: ");

                SortedLinkedList tList = new SortedLinkedList();

                while(tLength > 0){

                    int tL = scanner.nextInt();

                    ItemType lIt = new ItemType(tL);

                    tList.insertItem(lIt);
                    tLength--;

                }

                System.out.print("Intersection of lists: ");

                tList = list.intersection(tList);

                tList.printList();
                scanner.nextLine();
            } else {

                System.out.println("Invalid command, try again");
            }
        }



        // testing:




/*
        SortedLinkedList list = new SortedLinkedList();
        SortedLinkedList list2 = new SortedLinkedList();

        ItemType item = new ItemType(3);
        ItemType item2 = new ItemType(10);
        ItemType item3 = new ItemType(5);
        ItemType item4 = new ItemType(12);
        ItemType item5 = new ItemType(8);
        ItemType item6 = new ItemType(20);
        ItemType item7 = new ItemType(3);


        ItemType item11 = new ItemType(3);
        ItemType item22 = new ItemType(5);
        ItemType item33 = new ItemType(23);
        ItemType item44 = new ItemType(1);
        ItemType item66 = new ItemType(20);



        /*
        list2.insertItem(item11);
        list2.insertItem(item22);
        list2.insertItem(item33);
        list2.insertItem(item44);
        list2.insertItem(item66);
        */
/*
        list.insertItem(item);
        list.insertItem(item2);
        list.insertItem(item3);
        list.insertItem(item4);
        list.insertItem(item5);
        list.insertItem(item6);
        list.insertItem(item7);
        list.insertItem(item11);
*/

        // list.printList();

        // list.deleteItem(item4);

        //list.printList();

        // System.out.println("testingggg");



        //list.printList();
        /*
        list.searchItem(item7);
        list.searchItem(item);
        list.searchItem(item3);
        list.searchItem(item5);
        list.searchItem(item2);
        list.searchItem(item4);
        list.searchItem(item6);
        */

        //list.deleteAlternate();

        //list.printList();
        //list2.printList();

        //list.intersection(list2);

        // list.mergeList(list2);



    }
}
