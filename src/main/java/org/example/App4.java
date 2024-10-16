package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;

public class App4 {
    public static void main(String[] args) {

        XmlCtrlDom dom = new XmlCtrlDom();
        File archivo = new File("./src/main/resources/ejercicio4.xml");
        ArrayList<Alumnos> alumnos = new ArrayList<>();
        try {
            Document document = dom.instanciarDocument(archivo);

            NodeList listaNodos = document.getElementsByTagName("alumne");

            for (int i = 0; i < listaNodos.getLength(); i++) {
                Element nodo = (Element) listaNodos.item(i);

                int id = Integer.parseInt(nodo.getAttribute("id"));
                String nombre = nodo.getElementsByTagName("nom").item(0).getTextContent();
                String apellido = nodo.getElementsByTagName("cognom").item(0).getTextContent();
                String curso = nodo.getElementsByTagName("curs").item(0).getTextContent();




                alumnos.add(new Alumnos(id, nombre, apellido, curso));

            }

            for (Alumnos a : alumnos) {
                System.out.println(a.toString());
            }


        } catch (IOException | ParserConfigurationException | SAXException | NullPointerException e){
            throw new RuntimeException(e);
        }

    }

    public static class Alumnos{
        int id;
        String nombre;
        String apellido;
        String curso;

        public Alumnos(int id, String nombre, String apellido, String curso) {
            this.id = id;
            this.nombre = nombre;
            this.apellido = apellido;
            this.curso = curso;
        }

        @Override
        public String toString() {
            return "Alumnos{" +
                    "id='" + id + '\'' +
                    ", nombre='" + nombre + '\'' +
                    ", apellido='" + apellido + '\'' +
                    ", curso='" + curso + '\'' +
                    '}';
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setCurso(String curso) {
            this.curso = curso;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getId() {
            return id;
        }

        public String getApellido() {
            return apellido;
        }

        public String getCurso() {
            return curso;
        }

        public String getNombre() {
            return nombre;
        }
    }
}
