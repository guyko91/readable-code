package cleancode.minesweeper.tobe;

public class Cell {

    private static final String FLAG_SIGN = "⚑";
    private static final String LAND_MINE_SIGN = "☼";
    private static final String UNCHECKED_SIGN = "□";
    private static final String EMPTY_SIGN = "■";

    private int nearByLandMineCount;
    private boolean isLandMine;
    private boolean isFlagged;
    private boolean isOpened;

    // Cell 이 가진 속성 : 근처 지뢰 숫자, 지뢰 여부
    // Cell 의 상태 : 깃발 유무, 열렸다/닫혔다, 사용자가 확인함

    // 도메인 지식
    // '열렸다 / 닫혔다' 는 개념과, '사용자가 체크했다'는 개념은 다르다.

    // sign(String) 기반의 BOARD 가 있고,
    // 이를 상황에 따라 표시할 sign을 갈아끼우는 형태에서,
    // 이제 'Cell' 이라는 정보를 담을 공간, 객체가 생겼다.
    // BOARD는 Cell을 갈아끼우는 곳이 아니라,
    // 사용자 행위에 따라 Cell의 상태를 변화시키는 방향으로 가야 한다.

    // 기본 생성자는 private으로 제한
    private Cell(int nearByLandMineCount, boolean isLandMine, boolean isFlagged, boolean isOpened) {
        this.nearByLandMineCount = nearByLandMineCount;
        this.isLandMine = isLandMine;
        this.isFlagged = isFlagged;
        this.isOpened = isOpened;
    }

    // 정적 팩토리 메서드 사용 (생성 메소드 이름을 지정 가능)
    public static Cell of(int nearByLandMineCount, boolean isLandMine, boolean isFlagged, boolean isOpened) {
        return new Cell(nearByLandMineCount, isLandMine, isFlagged, isOpened);
    }

    // 빈 Cell 생성
    public static Cell create() {
        return of(0, false, false, false);
    }

    public void turnOnLandMine() {
        this.isLandMine = true;
    }

    public void updateNearByLandMineCount(int count) {
        this.nearByLandMineCount = count;
    }

    public void open() {
        this.isOpened = true;
    }

    public void flag() {
        this.isFlagged = true;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public boolean isChecked() {
        return this.isFlagged || this.isOpened;
    }

    public boolean isLandMine() {
        return this.isLandMine;
    }

    public boolean hasLandMineCount() {
        return this.nearByLandMineCount != 0;
    }

    public String getSign() {

        if (isOpened) {
            if (isLandMine) {
                return LAND_MINE_SIGN;
            }

            if (hasLandMineCount()) {
                return String.valueOf(nearByLandMineCount);
            }

            return EMPTY_SIGN;
        }

        if (isFlagged) {
            return FLAG_SIGN;
        }

        return UNCHECKED_SIGN;
    }
}
