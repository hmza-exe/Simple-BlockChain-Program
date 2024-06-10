import java.util.Date;

/**
 * The Block class represents a block in a blockchain.
 * It contains a hash, a reference to the previous block's hash, 
 * some data, and a timestamp.
*/
public class Block {
  /**
   * The Hash of this block that uniquely identifies it.
  */
  public String hash;

  /** 
   * The Hash of the previous block in the blockchain. 
  */
  public String previousHash;

  /**
   * The data stored in this block.
   * This can be any data relevant to the application using the blockchain. 
  */
  private String data;

  /**
   * The timestamp when this block was created, represented in milliseconds since the epoch.
  */
  private long timeStamp;

  private int num;

  /**
   * Constructs a new Block with the specified data and previous hash.
   * The current timestamp is recorded at the time of block creation.
   *
   * @param data The data to be stored in the block.
   * @param previousHash The hash of the previous block in the blockchain.
  */
  public Block(String data, String previousHash) {
    this.data = data;
    this.previousHash = previousHash;
    this.timeStamp = new Date().getTime();

    /**
     * It is important to perform this operation last.
     * The values of previousHash, timeStamp, and data
     * must be set first because the hash function
     * requires these values to calculate the hash.
     */
    this.hash = calculateHash();
  }

  /**
   * Calculates the hash of the block by applying the SHA-256 hash function
   * to the concatenation of the previous block's hash, the current timestamp, 
   * and the block's data.
   *
   * @return The calculated hash as a hexadecimal string.
   */
  public String calculateHash() {
    String calculatedHash = Utility.applySHA256(previousHash + Long.toString(timeStamp) + Integer.toString(num) + data);
    return calculatedHash;
  }

  public void mineBlock(int difficulty) {
    String target = new String(new char[difficulty]).replace("\0", "0");

    while (!hash.substring(0, difficulty).equals(target)) {
      num++;
      hash = calculateHash();
    }
    
    System.out.println("Block Mined!!! : " + hash);
  }

}
