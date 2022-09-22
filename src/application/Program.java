package application;

public class Program {

    public static void main(String[] args) {
        Dfs dfs = new Dfs("src\\application\\in.txt");

        System.out.println("Como ficou o grafo: ");
        dfs.showVertices();
    }
}
