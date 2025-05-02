package dk.easv.exambelsign.DAL;

import at.favre.lib.crypto.bcrypt.BCrypt;


public class BCryptor {


    public static void main(String[] args) {

        String pw = "myadminpassword";

        System.out.println("BCrypt (192):\t" + bcryption(pw));
    }

    /**
     * BCrypt hash algorithm
     * @param password The input to the algorithm (typically a user password)
     * @return The final output (hash)
     */
    public static String bcryption(String password) {

        // Hash password using the specified cost
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());


        return bcryptHashString;
    }

    public static boolean checkPassword(String password, String bcryptHashString) {
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), bcryptHashString);
        System.out.println(result.verified);

        return result.verified;
    }



}
