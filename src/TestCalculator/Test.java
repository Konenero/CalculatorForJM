package TestCalculator;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        VvodOperacii vodSklaviatury = new VvodOperacii(); // ввод данных
        MyResult result = vodSklaviatury.RomOrArab(vodSklaviatury.first, vodSklaviatury.second, vodSklaviatury.third); // Римские или арабские
        if (vodSklaviatury.Isklycheniy(result.getFirstForRomORArabString(), result.getSecondForRomOrArabString()) == 0) {
            vodSklaviatury.transformRomToArab(vodSklaviatury.first, vodSklaviatury.third);
            MyResult result1 = vodSklaviatury.transformRomToArab(vodSklaviatury.first, vodSklaviatury.third);
            int tryResalt = vodSklaviatury.resultCulculator(result1.getFirstForRomORArabInt(), vodSklaviatury.second,
                    result1.getSecondForRomOrArabInt());
            vodSklaviatury.ArabToRome(tryResalt);
        } else {
            System.out.println(vodSklaviatury.resultCulculator(Integer.parseInt(vodSklaviatury.first), vodSklaviatury.second,
                    Integer.parseInt(vodSklaviatury.third)));

        }
    }
}

class VvodOperacii {
    String first;
    char second;
    String third;

    VvodOperacii() {
        Scanner in = new Scanner(System.in); // Создание объекта класса Сканер
        String str = in.nextLine(); // вызов метода "считывать всю строку"
        String[] input = str.split(" "); // создание массива каждый элемент вводится через пробел
        first = input[0];
        second = input[1].charAt(0);
        third = input[2];
    }

    // метод определяет в массив Римские и\или арабские цифры
    MyResult RomOrArab(String first, char second, String third) {
        String[] Rome = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] Arab = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        char[] Oper = {'-', '+', '*', '/'};
        String[] pull = new String[2];
        boolean[] otvet = new boolean[3];

        for (int i = 0; i < 10; i++) {
            if (first.equals(Rome[i])) {
                for (int j = 0; j < 10; j++) {
                    if (third.equals(Rome[j])) {
                        otvet[0] = true;
                        break;
                    }
                }

            }
        }
        for (int i = 0; i < 4; i++) {
            if (Oper[i] == second) {
                otvet[1] = true;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (first.equals(Arab[i])) {
                for (int j = 0; j < 10; j++) {
                    if (third.equals(Arab[j])) {
                        otvet[2] = true;
                        break;
                    }
                }

            }
        }
        if ((otvet[0] && otvet[1]) || (otvet[2] && otvet[1])) {

        } else {
            System.out.println("Неверный ввод");
            System.exit(0);
        }

        return new MyResult(pull[0] = first, pull[1] = third);
    }

    // метод выбора Римские или арабские на входе
    int Isklycheniy(String first, String second) {
        String[] Rome = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] Arab = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        boolean a = false;
        boolean b = false;
        int[] pull = new int[1];

        for (int i = 0; i < 10; i++) {
            if (first.equals(Rome[i])) {
                for (int j = 0; j < 10; j++) {
                    if (second.equals(Rome[j])) {

                        a = true;
                    }
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            if (first.equals(Arab[i])) {
                for (int j = 0; j < 10; j++) {
                    if (second.equals(Arab[j])) {
                        b = true;

                    }
                }
            }
        }
        if (a) {
            pull[0] = 0;
        }
        if (b) {
            pull[0] = 1;
        }
        return pull[0];
    }

    // метод первода римских чисел в арабские
    MyResult transformRomToArab(String first, String second) {
        String[] Rome = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV",
                "XVI", "XVII", "XVIII", "XIX", "XX"};
        int[] Arab = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] pull = new int[2];
        for (int i = 0; i < 10; i++) {
            if (first.equals(Rome[i])) {
                pull[0] = Arab[i];
                break;

            }

        }
        for (int i = 0; i < 10; i++) {
            if (second.equals(Rome[i])) {
                pull[1] = Arab[i];
                break;

            }

        }
        return new MyResult(pull[0], pull[1]);
    }

    // метод расчета.
    int resultCulculator(int a, char b, int c) {
        int[] result = new int[1];
        if (((a >= 1 && a <= 10) && (c >= 1 && c <= 10)) && (b == '/'))
            result[0] = (a / c);
        else if (((a >= 1 && a <= 10) && (c >= 1 && c <= 10)) && (b == '*'))
            result[0] = (a * c);
        else if (((a >= 1 && a <= 10) && (c >= 1 && c <= 10)) && (b == '+'))
            result[0] = (a + c);
        else if (((a >= 1 && a <= 10) && (c >= 1 && c <= 10)) && (b == '-'))
            result[0] = (a - c);
        return result[0];
    }

    // метод перевода арабских цифр в Римские
    void ArabToRome(int first) {
        String[] Rome = {"-IX", "-VIII", "-VII", "-VI", "-V", "-IV", "-III", "-II", "-I", "Неопределено", "I", "II", "III", "IV",
                "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX","XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV",
                "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI",
                "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII",
                "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV",
                "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI",
                "XCVII", "XCVIII", "XCIX", "C"};
        int[] Arab = {-9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
                18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43,
                44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69,
                70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93,
                94, 95, 96, 97, 98, 99, 100};
        for (int i = 0; i < Arab.length; i++) {
            if (first == Arab[i]) {
                System.out.println(Rome[i]);

            }


        }
    }

}

class MyResult {
    String firstForRomOrArabString;
    String secondForRomeOrArabString;
    int firstForRomOrArabInt;
    int secondForRomeOrArabInt;

    MyResult(String first, String second) {
        firstForRomOrArabString = first;
        secondForRomeOrArabString = second;
    }

    MyResult(int first, int second) {
        firstForRomOrArabInt = first;
        secondForRomeOrArabInt = second;
    }

    int getFirstForRomORArabInt() {
        return firstForRomOrArabInt;
    }

    int getSecondForRomOrArabInt() {
        return secondForRomeOrArabInt;
    }

    String getFirstForRomORArabString() {
        return firstForRomOrArabString;
    }

    String getSecondForRomOrArabString() {
        return secondForRomeOrArabString;
    }
}
