import java.util.ArrayList;
import java.util.List;

public class Ex05PreOrdem {

    static class No {
        String etapa;
        No esquerda;
        No direita;

        No(String etapa) {
            this.etapa = etapa;
        }
    }

    public static List<String> preOrdem(No raiz) {
        List<String> sequencia = new ArrayList<>();
        preOrdemRec(raiz, sequencia);
        return sequencia;
    }

    public static void preOrdemRec(No node, List<String> sequencia) {
        if (node == null) {
            return;
        }
        sequencia.add(node.etapa);
        preOrdemRec(node.esquerda, sequencia);
        preOrdemRec(node.direita, sequencia);
    }

    public static No exemplo() {
        No raiz = new No("deploy");
        raiz.esquerda = new No("notificar");
        raiz.direita = new No("build");
        raiz.esquerda.esquerda = new No("testes");
        raiz.esquerda.direita = new No("empacotar");
        return raiz;
    }

    public static void main(String[] args) {
        No teste = exemplo();
        List<String> sequencia = preOrdem(teste);
        System.out.println(sequencia);
    }
}