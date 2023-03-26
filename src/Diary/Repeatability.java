package Diary;

public enum Repeatability {
    WEEKLY("Еженедельная"),
    MONTLY("Ежемесячная"),
    DIALY("Ежедневная"),
    YEARLY("Ежегодная"),
    ONE_TIME("Однократная");

    private String repeat;

    Repeatability(String repeat) {
        this.repeat = repeat;
    }

    @Override
    public String toString() {
        return repeat;
    }

    public static Repeatability getRepeatability(int number){
        if (number == 1) return Repeatability.WEEKLY;
        else if (number == 2) return Repeatability.MONTLY;
        else if (number == 3) return Repeatability.DIALY;
        else if (number == 4) return Repeatability.YEARLY;
        else return Repeatability.ONE_TIME;
    }

}
