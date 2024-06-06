import java.util.ArrayList;
import com.google.gson.GsonBuilder;

/**
 * The BasicChain class is used to test the blockchain implementation.
 * It creates a simple blockchain with three blocks and prints their hash values.
 */
public class BasicChain {

    // An arraylisyt to store the blockchain. Every element is a block
    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    
    /**
     * The main method is the entry point of the application.
     * It creates three blocks, each linked to the previous one,
     * adds them to the blockchain, and prints the blockchain in JSON format.
     */
    public static void main(String[] args) {
        
        // Add the genesis block to the blockchain.
        blockchain.add(new Block("This is the genesis block!", "0"));
        // Add the second block to the blockchain.
        blockchain.add(new Block("This is the second block!", blockchain.get(blockchain.size() - 1).hash));
        // Add the third block to the blockchain.
        blockchain.add(new Block("This is the third block!", blockchain.get(blockchain.size() - 1).hash));

        // Convert the blockchain into Pretty-printed JSON format and print it.
        String blockchainJSON = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockchainJSON);

    }

}
