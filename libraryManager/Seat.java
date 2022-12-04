package libraryManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Seat {

    public static int[][] AllSeat = new int[4][4];

    public static void AllSeat() {

        try(Stream<String> stream = Files.lines(Path.of(LibraryManager.file))) {

            int[] temp = stream.skip(2)
                    .flatMap(e -> Stream.of(e.split("\\t")))
                    .filter(f -> f.length() <= 2)
                    .mapToInt(g -> Integer.parseInt(g))
                    .toArray();

            int num = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    AllSeat[i][j] = temp[num];
                    num++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[]  RegularSeat() {

        int[] seat;

        try (Stream<String> stream = Files.lines(Path.of(LibraryManager.file))) {

            seat = stream.filter(e -> e.startsWith("false\t"))
                    .flatMap(f -> Stream.of(f.split("\\t")))
                    .filter(g -> g.length() <= 2)
                    .mapToInt(h -> Integer.parseInt(h))
                    .toArray();

            return seat;

        } catch (IOException e) {
            e.printStackTrace();
            return seat = new int[0];
        }
    }

    public static int[] StudentSeat() {

        int[] seat;

        try (Stream<String> stream = Files.lines(Path.of(LibraryManager.file))) {

            seat = stream.filter(e -> e.contains("\tfalse"))
                    .flatMap(f -> Stream.of(f.split("\\t")))
                    .filter(g -> g.length() <= 2)
                    .mapToInt(h -> Integer.parseInt(h))
                    .toArray();

            return seat;

        } catch (IOException e) {
            e.printStackTrace();
            return seat = new int[0];
        }
    }

        public static int[] BasicSeat() {

            int[] seat;

            try (Stream<String> stream = Files.lines(Path.of(LibraryManager.file))) {

                seat = stream.filter(e -> e.contains("false\tfalse"))
                        .flatMap(f -> Stream.of(f.split("\\t")))
                        .filter(g -> g.length() <= 2)
                        .mapToInt(h -> Integer.parseInt(h))
                        .toArray();

                return seat;

            } catch (IOException e) {
                e.printStackTrace();
                return seat = new int[0];
            }

        }

}
