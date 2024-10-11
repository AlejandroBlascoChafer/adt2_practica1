package org.example;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IO;
import java.io.IOException;

public class App4 {
    public static void main(String[] args) {

        XmlCtrlDom dom = new XmlCtrlDom();
        File archivo = new File("./src/main/resources/ejercicio4.xml");
        try {
            Document document = dom.instanciarDocument(archivo);

        } catch (IOException | ParserConfigurationException | SAXException e){
            throw new RuntimeException(e);
        }

    }
}
