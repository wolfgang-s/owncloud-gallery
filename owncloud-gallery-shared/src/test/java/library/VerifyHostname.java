package library;

import java.util.concurrent.ExecutionException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VerifyHostname {
	@Before
	public void initNetworkSettings() {
		// System.setProperty("java.net.useSystemProxies", "true");
		System.setProperty("http.proxyHost", "172.30.9.12");
		System.setProperty("http.proxyPort", "8080");
	}

	@Test
	public void testInvalidURL() throws InterruptedException,
			ExecutionException {
		VerifyHostnameResult result1 = OwncloudHelper.VerifyHostname(
				"woeijfe234wef2452asgbr2245").get();
		Assert.assertEquals(result1.getType(),
				VerifyHostnameResult.ResultType.NotFound);
		VerifyHostnameResult result2 = OwncloudHelper.VerifyHostname(
				"wefioj://eifh2b49dnf").get();
		Assert.assertEquals(result2.getType(),
				VerifyHostnameResult.ResultType.NotFound);
		VerifyHostnameResult result3 = OwncloudHelper.VerifyHostname(
				"ftp://efijefb23zh/efun").get();
		Assert.assertEquals(result3.getType(),
				VerifyHostnameResult.ResultType.NotFound);
		VerifyHostnameResult result4 = OwncloudHelper.VerifyHostname(
				"ÖLÄ§)($&/&).com").get();
		Assert.assertEquals(result4.getType(),
				VerifyHostnameResult.ResultType.NotFound);
		VerifyHostnameResult result5 = OwncloudHelper.VerifyHostname("s").get();
		Assert.assertEquals(result5.getType(),
				VerifyHostnameResult.ResultType.NotFound);
	}

	@Test
	public void testNullURL() throws InterruptedException, ExecutionException {
		VerifyHostnameResult result1 = OwncloudHelper.VerifyHostname("").get();
		Assert.assertEquals(result1.getType(),
				VerifyHostnameResult.ResultType.Null);
		VerifyHostnameResult result2 = OwncloudHelper.VerifyHostname(null)
				.get();
		Assert.assertEquals(result2.getType(),
				VerifyHostnameResult.ResultType.Null);
	}

	@Test
	public void testWithoutProtocol() throws InterruptedException,
			ExecutionException {
		VerifyHostnameResult result1 = OwncloudHelper.VerifyHostname(
				"oc-test.steuer.md/700").get();
		Assert.assertEquals(result1.getType(),
				VerifyHostnameResult.ResultType.OK);
		VerifyHostnameResult result2 = OwncloudHelper.VerifyHostname(
				"oc-test.steuer.md/604").get();
		Assert.assertEquals(result2.getType(),
				VerifyHostnameResult.ResultType.OK);
		VerifyHostnameResult result3 = OwncloudHelper.VerifyHostname(
				"oc-test.steuer.md/70RC1").get();
		Assert.assertEquals(result3.getType(),
				VerifyHostnameResult.ResultType.OK);
		VerifyHostnameResult result4 = OwncloudHelper.VerifyHostname(
				"oc-test.steuer.md/603").get();
		Assert.assertEquals(result4.getType(),
				VerifyHostnameResult.ResultType.OK);
	}

	@Test
	public void testHttp() throws InterruptedException, ExecutionException {
		VerifyHostnameResult result1 = OwncloudHelper.VerifyHostname(
				"http://oc-test.steuer.md/700").get();
		Assert.assertEquals(result1.getType(),
				VerifyHostnameResult.ResultType.OK);

		VerifyHostnameResult result2 = OwncloudHelper.VerifyHostname(
				"http://oc-test.steuer.md/604").get();
		Assert.assertEquals(result2.getType(),
				VerifyHostnameResult.ResultType.OK);
		VerifyHostnameResult result3 = OwncloudHelper.VerifyHostname(
				"http://oc-test.steuer.md/70RC1").get();
		Assert.assertEquals(result3.getType(),
				VerifyHostnameResult.ResultType.OK);
		VerifyHostnameResult result4 = OwncloudHelper.VerifyHostname(
				"http://oc-test.steuer.md/603").get();
		Assert.assertEquals(result4.getType(),
				VerifyHostnameResult.ResultType.OK);

	}

	@Test
	public void testHttps() throws InterruptedException, ExecutionException {
		VerifyHostnameResult result1 = OwncloudHelper.VerifyHostname(
				"https://oc-test.steuer.md/700").get();
		Assert.assertEquals(result1.getType(),
				VerifyHostnameResult.ResultType.InvalidCertificate);
		VerifyHostnameResult result2 = OwncloudHelper.VerifyHostname(
				"https://oc-test.steuer.md/604").get();
		Assert.assertEquals(result2.getType(),
				VerifyHostnameResult.ResultType.InvalidCertificate);
		VerifyHostnameResult result3 = OwncloudHelper.VerifyHostname(
				"https://oc-test.steuer.md/70RC1", true).get();
		Assert.assertEquals(result3.getType(),
				VerifyHostnameResult.ResultType.OK);
		VerifyHostnameResult result4 = OwncloudHelper.VerifyHostname(
				"https://oc-test.steuer.md/603", true).get();
		Assert.assertEquals(result4.getType(),
				VerifyHostnameResult.ResultType.OK);
	}

}
