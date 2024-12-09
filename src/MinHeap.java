import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    List<Node> pq;

    public MinHeap(){
        this.pq = new ArrayList<>();
    }

    public int getSize(){
        return pq.size();
    }

    public int getMin(){
        return pq.get(0).val;
    }

    public void percolateUp(){
        int childIndex = pq.size()-1;

        while(childIndex > 0){
            int parentIndex = (childIndex - 1) / 2;

            if(pq.get(childIndex).priority < pq.get(parentIndex).priority){
                Node temp = pq.get(parentIndex);
                pq.set(parentIndex , pq.get(childIndex));
                pq.set(childIndex , temp);

                childIndex = parentIndex;
            }
            else{
                break;
            }
        }
    }

    public void insert(int val , int priority){
        Node newNode = new Node(val , priority);
        pq.add(newNode);

        percolateUp();
    }

    public void percolateDown(){
        int parentIndex = 0;
        int leftChildIndex = 1;
        int rightChildIndex = 2;

        while(leftChildIndex < pq.size()){
            int minIndex = parentIndex;
            if(pq.get(minIndex).priority > pq.get(leftChildIndex).priority){
                minIndex = leftChildIndex;
            }
            if((rightChildIndex < pq.size()) && (pq.get(minIndex).priority > pq.get(rightChildIndex).priority)){
                minIndex = rightChildIndex;
            }

            if(minIndex != parentIndex){
                Node temp = pq.get(parentIndex);
                pq.set(parentIndex , pq.get(minIndex));
                pq.set(minIndex , temp);

                parentIndex = minIndex;
                leftChildIndex = (2 * parentIndex) + 1;
                rightChildIndex = (2 * parentIndex) + 2;
            }
            else{
                break;
            }
        }
    }

    public int delete(){
        if(pq.size() == 0){
            return -1;
        }

        Node res = pq.get(0);

        pq.set(0 , pq.get(pq.size()-1));
        pq.remove(pq.size()-1);

        percolateDown();

        return res.val;
    }

}
