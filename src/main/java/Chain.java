public class Chain {
    public static void main(String[] args) {
        System.out.println("Chain");

        Blockchain<Block> chain = new Blockchain<Block>();
        Block tb = null;

        tb = chain.addBlock("Send Kris $100.");

        tb = chain.addBlock("Buy a copy of US Constitution for $80000000.");

        tb = chain.addBlock("Finish ZipCode");

        System.out.println("Resultant Chain:");
        System.out.println(chain.toString());
    }
}
