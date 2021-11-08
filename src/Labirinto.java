public class Labirinto {
    public static char[][] array = {
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
    public static void main(String[] args) {
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
                array[x][y] = '+';
                x = 4;
                y = 4;
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
                            if ((array[x][y + 1] == '+' || array[x][y + 1] == '*') && (array[x][y - 1] == '+' || array[x][y - 1] == '*') && (array[x - 1][y] == '+' || array[x - 1][y] == '*')) {
                                array[x][y] = '+';
                                x = x + 1;
                            } else {
                                if ((array[x][y + 1] == '+' || array[x][y + 1] == '*') && (array[x][y - 1] == '+' || array[x][y - 1] == '*') && (array[x + 1][y] == '+' || array[x + 1][y] == '*')) {
                                    array[x][y] = '+';
                                    x = x - 1;
                                } else {
                                    if ((array[x + 1][y] == '+' || array[x + 1][y] == '*') && (array[x - 1][y] == '+' || array[x - 1][y] == '*') && (array[x][y - 1] == '+' || array[x][y - 1] == '*')) {
                                        array[x][y] = '+';
                                        y = y + 1;
                                    } else {
                                        if ((array[x + 1][y] == '+' || array[x + 1][y] == '*') && (array[x - 1][y] == '+' || array[x - 1][y] == '*') && (array[x][y + 1] == '+' || array[x][y + 1] == '*')) {
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