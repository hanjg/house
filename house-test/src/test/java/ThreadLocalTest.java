import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author anxi
 * @version 2022/5/23 10:32
 */
public class ThreadLocalTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 0, TimeUnit.DAYS, new ArrayBlockingQueue<>(1));

        executor.execute(() -> {
            try {
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
              throw new RuntimeException("wrapper");
            }
        });
        executor.execute(() -> {
            try {
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.shutdownNow();

        Thread.sleep(1000000);
    }


}
