public class Ex04BuscaEmABB {

    static class No {
        int codigo;
        No esquerda;
        No direita;

        No(int codigo) {
            this.codigo = codigo;
        }

        public static No inserir(No raiz, int codigo) {
            if (raiz == null) {
                return new No(codigo);
            }

            if (codigo < raiz.codigo) {
                raiz.esquerda = inserir(raiz.esquerda, codigo);
            } else if (codigo > raiz.codigo) {
                raiz.direita = inserir(raiz.direita, codigo);
            }

            return raiz;
        }

        public static boolean buscar(No raiz, int codigo) {
            No atual = raiz;

            while (atual != null) {
                if (codigo == atual.codigo) {
                    return true;
                }

                if (codigo < atual.codigo) {
                    atual = atual.esquerda;
                } else {
                    atual = atual.direita;
                }
            }

            return false;
        }

        public static void main(String[] args) {

            No raiz = null;

            raiz = inserir(raiz, 50);
            raiz = inserir(raiz, 30);
            raiz = inserir(raiz, 70);
            raiz = inserir(raiz, 20);
            raiz = inserir(raiz, 40);
            raiz = inserir(raiz, 60);
            raiz = inserir(raiz, 80);

            // produto existente
            System.out.println(buscar(raiz, 40));  // true
            System.out.println(buscar(raiz, 70));  // true

            // p    roduto inexistente
            System.out.println(buscar(raiz, 99));  // false
            System.out.println(buscar(raiz, 10));  // false
        }
    }
}