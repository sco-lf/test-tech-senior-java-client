package lesfurets.auto.model;

public class TarifList {
    int code;
    String message;

    public TarifList(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
