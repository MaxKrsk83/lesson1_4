import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static final int SIZE = 10;
    private static final int DOTS_TO_WIN = 7;
    private static final char DOT_EMPTY = '.';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static char[][] map;
    private static Scanner sc = new Scanner(System.in);
    private static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if(checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if(isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if(checkWin(DOT_O)) {
                System.out.println("Победил ИИ");
                break;
            }
            if(isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра окончена");
    }

    public static boolean checkWinHor(char symbol){
        for (int i = 0; i < SIZE; i++) {
            int countToWin = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j]==symbol) {
                    countToWin++;
                    if (countToWin==DOTS_TO_WIN){
                        return true;
                    }
                } else {
                    countToWin = 0;
                }
            }
        }
        return false;
    }
    public static boolean checkWinVer(char symbol){
        for (int i = 0; i < SIZE; i++) {
            int countToWin = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i]==symbol) {
                    countToWin++;
                    if (countToWin==DOTS_TO_WIN){
                        return true;
                    }
                } else {
                    countToWin = 0;
                }
            }
        }
        return false;
    }
    public static boolean checkWinDiag(char symbol){
        int countToWin = 0;
        for (int i = 0; i < SIZE; i++) {
            if (map[i][i]==symbol){
                countToWin++;
                if (countToWin==DOTS_TO_WIN){
                    return true;
                }
            }else {
                countToWin = 0;
            }
        }
        return false;
    }
    public static boolean checkWinDiag2(char symbol){
        int countToWin = 0;
        for (int i = 0; i < SIZE; i++) {
            if (map[SIZE - i -1][i]==symbol){
                countToWin++;
                if (countToWin==DOTS_TO_WIN){
                    return true;
                }
            }else{
                countToWin = 0;
            }
        }
        return false;
    }
    private static boolean checkWin(char symbol) {
        if(checkWinHor(symbol)){
            return true;
        }else if (checkWinVer(symbol)){
            return true;
        }else if (checkWinDiag(symbol)){
            return true;
        }else if (checkWinDiag2(symbol)){
            return true;
        }

        return false;
    }

    private static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY)
                    return false;
            }
        }
        return true;
    }

    private static void aiTurn() {
        int x;
        int y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер сходил в точку " + (x + 1) + " " + (y + 1));
        map[x][y] = DOT_O;
    }

    private static void humanTurn() {
        int x;
        int y;

        do {
            System.out.println("Введите координаты в формате Х и У");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[x][y] = DOT_X;
    }

    private static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE)
            return false;
        if (map[x][y] == DOT_EMPTY)
            return true;
        return false;
    }

    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
