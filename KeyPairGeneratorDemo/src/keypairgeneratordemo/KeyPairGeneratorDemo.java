/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keypairgeneratordemo;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 *
 * @author asalah
 */
public class KeyPairGeneratorDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException {

        //Creating Key Pair Generator
        KeyPairGenerator pairGenerator = KeyPairGenerator.getInstance("DSA");

        //initialize Key Pair Generator
        pairGenerator.initialize(2048);

        //Generating the pair of keys
        KeyPair pair = pairGenerator.generateKeyPair();

        //Getting the private key from the key pair
        PrivateKey privKey = pair.getPrivate();
        System.out.println("Private Key "+privKey);
        //Getting the public key from the key pair
        PublicKey publicKey = pair.getPublic();
        System.out.println("Public Key "+publicKey);
        
        System.out.println("Keys generated");

    }

}
