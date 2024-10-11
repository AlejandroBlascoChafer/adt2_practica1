package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;

public class App2 {
    public static void main(String[] args) {

        XmlCtrlDom dom = new XmlCtrlDom();


        try {
            Document document = dom.instanciarDocument();

            Element raiz = document.createElement("alumnos");
            document.appendChild(raiz);

            Element alumno1 = document.createElement("alumno");
            Element nuevoNombre1 = document.createElement("nombre");
            nuevoNombre1.setTextContent("Juan");
            alumno1.appendChild(nuevoNombre1);

            Element nuevoApellido1 = document.createElement("apellidos");
            nuevoApellido1.setTextContent("Martí López");
            alumno1.appendChild(nuevoApellido1);

            Element nuevaEdad1 = document.createElement("edad");
            nuevaEdad1.setTextContent("18");
            alumno1.appendChild(nuevaEdad1);

            raiz.appendChild(alumno1);


            Element alumno2 = document.createElement("alumno");
            Element nuevoNombre2 = document.createElement("nombre");
            nuevoNombre2.setTextContent("Amaparo");
            alumno2.appendChild(nuevoNombre2);

            Element nuevoApellido2 = document.createElement("apellidos");
            nuevoApellido2.setTextContent("Luna Dolores");
            alumno2.appendChild(nuevoApellido2);

            Element nuevaEdad2 = document.createElement("edad");
            nuevaEdad2.setTextContent("25");
            alumno2.appendChild(nuevaEdad2);

            raiz.appendChild(alumno2);

            dom.escribirDocumentAXmlFichero(document, new File("./src/main/resources/ejercicio2.xml"));



        } catch (Exception e){
            throw new RuntimeException(e);
        }


    }
}
