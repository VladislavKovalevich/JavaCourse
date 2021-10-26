package epam.java.chapter6.task3.server.dao;

import epam.java.chapter6.task3.server.config.Config;
import epam.java.chapter6.task3.server.entity.User;
import epam.java.chapter6.task3.server.entity.UserType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class UserBaseDAO {
    private final String RESOURCE_USERS_LIST = "usersBase.xml";

    UserBaseDAO(){

    }

    public ArrayList<User> getUsersListFromXMLFile(){
        ArrayList<User> users;
        Document document;

        users = new ArrayList<>();
        document = getXMLDocument(Config.getRootPath() + RESOURCE_USERS_LIST);

        if (document != null){
            NodeList nodeList;

            nodeList = document.getElementsByTagName("user");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node;

                node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element element;
                    User user;
                    int id;

                    element = (Element) node;
                    user = new User();
                    id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());

                    user.setId(id);
                    user.setEmail(element.getElementsByTagName("email").item(0).getTextContent());
                    user.setPassword(element.getElementsByTagName("password").item(0).getTextContent());
                    user.setUserType(UserType.valueOf(element.getElementsByTagName("role").item(0).getTextContent().toUpperCase()));

                    users.add(user);
                }
            }
        }

        return users;
    }

    private Document getXMLDocument(String path){
        DocumentBuilderFactory builderFactory;
        Document document = null;
        java.io.File file;

        file = new java.io.File(path);
        builderFactory = DocumentBuilderFactory.newInstance();

        try {
            document = builderFactory.newDocumentBuilder().parse(file);
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }

        return document;
    }
}
