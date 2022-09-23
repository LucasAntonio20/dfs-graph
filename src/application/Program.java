package application;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        System.out.print("Digite o vertice de inicio: ");
        int startVertice = in.nextInt(); in.nextLine();
        System.out.print("Digite o vertice final: ");
        int finishVertice = in.nextInt(); in.nextLine();

        Dfs dfs = new Dfs("src\\application\\in.txt", startVertice, finishVertice);


        System.out.println("Como ficou o grafo: ");
        dfs.showVertices();
    }
}
