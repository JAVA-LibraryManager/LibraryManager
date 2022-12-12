package member;

public class Member {

    private boolean student;
    private String number;
    private String name;
    private int seat;
    public int payForHour = 1000;
    public int fee = payForHour * 3;

    public Member(String name, String number, boolean student) {
        this.name = name;
        this.number = number;
        this.student = student;
    }
    public Member(String name, String number, boolean student, int seat) {
        this(name, number, student);
        this.seat = seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
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

    public int getFee() {
        return fee;
    }

    // 시간당 가격 * 3 반환
    public int calcMoney() {
        return fee = payForHour * 3;
    }

    // 정규 회원이 아닌 경우에 -1 반환
    public int getNum() {
        return -1;
    }

}
