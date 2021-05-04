/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Orginal_Project;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
class encryption {
    String key;
    Cipher cipher;
    Key aesKey;
    encryption () {
        try    
        {
            key = "Bar12345Bar12345"; // 128 bit key
            // Create key and cipher
            aesKey = new SecretKeySpec(key.getBytes(), "AES");
            cipher = Cipher.getInstance("AES");
            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public String encrypt(String text) {
        try
        {
            // String text = "Hello World";
            byte[] encrypted = cipher.doFinal(text.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : encrypted) {
                sb.append((char) b);
            }
            // the encrypted String
            String enc = sb.toString();
            return enc;
        }catch(Exception exe) {
          //  System.out.println(exe);
            return null;
        }
    }
    public String decrypt(String enc) {
        try {
            // now convert the string to byte array
            // for decryption
            byte[] bb = new byte[enc.length()];
            for (int i = 0; i < enc.length(); i++) {
                bb[i] = (byte) enc.charAt(i);
            }

            // decrypt the text
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            String decrypted = new String(cipher.doFinal(bb));
        //    System.err.println("decrypted:" + decrypted);
            return decrypted;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
        String text=new encryption().encrypt("mugi");
        System.out.println(text);
        String res=new encryption().decrypt(text);
        System.out.println(res);
    }
}
