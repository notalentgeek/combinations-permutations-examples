import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.permutation.basic.with.maven.Main;

public class MainTest {

    @Test
    public void testGenerateCombinations() {
        String[][] input = {
                {"A", "B"},
                {"C", "D"}
        };
        ArrayList<ArrayList<String>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList("A", "C")));
        expected.add(new ArrayList<>(Arrays.asList("A", "D")));
        expected.add(new ArrayList<>(Arrays.asList("B", "C")));
        expected.add(new ArrayList<>(Arrays.asList("B", "D")));

        ArrayList<ArrayList<String>> result = new ArrayList<>();
        Main.generateCombinations(input, new ArrayList<>(), result, 0);

        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    public void testGeneratePermutations() {
        String[] input = {"A", "B"};
        ArrayList<ArrayList<String>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList("A", "B")));
        expected.add(new ArrayList<>(Arrays.asList("B", "A")));

        ArrayList<ArrayList<String>> result = new ArrayList<>();
        Main.generatePermutations(input, new ArrayList<>(), result, 0);

        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }
}
