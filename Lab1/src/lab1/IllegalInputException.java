package lab1;

/**
 * Created by Mengxiao Lin on 2016/3/11.
 */
public class IllegalInputException extends Exception {
    private String inputStr;

    public IllegalInputException(String inputStr) {
        super();
        this.inputStr = inputStr;
    }

    public String getInputStr() {
        return inputStr;
    }
}
