/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messageauthenticationcode;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;

/**
 *
 * @author asalah
 */
public class MessageAuthenticationCode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {

        //Creating a KeyGenerator object
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        //Creating a SecureRandom object
        SecureRandom secRandom = new SecureRandom();
        //Initializing the KeyGenerator
        keyGen.init(secRandom);
        //Creating/Generating a key
        Key key = keyGen.generateKey();
        //System.out.println("Key is "+key.getEncoded());
        //Initializing the Mac object
        //Creating a Mac object
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(key);
        //Computing the Mac
        String msg = new String("Hi how are you");
        byte[] bytes = msg.getBytes();      
        byte[] macResult = mac.doFinal(bytes);

        System.out.println("Mac result:");
        System.out.println(new String(macResult)); 
    }

}
