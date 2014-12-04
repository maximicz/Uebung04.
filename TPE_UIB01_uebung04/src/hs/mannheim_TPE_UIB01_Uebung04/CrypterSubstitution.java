package hs.mannheim_TPE_UIB01_Uebung04;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CrypterSubstitution implements Crypter {
 
	private Map<Character, Character> map = new HashMap<>();
	//private HashMap<Character,Character> decr;
	private String key;
	
	
	public CrypterSubstitution(String key) {
		this.key = key;
	}
	
	@Override
	public String encrypt(String message) throws CrypterException {
		
		 	   
		 	       String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		 	 
		 	       for(int i = 0; i < alphabet.length(); ++i) {
		 	          map.put(alphabet.charAt(i), key.charAt(i));
		 	       }
		 	       
		 	       String a = new String(""); 
		 	       for(int k = 0; k < message.length(); k++) {
		 	    	  char c = message.charAt(k);
		 	    	  a += Character.toString(map.get(c)) ;
		 	       }
		 	       return a;
		 	  
	}

	@Override
	public List<String> encrypt(List<String> messages) throws CrypterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		// TODO Auto-generated method stub
		return null; decr = new HashMap<Character,Character>();
		 	       for(int i = 0; i < from.length(); ++i)
		 	          decr.put(to.charAt(i), from.charAt(i));
	}

	@Override
	public List<String> decrypt(List<String> cypherTexte) throws CrypterException {
		// TODO Auto-generated method stub
		return null;
	}

}
