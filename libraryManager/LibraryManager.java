package libraryManager;

import member.Member;
import member.RegularMember;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class LibraryManager {
    private int[][] result;
    private Member member;
    ArrayList<Member> memberList = new ArrayList<>();

    static String file;

    public LibraryManager(String file) {

        this.file = file;

        Seat.AllSeat();

        memberList = new ArrayList<>();
    }

    public void seat(int[] seat) {
        resetSeat();
        result = Seat.AllSeat;
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                for (int k = 0; k < seat.length; k++) {
                    if (result[i][j] < 0) {
                        break;
                    }
                    if (seat[k] == result[i][j]) {
                        break;
                    }
                    if (k == seat.length - 1) {
                        result[i][j] = 0;
                    }
                }
            }
        }

        printSeat();
    }

    public void seat() {
        resetSeat();
        result = Seat.AllSeat;
        printSeat();
    }

    public void printSeat() {
        int j1;
        System.out.println("#### 좌석 배치 ####");
        System.out.println("-----------------");
        for (int[] i : result) {
            for (int j : i) {
                System.out.print("|");
                if(j == 0) {
                    System.out.printf("%2c ",0x2592); // 정규회원 / 선택불가 좌석
                } else if(j > 0) {
                    System.out.printf("%2c ", 0x245f+j);// 0x2460 / 선택가능 좌석 / 0x245f+j
                } else if (j < 0) {
                    j1 = Math.abs(j); // j를 절대값으로 반환
                    if (j1 > 10) {
                        System.out.printf("%2c", 0x24ea + (j1 - 10)); // 이미 착석 11 ~
                    } else {
                        System.out.printf("%2c ", 0x2775+j1); //0x2776 / 비규회원 1 / 이미 착석 좌석 1 ~ 10
                    }
                }
            }
            System.out.println("|");
        }
        System.out.println("-----------------");
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

    // 회원 탈퇴
    public void withdraw() {
        Scanner sc = new Scanner(System.in);
        int memberNum;
        Member m;
        System.out.print("--> 회원 번호를 입력하세요 : ");
        memberNum = sc.nextInt();

        Iterator<Member> iter = memberList.iterator();
        while (iter.hasNext()) {
            m = iter.next();
            if (m.getNum() == memberNum) {
                System.out.printf("%s님 정기회원 탈퇴 완료. \n", m.getName());
                memberList.remove(m);
                return;
            }
        }
        System.out.println("유효한 정규회원 번호가 아닙니다.");
    }

    // 입실
    public void in() {
        Scanner sc = new Scanner(System.in);
        String info, name, phoneNum;
        String student;
        int memberNum, check = -1, seat;
        Member m = null;

        //정기 회원인지 아닌지 입력
        System.out.print("-->정기 이용 회원인가요? (Y/N) ");
        info = sc.nextLine();
        System.out.println();

        //정기 회원일 경우
        if(info.equals("y") || info.equals("Y")) {
            //회원 번호 입력
            System.out.print("-->회원번호를 입력하세요 : ");
            memberNum = sc.nextInt();
            if(memberNum <= 0) {
                System.out.println("유효한 번호를 입력해주세요");
                return;
            }

            Iterator<Member> iterator = memberList.iterator();

            while (iterator.hasNext()) {
                Member iter = iterator.next();
                if(iter.getNum() != memberNum)
                    continue;
                else if (iter.getNum() == memberNum) {
                    m = iter;
                    break;
                }

            }

            if (m == null) {
                System.out.println("존재하는 회원이 아닙니다.");
                return;
            } else {
                if(m.isStudent()) {
                    seat();
                } else {
                    seat(Seat.RegularSeat());
                }
                System.out.print("--> 좌석번호 입력 : ");
                seat = sc.nextInt();
                System.out.println();
                checkSeatAvailable(m, seat);
            }

        }

        //정기 회원이 아닐 경우
        else if(info.equals("n") || info.equals("N")) {

            //학생인지 아닌지 입력
            System.out.print("--> 학생인가요? (Y/N) ");
            student = sc.nextLine();
            System.out.println();

            //이름 입력
            System.out.print("--> 이름 입력 : ");
            name = sc.nextLine();
            System.out.println();

            //전화번호 입력
            System.out.print("--> 전화번호 입력 : ");
            phoneNum = sc.nextLine();
            System.out.println();

            //
            if(student.equals("Y") ||  student.equals("y")) {
                //학생 비정규회원일때의 자리배치
                seat(Seat.StudentSeat());
                System.out.print(" --> 좌석번호 입력 : ");
                seat = sc.nextInt();
                checkSeatAvailable(name, seat, phoneNum, true);
                System.out.println();
            }
            else if(student.equals("n") || student.equals("N")) {
                //일반 비정규 회원일때의 자리배치
                seat(Seat.BasicSeat());
                System.out.print(" --> 좌석번호 입력 : ");
                seat = sc.nextInt();
                checkSeatAvailable(name, seat, phoneNum, false);
                System.out.println();
            }
        }
    }

    public void checkSeatAvailable(String name, int seatNum, String phoneNum, boolean student) {
        for (int[] i : result) {
            for (int j : i) {
                if (seatNum == j) {
                    member = new Member(name, phoneNum, true, seatNum);
                    memberList.add(member);
                    System.out.printf("\n %s님 %d번좌석 입장하십시오. ", member.getName(), member.getSeat());
                    return;
                } else if (seatNum == j*(-1)) {
                    System.out.printf("\n 다른 회원이 사용중인 자리입니다.");
                    return;
                }
            }
        }
        System.out.printf("\n 앉을 수 없는 자리입니다.");
    }

    public void checkSeatAvailable(Member m, int seatNum) {
        for (int[] i : result) {
            for (int j : i) {
                if (seatNum == j) {
                    m.setSeat(seatNum);
                    System.out.printf("\n %s님 %d번좌석 입장하십시오. ", m.getName(), m.getSeat());
                    return;
                } else if (seatNum == j*(-1)) {
                    System.out.printf("\n 다른 회원이 사용중인 자리입니다.");
                    return;
                }
            }
        }
        System.out.println();
        System.out.printf("\n 앉을 수 없는 자리입니다.");
    }

    public void resetSeat() {
        Member m;
        Seat.AllSeat();
        Iterator<Member> iter = memberList.iterator();
        while (iter.hasNext()) {
            m = iter.next();
            for (int i = 0; i < Seat.AllSeat.length; i++) {
                for (int j = 0; j < Seat.AllSeat[i].length; j++) {
                    if (Seat.AllSeat[i][j] == m.getSeat()) {
                        Seat.AllSeat[i][j] = (-1)*m.getSeat();
                    }
                }
            }
        }
    }

    // 퇴실
    public void out() {
        Scanner sc = new Scanner(System.in);
        int seat;
        Member m;
        int money;

        System.out.print("--> 좌석번호 입력 : ");
        seat = sc.nextInt();
        System.out.println();

        Iterator<Member> iter = memberList.iterator();
        while (iter.hasNext()) {
            m = iter.next();
            if (m.getSeat() == seat) {
                if (m instanceof RegularMember) {
                    System.out.printf("정산 요금은 %d원 입니다.\n", m.getFee());
                    money = m.calcMoney();
                    System.out.printf("정산후 남은 금액은 %d원 입니다. 감사합니다 !!\n", money);
                    m.setSeat(0);
                } else {
                    System.out.printf("정산 요금은 %d원 입니다. 감사합니다 !!\n", m.getFee());
                    memberList.remove(m);
                }
                System.out.printf("%d번 좌석 퇴장 완료\n", seat);
                return;
            }
        }
        System.out.println("착석된 자리가 아닙니다.");
    }

}
