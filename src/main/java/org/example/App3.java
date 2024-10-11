package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App3 {
    public static void main(String[] args) {

        XmlCtrlDom dom = new XmlCtrlDom();
        Scanner entrada = new Scanner(System.in);
        File archivo = new File("./src/main/resources/ejercicio3.xml");



        try{
            Document document = dom.instanciarDocument(archivo);
            boolean salir = false;

            while (!salir){
                menu();
                System.out.print("Introduce la opción: ");
                int opcion = entrada.nextInt();

                switch (opcion){
                    case 1:

                        dom.escribirDocumentAXmlPantalla(document);

                        break;

                    case 2:

                        Node prestados = (Node)(XPathFactory.newInstance().newXPath().evaluate(
                                "/libros/prestamo", document, XPathConstants.NODE));
                        if (prestados!=null){
                            System.out.println(prestados.getTextContent());
                        }

                        break;

                    case 3:
                        Node venta = (Node)(XPathFactory.newInstance().newXPath().evaluate(
                                "/libros/venta", document, XPathConstants.NODE));
                        if (venta!=null){
                            System.out.println(venta.getTextContent());
                        }

                        break;



                    case 4:
                        salir=true;
                        break;
                }

            }

        } catch (IOException | ParserConfigurationException | SAXException | TransformerException |
                 XPathExpressionException e){
            throw new RuntimeException(e);
        }

    }

    public static void menu(){
        System.out.println("---------------------------------------------------");
        System.out.println("Opción 1.- Vista de todo el documento XML");
        System.out.println("Opción 2.- Listado de los libros prestados");
        System.out.println("Opción 3.- Listado de los libros en venta");
        System.out.println("Opción 4.- Salir");
        System.out.println("---------------------------------------------------");
    }
}
