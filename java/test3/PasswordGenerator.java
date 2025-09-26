package test3;
import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+";

    private static final Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Спрашиваем длину пароля
        System.out.print("Введите длину пароля (от 8 до 12 символов): ");
        int length = scanner.nextInt();

        // Проверяем правильность длины
        if (length < 8 || length > 12) {
            System.out.println("Длина пароля должна быть от 8 до 12 символов.");
            return;
        }

        // Генерация пароля
        String password = generatePassword(length);
        System.out.println("Ваш новый пароль: " + password);

        scanner.close();
    }

    /**
     * Генерация надежного пароля заданной длины.
     * Пароль должен включать прописные и строчные буквы,
     * цифры и специальные символы.
     */
    private static String generatePassword(int length) {
        StringBuilder password = new StringBuilder();

        // Начинаем с добавления обязательных элементов:
        // Прописная буква, строчная буква, цифра и спецсимвол
        password.append(getRandomCharFrom(UPPERCASE_LETTERS));
        password.append(getRandomCharFrom(LOWERCASE_LETTERS));
        password.append(getRandomCharFrom(DIGITS));
        password.append(getRandomCharFrom(SPECIAL_CHARACTERS));

        // Добавляем оставшиеся символы рандомно
        for (int i = 4; i < length; i++) {
            password.append(getRandomCharFrom(LOWERCASE_LETTERS + UPPERCASE_LETTERS + DIGITS + SPECIAL_CHARACTERS));
        }

        // Перемешиваем символы, чтобы порядок был случайным
        shuffle(password);

        return password.toString();
    }

    /**
     * Возвращает случайный символ из заданной строки.
     */
    private static char getRandomCharFrom(String chars) {
        return chars.charAt(random.nextInt(chars.length()));
    }

    /**
     * Перемешаем символы в строке.
     */
    private static void shuffle(StringBuilder sb) {
        for (int i = 0; i < sb.length(); i++) {
            int index = random.nextInt(sb.length());
            char temp = sb.charAt(index);
            sb.setCharAt(index, sb.charAt(i));
            sb.setCharAt(i, temp);
        }
    }
}