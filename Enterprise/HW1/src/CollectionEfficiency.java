import java.time.Clock;
import java.util.ArrayList;
import java.util.List;

public class CollectionEfficiency {

    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();


        Clock clock = Clock.systemUTC();
        long start = clock.millis();

        for(int i = 0; i != 1000000; i++) {
            arrayList.add(i);
        }
        for(int i = 0; i != 1000000; i++) {
            arrayList.get(i);
        }


        System.out.println(clock.millis() - start);

    }
}

