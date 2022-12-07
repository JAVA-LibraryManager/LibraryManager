package libraryManager;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class LibraryManager {
    private int[] seat;
    private int[][] result;

    public int[][] getResult() {
        return result;
    }

    static String file;

    public LibraryManager(String file) {

        this.file = file;

        Seat.AllSeat();

    }

    public void seat(int[] seat) {
        this.seat = seat;
        result = new int[4][4];
        for (int i = 0; i < Seat.AllSeat.length; i++) {
            for (int j = 0; j < Seat.AllSeat[i].length; j++) {
                for (int k = 0; k < seat.length; k++) {
                    if (Seat.AllSeat[i][j] == seat[k]) {
                        result[i][j] = seat[k];
                        break;
                    }
                }
            }
        }
    }

    // 시작
    public void start(Scanner sc) {

    }

    // 정규 회원 가입
    public void register() {

    }

    // 회원 탈퇴
    public void withdraw() {

    }

    // 입실
    public void in() {

    }

    // 퇴실
    public void out() {

    }

}
