import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Program3 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch allStart = new CountDownLatch(3);
        CountDownLatch startRace = new CountDownLatch(1);
        Thread runnerThread1 = new Thread(new Runner(allStart, startRace));
        Thread runnerThread2 = new Thread(new Runner(allStart, startRace));
        Thread runnerThread3 = new Thread(new Runner(allStart, startRace));
        runnerThread1.start();
        runnerThread2.start();
        runnerThread3.start();
        System.out.println("Ждем бегунов на старте...");
        allStart.await();
        System.out.println("Все пришли...");
        System.out.println("НАСТАРТ! ВНИМАНИЕ! МАРШ!");
        startRace.countDown();
        runnerThread1.join();
        runnerThread2.join();
        runnerThread3.join();
        System.out.println("Гонка завершена");
    }

    static class Runner implements Runnable {
        CountDownLatch readyToStart;
        CountDownLatch raceStart;

        public Runner(CountDownLatch readyToStart, CountDownLatch raceStart) {
            this.raceStart = raceStart;
            this.readyToStart = readyToStart;
        }

        @Override
        public void run() {
            try {
                System.out.println("Иду на старт..." + Thread.currentThread().getName());
                Thread.sleep(new Random().nextInt(500, 2000));
                readyToStart.countDown();
                raceStart.await();
                System.out.println("Бегу..." + Thread.currentThread().getName());
                Thread.sleep(new Random().nextInt(3000, 5000));
                System.out.println("Прибежал!" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
