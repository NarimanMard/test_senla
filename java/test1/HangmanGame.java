package test1;
import java.util.*;

public class HangmanGame {

    // Список слов для выбора
    private final List<String> words = Arrays.asList("яблоко", "компьютер", "самолет", "машина", "собака");

    // Загаданное слово
    private String secretWord;

    // Количество жизней
    private int livesRemaining;

    // Массив состояния отгадки
    private char[] guessedChars;

    /**
     * Конструктор игры, инициализирует новое игровое состояние.
     */
    public HangmanGame() {
        reset();
    }

    /**
     * Обнуляет игровое состояние перед началом нового раунда.
     */
    private void reset() {
        Random random = new Random();
        this.secretWord = words.get(random.nextInt(words.size()));

        // Устанавливаем начальное количество жизней
        this.livesRemaining = 6;

        // Заполняем массив состоянием 'не отгадано'
        this.guessedChars = new char[this.secretWord.length()];
        for(int i = 0; i < this.secretWord.length(); i++) {
            this.guessedChars[i] = '_';
        }
    }

    /**
     * Основная логика игры.
     */
    public void play() {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            displayState();

            if(isWon()) { // Проверка победы
                System.out.println("\nПоздравляем! Вы выиграли!");
                break;
            }

            if(this.livesRemaining <= 0) { // Проверка поражения
                System.out.println("\nВы проиграли :(\nЗагаданное слово было: " + this.secretWord);
                break;
            }

            System.out.print("Введите букву: ");
            String input = scanner.nextLine().trim().toLowerCase(Locale.ROOT); // Получение ввода

            processInput(input.charAt(0)); // Процессируем букву
        }

        scanner.close();
    }

    /**
     * Проверяет, выиграл ли игрок.
     *
     * @return true, если все символы открыты, false иначе.
     */
    private boolean isWon() {
        return !Arrays.toString(guessedChars).contains("_");
    }

    /**
     * Обрабатываем введенную игроком букву.
     *
     * @param letter буква, которую ввёл игрок.
     */
    private void processInput(char letter) {
        boolean found = false;

        for(int i = 0; i < this.secretWord.length(); i++) {
            if(secretWord.charAt(i) == letter) {
                guessedChars[i] = letter;
                found = true;
            }
        }

        if(!found) {
            livesRemaining--;
            System.out.println("Нет такой буквы!\nОсталось жизней: " + livesRemaining);
        }
    }

    /**
     * Показывает текущее состояние игры.
     */
    private void displayState() {
        System.out.println("\nОтгаданные буквы:");
        System.out.println(Arrays.toString(guessedChars));
        System.out.println("Осталось жизней: " + livesRemaining);
    }

    /**
     * Точка входа приложения.
     */
    public static void main(String[] args) {
        HangmanGame game = new HangmanGame();
        game.play();
    }
}