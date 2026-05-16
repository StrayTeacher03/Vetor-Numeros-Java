package app;

import service.SistemaNumero;//Importação da classe SistemaNumero para ter os métodos necessários

public class Arnaldo {
    public static void main(String[] args) {//Método principal para rodar o programa
        SistemaNumero sisN = new SistemaNumero();//Criação do objeto da classe SistemaNumero para acesso dos métodos
        int[] nums = new int[5];//Criação do array para armazenar os números lidos

        for (int cont = 0; cont < nums.length; cont++) {//Estrutura de repetição para ler os números
            nums[cont] = sisN.Ler(cont + 1);
        }
        //Métodos da classe SistemaNumero para calcular o maior par, menor ímpar, soma, média dos números lidos e exibir os resultados
        int maPar = sisN.MaPar(nums);
        int meImp = sisN.MeImp(nums);
        int soma = sisN.Soma(nums);
        float media = sisN.Media(nums, soma);
        sisN.Exibir(maPar, meImp, soma, media);
    }
}
