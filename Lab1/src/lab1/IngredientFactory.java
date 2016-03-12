package lab1;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * Created by Mengxiao Lin on 2016/3/12.
 */
public class IngredientFactory {
    private HashMap<String, Class> ingredientClasses;
    private static IngredientFactory instance;
    private IngredientFactory(){
        ingredientClasses=new HashMap<>();
    }
    public static IngredientFactory getInstance(){
        if (instance==null){
            instance=new IngredientFactory();
            instance.initIngredients();
        }
        return instance;
    }
    public void initIngredients(){
        registerIngredient("chocolate", Chocolate.class);
        registerIngredient("jasmine", Jasmine.class);
        registerIngredient("ginger", Ginger.class);
        registerIngredient("whip", WhipCream.class);
    }
    public void registerIngredient(String key, Class c){
        ingredientClasses.put(key.toLowerCase(),c);
    }
    public BeverageWithIngredient createIngredient(String key, Beverage beverage) throws BeverageNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (ingredientClasses.containsKey(key)){
            Class c=ingredientClasses.get(key);
            return (BeverageWithIngredient) c.getConstructor(Beverage.class).newInstance(beverage);
        }else{
            throw new BeverageNotFoundException(key);
        }
    }
}