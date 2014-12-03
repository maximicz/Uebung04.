package hs.mannheim_TPE_UIB01_Uebung04;

import java.util.ArrayList;
import java.util.List;

public class CrypterCaesar implements Crypter {

	private String message;  //Braucht man den String überhaupt? Wie wird aufgerufen?
	private int key;
	private List<String> list;
	
	public CrypterCaesar(String message, int key) {
		this.message = message;
		this.key = key;
	}
	
	
	@Override
	public String encrypt(String message) throws CrypterException {

			   message = message.toUpperCase();                                    // UPPERCASE
			   char[] k = message.toCharArray();                             // Umwandeln in char-Array

			   for (int i=0; i<message.length(); i++) {
			     char c = message.charAt(i);                                 // Jedes einzelnes char-Element wird angewählt

			     if(((int)(c) >= 65) && ((int)(c) <= (90-key))){         // "Normale" Erhöhung des ASCII-Wertes um a
			       c = (char)(c + key);
			       k[i] = c;
			     }
			     else if (((int)(c) >(90-key)) && ((int)(c) <=90)){      // Sonderregel für das Überschreiten der Grenze
			       c = (char)(c + key -26);
			       k[i] = c;
			     }
			   }
			   message = new String(k);
			   return message;
		
	}

	
	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		List<String> messages2 = new ArrayList<String>();
		
		do {
			String a = encrypt(messages.iterator().next());
			messages2.add(a);
		}
		while(messages.iterator().hasNext()); 
			
		return messages2;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {

			   cypherText = cypherText.toUpperCase();                                    // UPPERCASE
			   char[] k = cypherText.toCharArray();                             // Umwandeln in char-Array

			   for (int i=0; i<cypherText.length(); i++) {
			     char c = cypherText.charAt(i);                                 // Jedes einzelnes char-Element wird angewählt

			     if(((int)(c) >= (65+key)) && ((int)(c) <= (90))){         // "Normale" Erniedrigung des ASCII-Wertes um a
			       c = (char)(c - key);
			       k[i] = c;
			     }
			     else if (((int)(c) >= 65) && ((int)(c) <(65+key))){      // Sonderregel für das Überschreiten der Grenze
			       
			   c = (char)(c - key +26);

			       k[i] = c;
			     }
			   }
			   cypherText = new String(k);
			   return cypherText;
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte)
			throws CrypterException {
		// TODO Auto-generated method stub
		return null;
	}
 
}
