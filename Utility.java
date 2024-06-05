import java.security.MessageDigest;

public class Utility {
    
    /**
     * Applies the SHA-256 hash function to the given input string 
     * and returns the resulting hash as a hexadecimal string.
     *
     * @param input The input string to hash.
     * @return The SHA-256 hash of the input string as a hexadecimal string.
     * @throws RuntimeException If an error occurs during hashing.
     */
    public static String applySHA256(String input) {
        try {
            // Create a MessageDigest instance of SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Apply the SHA-256 hash function to the input string
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            // Convert the hash bytes into a hexadecimal string
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);

                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            // Return the resulting hexadecimal string
            return hexString.toString();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
