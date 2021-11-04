package epam.java.chapter6.task3.client.validator;

/**
 * Класс для проверки вводиимых пользователем данных (при добавлении, удалении, поиске или изменении)
 */
public class Validator {
    private final String EMAIL_REG_EX = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";

    public Validator(){

    }

    public boolean validateEmail(String email) {
        boolean isValid;

        isValid = false;

        if (email.matches(EMAIL_REG_EX)){
            isValid = true;
        }

        return isValid;
    }
}
