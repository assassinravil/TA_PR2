public class RegMatchInteger1 {
    public static final int START = 0;
    public static final int DIGITS = 1;
    private static boolean isDigit(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }
    public static void main(String[] args) {
        int state = START;
        String str = "abbA 01.01.B017 Zyzzy 02.02.2017";
        int numberStarted = -1;
        // Перебираем все символы строки:
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int nextState;
            switch (state) {
                case START:
// Находимся в состоянии "до цифр"
                    if (isDigit(ch)) {
// Встретили первую цифру - переключаемся в состояние DIGITS и сохраняем позицию первой цифры:
                        numberStarted = i;
                        nextState = DIGITS;
                    } else {
// Так и остаемся в состоянии START
                        nextState = START;
                    }
                    break;
                case DIGITS:
// Находимя в состоянии "цифры"
                    if (isDigit(ch)) {
// Еще одна цифра - остаемся в состоянии DIGITS
                        nextState = DIGITS;
                    } else {
// Цифры кончились - переключаемся обратно в состояние START и печатаем найденные цифры:
                        System.out.println(str.substring(numberStarted, i));
                        nextState = START;
                    }
                    break;
                default:
                    throw new IllegalStateException();
            }
            state = nextState;
        }
    }
}