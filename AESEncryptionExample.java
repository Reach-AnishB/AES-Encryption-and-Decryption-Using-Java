/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aesencryptionexample;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import java.util.Base64;

public class AESEncryptionExample 
{
    public static void main(String[] args)
            throws Exception {
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
