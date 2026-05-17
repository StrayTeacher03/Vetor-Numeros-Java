package service;

import javax.swing.JOptionPane;//Importação da classe JOptionPane para exibir janelas de diálogo para entrada e saída de dados

public class SistemaNumero {
    int quantPar = 0, quantImp = 0;//Variáveis para contar a quantidade de números pares e ímpares lidos

    public int Ler(int numN) {//Método para ler os números, com tratamento de entrada para considerar somente números e ignorar letras, vírgulas e pontos
        String input = JOptionPane.showInputDialog(null, "Digite o " + numN + "° número \n(Letra, vírgulas e pontos serão ignorados e será enviado somente números, caso não tenha número, será considerado 0)", "Digitar número",
                JOptionPane.QUESTION_MESSAGE);
        int num = Integer.parseInt(
                (input == null || input.replaceAll("[^0-9]", "").isEmpty()) ? "0" : input.replaceAll("[^0-9]", ""));
        
        if (input == null) {
            JOptionPane.showMessageDialog(null, "Entrada cancelada, o número será considerado 0.", "Entrada cancelada", JOptionPane.WARNING_MESSAGE);
        } else if (input.replaceAll("[^0-9]", "").isEmpty()) {
            JOptionPane.showMessageDialog(null, "Entrada inválida, o número será considerado 0.", "Entrada inválida", JOptionPane.WARNING_MESSAGE);
        }

        return num;
    }
    
    public int MaPar(int[] nums) {//Método para calcular o maior número par, contando a quantidade de números pares lidos
        int maPar = 0;
        for (int num : nums) {
            if (num % 2 == 0 && num != 0) {
                quantPar++;
                if (maPar == 0 || num > maPar) {
                    maPar = num;
                }
            }
        }

        return maPar;
    }

    public int MeImp(int[] nums) {//Método para calcular o menor número ímpar, contando a quantidade de números ímpares lidos
        int meImp = 0;
        for (int num : nums) {
            if (num % 2 != 0) {
                quantImp++;
                if (meImp == 0 || num < meImp) {
                    meImp = num;
                }
            }
        }

        return meImp;
    }

    public int Soma(int[] nums) {//Método para calcular a soma dos números lidos
        int soma = 0;
        for (int num : nums) {
            soma += num;
        }

        return soma;
    }

    public float Media(int[] nums, int soma) {//Método para calcular a média dos números lidos, utilizando a soma e a quantidade de números lidos
        float media = soma/nums.length;

        return media;
    }

    public void Exibir(int maPar, int meImp, int soma, float media) {//Método para exibir os resultados utilizando janelas de diálogo, considerando a quantidade de números pares e ímpares lidos para exibir mensagens adequadas
        JOptionPane.showMessageDialog(null,
                "O maior número par é: " + ((quantPar > 0) ? String.valueOf(maPar) : "Não tem número par"),
                "Maior número par", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,
                "O menor número ímpar é: " + ((quantImp > 0) ? String.valueOf(meImp) : "Não tem número ímpar"),
                "Menor número ímpar", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,
                "A soma é: " + soma,
                "Soma total do vetor", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "A média é: " + media, "Média total do vetor", JOptionPane.INFORMATION_MESSAGE);
    }
}
