import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Callable<Integer> myCallable1 = new MyCallable("Задача 1");
        Callable<Integer> myCallable2 = new MyCallable("Задача 2");
        Callable<Integer> myCallable3 = new MyCallable("Задача 3");
        Callable<Integer> myCallable4 = new MyCallable("Задача 4");

        ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        List<Callable<Integer>> listOfCallable = Arrays.asList(myCallable1, myCallable2, myCallable3, myCallable4);

        Future<Integer> task1 = threadPool.submit(myCallable1);
        Future<Integer> task2 = threadPool.submit(myCallable2);
        Future<Integer> task3 = threadPool.submit(myCallable3);
        Future<Integer> task4 = threadPool.submit(myCallable4);

        try {
            System.out.println(myCallable1 + " вывела в консоль " + task1.get() + " сообщений");
            System.out.println(myCallable2 + " вывела в консоль " + task2.get() + " сообщений");
            System.out.println(myCallable3 + " вывела в консоль " + task3.get() + " сообщений");
            System.out.println(myCallable4 + " вывела в консоль " + task4.get() + " сообщений");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        Integer count = null;
        try {
            count = threadPool.invokeAny(listOfCallable);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("Самая быстрая задача вывела " + count + " сообщений");

        threadPool.shutdown();
    }
}
