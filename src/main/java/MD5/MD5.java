package MD5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5 {
    public static String md5(String input) {

        String md5 = null;
        String solomiia = "1cfa36608317d43a4633ee6637480ebe";
        if (null == input) return null;

        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            String inp = input + solomiia;
            digest.update(inp.getBytes(), 0, inp.length());
            md5 = new BigInteger(1, digest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5;
    }
}
