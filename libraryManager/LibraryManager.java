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
        result = Seat.AllSeat;
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                for (int k = 0; k < seat.length; k++) {
                    if (result[i][j] < 0) {
                        break;
                    }
                    if (result[i][j] == seat[k]) {
                        break;
                    }
                    if (k == seat.length - 1) {
                        result[i][j] = 0;
                    }
                }
            }
        }
    }

    // Allseat외 출력
    public void printSeat() {
        int j1;
        for (int[] i : result) {
            for (int j : i) {
                if(j == 0) {
                    System.out.printf("| %2c ",0x2592); // 정규회원 / 선택불가 좌석
                } else if(j > 0) {
                    System.out.printf("| %2c ", 0x245f+j);// 0x2460 / 선택가능 좌석 / 0x245f+j
                } else if (j < 0) {
                    j1 = Math.abs(j); // j를 절대값으로 반환
                    if (j1 > 10) {
                        System.out.printf("| %2c ", 0x24ea + (j1 - 10)); // 이미 착석 11 ~
                    } else {
                        System.out.printf("| %2c ", 0x2775+j1); //0x2776 / 비규회원 1 / 이미 착석 좌석 1 ~ 10
                    }
                }
            }
            System.out.println("|");
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

    // 회원 탈퇴
    public void withdraw() {

    }

    // 입실
    public void in() {
        Scanner sc = new Scanner(System.in);
        String info, name, phoneNum;
        String student;
        int memberNum, seat, result;

        //정기 회원인지 아닌지 입력
        System.out.print("-->정기 이용 회원인가요? (Y/N)");
        info = sc.nextLine();
        System.out.println();

        //정기 회원일 경우
        if(info.equals("y") || info.equals("Y")) {
            //회원 번호 입력
            System.out.print("-->회원번호를 입력하세요 : ");
            memberNum = sc.nextInt();
            System.out.println();

    		/*
    		 if(회원번호가 일치할 경우){
    		 	if(student == y){
    		 		학생 정규회원 자리 출력
    		 	}
    		 	if(student == n){
    		 		일반 정규회원 자리 출력
    		 	}
    		 }
    		 else if(회원번호가 일치하지 않을 경우 ){
    			System.out.print("회원번호가 일치하지 않습니다!");
    			break;
    		}
    		 */
            //좌석 번호 입력
            System.out.print("--> 좌석번호 입력 : ");
            seat = sc.nextInt();
            System.out.println();

            //이름과 자리 출력 -이름은 입력되어있는 배열에서 가져와야 함
            System.out.printf("\n 님 %d번좌석 입장하십시오. ", seat);
        }

        //정기 회원이 아닐 경우
        else if(info.equals("n") || info.equals("N")) {

            //학생인지 아닌지 입력
            System.out.print("--> 학생인가요? (Y/N)");
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
                printSeat();
                System.out.print(" --> 좌석번호 입력 : ");
                seat = sc.nextInt();
                checkSeatAvailable(name, seat, phoneNum, true);
            }
            else if(student.equals("n") || student.equals("N")) {
                //일반 비정규 회원일때의 자리배치
                seat(Seat.BasicSeat());
                printSeat();
                System.out.print(" --> 좌석번호 입력 : ");
                seat = sc.nextInt();
                System.out.println();
                checkSeatAvailable(name, seat, phoneNum, false);
            }
        }
    }

    public void checkSeatAvailable(String name, int seatNum, String phoneNum, boolean student) {
        for (int[] i : result) {
            for (int j : i) {
                if (seatNum == j) {
                    member = new Member(name, phoneNum, true, seatNum);
                    memberList.add(member);
                    System.out.println();
                    System.out.printf("\n %s님 %d번좌석 입장하십시오. ", member.getName(), member.getSeat());
                    successIn(seatNum);
                    return;
                } else if (seatNum == j*(-1)) {
                    System.out.println();
                    System.out.printf("\n 다른 회원이 사용중인 자리입니다.");
                    return;
                }
            }
        }
        System.out.println();
        System.out.printf("\n 앉을 수 없는 자리입니다.");
    }

    public void successIn(int seatNum) {
        for (int i = 0; i < Seat.AllSeat.length; i++) {
            for (int j = 0; j < Seat.AllSeat[i].length; j++) {
                if (seatNum == Seat.AllSeat[i][j]) {
                    Seat.AllSeat[i][j] = (-1) * Seat.AllSeat[i][j];
                    return;
                }
            }
        }
    }

    // 퇴실
    public void out() {

    }

}
