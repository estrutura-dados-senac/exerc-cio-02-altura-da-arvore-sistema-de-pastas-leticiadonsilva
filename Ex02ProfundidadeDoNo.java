    public class Ex02ProfundidadeDoNo {


        static class No{
            int id;
            No esquerda;
            No direita;


            No(int id){
                this.id=id;
            }


            public static int profundidade(No raiz, int alvo){
                return profundidadeAuxiliar(raiz, alvo, 0);


            }


            private static int profundidadeAuxiliar(No atual, int alvo, int nivel) {


                if (atual == null) {
                    return -1;
                }


                if (atual.id == alvo) {
                    return nivel;
                }


                int resultadoEsquerda = profundidadeAuxiliar(atual.esquerda, alvo, nivel + 1);


                if (resultadoEsquerda != -1) {
                    return resultadoEsquerda;
                }
            
                return profundidadeAuxiliar(atual.direita, alvo, nivel + 1);
            }


            public static void main(String[] args) {


                No raiz = new No(1);
    
                raiz.esquerda = new No(2);
                raiz.direita = new No(3);
    
                raiz.esquerda.esquerda = new No(4);
                raiz.esquerda.direita = new No(5);
    
                System.out.println(profundidade(raiz, 5));
                System.out.println(profundidade(raiz, 3));
        }
    }
    }
    
            
    


    
    
    