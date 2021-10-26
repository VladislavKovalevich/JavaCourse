package epam.java.chapter6.task3.client.validator;

/**
 * Класс для проверки вводиимых пользователем данных (при добавлении, удалении, поиске или изменении)
 */
public class Validator {
    public Validator(){

    }

    public boolean validateEmail(String email) {
        boolean isValid = false;

        if (email.matches("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$")){
            isValid = true;
        }

        return isValid;
    }
}
