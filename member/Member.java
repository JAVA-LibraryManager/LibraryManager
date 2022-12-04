package member;

public class Member {

    private boolean student;
    private String number;
    private String name;
    private int seat;
    public int payForHour = 1000;

    public Member(String name, String number, boolean student) {
        this.name = name;
        this.number = number;
        this.student = student;
    }

    public boolean isStudent() {
        return student;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getSeat() {
        return seat;
    }

    // 자리 설정
    public void setSeat(int seat) {
        this.seat = seat;
    }

    // 시간당 가격 * 3 반환
    public int getMoney() {
        return payForHour * 3;
    }

    // 정규 회원이 아닌 경우에 -1 반환
    public int getNum() {
        return -1;
    }

}
