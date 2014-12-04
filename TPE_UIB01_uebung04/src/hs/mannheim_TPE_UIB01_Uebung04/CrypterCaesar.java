package hs.mannheim_TPE_UIB01_Uebung04;

import java.util.LinkedList;
import java.util.List;

public class CrypterCaesar implements Crypter {

	private String key;

	public CrypterCaesar(String key) {
		
		this.key = key;
	}

	@Override
	public String encrypt(String message) throws CrypterException {
		
		char buchstabe = key.charAt(0);
		int key = (int) buchstabe - 64;
		
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

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		List<String> ergebnis = new LinkedList<String>();
		for (String message : messages) {
			ergebnis.add(encrypt(message));
		}
		return ergebnis;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {

		
		char buchstabe = key.charAt(0);
		int key = (int) buchstabe + 64 *(-1);
		
		cypherText = cypherText.toUpperCase(); 
		char[] k = cypherText.toCharArray(); 

		for (int i = 0; i < cypherText.length(); i++) {
			char c = cypherText.charAt(i); 
			if (((int) (c) >= (65 + key)) && ((int) (c) <= (90))) { 
				c = (char) (c - key);
				k[i] = c;
			} 
			else if (((int) (c) >= 65) && ((int) (c) < (65 + key))) { 

				c = (char) (c - key + 26);

				k[i] = c;
			}
		}
		cypherText = new String(k);
		return cypherText;
	
	}

	
	
	@Override
	public List<String> decrypt(List<String> cypherTexte) throws CrypterException {
		
		List<String> ergebnis = new LinkedList<String>();
		for (String message : cypherTexte) {
			ergebnis.add(decrypt(message));
		}
		return ergebnis;
	}

}
