import java.security.*;
import java.util.*;

import javax.crypto.Cipher;

public class CipherDecrypt {
   public static void main(String args[]) throws Exception{
	   //Creating a Signature object
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Text encrypted");
	  String tex=sc.nextLine();
	  
	  
      Signature sign = Signature.getInstance("SHA256withRSA");
      
      //Creating KeyPair generator object
      KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
      
      //Initializing the key pair generator
      keyPairGen.initialize(2048);
      
      //Generate the pair of keys
      KeyPair pair = keyPairGen.generateKeyPair();   
      
      //Getting the public key from the key pair
      PublicKey publicKey = pair.getPublic();  

      //Creating a Cipher object
      Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

      //Initializing a Cipher object
      cipher.init(Cipher.ENCRYPT_MODE, publicKey);
	  
      //Add data to the cipher
      byte[] input = "Sid is not okay".getBytes();	  
      cipher.update(input);
	  
      //encrypting the data
      byte[] cipherText = cipher.doFinal();	 
      System.out.println( new String(cipherText, "UTF8"));

      //Initializing the same cipher for decryption
      cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());
      
      //Decrypting the text
      byte[] decipheredText = cipher.doFinal(cipherText);
      System.out.println(new String(decipheredText));
   }
}