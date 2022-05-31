import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    private String name;

    public MyCallable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public Integer call() throws Exception {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            Thread.sleep(2500);
            count++;
            System.out.println("Всем привет, я " + this.getName());
        }
        return count;
    }

    @Override
    public String toString() {
        return name;
    }
}