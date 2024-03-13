import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static public void bubbleSort(ArrayList<Integer> lst){
        for(int cycle = 0 ;cycle < lst.size(); cycle ++) {
            for(int i = 0 ; i < lst.size() - 1 - cycle; i ++) {
                if(lst.get(i) > lst.get(i + 1)){
                    //swap
                    int tmp = lst.get(i);
                    lst.set(i, lst.get(i + 1));
                    lst.set(i + 1, tmp);
                }
            }
        }
    }
    static public void selectionSort(ArrayList<Integer> lst) {
        for(int i = 0 ; i < lst.size(); i++) {
            for(int j = i + 1 ; j < lst.size(); j ++) {
                if(lst.get(i) > lst.get(j)){
                    int tmp = lst.get(i);
                    lst.set(i, lst.get(j));
                    lst.set(j, tmp);
                }
            }
        }
    }

    interface Sort{
        void sort(ArrayList<Integer> lst);
    }

    static class BubbleSort implements Sort {
        @Override
        public void sort(ArrayList<Integer> lst) {
            bubbleSort(lst);
        }
    }

    static class SelectionSort implements Sort {
        @Override
        public void sort(ArrayList<Integer> lst) {
            selectionSort(lst);
        }
    }

    static class SortPrinter {
        Sort sort;
        ArrayList<Integer> lst = new ArrayList<>();
        public void insert(int a){
            lst.add(a);
        }
        public void selection(Sort sort){
            this.sort = sort;
        }
        public void run(){
            sort.sort(lst);
        }
        public void show(){
            for(int i = 0 ; i < lst.size(); i++) {
                System.out.print(lst.get(i));
                System.out.print(' ');
            }
            System.out.print('\n');
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> lst = new ArrayList<>(Arrays.asList(3,3,3,2,1,1,2,3,2,1,2,3,1,2,3,2,1,5,5,2,1,7));

        SortPrinter sortMachine = new SortPrinter();
        Sort selectBubbleSort = new BubbleSort();
        Sort selectSelectionSort = new SelectionSort();

        for(int i = 0 ; i < lst.size(); i++) {
            sortMachine.insert(lst.get(i));
        }

        sortMachine.selection(selectBubbleSort);
        sortMachine.run();
        sortMachine.show();

        sortMachine.selection(selectSelectionSort);
        sortMachine.run();
        sortMachine.show();
    }
}
