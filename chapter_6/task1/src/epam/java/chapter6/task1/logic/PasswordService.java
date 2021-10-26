package epam.java.chapter6.task1.logic;

import epam.java.chapter6.task1.entity.user.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class PasswordService {

    PasswordService(){

    }

    boolean checkInputPassword(User user, String password){
        boolean isPasswordCorrect;
        String passwordHash;

        isPasswordCorrect = false;

        passwordHash = getSHA1Hash(password);

        if (passwordHash.equals(user.getPassword())){
            isPasswordCorrect = true;
        }

        return isPasswordCorrect;
    }

    String getSHA1Hash(String password){
        StringBuilder stringHashCode;
        byte[] bytes;
        MessageDigest messageDigest;

        stringHashCode = new StringBuilder();

        try {

            messageDigest = MessageDigest.getInstance("sha-1");
            bytes = messageDigest.digest(password.getBytes());

            for (byte b: bytes) {
                stringHashCode.append(String.format("%02x", b));
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return stringHashCode.toString();
    }
}
