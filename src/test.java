public class test {
    public static void main(String[] args) {
        MinHeap mn = new MinHeap();
        MaxHeap mx = new MaxHeap();

        mn.insert(1 , 10);
        mn.insert(3 , 5);
        mn.insert(2 , 19);
        mn.insert(4 , 4);

        mx.insert(1 , 10);
        mx.insert(3 , 5);
        mx.insert(2 , 19);
        mx.insert(4 , 4);

        while(mn.getSize() != 0){
            System.out.print(mn.delete() + " ");
        }

        System.out.println();

        while(mx.getSize() != 0){
            System.out.print(mx.delete() + " ");
        }

    }
}
