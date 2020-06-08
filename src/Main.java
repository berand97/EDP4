import unac.edu.co.poo2.BinaryTree;
import unac.edu.co.poo2.BinaryTreeSearch;
import unac.edu.co.poo2.Student;
import unac.edu.co.poo2.Node;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner input;
    static String a1 = "";
    static String str[] = new String[19];
    static int i = 0;

    static BinaryTreeSearch zw = new BinaryTreeSearch();
    static BufferedReader entry = new BufferedReader(new InputStreamReader(System.in));
    static Student std;
    static String temp;

    private static void readPrintLine() {
        String line = input.nextLine();
        a1 = "";
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            String a = Character.toString(c);
            a1 = a1 + a;
        }
        str[i] = a1;
    }
    public static void main(String[] a) {
        int nm;
        Random r;
        r = new Random(413);
        final int Mx = 999;
        try {
            input = new Scanner(new File("alumnos.txt"));
            for (i = 0; i < 19; i++) {
                readPrintLine();
                int a1 = r.nextInt(Mx) + 1;
                std = new Student(Main.a1, a1);
                zw.insert(std);
            }
            for (i = 0; i < 19; i++) {
                for (int j = i + 1; j < 19; j++) {
                    if (str[i].compareTo(str[j]) > 0) {
                        temp = str[i];
                        str[i] = str[j];
                        str[j] = temp;
                    }
                }
            }
            do {
                System.out.println("1. Mostrar el  Árbol");
                System.out.println("2. Eliminar un estudiante");
                System.out.println("3. Ordenado");
                System.out.println("4. Salir");

                do
                    nm = Integer.parseInt(entry.readLine());
                while (nm < 1 || nm > 4);
                if (nm == 1) {
                    System.out.println("Estudiantes");
                    BinaryTree.inorden(zw.treeRoot()) ;
                    System.out.print("\n \n preorden \n");
                    BinaryTree.preorden(zw.treeRoot());



                } else if (nm == 2) {
                    int nmt;
                    System.out.print("Matricula: ");
                    nmt = Integer.parseInt(entry.readLine());
                    try {
                        zw.deleted(new Student(null, nmt));
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                } else if (nm == 3) {
                    for (int i = 0; i <= 19 - 1; i++) {
                        System.out.print(str[i] + ", \n");
                    }

                }
            } while (nm != 4);
        } catch (Exception er) {
            er.printStackTrace();
        }
    }
    static void visualizar(Node r) {
        if (r != null) {
            visualizar(r.subTreeL());
            System.out.println(r.valueNode());
            visualizar(r.subTreeR());
        }
    }
    public static void searchMax(Node n) {

        if (n != null) {

        }

    }

}
