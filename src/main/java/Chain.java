public class Chain {
    public static void main(String[] args) {
        Chain.chain1();
        Chain.chain2();
    }

    private static void chain1() {
        // show a normal blockchain
        System.out.println("Chain");

        Blockchain<Block> chain = new Blockchain<Block>();
        Block tb = null;

        tb = chain.addBlock("{Deposit: $100.00 to: Jim's Account}");

        tb = chain.addBlock("{Transfer: $50.00 from: Jim's Account to: Joan's Account}");

        tb = chain.addBlock("{Withdraw: $10.00 from: Joan's Account}");

        tb = chain.addBlock("{Transfer: $20.00 from: Joan's Account to: Kim's Account}");

        // Output the state of the chain.
        System.out.println("Final Blockchain");
        System.out.println(chain.toString());
        System.out.printf("Resultant Chain: %s\n\n", chain.isValid()? "IS VALID" : "ERROR is not VALID");

    }

    public static void chain2() {
        // create a chain, and then corrupt it
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
