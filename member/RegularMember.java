package member;

public class RegularMember extends Member{

    private static int Number = 1;
    private int memberNum;

    private int money = 10000;

    public RegularMember(String name, String number, boolean student) {
        super(name, number, student);
        this.memberNum = Number;
        Number++;
    }

    @Override
    public int getMoney() {
        if (money - super.getMoney() >= 0) {
            money -= super.getMoney();
            return money;
        } else {
            money -= (10000 - super.getMoney());
            return money;
        }
    }

    @Override
    public int getNum() {
        return memberNum;
    }
}
