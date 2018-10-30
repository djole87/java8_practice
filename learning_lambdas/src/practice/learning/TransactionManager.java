package practice.learning;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * As its name suggests, a single instance of ThreadLocal can store different
 * values for each thread independently. Therefore, the value stored in a
 * ThreadLocal instance is specific (local) to the current running Thread, any
 * other code logic running on the same thread will see the same value, but not
 * the values set on the same instance by oth- er threads. (There are
 * exceptions, like InhertiableThreadLocal, which inherits parent thread’s
 * values by default.)
 * 
 * @author djordje
 * 
 *         Example of usage of ThreadLocal
 *
 */
public class TransactionManager {
	private static final ThreadLocal<String> context = new ThreadLocal<>();

	public static void startTransaction(String threadName) {
		String uuid = UUID.randomUUID().toString();
		System.out.println(threadName + " " + uuid);
		context.set(uuid);
	}

	public static String getTransactrionId() {
		return context.get();
	}

	public static void endTransaction() {
		context.remove();
	}
	
	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			TransactionRunner myRunnable = new TransactionRunner();
			Thread thread = new Thread(myRunnable);

			thread.start();
		}
	}
}

class TransactionRunner implements Runnable {
	private static final AtomicInteger nextId = new AtomicInteger(0);

	String threadName = "Thread " + nextId.getAndIncrement();

	@Override
	public void run() {
		System.out.println(threadName + " is started");

		TransactionManager.startTransaction(threadName);

		System.out.println(threadName + " " + TransactionManager.getTransactrionId());
		
		TransactionManager.endTransaction();
	}

}
