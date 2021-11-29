import java.util.Date;

// unit testing this class requires that you "wire" the date assigned to the Block.
// otherwise you have no way of ensuring what the hash will be.
// So we have two constructors, one for use and one for testing. the normal one calls the testing one.

public class Block {
    private String data = ""; // JSON string of a transaction
    private String hash = null;
    private String previousHash = null;
    private Date timeStamp = null;
    private Integer proofOfWork = 0;

    Block(String previousHash, String data) {
        this(previousHash, data, false);
    }

    // the fakeDate, if true becomes "new Date(1)" 1 millisecond after "the UNIX epoch", namely January 1, 1970 at midnight plus 1ms;
    // this is here for unit testing. notice "protected" class.
    protected Block(String previousHash, String data, Boolean fakeDate) {
        this.data = data;
        this.hash = this.calculateHash();
        this.previousHash = previousHash;
        this.timeStamp = !fakeDate ? new Date() : new Date(1);
        this.proofOfWork = 0;
    }

    public String calculateHash() {
        return ShaUtils.hash(this.previousHash + 
        this.data +
        this.timeStamp +
        this.proofOfWork);
    }

    public String mine(Integer difficulty) {
        while (!this.hash.startsWith("0".repeat(difficulty))) {
          this.proofOfWork++;
          this.hash = this.calculateHash();
        }
        return this.hash;
    }

    public String getHash() {
        return this.hash;
    }
    public String getPreviousHash() {
        return this.previousHash;
    }

    public void corruptData(String newCorruptData) {
        System.err.println("Alert!: corrupting a Block instance");
        this.data = newCorruptData;
        System.err.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("block:\n\tdata: ");
        sb.append(this.data);
        sb.append("\n\thash: ");
        sb.append(this.hash);
        sb.append("\n\tprevious hash: ");
        sb.append(this.previousHash);
        sb.append("\n\ttimestamp: ");
        sb.append(this.timeStamp);
        sb.append("\n\tproof of work: ");
        sb.append(this.proofOfWork);
        sb.append("\n");
        return sb.toString();
    }
   
}
