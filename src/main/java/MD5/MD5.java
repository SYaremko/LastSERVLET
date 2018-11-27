package MD5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5 {
    public static String md5(String input) {

        String md5 = null;
        String solomiia = "1cfa36608317d43a4633ee6637480ebe";

        if(null == input) return null;

        try {

            //Create MessageDigest object for MD5
            MessageDigest digest = MessageDigest.getInstance("MD5");
            String inp = input+solomiia;
            //Update input string in message digest
            digest.update(inp.getBytes(), 0, inp.length());

            //Converts message digest value in base 16 (hex)
            md5 = new BigInteger(1, digest.digest()).toString(16);

        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();
        }
        return md5;
    }
}
