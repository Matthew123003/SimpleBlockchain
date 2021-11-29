import java.util.Date;

public class Block {
    private String data = ""; // JSON string of a transaction
    private String hash = null;
    private String previousHash = null;
    private Date timeStamp = null;
    private Integer proofOfWork = 0;

    Block(String previousHash, String data) {
        this.data = data;
        this.hash = this.calculateHash();
        this.previousHash = previousHash;
        this.timeStamp = new Date();
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
