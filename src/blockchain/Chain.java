package blockchain;

public class Chain {
    Block [] chain;
    int blockCount = 0;

    public Chain () {
        this.chain = new Block [1];
        this.chain[0] = new Block("Genenis Block", "Genenis Block");
        mine(this.chain[0]);
        blockCount++;
    }

    public void addBlock (String data) {
        Block [] chain = new Block [blockCount + 1];

        for (int i = 0; i < blockCount; i++) {
            chain[i] = this.chain[i];
        }

        chain[blockCount] = new Block(data, this.chain[blockCount - 1].getHash());
        mine(chain[blockCount]);
        blockCount++;
        this.chain = chain;
    }

    public void mine (Block block) {
        while (true) {
            if (checkUniqueness(block))
                break;
        }
    }

    public boolean checkUniqueness(Block block) {
        String hash = block.hash();

        for (int i = 0; i < blockCount; i++) {
            if (hash == chain[i].getHash() || block.getNonce() == chain[i].getNonce() || !hash.startsWith("0000")) {
                block.incrementNonce();
                
                return false;
            }
        }

        return true;
    }

    public void print () {
        for (Block block : chain) {
            block.print();
        }
    }
}