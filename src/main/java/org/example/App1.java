package org.example;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

public class App1 {
    public static void main(String[] args) {

        XmlCtrlDom dom = new XmlCtrlDom();
        File archivo = new File("./src/main/resources/ejercicio1.xml");

        try {
            Document document = dom.instanciarDocument(archivo);

            Element root = document.getDocumentElement();

            NodeList listaNodos = document.getElementsByTagName("prestamo");
            Node prestamo = listaNodos.item(0);

            Element nuevoLibro = document.createElement("libro");
            nuevoLibro.setAttribute("isbn", "123456789");

            Element nuevoTitulo = document.createElement("titulo");
            nuevoTitulo.setTextContent("Título de ejemplo");
            nuevoLibro.appendChild(nuevoTitulo);

            Element nuevoAutor = document.createElement("autor");
            nuevoAutor.setTextContent("Autor de ejemplo");
            nuevoLibro.appendChild(nuevoAutor);

            Element nuevoAnyo = document.createElement("anyo");
            nuevoAnyo.setTextContent("Anyo de ejemplo");
            nuevoLibro.appendChild(nuevoAnyo);

            Element nuevoEditorial = document.createElement("editorial");
            nuevoEditorial.setTextContent("Editorial de ejemplo");
            nuevoLibro.appendChild(nuevoEditorial);

            prestamo.appendChild(nuevoLibro);


            dom.escribirDocumentAXmlFichero(document, new File("./src/main/resources/ejercicio1Final.xml"));








        } catch (ParserConfigurationException | IOException | SAXException | TransformerException e) {
            throw new RuntimeException(e);
        }


    }
}