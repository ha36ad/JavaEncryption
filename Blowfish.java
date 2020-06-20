import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
public class Blowfish {

    public static void main(String[] args) throws Exception {
       //Asks user for a message
        Scanner InputMessage = new Scanner(System.in);
        System.out.println("Enter message");
        String Message = InputMessage.nextLine();  
        System.out.println("Your message in plaintext is: " + Message);
       
      //Key generation
        KeyGenerator kgen = KeyGenerator.getInstance("Blowfish");
        SecretKey skey = kgen.generateKey();
        byte[] skeyb = skey.getEncoded();
        SecretKeySpec secretkey = new SecretKeySpec(skeyb, "Blowfish");

      //Encryption
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, secretkey);
        byte[] encrypted = cipher.doFinal(Message.getBytes());
        Base64.Encoder encoder = Base64.getEncoder();
        encrypted_msg = new String(encoder.encode(encrypted));
        System.out.println("Your encoded message is: " + encrypted_msg);
                           
     //Decryption
        cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.DECRYPT_MODE,secretkey);
        byte[] decrypted = cipher.doFinal(encrypted_msg.getBytes());
        Base64.Decoder decoder = Base64.getDecoder();
        decrypted_String = new String(decoder.decode(decrypted));        
        System.out.println("Your message in plaintext is: " + decrypted);
                                          
}
}
        
