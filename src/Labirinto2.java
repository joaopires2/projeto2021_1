import java.util.*;

public class Labirinto {
    public static char[][] prof = {
            {'*', '*', '*', ' ', '*', '*', '*', '*', '*', '*'},
            {'*', '*', '*', ' ', ' ', ' ', ' ', '*', '*', '*'},
            {'*', '*', '*', ' ', '*', '*', ' ', ' ', '*', '*'},
            {'*', '*', '*', ' ', ' ', ' ', '*', ' ', ' ', '*'},
            {'*', '*', '*', '*', 'P', ' ', '*', '*', ' ', '*'},
            {'*', '*', '*', '*', '*', ' ', '*', '*', ' ', '*'},
            {'*', '*', '*', '*', '*', ' ', '*', '*', '*', '*'},
            {'*', '*', '*', '*', '*', ' ', ' ', ' ', '*', '*'},
            {'*', '*', '*', '*', ' ', ' ', '*', ' ', '*', '*'},
            {'*', '*', '*', '*', ' ', '*', '*', ' ', '*', '*'}};

    public static char[][] test = {
            {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
            {'*', '*', '*', '*', ' ', ' ', ' ', '*', '*', '*'},
            {'*', '*', '*', '*', '*', '*', ' ', '*', '*', '*'},
            {'*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*'},
            {'*', ' ', '*', '*', 'P', ' ', '*', '*', ' ', '*'},
            {' ', ' ', '*', '*', '*', ' ', '*', ' ', ' ', '*'},
            {'*', '*', '*', '*', '*', ' ', '*', ' ', '*', '*'},
            {'*', '*', '*', '*', '*', ' ', '*', ' ', ' ', ' '},
            {'*', '*', '*', '*', ' ', ' ', '*', '*', '*', '*'},
            {'*', '*', '*', '*', ' ', '*', '*', '*', '*', '*'}};
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Labirinto: ");
        System.out.println("1- test");
        System.out.println("2- prof");
        System.out.println("3 - exit");

        int labarinto;
        labarinto = input.nextInt();

        char[][] array = new char[0][];
        if (labarinto == 1){
            array = test;
        }else{
            if (labarinto == 2){
                array = prof;
            }else{
                System.out.print("Fim exit");
                System.exit(0);
            }
        }
        int a, e, totalsaidas = 0, saidasenc = 0, x = 4, y = 4;
        System.out.println("  |0|1|2|3|4|5|6|7|8|9|");
        for (a = 0; a < 10; a++) {
            System.out.print("|" + a);
            System.out.print("|");
            for (e = 0; e < 10; e++) {
                if (array[a][e]=='+'){
                    System.out.print(' '+"|");
                }else {
                    System.out.print(array[a][e] + "|");
                }
            }
            System.out.println(" ");
        }
        for (e = 0; e <= 9; e++) {
            if (array[0][e] == ' ') {
                totalsaidas++;
            }
            if (array[e][0] == ' ') {
                totalsaidas++;
            }
            if (array[9][e] == ' ') {
                totalsaidas++;
            }
            if (array[e][9] == ' ') {
                totalsaidas++;
            }
        }
        System.out.println(totalsaidas);
        while (totalsaidas != saidasenc) {
            if (x == 0 || x == 9 || y == 0 || y == 9) {
                array[x][y] = 'S';
                x = 4;
                y = 4;
                for (a = 0; a < 10; a++) {
                    for (e = 0; e < 10; e++) {
                        if(array[a][e]=='+'){
                            array[a][e]=' ';
                        }
                    }
                }
                saidasenc = saidasenc + 1;
                array[4][4] = 'P';
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("  |0|1|2|3|4|5|6|7|8|9|");
                for (a = 0; a < 10; a++) {
                    System.out.print("|" + a);
                    System.out.print("|");
                    for (e = 0; e < 10; e++) {
                        System.out.print(array[a][e] + "|");
                    }
                    System.out.println(" ");

                }
                array[4][4] = '*';

            }
            if (array[x][y + 1] == ' ') {
                y = y + 1;
                array[x][y] = '-';
            } else {
                if (array[x - 1][y] == ' ') {
                    x = x - 1;
                    array[x][y] = '-';
                } else {
                    if (array[x + 1][y] == ' ') {
                        x = x + 1;
                        array[x][y] = '-';
                    } else {
                        if (array[x][y - 1] == ' ') {
                            y = y - 1;
                            array[x][y] = '-';
                        } else {

                            //----------------------------------------------
                            if ((array[x][y + 1] == '+' || array[x][y + 1] == '*'|| array[x][y + 1] == 'S') && (array[x][y - 1] == '+' || array[x][y - 1] == '*'||array[x][y - 1] == 'S') && (array[x - 1][y] == '+' || array[x - 1][y] == '*'|| array[x - 1][y] == 'S')) {
                                array[x][y] = '+';
                                x = x + 1;
                            } else {
                                if ((array[x][y + 1] == '+' || array[x][y + 1] == '*'|| array[x][y + 1] == 'S') && (array[x][y - 1] == '+' || array[x][y - 1] == '*'|| array[x][y - 1] == 'S') && (array[x + 1][y] == '+' || array[x + 1][y] == '*'|| array[x + 1][y] == 'S')) {
                                    array[x][y] = '+';
                                    x = x - 1;
                                } else {
                                    if ((array[x + 1][y] == '+' || array[x + 1][y] == '*'|| array[x + 1][y] == 'S') && (array[x - 1][y] == '+' || array[x - 1][y] == '*'|| array[x - 1][y] == 'S') && (array[x][y - 1] == '+' || array[x][y - 1] == '*'|| array[x][y - 1] == 'S')) {
                                        array[x][y] = '+';
                                        y = y + 1;
                                    } else {
                                        if ((array[x + 1][y] == '+' || array[x + 1][y] == '*'|| array[x + 1][y] == 'S') && (array[x - 1][y] == '+' || array[x - 1][y] == '*'|| array[x - 1][y] == 'S') && (array[x][y + 1] == '+' || array[x][y + 1] == '*'|| array[x][y + 1] == 'S')) {
                                            array[x][y] = '+';
                                            y = y - 1;
                                        } else {
                                            if (array[x][y - 1] == '-') {
                                                y = y - 1;
                                                array[x][y] = '-';
                                            } else {
                                                if (array[x - 1][y] == '-') {
                                                    x = x - 1;
                                                    array[x][y] = '-';
                                                } else {
                                                    if (array[x + 1][y] == '-') {
                                                        x = x + 1;
                                                        array[x][y] = '-';
                                                    } else {
                                                        if (array[x][y + 1] == '-') {
                                                            y = y + 1;
                                                            array[x][y] = '-';
                                                        }
                                                    }
                                                }
                                            }
                                        }

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
