package org.permutation.basic.with.maven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        // Initialize Variables With Different Sets
        int valuesPerVariable = 5;
        String[] colors = {"Blue", "Green", "Ivory", "Red", "Yellow"};
        String[] fewColors = Arrays.copyOfRange(colors, 0, valuesPerVariable);
        String[] drinks = {"Coffee", "Milk", "Orange Juice", "Tea", "Generic Drink 1"};
        String[] fewDrinks = Arrays.copyOfRange(drinks, 0, valuesPerVariable);
        String[] hobbies = {"Chess", "Dancing", "Football", "Painting", "Reading"};
        String[] fewHobbies = Arrays.copyOfRange(hobbies, 0, valuesPerVariable);
        String[] nationalities = {"English", "Japanese", "Norwegian", "Spanish", "Ukrainian"};
        String[] fewNationalities = Arrays.copyOfRange(nationalities, 0, valuesPerVariable);
        String[] pets = {"Dog", "Fox", "Horse", "Snail", "Generic Pet 1"};
        String[] fewPets = Arrays.copyOfRange(pets, 0, valuesPerVariable);
        String[][] variablesBigSet = {colors, drinks, hobbies, nationalities, pets};
        String[][] variablesSmallSet = {fewColors, fewDrinks, fewHobbies, fewNationalities, fewPets};

