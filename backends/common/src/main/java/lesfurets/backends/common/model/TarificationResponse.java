package lesfurets.backends.common.model;

/**
 * Classe décrivant un retour de tarification : est mappée depuis la réponse json du Web Service
 * du partenaire
 */
public class TarificationResponse {
    private int returnCode;
    private String payload;
    private Prime prime;

    public TarificationResponse(int returnCode, String message) {
        this.returnCode = returnCode;
        this.payload = message;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public String getPayload() {
        return payload;
    }

    public Prime getPrime() {
        return prime;
    }

    public void setPrime(Prime prime) {
        this.prime = prime;
    }
}
