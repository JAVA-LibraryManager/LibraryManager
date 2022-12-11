package libraryManager;

import java.util.Scanner;

public class LibraryManagerTest {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        LibraryManager library = new LibraryManager("src/seat.txt");
//        library.start(sc);




        int[] regularSeat = Seat.RegularSeat();

        int[][] allSeat = Seat.AllSeat;

        System.out.println("학생 정규회원");
        for (int[] i : allSeat) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println("일반 정규회원");
        for (int i : regularSeat) {
                System.out.print(i + " ");
        }
        System.out.println();


        int[] studnetSeat = Seat.StudentSeat();

        System.out.println("학생 비정규회원");
        for (int i : studnetSeat) {
            System.out.print(i + " ");
        }
        System.out.println();


        int[] basicSeat = Seat.BasicSeat();

        System.out.println("일반 비정규회원");
        for (int i : basicSeat) {
            System.out.print(i + " ");
        }
        System.out.println();

//        sc.close();


    }

}
