public class ValidationUtil {

    public static boolean isValid(String name, String email, String password, String dob) {

        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || dob.isEmpty()) {
            return false;
        }

        return true;
    }
}
