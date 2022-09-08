package thread;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class CollectionFrameworkSynchronize {

	public static void main(String[] args) throws InterruptedException {

		List<Integer> lst = Collections.synchronizedList(new ArrayList<>());
		ReentrantLock rl = new ReentrantLock();
		for (int i = 0; i < 15; i++) {
			lst.add(i);
		}
		System.out.println(lst);

		Runnable task1 = () -> {
			ListIterator<Integer> itr = lst.listIterator();
			rl.lock();
			try {
				while (itr.hasNext()) {
					itr.set(itr.next() + 1);
				}
			} finally {
				rl.unlock();
			}
		};

		Runnable task2 = () -> {
			ListIterator<Integer> itr = lst.listIterator();
			synchronized(lst){
			while (itr.hasNext()) {
				itr.set(itr.next() + 1);
			}
			}
		};

		ExecutorService es = Executors.newFixedThreadPool(2);
		es.submit(task1);
		es.submit(task2);

		es.shutdown();
		es.awaitTermination(100, TimeUnit.SECONDS);
		System.out.println(lst);
	}

}
