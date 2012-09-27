package org.cake.runescape.accountmaker;

public class Data {
	public interface Constants {
		int TIME_OUT = 10600;
		
		String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.4 (KHTML, like Gecko) Chrome/22.0.1229.79 Safari/537.4";
		
		String VALID_ACCOUNT = "Your account has been successfully created! Please wait whilst we activate your account";
		String BLOCKED_FEW_MINUTES = "You have been blocked from creating too many accounts, please try again in a few minutes.";
	}

	public enum EmailTypes {
		HOTMAIL("hotmail.com", "live.com", "live.no", "live.se"), GMAIL("gmail.com", "googlemail.com");

		public String[] value;

		EmailTypes(String... value) {
			this.value = value;

		}

	}

	public enum Return {
		INVALID(0), SUCCESS(1), BLOCKED(2);
		public int value;

		Return(int value) {
			this.value = value;
		}

		public static Return valueOf(int valueInt) {
			for (Return r : values())
				if (r.value == valueInt)
					return r;
			return null;
		}
	}
}
