package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Dfs {

    private LinkedList<LinkedList<Integer>> graph = new LinkedList<>();
    private int vertices;
    private int edges;
    private String color[];
    private int i[];
    private int ante[];
    private int f[];

    private int startVertice;
    private int time;

    public Dfs(String path){
        try (BufferedReader buffRead = new BufferedReader(new FileReader(path))) {
            String line = buffRead.readLine();
            this.vertices = Integer.parseInt(line);

            line = buffRead.readLine();
            this.edges = Integer.parseInt(line);

            for (int j = 0; j < vertices; ++j) {
                graph.add(new LinkedList<>());
            }

            color = new String[vertices];
            i = new int[vertices];
            ante = new int[vertices];
            f = new int[vertices];

            line = buffRead.readLine();
            while (line != null) {
                String[] s = line.split(" ");
                graph.get(Integer.parseInt(s[0])).add(Integer.parseInt(s[1]));
                graph.get(Integer.parseInt(s[1])).add(Integer.valueOf(s[0]));
                line = buffRead.readLine();
            }

            this.startVertice = 0;
            DFSstart(graph, startVertice);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void DFSstart(LinkedList<LinkedList<Integer>> g, int s) {
        for (int j = 0; j < g.size(); j++) {
            color[j] = "BRANCO";
            i[j] = f[j] = ante[j] = -1;
        }
        time = 1;
        DFSvisit(g, s);
    }

    public void DFSvisit(LinkedList<LinkedList<Integer>> g, int u) {
        color[u] = "CINZA";
        i[u] = time++;
        for (Integer v : g.get(u)) {
            if ("BRANCO".equals(color[v])) {
                ante[v] = u;
                showVertices();
                printPath(v);
                System.out.println();

                DFSvisit(g, v);
            }
        }
        color[u] = "PRETO";
        f[u] = time++;

    }

    public void showVertices() {
        for (int j = 0; j < graph.size(); j++) {
            System.out.println(j + " -> " + color[j]+" ("+i[j]+"/"+f[j]+")");
        }
    }

    public void printPath(int v) {
        if (v == startVertice)
            System.out.print(v + " ");
         else {
            if (ante[v] == -1) {
                System.out.println("Não há caminho!");
            } else {
                printPath(ante[v]);
                System.out.print(v + " ");
            }
        }
    }
}
