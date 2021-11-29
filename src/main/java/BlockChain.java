import java.util.ArrayList;

// subclassing ArrayList here.
final class Blockchain<T> extends ArrayList<Block>{

    Blockchain() {
      Block genesisBlock = new Block("0", "{\"GenesisBlock\": \"true\"}");
      this.add(genesisBlock);
    }
  
    public Block addBlock(String data) {
      Block lastBlock = this.get(this.size()-1);
      Block newBlock = new Block(lastBlock.getHash(), data);
      newBlock.mine(2); // find a hash for new block
      this.add(newBlock);
      //System.out.printf("len: %d\n", this.size());
      return newBlock;
    }
  
    public boolean isValid() {
        if (this.size() == 1) {
            return true;
        }
        for (int i = 1; i < this.size(); i++) {
            Block currentBlock = this.get(i);
            Block previousBlock = this.get(i - 1);
            if (currentBlock.getHash() != currentBlock.calculateHash()) return false;
            if (currentBlock.getPreviousHash() != previousBlock.getHash()) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (Block block : this) {
            sb.append(block.toString());
        }
        sb.append("]\n");
        return sb.toString();
    }
  }