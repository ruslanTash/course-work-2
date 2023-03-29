package Diary;

public enum Type {
    WORK("Рабочая задача"),
    PERSONAL("Личная задача");
    private String type;

    Type(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }

    public static Type getType(int number) {
        if (number == 1) return Type.WORK;
        else return Type.PERSONAL;
    }
}


