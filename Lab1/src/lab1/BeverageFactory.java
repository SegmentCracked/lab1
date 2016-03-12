package lab1;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Mengxiao Lin on 2016/3/12.
 */
public class BeverageFactory {
    private HashMap<String, Class> beverageClasses;
    private static BeverageFactory instance;
    private BeverageFactory(){
        beverageClasses=new HashMap<>();
    }
    public static BeverageFactory getInstance(){
        if (instance==null){
            instance=new BeverageFactory();
            instance.initBeverages();
        }
        return instance;
    }
    public void initBeverages(){
        registerBeverage("espresso",Espresso.class);
        registerBeverage("houseblend",HouseBlend.class);
        registerBeverage("mocha",Mocha.class);
        registerBeverage("latte",Latte.class);
        registerBeverage("cappuccino",Cappuccino.class);
        registerBeverage("green tea",GreenTea.class);
        registerBeverage("red tea",RedTea.class);
        registerBeverage("white tea",WhiteTea.class);
        registerBeverage("flower tea",FlowerTea.class);
        registerBeverage("ginger tea",GingerTea.class);
        registerBeverage("tea latte", TeaLatte.class);
        registerBeverage("decaf", Decaf.class);
        registerBeverage("decaf mocha", DecafMocha.class);
        registerBeverage("decaf latte", DecafLatte.class);
        registerBeverage("decaf cappuccino", DecafCappuccino.class);
    }
    public void registerBeverage(String key, Class c){
        beverageClasses.put(key,c);
    }
    public Beverage createBeverage(String key) throws IllegalAccessException, InstantiationException,BeverageNotFoundException {
        if (beverageClasses.containsKey(key)){
            Class c=beverageClasses.get(key);
            return (Beverage)c.newInstance();
        }else{
            throw new BeverageNotFoundException(key);
        }
    }
}
