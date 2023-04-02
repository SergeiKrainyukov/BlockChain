import java.util.*;

public class Blockchain {
    private List<Block> blocks;
    private final String ending;

    public Blockchain(String ending) {
        this.ending = ending;
        blocks = new ArrayList<>();
        blocks.add(new Block("00000" + ending, null, 0, new Date(), "block 1", 123));
    }

    public String calculateHashWithoutNonce(String previousHash, String data, int index, Date date) {
        return String.valueOf(Objects.hash(previousHash, data, index, date));
    }

    public String calculateHashWithNonce(String previousHash, String data, int index, Date date, int nonce) {
        int hashCode = Objects.hash(previousHash, data, index, date, nonce);
        while (!String.valueOf(hashCode).substring(String.valueOf(hashCode).length() - ending.length()).equals(ending)) {
            hashCode = Objects.hash(previousHash, data, index, date, new Random().nextInt());
            while (String.valueOf(hashCode).length() <= ending.length()) {
                hashCode = Objects.hash(previousHash, data, index, date, new Random().nextInt());
            }
        }
        return String.valueOf(hashCode);
    }

    public int calculateNonce(String hash, String data, int index, Date date) {
        int hashCode = Objects.hash(hash, data, index, date);
        int nonce = 0;
        while (!String.valueOf(hashCode).substring(String.valueOf(hashCode).length() - ending.length()).equals(ending)) {
            nonce = new Random().nextInt();
            hashCode = Objects.hash(hash, data, index, date, nonce);
            while (String.valueOf(hashCode).length() <= ending.length()) {
                nonce = new Random().nextInt();
                hashCode = Objects.hash(hash, data, index, date, nonce);
            }
        }
        return nonce;
    }

    public Block addNewBlock(String data) {
        Block lastBlock = blocks.get(blocks.size() - 1);
        Date currentDate = new Date();
        String hash = calculateHashWithNonce(lastBlock.getCurrentBlockHash(), data, lastBlock.getIndex(), currentDate, 123);
        int nonce = calculateNonce(hash, data, lastBlock.getIndex() + 1, currentDate);
        return new Block(hash, lastBlock.getCurrentBlockHash(), lastBlock.getIndex() + 1, currentDate, data, nonce);
    }

    public Block findBlockByHash(String hash) {
        for (Block block : blocks) {
            if (block.getCurrentBlockHash().equals(hash)) return block;
        }
        return null;
    }

    public boolean checkIsBlockchainCorrect() {
        for (Block block : blocks) {
            if (!(block.getCurrentBlockHash().substring(block.getCurrentBlockHash().length() - ending.length())).equals(ending))return false;
        }
        return true;
    }
}
