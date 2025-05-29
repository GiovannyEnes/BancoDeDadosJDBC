package db;

public class DBIntegretyException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DBIntegretyException(String msg) {
        super(msg);
    }
}
