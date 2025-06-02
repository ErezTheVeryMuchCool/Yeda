import java.util.Scanner;

public class XO {
    public static Scanner reader = new Scanner(System.in);
    public static int[] numToXY(int n) {
        int row = (n - 1) / 3;
        int col = (n - 1) % 3;
        return new int[] { row, col };

    }

    public static int xyToNum(int nums[]) {
        return nums[0] * 3 + nums[1] + 1;
    }
    public static void printBoard(char[][] XOO) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("[" + XOO[i][j] + "]" );
            }
            System.out.print("               ");
            for (int j = 0; j < 3; j++) {
                System.out.print("[" + xyToNum(new int[]{i, j}) + "]" );
            }

            System.out.println();
        }
    }


    public static boolean isUsed(char[][] XOO, int n){
        int row = numToXY(n)[0];
        int col = numToXY(n)[1];
        if(XOO[row][col] == ' ') {
            return false;
        }
        return true;
    }

    public static int bestMove(char[][] XOO) {
        if (XOO[1][1] == ' ') {
            return 5;
        }

        int row;
        int col;
        int Xrow;
        int Xcol;

        if (XOO[2][2] == 'X' && XOO[1][1] == 'X' )
            if(!isUsed(XOO, 3))
                return 3;

        for (int i = 1; i <= 9; i++) {
            if (!isUsed(XOO, i)) {
                row = numToXY(i)[0];
                col = numToXY(i)[1];
                XOO[row][col] = 'O';
                if (whoWon(XOO) == 'O') {
                    XOO[row][col] = ' ';
                    return i;
                }
                XOO[row][col] = ' ';
            }
        }

        boolean xCanWin = false;
        for (int i = 1; i <= 9; i++) {
            if (!isUsed(XOO, i)) {
                row = numToXY(i)[0];
                col = numToXY(i)[1];
                XOO[row][col] = 'O';
                for (int j = 1; j <= 9; j++) {
                    if (!isUsed(XOO, j)) {
                        Xrow = numToXY(j)[0];
                        Xcol = numToXY(j)[1];
                        XOO[Xrow][Xcol] = 'X';
                        if (whoWon(XOO) == 'X') {
                            XOO[Xrow][Xcol] = ' ';
                            xCanWin = true;
                        }
                        XOO[Xrow][Xcol] = ' ';
                    }
                }

                XOO[row][col] = ' ';
                if (!xCanWin) {
                    return i;
                }
                xCanWin = false;
            }
        }

        int randomSpot = (int) (Math.random() * 9) + 1;
        while(isUsed(XOO, randomSpot)) {
            randomSpot = (int) (Math.random() * 9) + 1;
        }
        return randomSpot;
    }

    public static char whoWon(char[][] XOO) {
        if ((XOO[0][0] == XOO[1][1] && XOO[1][1] == XOO[2][2]) || (XOO[2][0] == XOO[1][1] && XOO[1][1] == XOO[0][2])) {
            if (XOO[1][1] != ' ')
                return XOO[1][1];
        }


        if (XOO[0][0] == XOO[0][1] && XOO[0][1] == XOO[0][2] || XOO[0][0] == XOO[1][0] && XOO[1][0] == XOO[2][0]) {
            if (XOO[0][0] != ' ')
                return XOO[0][0];
        }

        if (XOO[1][0] == XOO[1][1] && XOO[1][1] == XOO[1][2] || XOO[0][1] == XOO[1][1] && XOO[1][1] == XOO[2][1]) {
            if (XOO[1][1] != ' ')
                return XOO[1][1];
        }
        if (XOO[2][0] == XOO[2][1] && XOO[2][1] == XOO[2][2] || XOO[0][2] == XOO[1][2] && XOO[1][2] == XOO[2][2]) {
            if (XOO[2][2] != ' ')
                return XOO[2][2];
        }
        return 'n';
    }

    public static void main(String[] args) {
        char[][] XOO = new char[3][3];
        char WhoWon = 'n';
        int Ospot = 0;
        int nextPlace = 0;
        int row = -1;
        int col = -1;
        int moves = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                XOO[i][j] = ' ';
            }
        }
        while (WhoWon == 'n') {
            System.out.println("---------------");
            printBoard(XOO);
            System.out.println("---------------");
            System.out.println("Enter the place(1-9)");
            nextPlace = reader.nextInt();
            while (isUsed(XOO, nextPlace)) {
                row = numToXY(nextPlace)[0];
                col = numToXY(nextPlace)[1];
                if (isUsed(XOO, nextPlace)) {
                    System.out.println("used spot. try again.");
                }
                System.out.println("Enter the place(1-9)");
                nextPlace = reader.nextInt();
            }
            row = numToXY(nextPlace)[0];
            col = numToXY(nextPlace)[1];
            XOO[row][col] = 'X';
            moves++;
            WhoWon = whoWon(XOO);
            if (WhoWon == 'n' && moves != 9) {
                Ospot = bestMove(XOO);
                row = numToXY(Ospot)[0];
                col = numToXY(Ospot)[1];
                System.out.println("Computer Chose " + Ospot + "! ");
                XOO[row][col] = 'O';
                moves++;
            }
            WhoWon = whoWon(XOO);

            if (moves == 9) {
                WhoWon = 't';
            }
        }
        if (WhoWon == 't') {
            System.out.println("Its a tie!");
        }
        else{
            System.out.println(whoWon(XOO) + " Won!");
        }

    }

}
