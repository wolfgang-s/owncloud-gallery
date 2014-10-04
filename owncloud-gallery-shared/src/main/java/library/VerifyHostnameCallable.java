package library;

import java.io.IOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Callable;

import javax.net.ssl.HttpsURLConnection;

public class VerifyHostnameCallable implements Callable<VerifyHostnameResult> {
	private String hostname;
	private int timeout;
	private boolean acceptAllCertificate;

	public VerifyHostnameCallable(String Hostname, int Timeout,
			boolean acceptAllCertificates) {
		this.hostname = Hostname;
		this.timeout = Timeout;
		this.acceptAllCertificate = acceptAllCertificate;
	}

	public VerifyHostnameResult call() throws Exception {
		VerifyHostnameResult toReturn = new VerifyHostnameResult();
		if (hostname == null) {
			toReturn.setTitle(Properties
					.getString("verifyhostnameresult.null.title"));
			toReturn.setMessage(Properties
					.getString("verifyhostnameresult.null.message"));
			toReturn.setType(VerifyHostnameResult.ResultType.Null);
			return toReturn;
		}
		try {
			if (hostname.startsWith("http://")) {
				verifyConnection(
						(HttpURLConnection) new URL(hostname).openConnection(),
						toReturn, acceptAllCertificate);
			} else if (hostname.startsWith("https://")) {
				verifyConnection(
						(HttpsURLConnection) new URL(hostname).openConnection(),
						toReturn, acceptAllCertificate);
			} else {
				try {
					verifyConnection((HttpURLConnection) new URL("http://"
							+ hostname).openConnection(), toReturn,
							acceptAllCertificate);
				} catch (Exception ex) {
					verifyConnection((HttpsURLConnection) new URL("https://"
							+ hostname).openConnection(), toReturn,
							acceptAllCertificate);
				}
			}
			System.out.println(String.format("%s: %s", hostname,
					toReturn.getResponseCode()));
			if (toReturn.getResponseCode() >= 500) {
				toReturn.setType(VerifyHostnameResult.ResultType.ServerError);
			} else if (toReturn.getResponseCode() >= 400) {
				toReturn.setType(VerifyHostnameResult.ResultType.NotFound);
			} else if (toReturn.getResponseCode() >= 300) {
				toReturn.setType(VerifyHostnameResult.ResultType.Redirect);
			} else {
				toReturn.setType(VerifyHostnameResult.ResultType.OK);
			}
		} catch (ProtocolException ex) {
			System.out.println(String.format("%s: %s", ex.getClass()
					.getSimpleName(), ex.getMessage()));
			toReturn.setType(VerifyHostnameResult.ResultType.MalformedUri);
			return toReturn;
		} catch (UnknownHostException ex) {
			System.out.println(String.format("%s: %s", ex.getClass()
					.getSimpleName(), ex.getMessage()));
			return toReturn;
		} catch (SocketTimeoutException ex) {
			System.out.println(String.format("%s: %s", ex.getClass()
					.getSimpleName(), ex.getMessage()));
			return toReturn;
		} catch (ConnectException ex) {
			toReturn.setType(VerifyHostnameResult.ResultType.InvalidCertificate);
			System.out.println(String.format("%s: %s", ex.getClass()
					.getSimpleName(), ex.getMessage()));
			return toReturn;
		} catch (IOException ex) {
			toReturn.setType(VerifyHostnameResult.ResultType.Null);
			System.out.println(String.format("%s: %s", ex.getClass()
					.getSimpleName(), ex.getMessage()));
			return toReturn;
		} catch (RuntimeException ex) {
			toReturn.setType(VerifyHostnameResult.ResultType.Null);
			System.out.println(String.format("%s: %s", ex.getClass()
					.getSimpleName(), ex.getMessage()));
			return toReturn;
		} catch (Exception ex) {
			System.out.println(String.format("%s: %s", ex.getClass()
					.getSimpleName(), ex.getMessage()));
			return toReturn;
		}

		toReturn.setMessage(Properties.getString("verifyhostnameresult."
				+ toReturn.getType().toString().toLowerCase() + ".message"));
		return toReturn;
	}

	private void verifyConnection(HttpURLConnection connection,
			VerifyHostnameResult ToReturn, boolean acceptAllCertificate)
			throws IOException, KeyManagementException,
			NoSuchAlgorithmException, KeyStoreException {
		if (acceptAllCertificate) {
			TrustModifier.relaxHostChecking(connection);
		}
		connection.setConnectTimeout(timeout);
		connection.setReadTimeout(timeout);
		connection.setRequestMethod("HEAD");
		ToReturn.setResponseCode(connection.getResponseCode());
	}
}
