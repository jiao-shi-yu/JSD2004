package thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池是管理线程的机制。
 * 主要做两件事：
 * 1. 控制线程数量
 * 2. 重用线程
 * @author jiao_
 *
 */
public class ThreadPoolDemo {
	public static void main(String[] args) {
		// 创建一个固定大小的线程池，这里容量是2
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		for(int i = 0; i < 5; i++) {
			Runnable r = new Runnable() {
				public void run() {
					try {
						Thread t = Thread.currentThread();
						System.out.println(t + "： 正在执行一个任务");
						Thread.sleep(5000);
						System.out.println(t + "： 执行完毕");
					} catch (Exception e)  {
						e.printStackTrace();
					}
				}
			};
			threadPool.execute(r);
			System.out.println("交给线程池一个任务");
		}
//		threadPool.shutdown();// 线程池不再接受新任务
		threadPool.shutdownNow();
		System.out.println("结束线程池。");
	}
}
