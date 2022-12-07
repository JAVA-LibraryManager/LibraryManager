package libraryManager;

import java.util.Arrays;
import java.util.Scanner;

public class LibraryManagerTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryManager library = new LibraryManager("src/seat.txt");
        library.start(sc);

        sc.close();


    }

}
