import com.zafar.javapractice.arrays.ArraysExample;

public class ArraysExampleTest {

    ArraysExample ae = new ArraysExample();

    public void testArrayUpperCase() {
        String[] animals = new String[]{"dog", "cat", "fish"};
        ae.makeUpperCase(animals);
//        assertArrayEquals(new String[]{"DOG", "CAT", "FISH"}, animals);
    }
}
