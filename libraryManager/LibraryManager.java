package libraryManager;

import member.Member;
import member.RegularMember;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManager {
    private int[][] result;
    private Member member;
    ArrayList<Member> memberList = new ArrayList<>();

    public int[][] getResult() {
        return result;
    }

    static String file;

    public LibraryManager(String file) {

        this.file = file;

        Seat.AllSeat();

        memberList = new ArrayList<>();
    }

    public void seat(int[] seat) {
        result = new int[4][4];
        for (int i = 0; i < Seat.AllSeat.length; i++) {
            for (int j = 0; j < Seat.AllSeat[i].length; j++) {
                if(Seat.AllSeat[i][j] < 0) {
                    result[i][j] = Seat.AllSeat[i][j];
                    break;
                }
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
        int num;
        do{
            System.out.println("# DMU 도서실 좌석 관리 시스템 #");
            System.out.println("######### 메 뉴 #########");
            System.out.println("0. 종   료");
            System.out.println("1. 입   실");
            System.out.println("2. 퇴   실");
            System.out.println("3. 정기 이용권");
            System.out.println("4. 정기이용 탈퇴");
            System.out.println("#######################");
            num = sc.nextInt(); // 메뉴번호를 사용자에게 입력 받음

            switch(num) { // 입력한 숫자에 따라 메뉴시작
                case 0 :
                    System.out.println("종료");
                    break;
                case 1 :
                    in();
                    break;
                case 2 :
                    out(); //
                    break;
                case 3 :
                    register(); //
                    break;
                case 4 :
                    withdraw(); // num의 값이 4일 경우 withdraw를 실행한다.
                    break;
                default :
                    System.out.println("다시 입력 해주세요.");
                    break;
            }
            if (num == 0) return;
        }while(true);
    }

    // 정규 회원 가입
    public void register() {
        Scanner sc = new Scanner(System.in);
        String student;
        String name;
        String number;
        System.out.print("--> 학생인가요? (Y/N) ");
        student = sc.nextLine();
        System.out.println();

        if(student.equals("y") || student.equals("Y")){
            System.out.print("--> 이름 입력 : ");
            name = sc.nextLine();
            System.out.println();

            if(name.equals(name)) {
                System.out.print("--> 전화번호 입력 : ");
                number = sc.nextLine();
                System.out.println();

                member = new RegularMember(name, number, true);
                memberList.add(member);

                // if(number.equals(number)) {
                System.out.println(member.getName() + "님 정기회원으로 등록되었습니다."
                        + "\n" + "이용금액 만원이 자동 충전되었습니다."
                        + "\n" + "회원번호는 " + member.getNum() + "입니다.");
                // }
            }
        }
        else if(student.equals("n") || student.equals("N")) {
            System.out.print("--> 이름 입력 : ");
            name = sc.nextLine();
            System.out.println();

            if(name.equals(name)) {
                System.out.print("--> 전화번호 입력 : ");
                number = sc.nextLine();
                System.out.println();

                member = new RegularMember(name, number, false);
                memberList.add(member);

                // if(number.equals(number)) {
                System.out.println(member.getName() + "님 정기회원으로 등록되었습니다."
                        + "\n" + "이용금액 만원이 자동 충전되었습니다."
                        + "\n" + "회원번호는 " + member.getNum() + "입니다.");
                // }
            }
        }
        else {
            System.out.println("다시 입력 해주세요.");
        }
    }

    // 퇴실
    public void out() {
        Scanner en = new Scanner(System.in);
        System.out.println("--> 좌석번호 입력 : ");
//                int chair=en.nextInt()if((AllSeat[chair]>=ox24eb+1 && AllSeat[chair]<=ox24eb+5) || (AllSeat[chair] <= 0x2776+10&&AllSeat[chair] >= 0x2776+1)) {
//                   if(AllSeat[chair].member ==정기이용회원){
//                          if(//chair 자리의 멤버의 돈>3000)
//                {
//                        System.out.println("정산 후 남은 요금은"+money-3000+"입니다. 감사합니다 !!");
//                        System.out.println(chair+"좌석 퇴장완료")
//                        AllSeat[chair]=0x2460+chair;
//                }
//        else if(//chair 자리의 멤버의 돈<3000)
//                {
//                        System.out.println("충전금액이 모자라서 자동으로 만원 충전됩니다.");
//                        member.money+=10000;
//                    System.out.println("정산 후 남은 요금은"+money-3000+"입니다. 감사합니다 !!");
//                    System.out.println(chair+"좌석 퇴장완료");
//                        AllSeat[chair]=0x2460+chair;
//                }
//                }
//                  else {
//                      System.out.println("정산요금은 3000원 입니다. 감사합니다!!");
//                      System.out.println("chair"+좌석 퇴장완료);
//                      AllSeat[chair]=ox2460+chair;
//                }
//                        }
//        else{
//            System.out.println("좌석번호가 올바르지 않습니다. ");
//        }
//            }
    }
}
