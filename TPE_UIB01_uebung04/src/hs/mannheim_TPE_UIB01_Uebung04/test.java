package hs.mannheim_TPE_UIB01_Uebung04;

import java.util.ArrayList;
import java.util.List;

public class test {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		list.add("Ziel");
		list.add("Ziel");

		System.out.println(encrypt("Ziel"));

	}

	public static int key = 3;

	public static String encrypt(String message) {

		message = message.toUpperCase();
		char[] k = message.toCharArray(); 

		for (int i = 0; i < message.length(); i++) {
			char c = message.charAt(i); 

			if (((int) (c) >= 65) && ((int) (c) <= (90 - key))) { 																									
				c = (char) (c + key);
				k[i] = c;
			} else if (((int) (c) > (90 - key)) && ((int) (c) <= 90)) { 														
				c = (char) (c + key - 26);
				k[i] = c;
			}
		}
		message = new String(k);
		return message;
	}

	public static List<String> encrypt(List<String> messages) {
		List<String> messages2 = new ArrayList<String>();

		do {
			String a = encrypt(messages.iterator().next());
			messages2.add(a);
		} while (messages.iterator().hasNext());

		return messages2;
	}

}