//        // Generate Combinations
//        ArrayList<ArrayList<String>> combinations = new ArrayList<>();
//        generateCombinations(variablesSmallSet, new ArrayList<>(), combinations, 0);
//
//        // Print Generated Combinations and Their Size
//        System.out.println(combinations);
//        System.out.println(combinations.size());

        // Generate Permutations for Few Colors, Drinks, and Hobbies
        ArrayList<ArrayList<String>> permutedFewColors = new ArrayList<>();
        ArrayList<ArrayList<String>> permutedFewDrinks = new ArrayList<>();
        ArrayList<ArrayList<String>> permutedFewHobbies = new ArrayList<>();
        ArrayList<ArrayList<String>> permutedFewNationalities = new ArrayList<>();
        ArrayList<ArrayList<String>> permutedFewPets = new ArrayList<>();
        generatePermutations(fewColors, new ArrayList<>(), permutedFewColors, 0);
        generatePermutations(fewDrinks, new ArrayList<>(), permutedFewDrinks, 0);
        generatePermutations(fewHobbies, new ArrayList<>(), permutedFewHobbies, 0);
        generatePermutations(fewNationalities, new ArrayList<>(), permutedFewNationalities, 0);
        generatePermutations(fewPets, new ArrayList<>(), permutedFewPets, 0);

        // Print Permutations and Their Sizes
        System.out.println(permutedFewColors);
        System.out.println(permutedFewColors.size());
        System.out.println(permutedFewDrinks);
        System.out.println(permutedFewDrinks.size());
        System.out.println(permutedFewHobbies);
        System.out.println(permutedFewHobbies.size());
        System.out.println(permutedFewNationalities);
        System.out.println(permutedFewNationalities.size());
        System.out.println(permutedFewPets);
        System.out.println(permutedFewPets.size());

        // Combine All Permutations
        ArrayList<ArrayList<ArrayList<String>>> permutations = new ArrayList<>();
        permutations.add(permutedFewColors);
        permutations.add(permutedFewDrinks);
        permutations.add(permutedFewHobbies);
        permutations.add(permutedFewNationalities);
        permutations.add(permutedFewPets);

        // Print Combined Permutations and Their Size
        System.out.println(permutations);
        System.out.println(permutations.size());

        /*// Generate and Print Combined Permutations Example With Hard Coded Function
        ArrayList<ArrayList<ArrayList<String>>> combinationsPermutationsHardCoded = generateHardCodedCombinationsPermutations(
            valuesPerVariable,
            permutedFewColors,
            permutedFewDrinks,
            permutedFewHobbies,
            permutedFewNationalities,
            permutedFewPets
        );

        // Print Combined Permutations and Their Size
        System.out.println(combinationsPermutationsHardCoded);
        System.out.println(combinationsPermutationsHardCoded.size());*/

        // Generate and Print Combined Permutations Example With More Granular Function
        ArrayList<ArrayList<ArrayList<String>>> combinationsPermutations = new ArrayList<>();
        generateCombinationsPermutations(
                permutations,
                combinationsPermutations,
                new ArrayList<>(),
                0
        );

        // Print Combined Permutations and Their Size
        System.out.println(combinationsPermutations);
        System.out.println(combinationsPermutations.size());
    }

    public static void generateCombinationsPermutations(
            ArrayList<ArrayList<ArrayList<String>>> variables,
            ArrayList<ArrayList<ArrayList<String>>> results,
            ArrayList<ArrayList<String>> current,
            int depth
    ) {
        if (depth == variables.size()) {
            ArrayList<ArrayList<String>> currentCopy = new ArrayList<>(current);
            ArrayList<ArrayList<String>> complex = new ArrayList<>();
            for (int pairsIndex = 0; pairsIndex < currentCopy.size(); pairsIndex++) {
                for (int pairIndex = 0; pairIndex < currentCopy.get(pairsIndex).size(); pairIndex++) {
                    if (pairsIndex == 0) {
                        ArrayList<String> set = new ArrayList<>();
                        set.add(currentCopy.get(pairsIndex).get(pairIndex));
                        complex.add(set);
                    } else {
                        complex.get(pairIndex).add(currentCopy.get(pairsIndex).get(pairIndex));
                    }
                }
            }

            results.add(complex);
        } else {
            for (int i = 0; i < variables.get(depth).size(); i++) {
                current.add(variables.get(depth).get(i));

                generateCombinationsPermutations(
                        variables,
                        results,
                        current,
                        depth + 1
                );
                current.removeLast();
            }
        }
    }


    public static ArrayList<ArrayList<ArrayList<String>>> generateHardCodedCombinationsPermutations(
            int valuesPerVariable,
            ArrayList<ArrayList<String>> permutedFewColors,
            ArrayList<ArrayList<String>> permutedFewDrinks,
            ArrayList<ArrayList<String>> permutedFewHobbies,
            ArrayList<ArrayList<String>> permutedFewNationalities,
            ArrayList<ArrayList<String>> permutedFewPets
    ) {
        ArrayList<ArrayList<ArrayList<String>>> combinationsPermutations = new ArrayList<>();

        for (ArrayList<String> permutedFewColor : permutedFewColors) {
            for (ArrayList<String> permutedFewDrink : permutedFewDrinks) {
                for (ArrayList<String> permutedFewHobby : permutedFewHobbies) {
                    for (ArrayList<String> permutedFewNationality : permutedFewNationalities) {
                        for (ArrayList<String> permutedFewPet : permutedFewPets) {
                            ArrayList<ArrayList<String>> complex = new ArrayList<>();

                            for (int l = 0; l < valuesPerVariable; l++) {
                                ArrayList<String> set = new ArrayList<>();
                                set.add(permutedFewColor.get(l));
                                set.add(permutedFewDrink.get(l));
                                set.add(permutedFewHobby.get(l));
                                set.add(permutedFewNationality.get(l));
                                set.add(permutedFewPet.get(l));
                                complex.add(set);
                            }

                            combinationsPermutations.add(complex);
                        }
                    }
                }
            }
        }
        return combinationsPermutations;
    }

    public static void generateCombinations(
            String[][] variables,
            ArrayList<String> current,
            ArrayList<ArrayList<String>> results,
            int currentIndex
    ) {
        // Check If All Variables Have Been Processed
        if (currentIndex == variables.length) {
            results.add(new ArrayList<>(current));
        } else {
            // Iterate Over Current Variable and Recur for Next Variable
            for (String value : variables[currentIndex]) {
                current.add(value);
                generateCombinations(variables, current, results, currentIndex + 1);
                current.removeLast();
            }
        }
    }

    public static void generatePermutations(
            String[] variable,
            ArrayList<String> current,
            ArrayList<ArrayList<String>> result,
            int startIndex
    ) {
        // Check If All Elements Have Been Used
        if (startIndex == variable.length) {
            result.add(new ArrayList<>(current));
        } else {
            // Iterate Over Variable to Generate Permutations
            for (int i = 0; i < variable.length; i++) {
                boolean exist = false;
                String currentIteratedValue = variable[(startIndex + i) % variable.length];

                // Check If Current Value Already Exists in Permutation
                for (String value : current) {
                    if (Objects.equals(value, currentIteratedValue)) {
                        exist = true;
                        break;
                    }
                }

                // Add Value to Current Permutation if It Doesn't Exist and Recur
                if (!exist) {
                    current.add(currentIteratedValue);
                    generatePermutations(variable, current, result, startIndex + 1);
                    current.removeLast();
                }
            }
        }
    }
}
