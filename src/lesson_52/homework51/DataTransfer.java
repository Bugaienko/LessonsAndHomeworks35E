package lesson_52.homework51;
/*
@date 20.11.2023
@author Sergey Bugaienko
*/

public class DataTransfer {
    private String userName;
    private int value;

    public DataTransfer(String record) {
        String[] data = record.split(":");
        this.userName = data[0];
        this.value = Integer.parseInt(data[1]);
    }

    public String getUserName() {
        return userName;
    }

    public int getValue() {
        return value;
    }
}
