/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storingkeys;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author asalah
 */
public class StoringKeys {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws KeyStoreException, FileNotFoundException, IOException, NoSuchAlgorithmException, CertificateException {

        //Creating the KeyStore object
        KeyStore keyStore = KeyStore.getInstance("JCEKS");

        //Loading the KeyStore object
        char[] password = "changit".toCharArray();
        String path = "C:\\Program Files\\Java\\jre1.8.0_131\\lib\\security\\cacerts";
        java.io.FileInputStream fis = new FileInputStream(path);
        keyStore.load(fis, password);

        //Creating the KeyStore.ProtectionParameter object
        KeyStore.ProtectionParameter protectionParam = new KeyStore.PasswordProtection(password);
        //Creating SecretKey object
        SecretKey mySecretKey = new SecretKeySpec("123456".getBytes(), "DSA");

        //Creating SecretKeyEntry object
        KeyStore.SecretKeyEntry secretKeyEntry = new KeyStore.SecretKeyEntry(mySecretKey);
        keyStore.setEntry("secretKeyAlias", secretKeyEntry, protectionParam);

        //Storing the KeyStore object
        java.io.FileOutputStream fos = null;
        fos = new java.io.FileOutputStream("newKeyStoreName");
        keyStore.store(fos, password);
        System.out.println("data stored");
    }

}
