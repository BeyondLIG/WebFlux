package lamda_train;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Supplier;

/**
 * @Author: licg
 * @Date: 2019/7/11
 * @Description：lamda
 */

/**
 * Lamda: 返回指定接口的实例对象
 */

class Dog{
    private String name = "dog";

    private int food = 50;

    public Dog(){}

    public Dog(String name){
        this.name = name;
    }

    public static void bak(Dog dog){
        System.out.println(dog + "bak");
    }

    public int eat(int num){
        return food - num;
    }

    @Override
    public String toString() {
        return this.name;
    }
}


public class FuctionDemo {
    public static void main(String[] args) {
        // 断言接口
        IntPredicate result = i -> i > 0;
        System.out.println(result.test(6));

        // 消费接口
        Consumer<String> consumer = System.out::println;
        consumer.accept("data");

        // 静态方法引用
        Consumer<Dog> dogConsumer = Dog::bak;
        dogConsumer.accept(new Dog());

        // 非静态方法引用
        Dog dog = new Dog();
        Function<Integer, Integer> function = dog::eat;
        System.out.println(function.apply(1));

        // 无参数构造函数的引用
        Supplier<Dog> supplier = Dog::new;
        System.out.println("create new object " + supplier.get());

        // 有参数构造函数的引用
        Function<String, Dog> dogFunction = Dog::new;
        System.out.println("create new object " + dogFunction.apply("erha"));

        // 级联表达式和柯里化 x + y
        Function<Integer, Function<Integer, Integer>> integerFunctionFunction = x -> y -> x + y;
        System.out.println(integerFunctionFunction.apply(2).apply(3));


    }
}