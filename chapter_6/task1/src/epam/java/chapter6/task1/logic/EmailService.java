package epam.java.chapter6.task1.logic;

import epam.java.chapter6.task1.entity.Library;
import epam.java.chapter6.task1.entity.book.Book;
import epam.java.chapter6.task1.entity.user.User;
import epam.java.chapter6.task1.entity.user.UserType;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Properties;

public class EmailService {
    public void notifyAdminAboutNewBook(Book book){
        Properties properties;
        Session session;
        MimeMessage message;
        Library library;

        library = Library.getInstance();
        properties = System.getProperties();

        properties.setProperty("mail.transport.protocol", "smtps");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.setProperty("mail.smtp.user", library.getAuthorizedUser().getEmail());

        try {
            session = Session.getDefaultInstance(properties);
            message = new MimeMessage(session);

            message.setFrom(new InternetAddress(library.getAuthorizedUser().getEmail()));
            message.setRecipients(Message.RecipientType.TO, getUsersEmails(UserType.ADMINISTRATOR));
            message.setSubject("Предложение для добавления новой книги");
            message.setText("Информация о предложенной книге:"+
                    "Название: " + book.getName() + "\n" +
                    "Автор: " +book.getAuthor() + "\n" +
                    "Год издания: " +book.getYear() + "\n" +
                    "Описание: " +book.getDescription() + "\n" +
                    "Тип книги: " +book.getBookType());

            Transport tr = session.getTransport();

            tr.connect(null, "123");
            tr.sendMessage(message, message.getAllRecipients());
            tr.close();
        } catch (MessagingException e) {
            //e.printStackTrace();
            System.out.println("Отправка сообщения администраторам");
        }
    }

    public void notifyAllUsersAboutNewAddedBook(Library library, Book book){
        Properties properties;
        Session session;
        MimeMessage message;

        properties = System.getProperties();

        properties.setProperty("mail.transport.protocol", "smtps");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.setProperty("mail.smtp.user", library.getAuthorizedUser().getEmail());

        try {
            session = Session.getDefaultInstance(properties);
            message = new MimeMessage(session);

            message.setFrom(new InternetAddress(library.getAuthorizedUser().getEmail()));
            message.setRecipients(Message.RecipientType.TO, getUsersEmails(UserType.USER));
            message.setSubject("Добавление книги");
            message.setText("В библиотеку была добавлена книга:"+
                    "Название: " + book.getName() + "\n" +
                    "Автор: " +book.getAuthor() + "\n" +
                    "Год издания: " +book.getYear() + "\n" +
                    "Описание: " +book.getDescription() + "\n" +
                    "Тип книги: " +book.getBookType());

            Transport tr = session.getTransport();

            tr.connect(null, "123");
            tr.sendMessage(message, message.getAllRecipients());
            tr.close();
        } catch (MessagingException e) {
            //e.printStackTrace();
            System.out.println("Отправка сообщения пользователям");
        }
    }

    public Address[] getUsersEmails(UserType userType){
        ArrayList<String> emails;
        Address[] addresses;

        emails = new ArrayList<>();

        for (User user : Library.getInstance().getUsers()) {
            if(user.getRole().equals(userType)){
                emails.add(user.getEmail());
            }
        }

        addresses = new Address[emails.size()];

        try {
            addresses = InternetAddress.parse(emails.toString().substring(1, emails.toString().length() - 1));
        } catch (AddressException e) {
            e.printStackTrace();
        }

        return addresses;
    }
}
