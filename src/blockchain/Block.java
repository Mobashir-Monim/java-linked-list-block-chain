package blockchain;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Block {
    protected String data;
    private Long nonce;
    public String hash;
    public String prevHash;
    MessageDigest digest;

    public Block (String data, String prevHash) {
        this.data = data;
        this.prevHash = prevHash;
        this.nonce = 0L;
    }

    // Custom Functions
    public String hash () {
        try {
            String data = "{data: " + getData() + ", nonce:" + getNonce() + ", prevHash:" + getPrevHash() + "}";
            digest = MessageDigest.getInstance("SHA-256");
            this.hash = byteToHex(digest.digest(data.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return this.hash;
    }

    public String byteToHex(byte [] num) {
        String hash = "";

        for (byte b : num) {
            char[] hexDigits = new char[2];
            hexDigits[0] = Character.forDigit((b >> 4) & 0xF, 16);
            hexDigits[1] = Character.forDigit((b & 0xF), 16);
            hash += new String(hexDigits);
        }

        this.hash = hash;

        return hash;
    }

    // Setter Functions
    public void setHash (String hash) {
        this.hash = hash;
    }

    public void incrementNonce () {
        this.nonce++;
    }

    // Getter Functions
    public String getData () {
        return this.data;
    }

    public Long getNonce () {
        return this.nonce;
    }
    
    public String getHash () {
        return this.hash;
    }

    public String getPrevHash () {
        return this.prevHash;
    }

    public void print() {
        System.out.println("{\n\tdata: " + getData() + ",\n\tnonce: " + getNonce() + ",\n\tprevHash: " + getPrevHash() + ",\n\thash: " + getHash() + "\n},");
    }
}