/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retrivingkeysofkeystore;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStore.ProtectionParameter;
import java.security.KeyStore.SecretKeyEntry;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author asalah
 */
public class RetrivingKeysOfKeyStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws KeyStoreException, FileNotFoundException, IOException, NoSuchAlgorithmException, CertificateException, UnrecoverableEntryException {

        //Creating the KeyStore object
        KeyStore keyStore = KeyStore.getInstance("JCEKS");
        //Loading the the KeyStore object
        char[] password = "changeit".toCharArray();
        java.io.FileInputStream fis = new FileInputStream(
                "C:/Program Files/Java/jre1.8.0_101/lib/security/cacerts");

        keyStore.load(fis, password);

        //Creating the KeyStore.ProtectionParameter object
        ProtectionParameter protectionParam = new KeyStore.PasswordProtection(password);

        //Creating SecretKey object
        SecretKey mySecretKey = new SecretKeySpec("myPassword".getBytes(), "DSA");

        //Creating SecretKeyEntry object
        SecretKeyEntry secretKeyEntry = new SecretKeyEntry(mySecretKey);
        keyStore.setEntry("secretKeyAlias", secretKeyEntry, protectionParam);

        //Storing the KeyStore object
        java.io.FileOutputStream fos = null;
        fos = new java.io.FileOutputStream("newKeyStoreName");
        keyStore.store(fos, password);

        //Creating the KeyStore.SecretKeyEntry object
        SecretKeyEntry secretKeyEnt = (SecretKeyEntry) keyStore.getEntry("secretKeyAlias", protectionParam);

        //Creating SecretKey object
        SecretKey mysecretKey = secretKeyEnt.getSecretKey();
        System.out.println("Algorithm used to generate key : " + mysecretKey.getAlgorithm());
        System.out.println("Format used for the key: " + mysecretKey.getFormat());

    }

}
