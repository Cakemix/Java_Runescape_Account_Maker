package org.cake.runescape.accountmaker;

import java.io.IOException;
import java.util.Random;

/**
 * @author Cake
 * 
 */
public class Run extends Data {
	public static void main(String[] args) throws IOException {
		Logger.info(" [ - :: Account Creater :: - ]");

		Maker maker = new Maker();

		String email = maker.randomLetters(5 + new Random().nextInt(5)).concat(maker.randomEmail());

		Logger.debug("   ^- Email    - %s", email);

		int age = 13 + new Random().nextInt(13);

		Logger.debug("   ^- Age      - %s", age);

		String password = "sicritpassword";

		Logger.debug("   ^- Password - %s", password);

		String proxyIp = "";
		String proxyPort = "";

		if (!proxyIp.isEmpty())
			Logger.debug("   ^- Proxy    - %s:%s", proxyIp, proxyPort);

		Logger.info("   ^- Output   - %s", Return.valueOf(maker.register(email, password, age, proxyIp, proxyPort)));
	}

}
