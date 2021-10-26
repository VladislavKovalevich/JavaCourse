package epam.java.chapter6.task3.server.dao;


import epam.java.chapter6.task3.server.config.Config;
import epam.java.chapter6.task3.server.entity.File;
import epam.java.chapter6.task3.server.entity.FileBase;
import epam.java.chapter6.task3.server.entity.Student;
import epam.java.chapter6.task3.server.entity.TestSubjectType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FilesBaseDAO {
    private final String RESOURCE_FILES_LIST = "filesBase.xml";

    FilesBaseDAO(){

    }

    public ArrayList<File> getFilesFromXMLFile(){
        ArrayList<File> filesList;
        Document document;

        filesList = new ArrayList<>();
        document = getXMLDocument(Config.getRootPath() + RESOURCE_FILES_LIST);

        if (document != null){
            NodeList nodeList;

            nodeList = document.getElementsByTagName("file");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node;

                node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    File file;
                    int id;

                    file = new File();
                    id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());

                    file.setId(id);
                    file.setStudent(getStudentInfoFromXMLElement(element));
                    file.setSubjectMap(getMapFromXMLElement(element));

                    filesList.add(file);
                }
            }
        }

        return filesList;
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

    private Student getStudentInfoFromXMLElement(Element element){
        Student student;
        int groupNumber;
        Date birthDate = null;

        student = new Student();

        groupNumber = Integer.parseInt(element.getElementsByTagName("group-id").item(0).getTextContent());
        student.setGroupNumber(groupNumber);
        student.setName(element.getElementsByTagName("name").item(0).getTextContent());
        student.setSurname(element.getElementsByTagName("surname").item(0).getTextContent());

        try {
            birthDate = Student.simpleDateFormat.parse(element.getElementsByTagName("birth-date").item(0).getTextContent());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        student.setBirthDate(birthDate);

        return student;
    }

    private HashMap<TestSubjectType, Integer> getMapFromXMLElement(Element element){
        HashMap<TestSubjectType, Integer> map = new HashMap<>();
        int languageNote;
        int mathNote;
        int physicsNote;

        languageNote = Integer.parseInt(element.getElementsByTagName("language").item(0).getTextContent());
        mathNote = Integer.parseInt(element.getElementsByTagName("math").item(0).getTextContent());
        physicsNote = Integer.parseInt(element.getElementsByTagName("physics").item(0).getTextContent());

        map.put(TestSubjectType.LANGUAGE, languageNote);
        map.put(TestSubjectType.MATH, mathNote);
        map.put(TestSubjectType.PHYSICS, physicsNote);

        return map;
    }

    public void saveFilesToXMLFile(){
        DocumentBuilderFactory factory;
        DocumentBuilder documentBuilder;
        FileBase fileBase;
        Document document = null;
        Element rootElement;

        factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();

            document = documentBuilder.newDocument();
            fileBase = FileBase.getInstance();
            rootElement = document.createElement("files");

            document.appendChild(rootElement);

            for (File file : fileBase.getFiles()) {
                rootElement.appendChild(getFileElement(document, file));
            }

            TransformerFactory transformerFactory;
            Transformer transformer;
            StreamResult streamResult;
            DOMSource domSource;

            transformerFactory = TransformerFactory.newInstance();

            transformer = transformerFactory.newTransformer();
            streamResult = new StreamResult(new java.io.File(Config.getRootPath() + RESOURCE_FILES_LIST));
            domSource = new DOMSource(document);

            transformer.transform(domSource, streamResult);

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }

    }

    private Node getFileElement(Document document, File file) {
        Element fileElem;
        Element idElem;

        fileElem = document.createElement("file");
        idElem = document.createElement("id");

        idElem.appendChild(document.createTextNode(Integer.toString(file.getId())));

        fileElem.appendChild(idElem);
        fileElem.appendChild(getXmlFromStudent(document, file.getStudent()));
        fileElem.appendChild(getXMLFromTestResult(document, file.getSubjectMap()));

        return fileElem;
    }

    private Node getXMLFromTestResult(Document document, Map<TestSubjectType, Integer> subjectMap) {
        Element testResultElem;

        testResultElem = document.createElement("test-result");

        Element mathElement  = document.createElement("math");
        mathElement.appendChild(document.createTextNode(subjectMap.get(TestSubjectType.MATH).toString()));

        Element languageElement  = document.createElement("language");
        languageElement.appendChild(document.createTextNode(subjectMap.get(TestSubjectType.LANGUAGE).toString()));

        Element physicsElement  = document.createElement("physics");
        physicsElement.appendChild(document.createTextNode(subjectMap.get(TestSubjectType.PHYSICS).toString()));

        testResultElem.appendChild(mathElement);
        testResultElem.appendChild(physicsElement);
        testResultElem.appendChild(languageElement);

        return testResultElem;
    }

    private Node getXmlFromStudent(Document document, Student student) {
        Element studentElem;

        studentElem = document.createElement("student");

        Element nameElement  = document.createElement("name");
        nameElement.appendChild(document.createTextNode(student.getName()));

        Element surnameElement  = document.createElement("surname");
        surnameElement.appendChild(document.createTextNode(student.getSurname()));

        Element groupIdElement  = document.createElement("group-id");
        groupIdElement.appendChild(document.createTextNode(Integer.toString(student.getGroupNumber())));

        Element birthDateElement = document.createElement("birth-date");
        birthDateElement.appendChild(document.createTextNode(Student.simpleDateFormat.format(student.getBirthDate())));

        studentElem.appendChild(nameElement);
        studentElem.appendChild(surnameElement);
        studentElem.appendChild(groupIdElement);
        studentElem.appendChild(birthDateElement);

        return studentElem;
    }
}
