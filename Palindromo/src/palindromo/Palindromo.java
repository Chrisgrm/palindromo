package palindromo;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Palindromo {

    public static void main(String[] args) {
        
        String palabra = "";

        try {

            palabra = JOptionPane.showInputDialog(null, "Introduce palabra o una frase");
            palabra = palabra.replaceAll("\\s", "");
            boolean palindromo = Detectar(palabra);
            
            if (palindromo) {
                JOptionPane.showMessageDialog(null, "La palabra " + palabra + " es palindroma");
            } else {
                JOptionPane.showMessageDialog(null, "La palabra " + palabra + " no es palindroma");
                Convertir(palabra);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido el siguiente error :", "", JOptionPane.WARNING_MESSAGE);
            System.out.println("Ha ocurrido el siguiente error :");
            e.printStackTrace();
        }

    }

    public static boolean Detectar(String palabra) {
        int inicio = 0;
        int fin = palabra.length() - 1;
        boolean palindromo = true;

        while ((inicio < fin) && (palindromo)) {
            if (palabra.charAt(inicio) == palabra.charAt(fin)) {
                inicio++;
                fin--;
            } else {
                palindromo = false;
            }
        }
        //retorna "true" en caso de que la palabra se palindroma
        return palindromo;
    }

    public static void Convertir(String palabra) {
        int inicio = 0;
        int fin = palabra.length() - 1;
        String añadido = "";
        String prov = "";

        while (!Detectar(palabra)) {
            añadido = palabra.charAt(inicio) + añadido;
            prov = palabra + añadido;
            if(Detectar(prov)){
                palabra = prov;
            }else{
                prov = "";
            }
            inicio++;
            fin--;
        }
        JOptionPane.showMessageDialog(null, "La nueva palabra es : " + palabra);
    }
}
