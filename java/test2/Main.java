package test2;
import java.util.*;

class CurrencyConverterApp {

    // Константа: перечень поддерживаемых валют с курсами относительно базовой валюты (рубля)
    private static final Map<String, Double> EXCHANGE_RATES = new HashMap<>(){
        {
            put("USD", 70.0); // Доллар США
            put("EUR", 80.0); // Евро
            put("CNY", 10.0); // Китайский юань
            put("GBP", 90.0); // Британский фунт стерлингов
        }
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод суммы для конвертации
        System.out.print("Введите сумму в рублях для конвертации: ");
        double amountInRubles = scanner.nextDouble();

        // Конвертируем и выводим результат
        printConvertedAmounts(amountInRubles);

        scanner.close();
    }


    private static void printConvertedAmounts(double amountInRubles) {
        for(Map.Entry<String, Double> entry : EXCHANGE_RATES.entrySet()) {
            String currency = entry.getKey();
            double exchangeRate = entry.getValue();

            // Рассчитываем новую сумму
            double convertedAmount = amountInRubles / exchangeRate;

            //вывод суммы
            System.out.printf("%.2f RUB = %.2f %s%n", amountInRubles, convertedAmount, currency);
        }
    }
}