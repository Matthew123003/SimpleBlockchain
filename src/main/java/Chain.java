public class Chain {
    public static void main(String[] args) {
        System.out.println("Chain");

        Blockchain<Block> chain = new Blockchain<Block>();
        Block tb, targetBlock = null;

        tb = chain.addBlock("Apply to Zip Code");

        targetBlock = chain.addBlock("Buy a copy of US Constitution for $80000000.");

        tb = chain.addBlock("Work Hard at ZipCode");

        tb = chain.addBlock("Finish ZipCode");

        // Output the state of the chain.
        System.out.println("Final Blockchain");
        System.out.println(chain.toString());
        System.out.printf("Resultant Chain: %s\n\n", chain.isValid()? "IS VALID" : "ERROR is not VALID");

        // NOW, corrupt one of the blocks. this should never happen.
        // It bothers me to even put a way to corrupt the block in the Block class.
        // but it is a good way to show how the validity of the chain get broken.

        targetBlock.corruptData("BOGUS DATA");
        System.out.println("CORRUPTed the Blockchain");
        System.out.println(chain.toString());
        System.out.printf("Resultant Chain: %s\n\n", chain.isValid()? "IS VALID" : "ERROR is not VALID");

    }
}
