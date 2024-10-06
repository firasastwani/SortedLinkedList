

    Firas Astwani
    Email: ffa53456@uga.edu


    RUNNING AND COMPILING:
    I did not use a run script. Just compile all the files then to run the main method:
    java LinkedListDriver.java (file name)







    mergeList pseudo code:

    create new list
    Create hashset

    curr1 = head of original list
    curr2 = head of list you want to merge

    while(curr1 is not null){
    add the values of the original list to the hashste
    add each node of the original list to the new list
    move curr1
    }

    while(curr2 is not null({

    if(the node value is not already in the hashset){
        add the node to the new list
        move curr2
    } else {
    move curr2
    }

    return the new merged list.

    }

    This function is O(n^2) because it iterates through the first linked list, then iterates through the second linked list to create the new list.





    Intersection pseudo code:

    if(either original list or new list is null){
        print one of the lists is empty
    }

    make new list
    Create hashset

    curr1 = head of original list
    curr2 = head of list you want to find intersection with


    while(curr1 is not null){

    add value of curr1 to set
    move curr1
    }

    while(curr2 is not null){

    if(the value of curr2 is in the hashset){
    add the node to the intersection list
    }
    move curr2
    }

    return the intersection list
    }

    This function is also O(n^2) because it iterates through the original list, then iterates through the second list to make the new list.
