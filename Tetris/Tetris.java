import java.util.ArrayList;
import java.lang.Thread;
public class Tetris{
    int[][] board;

    public  Tetris() {
        board = new int[20][10];
        make();
    }

    private void print() {
        
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println("test");
        }

        for(int i = 0; i < 1000; i++) {
            System.out.println("\b"); }

        for(int[] i : board) {
            for(int j : i) {
                if(j == 0) { System.out.print("0  "); }
                else { System.out.print("[] ");}
            }
            System.out.println();
        }
    }

    private void make() {
        int num = (int) (Math.random() * 7);
        if(num == 0) { i(); }
        else if(num == 1) { j(); }
        else if(num == 2) { l(); }
        else if(num == 3) { o(); }
        else if(num == 4) { s(); }
        else if(num == 5) { t(); }
        else if(num == 6) { z(); }
        print();
        rotate();
        move();

    }

    private void i() {
        for(int i = 3; i < 7; i++) {
            if(board[0][i] == 0) { board[0][i] = 2; }
            else { 
                System.out.println("GAME OVER"); 
                System.exit(0); }
        } }


    private void j() {
        for(int i = 3; i < 6; i++) {
            if(board[0][i] == 0) { board[0][i] = 2; }
            else { 
                System.out.println("GAME OVER"); 
                System.exit(0); }
        }
        if(board[1][5] == 0) { board[1][5] = 2; }
            else { System.out.println("GAME OVER"); } }


    private void l() {
        for(int i = 3; i < 6; i++) {
            if(board[0][i] == 0) { board[0][i] = 2; }
            else { 
                System.out.println("GAME OVER"); 
                System.exit(0); }
        }
        if(board[1][3] == 0) { board[1][3] = 2; }
            else { System.out.println("GAME OVER"); } }


    private void o() {
        for(int i = 0; i < 2; i++) {
            for(int j = 4; j < 6; j++) {
                if(board[i][j] == 0) { board[i][j] = 2; }
                else { 
                    System.out.println("GAME OVER"); 
                    System.exit(0); }
            }
        } }


    private void s() {

        for(int i = 4; i < 6; i++) {
            if(board[0][i] == 0) { board[0][i] = 2; }
            else { 
                System.out.println("GAME OVER"); 
                System.exit(0); }
        }

        for(int i = 3; i < 5; i++) {
            if(board[1][i] == 0) { board[1][i] = 2; }
            else { 
                System.out.println("GAME OVER"); 
                System.exit(0); }
        } }


    private void t() {
        for(int i = 3; i < 6; i++) {
            if(board[0][i] == 0) { board[0][i] = 2; }
            else { 
                System.out.println("GAME OVER"); 
                System.exit(0); }
        }

        if(board[1][4] == 0) { board[1][4] = 2; }
            else { System.out.println("GAME OVER"); } }


    private void z() {
        for(int i = 3; i < 5; i++) {
            if(board[0][i] == 0) { board[0][i] = 2; }
            else { 
                System.out.println("GAME OVER"); 
                System.exit(0); }
        }

        for(int i = 4; i < 6; i++) {
            if(board[1][i] == 0) { board[1][i] = 2; }
            else { 
                System.out.println("GAME OVER"); 
                System.exit(0); }
        } 
    }

    private boolean canMove() {
        ArrayList<String> check = new ArrayList<String>();
        int row;
        int col;
        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 10; j++) {
                if(board[i][j] == 2) {
                    check.add(i + "," + j);
                }
            }
        }

        for(String temp : check) {
            row = Integer.parseInt(temp.substring(0, temp.indexOf(",")));
            col = Integer.parseInt(temp.substring(temp.indexOf(",") + 1));

            if(row == 19 || board[row + 1][col] == 1) {
                return false;
            }
        }
        return true; }
    private void move() {

        

        ArrayList<String> peice = new ArrayList<String>();
        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 10; j++) {
                if(board[i][j] == 2) {
                    peice.add(i + "," + j);
                }
            }
        }
        
        if(canMove()) {
            for(String temp : peice) {
                board[Integer.parseInt(temp.substring(0, temp.indexOf(",")))][Integer.parseInt(temp.substring(temp.indexOf(",") + 1))] = 0;
            }
            for(String temp : peice) {
                board[Integer.parseInt(temp.substring(0, temp.indexOf(","))) + 1][Integer.parseInt(temp.substring(temp.indexOf(",") + 1))] = 2;
            }
            print();
            move();

        }
        else {
            for(String temp : peice) {
                board[Integer.parseInt(temp.substring(0, temp.indexOf(",")))][Integer.parseInt(temp.substring(temp.indexOf(",") + 1))] = 1;
            }
            clear();
            make();
        }
    }

    private boolean canLeft() {
        ArrayList<String> check = new ArrayList<String>();
        int row;
        int col;
        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 10; j++) {
                if(board[i][j] == 2) {
                    check.add(i + "," + j);
                }
            }
        }

        for(String temp : check) {
            row = Integer.parseInt(temp.substring(0, temp.indexOf(",")));
            col = Integer.parseInt(temp.substring(temp.indexOf(",") + 1));
            if(col == 0 || board[row][col - 1] == 1) {
                return false;
            }
        }
        return true; }

    private void left() {
        ArrayList<String> peice = new ArrayList<String>();
        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 10; j++) {
                if(board[i][j] == 2) {
                    peice.add(i + "," + j);
                }
            }
        }
        
        if(canLeft()) {
            for(String temp : peice) {
                board[Integer.parseInt(temp.substring(0, temp.indexOf(",")))][Integer.parseInt(temp.substring(temp.indexOf(",") + 1))] = 0;
            }
            for(String temp : peice) {
                board[Integer.parseInt(temp.substring(0, temp.indexOf(",")))][Integer.parseInt(temp.substring(temp.indexOf(",") + 1)) - 1] = 2;
            }
        }
    }

    private boolean canRight() {
        ArrayList<String> check = new ArrayList<String>();
        int row;
        int col;
        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 10; j++) {
                if(board[i][j] == 2) {
                    check.add(i + "," + j);
                }
            }
        }

        for(String temp : check) {
            row = Integer.parseInt(temp.substring(0, temp.indexOf(",")));
            col = Integer.parseInt(temp.substring(temp.indexOf(",") + 1));
            if(col == 9 || board[row][col + 1] == 1) {
                return false;
            }
        }
        return true; }

    private void right() {
        ArrayList<String> peice = new ArrayList<String>();
        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 10; j++) {
                if(board[i][j] == 2) {
                    peice.add(i + "," + j);
                }
            }
        }
        
        if(canRight()) {
            for(String temp : peice) {
                board[Integer.parseInt(temp.substring(0, temp.indexOf(",")))][Integer.parseInt(temp.substring(temp.indexOf(",") + 1))] = 0;
            }
            for(String temp : peice) {
                board[Integer.parseInt(temp.substring(0, temp.indexOf(",")))][Integer.parseInt(temp.substring(temp.indexOf(",") + 1)) + 1] = 2;
            }
        }
    }

    private int checkClear() {
        boolean full;
        for(int i = 0; i < 20; i++) {
            full = true;
            for(int j = 0; j < 10; j++) {
                if(board[i][j] == 0 || board[i][j] == 2) {
                    full = false;
                }
            }
            if(full) {
                return i;
            }
        }
        return -1; }

    private void clear() {
        int num = checkClear();
        int[] row;
        int[] blank = new int[10];
        if(num != -1) {
            for(int i = num - 1; i > -1; i--) {
                row = board[i];
                board[i + 1] = row;
            }
            board[0] = blank;
            clear();
        } else { return; }
    }

    private ArrayList<String> canRotate() {
        boolean can = true;
        ArrayList<String> check = new ArrayList<String>();
        ArrayList<String> rot = new ArrayList<String>();
        int row;
        int col;
        int rRow;
        int rCol;
        int dr;
        int dc;
        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 10; j++) {
                if(board[i][j] == 2) {
                    check.add(i + "," + j);
                }
            }
        }

        for(int i = 0; i < check.size(); i++) {
            int t;
            rRow = Integer.parseInt(check.get(0).substring(0, check.get(0).indexOf(",")));
            rCol = Integer.parseInt(check.get(0).substring(check.get(0).indexOf(",") + 1));

            row = Integer.parseInt(check.get(i).substring(0, check.get(i).indexOf(",")));
            col = Integer.parseInt(check.get(i).substring(check.get(i).indexOf(",") + 1));

            dr = row - rRow;
            dc = col - rCol;

            t = dc;

            dc = 0 - dr; 
            dr = t;

            row = dr + rRow;
            col = dc + rCol;

            rot.add(row + "," + col);            
        }

        for(String temp : rot) {
            row = Integer.parseInt(temp.substring(0, temp.indexOf(",")));
            col = Integer.parseInt(temp.substring(temp.indexOf(",") + 1));

            if( row > 19 ||  col > 9 || row < 0 || col < 0 || board[row][col] == 1) {
                can = false;
            }
        }

        if(can) { return rot; }
        else { return new ArrayList<String>(); } }
    
    private void rotate() {
        ArrayList<String> rot = canRotate();
        ArrayList<String> old = new ArrayList<String>();

        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 10; j++) {
                if(board[i][j] == 2) {
                    old.add(i + "," + j);
                }
            }
        }

        if(rot.size() > 0) {
            for(String temp : old) {
                board[Integer.parseInt(temp.substring(0, temp.indexOf(",")))][Integer.parseInt(temp.substring(temp.indexOf(",") + 1))] = 0;
            }
            for(String temp : rot) {
                board[Integer.parseInt(temp.substring(0, temp.indexOf(",")))][Integer.parseInt(temp.substring(temp.indexOf(",") + 1))] = 2;
            }
        }
    }

}

//https://java-design-patterns.com/patterns/game-loop/#explanation