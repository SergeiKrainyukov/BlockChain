import java.util.Date;

public class Block {
    private String currentBlockHash;
    private String previousBlockHash;
    private int index;
    private Date date;
    private String data;
    private int nonce;

    public Block(String currentBlockHash, String previousBlockHash, int index, Date date, String data, int nonce) {
        this.currentBlockHash = currentBlockHash;
        this.previousBlockHash = previousBlockHash;
        this.index = index;
        this.date = date;
        this.data = data;
        this.nonce = nonce;
    }

    public String getCurrentBlockHash() {
        return currentBlockHash;
    }

    public void setCurrentBlockHash(String currentBlockHash) {
        this.currentBlockHash = currentBlockHash;
    }

    public String getPreviousBlockHash() {
        return previousBlockHash;
    }

    public void setPreviousBlockHash(String previousBlockHash) {
        this.previousBlockHash = previousBlockHash;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }
}
