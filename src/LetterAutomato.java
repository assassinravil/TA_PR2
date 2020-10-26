import java.util.Scanner;
public class LetterAutomato {
    public static final int START = 0;
    public static final int DIGITS = 1;
    private static boolean isDigit(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'А' && ch <= 'Я');
    }
    public static void main(String[] args) {
        int state = START;
        Scanner scanner = new Scanner(System.in);
        // Вводим любую строку
        String str = scanner.nextLine();
        int NoLetters = 0;
        // Перебираем все символы строки:
        for (int i = 0; i <  str.length(); i++) {
            char ch = str.charAt(i);
            int nextState;
            switch (state) {
                case START:
// Находимся в состоянии "до Заглавной буквы"
                    if (isDigit(ch)) {
// Встретили первую заглавную букву - переключаемся в состояние DIGITS и сохраняем позицию первой буквы:
                        // Выводим Букву
                        System.out.println(ch);
                        NoLetters = 1;
                        nextState = DIGITS;
                    } else {
// Так и остаемся в состоянии START
                        nextState = START;
                    }
                    break;
                case DIGITS:
// Находимя в состоянии "Заглавная буква"
                    if (isDigit(ch)) {
// Еще одна заглавная буква - остаемся в состоянии DIGITS
                        System.out.println(ch);
                        nextState = DIGITS;
                    } else {
                        nextState = START;
                    }
                    break;
                default:
                    throw new IllegalStateException();
            }
            state = nextState;
        }
        if (NoLetters == 0)
        {
            System.out.println("Заглавных букв нет!");
        }
    }
}

