public class Codec {
    static final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789#$&";
    HashMap<String, String> codeDB = new HashMap<>();
    HashMap<String, String> urlDB = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String getCode() {
        char code[] = new char[6];
        for (int i=0; i<6; i++) {
            code[i] = chars.charAt((int)(Math.random()*65));
        }
        return "https://www.tinyurl.com/" + String.valueOf(code);
    }
    public String encode(String longUrl) {
        if (urlDB.containsKey(longUrl)) {
            return urlDB.get(longUrl);
        }
        String code = getCode();
        while (codeDB.containsKey(code)) {
            code = getCode();
        }
        codeDB.put(code, longUrl);
        urlDB.put(longUrl, code);

        return code;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if (codeDB.containsKey(shortUrl)) {
            return codeDB.get(shortUrl);
        }
        return "";
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));