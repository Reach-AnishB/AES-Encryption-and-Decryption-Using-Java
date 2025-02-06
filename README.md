# AES-Encryption-and-Decryption-Using-Java
This project demonstrates the implementation of AES(Advanced Encryption Standard) encryption and decryption using Java. The implementation consists of three steps- key generation, encryption and decryption. Uses Java's Cryptography Architecture(JCA) to bridge the gap between theoretical concepts of cryptography and hands-on-implementation 

// JAVA CODE STARTS HERE

// Here's a piece of code which debugs a set of input already present and does not take any user input -

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class AESEncryptionExample
{
  public static void main(String[] args) throws Exception
  {
    // Generate a secret key for AES encryption
    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
    keyGenerator.init(256); // 256-bit key size
    SecretKey secretKey = keyGenerator.generateKey();
    
    // Create an AES cipher instance
    Cipher cipher = Cipher.getInstance("AES");
    // Initialize the cipher for encryption using the secret key
    cipher.init(Cipher.ENCRYPT_MODE, secretKey);
    
    // Plaintext to be encrypted
    String plaintext = "Hello, Symmetric Cryptography in Java!";
    
    // Encrypt the plaintext
    byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
    // Encode the encrypted bytes to Base64 for readability
    String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
    System.out.println("Encrypted Text (AES): " + encryptedText);
    
    // Initialize the cipher for decryption using the same secret key
    cipher.init(Cipher.DECRYPT_MODE, secretKey);
    
    // Decrypt the encrypted bytes
    byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
    // Convert the decrypted bytes back to plaintext
    String decryptedText = new String(decryptedBytes);
    System.out.println("Decrypted Text (AES): " + decryptedText);
    }
}

// Now, following is the code for the encryption and decryption of data for any user input given -

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class AESExample {
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    // Take user input
    System.out.println("Enter text to encrypt: ");
    String data = scanner.nextLine();
    
    // Generate AES key
    SecretKey key = generateKey();
    
    // Encrypt the data
    String encryptedData = encrypt(data, key);
    System.out.println("Encrypted Data: " + encryptedData);
    
    // Decrypt the data
    String decryptedData = decrypt(encryptedData, key);
    System.out.println("Decrypted Data: " + decryptedData);
    scanner.close();
}

  // Generate AES Key
  private static SecretKey generateKey() throws Exception {
    KeyGenerator keyGen = KeyGenerator.getInstance("AES");
    keyGen.init(128); // 128-bit key
    return keyGen.generateKey();
  }
  
  // Encrypt Data
  private static String encrypt(String data, SecretKey key) throws Exception {
    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(Cipher.ENCRYPT_MODE, key);
    byte[] encryptedBytes = cipher.doFinal(data.getBytes());
    return Base64.getEncoder().encodeToString(encryptedBytes);
  }
  
  // Decrypt Data
  private static String decrypt(String encryptedData, SecretKey key) throws Exception {
    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(Cipher.DECRYPT_MODE, key);
    byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
    return new String(decryptedBytes);
  }
}

Find the execution used NetBeans IDE and a detailed report in the files uploaded. Thank You.
