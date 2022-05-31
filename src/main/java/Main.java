public class Main {
    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("Group 1");
        MyThread myThread1 = new MyThread(group, "1");
        MyThread myThread2 = new MyThread(group, "2");
        MyThread myThread3 = new MyThread(group, "3");
        MyThread myThread4 = new MyThread(group, "4");

        System.out.println("Создаю потоки...");
        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Завершаю все потоки.");
        group.interrupt();

    }
}
