package epam.java.chapter6.task2.validator;

public class Validator {

    public Validator(){

    }

    public boolean isValidEmail(String email) {
        boolean isValid = false;

        if (email.matches("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$")){
            isValid = true;
        }

        return isValid;
    }
}
