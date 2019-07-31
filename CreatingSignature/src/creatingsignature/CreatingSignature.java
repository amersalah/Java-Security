/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creatingsignature;

/**
 *
 * @author asalah
 */

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Scanner;

public class CreatingSignature {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, UnsupportedEncodingException {
        
         //Accepting text from user
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter some text");
      String msg = sc.nextLine();
      
      //Creating KeyPair generator object
      KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
      
      //Initializing the key pair generator
      keyPairGen.initialize(2048);
      
      //Generate the pair of keys
      KeyPair pair = keyPairGen.generateKeyPair();
      
      //Getting the private key from the key pair
      PrivateKey privKey = pair.getPrivate();
      
      //Creating a Signature object
      Signature sign = Signature.getInstance("SHA256withDSA");
      
      //Initialize the signature
      sign.initSign(privKey);
      byte[] bytes = "msg".getBytes();
      
      //Adding data to the signature
      sign.update(bytes);
      
      //Calculating the signature
      byte[] signature = sign.sign();
      
      //Printing the signature
      System.out.println("Digital signature for given text: "+new String(signature, "UTF8"));
        
        
    }
    
}
