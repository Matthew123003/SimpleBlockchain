public class Chain {
    public static void main(String[] args) {
        System.out.println("Chain");

        Blockchain<Block> chain = new Blockchain<Block>();
        Block tb, corruptThisBlock = null;

        tb = chain.addBlock("Send Kris $100.");

        corruptThisBlock = chain.addBlock("Buy a copy of US Constitution for $80000000.");

        tb = chain.addBlock("Work Hard at ZipCode");

        tb = chain.addBlock("Finish ZipCode");

        System.out.println("Final Blockchain");
        System.out.println(chain.toString());
        System.out.printf("Resultant Chain: %s\n\n", chain.isValid()? "IS VALID" : "ERROR is not VALID");

        corruptThisBlock.corruptData("BOGUS DATA");
        System.out.println("CORRUPTed the Blockchain");
        System.out.println(chain.toString());
        System.out.printf("Resultant Chain: %s\n\n", chain.isValid()? "IS VALID" : "ERROR is not VALID");

    }
}
