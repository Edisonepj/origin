import java.util.Scanner;

public class CurrencyConverter {

    private static final double[] CONVERSION_RATES = {1.0, 0.85, 0.72, 110.17, 1.36, 1.21};
    private static final String[] CURRENCIES = {"USD", "EUR", "GBP", "JPY", "AUD", "CAD"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bem-vindo ao Conversor de Moedas!");
            System.out.println("Selecione a moeda de origem:");

            // Exibir opções de moeda de origem
            for (int i = 0; i < CURRENCIES.length; i++) {
                System.out.println((i + 1) + ". " + CURRENCIES[i]);
            }
            System.out.println("0. Sair");

            int fromChoice = scanner.nextInt();
            if (fromChoice == 0) {
                System.out.println("Obrigado por usar o Conversor de Moedas. Até logo!");
                break;
            } else if (fromChoice < 1 || fromChoice > CURRENCIES.length) {
                System.out.println("Escolha inválida. Por favor, selecione uma opção válida.");
                continue;
            }

            System.out.println("Selecione a moeda de destino:");
            for (int i = 0; i < CURRENCIES.length; i++) {
                System.out.println((i + 1) + ". " + CURRENCIES[i]);
            }
            int toChoice = scanner.nextInt();
            if (toChoice < 1 || toChoice > CURRENCIES.length || toChoice == fromChoice) {
                System.out.println("Escolha inválida. Por favor, selecione uma opção válida.");
                continue;
            }

            System.out.println("Digite o valor a ser convertido:");
            double amount = scanner.nextDouble();

            double convertedAmount = convertCurrency(amount, fromChoice - 1, toChoice - 1);
            System.out.printf("%.2f %s é igual a %.2f %s\n", amount, CURRENCIES[fromChoice - 1],
                    convertedAmount, CURRENCIES[toChoice - 1]);
        }

        scanner.close();
    }

    private static double convertCurrency(double amount, int fromIndex, int toIndex) {
        return amount * CONVERSION_RATES[fromIndex] / CONVERSION_RATES[toIndex];
    }
}
