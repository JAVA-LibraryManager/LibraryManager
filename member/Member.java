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

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getMoney() {
        return payForHour * 3;
    }

    public int getNum() {
        return -1;
    }

}
