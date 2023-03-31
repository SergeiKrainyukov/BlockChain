import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Blockchain {
    private List<Block> blocks;

    public Blockchain() {
        blocks = new ArrayList<>();
        blocks.add(new Block("00000", null, 0, new Date(), "block 1", 3));
    }

    private long md5(String previousHash, String data, int index, Date date) {
        String hashCode = "1111";
        String ending = "000";
        while (!hashCode.substring(hashCode.length() - 3).equals(ending)) {
            hashCode = String.valueOf(Objects.hash(previousHash, data, index, date));
        }
        return Integer.parseInt(hashCode);
    }
}
