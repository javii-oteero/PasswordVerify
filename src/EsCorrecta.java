public class EsCorrecta {
    private boolean correcta;
    private String error;

    public EsCorrecta(boolean correcta, String error){
        this.correcta = correcta;
        this.error = error;
    }

    public boolean isCorrecta() {
        return correcta;
    }

    public String getError() {
        return error;
    }
}
