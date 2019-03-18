import java.util.Random;

public class ComplexoVetor {
    /**
     * Exercícios de Algortimos Experimentais - Complexidade de Algortimos - 11/03 - S.309-312
     *
     * A) Dado um vetor com números pares e ímpares, escreva um método int[] separaParImpar(int[] vet);
     * para colocar todos os números pares à frente no vetor e os ímpares ao final. Escreva o método em duas versões:
     *
     * Usando um vetor auxiliar
     * Sem usar outro vetor
     *
     * B) Analise a complexidade de cada implementação (Oh(), Omega() e Theta(), melhor e pior caso)
     * e diga quantas iterações cada uma executa, em função do tamanho da entrada;
     *
     * C) Execute ambas as implementações para entradas com a seguinte configuração:
     * 100 elementos, 50 pares e 50 ímpares;
     * 100 elementos, 20 pares e 80 ímpares;
     * 100 elementos, 80 pares e 20 ímpares;
     * 100000 elementos, 50000 pares e 50000 ímpares;
     * 100000 elementos, 20000 pares e 80000 ímpares;
     * 100000 elementos, 80000 pares e 20000 ímpares;
     * Compararemos resultados na próxima aula.
     */

    public static void main(String[] args) throws Exception {

        executa(100, 50, 50);
        executa(100, 20, 80);
        executa(100, 80, 20);
        executa(100000, 50000, 50000);
        executa(100000, 20000, 80000);
        executa(100000, 80000, 20000);
    }

    /**Esse método gerar os números e executa os separadores*/
    private static void executa(int total, int par, int impar) throws Exception {
        int vet[] = geradorDeNumeros(total, par, impar);
        long iInicial = System.nanoTime();
        int vetComAuxiliar[] = separaParImparComAuxiliar(vet);
        long iFinal = System.nanoTime();

        double tempo = ((iFinal - iInicial) / 1000.0);
        System.out.println("COM AUXILIAR " + total + " elementos, " + par + " pares, " + impar + " impares " + "e duração de " + tempo + " milissegundos");

        int vet2[] = geradorDeNumeros(total, par, impar);
        long iInicial2 = System.nanoTime();
        int vetSemAuxiliar[] = separaParImparSemAuxiliar(vet2);
        long iFinal2 = System.nanoTime();

        double tempo2 = ((iFinal2 - iInicial2) / 1000.0);
        System.out.println("SEM AUXILIAR " + total + " elementos, " + par + " pares, " + impar + " impares " + "e duração de " + tempo2 + " milissegundos" + "\n");
    }

    /**Esse método gerar números randomicamentes conforme os parâmetros informados acima.*/
    private static int[] geradorDeNumeros(int total, int par, int impar) throws Exception {

        if (par + impar != total) {
            throw new Exception("ERRO! A soma de pares e ímpares é diferente do total do array.");
        }

        int vet[] = new int[total];
        int contPar = 0;
        int contImpar = 0;

        while (contPar < par || contImpar < impar) {
            int somaNumeros = contPar + contImpar;
            Random random = new Random();
            int numero = random.nextInt(Integer.MAX_VALUE);

            if (numero % 2 == 0 && contPar < par) {
                contPar++;
                vet[somaNumeros] = numero;
            }
            if (numero % 2 != 0 && contImpar < impar) {
                contImpar++;
                vet[somaNumeros] = numero;
            }
        }
        return vet;
    }

    /**Esse método separa os números pares dos ímpares com um vetor auxiliar
     * Notação O de N */
    private static int[] separaParImparComAuxiliar(int[] vet) {
        int novoVetor[] = new int[vet.length];
        int posicao = 0;

        for (int aVet : vet) {
            if (aVet % 2 == 0) {
                novoVetor[posicao] = aVet;
                posicao++;
            } else {
                novoVetor[posicao] = aVet;
                posicao++;
            }
        }
        return novoVetor;
    }


    /**Esse método separa os números pares dos ímpares sem um vetor auxiliar
     * Notação O de N */
    private static int[] separaParImparSemAuxiliar(int[] vet) {
        int i = 0;
        int j = vet.length - 1;
        while (i != j) {
            if (vet[i] % 2 == 0) {
                i++;
            } else if (vet[j] % 2 != 0) {
                j--;
            } else {
                int aux = vet[i];
                vet[i] = vet[j];
                vet[j] = aux;
            }
        }
        return vet;
    }
}
