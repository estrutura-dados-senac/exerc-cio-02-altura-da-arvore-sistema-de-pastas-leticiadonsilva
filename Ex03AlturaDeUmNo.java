public class Ex03AlturaDeUmNo {

    static class No {
        int id;
        No esquerda;
        No direita;

        No(int id) {
            this.id = id;
        }

        public static int alturaDoNo(No raiz, int alvo) {
            No noAlvo = buscarNo(raiz, alvo);

            if (noAlvo == null) {
                return -1;
            }

            return alturaSubarvore(noAlvo);
        }

        private static No buscarNo(No atual, int alvo) {
            if (atual == null) {
                return null;
            }

            if (atual.id == alvo) {
                return atual;
            }

            No resultadoEsquerda = buscarNo(atual.esquerda, alvo);

            if (resultadoEsquerda != null) {
                return resultadoEsquerda;
            }

            return buscarNo(atual.direita, alvo);
        }

        private static int alturaSubarvore(No raiz) {
            if (raiz == null) {
                return 0;
            }

            int alturaEsquerda = alturaSubarvore(raiz.esquerda);
            int alturaDireita  = alturaSubarvore(raiz.direita);

            return 1 + Math.max(alturaEsquerda, alturaDireita);
        }

        public static void main(String[] args) {

            No raiz = new No(1);

            raiz.esquerda = new No(2);
            raiz.direita  = new No(3);

            raiz.esquerda.esquerda = new No(4);
            raiz.esquerda.direita  = new No(5);

            raiz.esquerda.esquerda.esquerda = new No(6);

            // alvo na raiz - altura da arvore inteira
            System.out.println(alturaDoNo(raiz, 1)); // 3

            // alvo em no interno - altura da subarvore abaixo dele
            System.out.println(alturaDoNo(raiz, 2)); // 2

            // alvo em folha - nenhum nivel abaixo
            System.out.println(alturaDoNo(raiz, 5)); // 1

            // alvo inexistente
            System.out.println(alturaDoNo(raiz, 99)); // -1
        }
    }
}