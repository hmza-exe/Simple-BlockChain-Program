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
  }
}