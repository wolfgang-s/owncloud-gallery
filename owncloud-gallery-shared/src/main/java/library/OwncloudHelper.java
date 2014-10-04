package library;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class OwncloudHelper {

	public static Future<VerifyHostnameResult> VerifyHostname(String Hostname) {
		Callable<VerifyHostnameResult> call = new VerifyHostnameCallable(
				Hostname, Properties.getAppInt("http.timeout"), false);
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		return executorService.submit(call);
	}

	public static Future<VerifyHostnameResult> VerifyHostname(String Hostname,
			boolean acceptAllCertificates) {
		Callable<VerifyHostnameResult> call = new VerifyHostnameCallable(
				Hostname, Properties.getAppInt("http.timeout"),
				acceptAllCertificates);
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		return executorService.submit(call);
	}
}
