        public class Ex01AlturaDaArvore {

            static class Node {
                String nome;
                Node left;
                Node right;

                Node(String nome) {
                    this.nome = nome;
                }
            }

            public static int altura(Node raiz) {
                if (raiz == null) {
                    return -1;
                }

                int alturaEsquerda = altura(raiz.left);
                int alturaDireita = altura(raiz.right);

                return 1 + Math.max(alturaEsquerda, alturaDireita);
            }

            public static Node exemploPastas() {
                Node raiz = new Node("/");
                raiz.left = new Node("HOME");
                raiz.right = new Node("etc");
                raiz.left.left = new Node("user");
                raiz.left.left.left = new Node("name");

                return raiz;
            }

            public static void main(String[] args) {
                Node raiz = exemploPastas();

                System.out.println("altura da arvore: " + altura(raiz));
            }
        }