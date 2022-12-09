package libraryManager;

import member.Member;

import java.util.Arrays;
import java.util.Scanner;

public class LibraryManagerTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryManager library = new LibraryManager("src/seat.txt");
        library.start(sc);

        for (Member m : library.memberList) {
            System.out.println(m.getName() + " " + m.getNumber() + " " + m.isStudent() + " " + m.getNum());
        }

        sc.close();

    }

}
