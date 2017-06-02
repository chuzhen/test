package test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		Future<String> future = executorService.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				return "Hello World";
			}
			
		});
		
		try {
			System.out.println("waiting thread to finish");
			System.out.println(future.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

