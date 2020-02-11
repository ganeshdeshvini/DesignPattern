package designpatterns.strategy;


public class Context {
    interface Strategy {
        public void sort(int[] numbers);
    }

    static class BubbleSort implements Strategy {
        @Override
        public void sort(int[] numbers) {
            // Ideally the bubble sort is implemented completely here
            System.out.println("sorting array using bubble sort strategy");
        }
    }

    static class QuickSort implements Strategy {
        @Override
        public void sort(int[] numbers) {
            // Ideally the quick sort is implemented completely here
            System.out.println("sorting array using bubble sort strategy");
        }
    }

    Strategy strategy;

    Context(Strategy sorter) {
        this.strategy = sorter;
    }

    void arrange(int[] values) {
        strategy.sort(values);
    }

    public static void main(String[] args) {
        Context context = new Context(new BubbleSort());
        // This can also be a setter..
        int[] arr = {1, 2, 3};
        context.arrange(arr);
    }
}