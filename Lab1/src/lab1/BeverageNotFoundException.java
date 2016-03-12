package lab1;

/**
 * Created by Mengxiao Lin on 2016/3/12.
 */
public class BeverageNotFoundException extends Exception{
    public BeverageNotFoundException(String beverageName) {
        super("Beverage "+ beverageName+" not Found!");
    }
}
