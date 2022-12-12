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

    // 정규 회원인 경우 돈 계산

    @Override
    public int calcMoney() {
        if (money < super.calcMoney()) {
            money = money + 10000 - super.calcMoney();
            System.out.println("충전금액이 모자라서 자동으로 만원 충전됩니다.");
        } else {
            money -= super.calcMoney();
        }
        return money;
    }


    // 정규 회원의 경우 회원 번호 반환
    @Override
    public int getNum() {
        return memberNum;
    }
}
