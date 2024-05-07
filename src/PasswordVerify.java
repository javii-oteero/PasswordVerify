public class PasswordVerify {

    public static EsCorrecta verify(String password){
        StringBuilder sb = new StringBuilder();
        boolean length = password.length() >= 8;
        boolean nums = password.matches(".*[0-9].*[0-9].*");
        boolean mayus = password.matches(".*[A-Z].*");
        boolean especial = password.matches(".*[!@#%&/()=+?~–^].*");
        if (!length)
            sb.append("La contrasenya ha de tenir almenys 8 caràcters\n");
        if (!nums)
            sb.append("La contrasenya ha de contenir almenys 2 números\n");
        if (!mayus)
            sb.append("La contrasenya ha de contenir almenys una lletra majúscula\n");
        if (!especial)
            sb.append("La contrasenya ha de contenir almenys un caràcter especial");
        boolean correcta = length && nums && mayus && especial;
        return new EsCorrecta(correcta, sb.toString());
    }
}
