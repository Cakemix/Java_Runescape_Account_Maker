package org.cake.runescape.accountmaker;

import java.io.IOException;
import java.util.Random;

import org.cake.runescape.accountmaker.Data.Constants;
import org.cake.runescape.accountmaker.Data.EmailTypes;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @author Cake
 * 
 */
public class Maker implements Constants {

	public int register(String email, String password, int age, String proxyIp, String proxyPort) throws IOException {

		if (!proxyIp.isEmpty()) {
			System.setProperty("http.proxyHost", "192.168.5.1");
			System.setProperty("http.proxyPort", "1080");
		}

		Connection connect = Jsoup.connect("https://secure.runescape.com/m=account-creation/");

		connect.userAgent(USER_AGENT);

		connect.timeout(TIME_OUT);

		connect.data("email1", email, "email2", email, "password1", password, "password2", password, "onlyOnePassword",
				"1", "age", String.valueOf(age), "agree_email", "1", "agree_pp_and_tac", "1", "submit", "register");

		Document post = connect.post();

		if (post.html().contains(VALID_ACCOUNT))
			return 1;

		if (post.html().contains(BLOCKED_FEW_MINUTES))
			return 2;

		return 0;
	}

	public String randomEmail() {
		EmailTypes emailTypes = Data.EmailTypes.values()[new Random().nextInt(Data.EmailTypes.values().length)];
		return '@' + emailTypes.value[new Random().nextInt(emailTypes.value.length)];
	}

	public String randomLetters(int length) {
		char[] ca = new char[length];

		for (int i = 0; i < length; i++)
			ca[i] = (char) (new Random().nextInt(26) + 'a');

		return new String(ca);
	}
}
