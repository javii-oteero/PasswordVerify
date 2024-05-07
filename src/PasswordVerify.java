public class PasswordVerify {

    public static EsCorrecta verify(String password){
        StringBuilder sb = new StringBuilder();
        boolean length;
        length = password.length() >= 8;
        if (!length)
            sb.append("La contrasenya ha de tenir almenys 8 caràcters\n");
            sb.append("La contrasenya ha de contenir almenys 2 números\n");
            sb.append("La contrasenya ha de contenir almenys una lletra majúscula\n");
            sb.append("La contrasenya ha de contenir almenys un caràcter especial");
        return new EsCorrecta(false, sb.toString());
    }
}
