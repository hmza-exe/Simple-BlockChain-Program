/**
 * The BasicChain class is used to test the blockchain implementation.
 * It creates a simple blockchain with three blocks and prints their hash values.
 */
public class BasicChain {
    
    /**
     * The main method is the entry point of the application.
     * It creates three blocks, each linked to the previous one,
     * and prints the hash value of each block.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        
        // Creates the genesis block (The first block in the blockchain)
        /**
         * Important Note: Since no other block exists before the genesis block,
         * the previous hash value is set to '0'. Subsequent blocks have their 
         * respective previous hashes correctly allocated.
         */
        Block genesisBlock = new Block("The first block in the blockchain!", "0");
        System.out.println("Hash value for the first block: " + genesisBlock.hash); 

        // Creates the second block, linked to the genesis block
        Block secondBlock = new Block("The second block in the blockchain!", genesisBlock.hash);
        System.out.println("Hash value for the second block: " + secondBlock.hash); 

        // Creates the third block, linked to the second block.
        Block thirdBlock = new Block("The first block in the blockchain!", secondBlock.hash);
        System.out.println("Hash value for the third block: " + thirdBlock.hash); 

    }

}
