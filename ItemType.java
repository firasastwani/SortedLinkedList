public class ItemType{


    private int value;

    public ItemType(int num){
        value = num;
    }

    public int compareTo(ItemType item){

        if(this.value < item.getValue()){
            return -1;
        } else if(this.value > item.getValue()){
            return 1;
        } else {
            return 0;
        }
    }

        public int getValue(){
            return value;
        }


    // dont need initalize bc I used constructor instead

    /*
    public void initialize(int num) {

            value = num;
        }

    */

}
