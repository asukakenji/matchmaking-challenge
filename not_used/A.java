import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class A {
    public static void main(String[] args) {
        B c = new C();
        System.out.println(c.getX());
        // error: incompatible types: Object is not a functional interface
        // Object obj = (A a) -> System.out.println(a);
        // Object obj = A::getName;
        //
        // error: incompatible types: cannot infer type-variable(s) T
        // Arrays.asList(A::getWins, A::getLosses);
        //
        ToIntFunction<A> f0a = A::getWins;
        Function<A, Integer> f0b = A::getWins;

        Function<A, ?> f1 = A::getName;
        Function<A, ?> f2 = A::getWins;
        Function<A, ?> f3 = A::getLosses;
        Function<A, ?> f4 = A::getWinRate;
        Function<A, ?> f5 = A::getBattlesFought;
        List<Function<A, ?>> list = Arrays.asList(f1, f2, f3, f4, f5);
    }

    public String getName() { return null; }
    public int getWins() { return 0; }
    public int getLosses() { return 0; }
    public double getWinRate() { return 0.0; }
    public long getBattlesFought() { return 0L; }
}

class B {
    public static void main(String[] args) {
        // error: incompatible types: invalid method reference
        // Function<B, ?> f0b = A::getName;
        // Function<? super B, ?> f0d = A::getName;
        // Function<? extends A, ?> f0e = B::getTimeStamp;
        // Function<?, ?> f0g = A::getName;
        //
        // error: invalid method reference
        // Function<B, ?> f0h = B::getName;
        //
        Function<A, ?> f0a = A::getName;
        Function<? extends A, ?> f0c = A::getName;
        Function<? super B, ?> f0f = B::getTimeStamp;

//         Function<?, ?> f1 = A::getName;
//         Function<?, ?> f2 = B::getWins;
//         Function<?, ?> f3 = B::getLosses;
//         Function<?, ?> f4 = B::getWinRate;
//         Function<?, ?> f5 = B::getBattlesFought;
//         Function<?, ?> f6 = B::getTimeStamp;
        //List<Function<? extends A, ?>> list = Arrays.asList(f1, f2, f3, f4, f5, f6);
    }

    public long getTimeStamp() { return 0L; }

    public static final String X = "Hello";

    public String getX() { return X; }
}

class C extends B {
    public static final String X = B.X + ", World";

    public String getX() { return X; }
}
