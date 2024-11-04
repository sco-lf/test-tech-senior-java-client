package lesfurets.funnel;

public enum ESite {
    JMA("jma", "Jean Michel Assurance", 0);

    String code;
    String readable;
    int dbKey;

    private ESite(String code, String readable, int dbKey) {
        this.code = code;
        this.readable = readable;
        this.dbKey = dbKey;
    }

    public String getCode() {
        return code;
    }

    public String getReadable() {
        return readable;
    }

    public int getDbKey() {
        return dbKey;
    }
}
