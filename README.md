# Permutation and Combination Generator

This Java program generates permutations and combinations from a set of different categories such as colors, drinks, hobbies, nationalities, and pets. It demonstrates how to handle arrays and lists in Java and showcases the generation of combinations and permutations of a specified subset of elements.

## Features

- Initializes different sets of values (e.g., colors, drinks)
- Generates all possible combinations of a limited number of values from each category
- Produces permutations for a selected subset of each category
- Combines all permutations into structured results
- Demonstrates both a hard-coded and a more flexible approach to generating combinations of permutations

## Requirements

- Java Development Kit (JDK) 8 or higher
- Maven for project management and building (optional)
- IntelliJ IDEA (optional for IDE users)

## How to Run the Program

### Using Maven (Command Line)

1. **Clone the repository** (if applicable)
   ```bash
   git clone https://github.com/yourusername/permutation-combination-generator.git
   ```

2. **Navigate to the project directory**
   ```bash
   cd permutation-combination-generator
   ```

3. **Compile the Java program**
   If you're using Maven, make sure your `pom.xml` is set up correctly, then use
   ```bash
   mvn compile
   ```

4. **Run the main class**
   ```bash
   mvn exec:java -Dexec.mainClass="org.permutation.basic.with.maven.Main"
   ```

   Alternatively, if you're not using Maven, compile and run the `Main` class directly
   ```bash
   javac Main.java
   java org.permutation.basic.with.maven.Main
   ```

### Using IntelliJ IDEA

1. **Open IntelliJ IDEA**.

2. **Import the Project**:
    - If you have cloned the repository, select **File > Open** and choose the project directory.
    - If you are starting a new project, select **File > New > Project** and then choose **Java**. Create a new Java class and copy the code from the `Main` class into it.

3. **Add Dependencies** (if using Maven):
    - If your project uses Maven, ensure that you have a `pom.xml` file in the root directory. IntelliJ will automatically detect it and download the required dependencies.

4. **Run the Program**:
    - Locate the `Main` class in the Project view (usually found under `src/main/java/org/permutation/basic/with/maven`).
    - Right-click on the `Main` class and select **Run 'Main.main()'**.
    - Alternatively, you can select the class and click the green play button in the toolbar.

## Code Structure

The code is structured as follows

- **Main Class**: Contains the main logic for generating combinations and permutations
    - **Variables Initialization**: Sets up the various categories and their potential values
    - **Combination Generation**: Calls the `generateCombinations` method to create all combinations
    - **Permutation Generation**: Calls the `generatePermutations` method for selected values in each category
    - **Combining Results**: Combines all generated permutations into a comprehensive result set

## Methods Overview

- **`generateCombinations(String[][] variables, ArrayList<String> current, ArrayList<ArrayList<String>> results, int currentIndex)`**: Generates all combinations of the provided variables
- **`generatePermutations(String[] variable, ArrayList<String> current, ArrayList<ArrayList<String>> result, int startIndex)`**: Generates permutations of the specified variable
- **`generateCombinationsPermutations(...)`**: Combines permutations from various categories into structured results
- **`generateHardCodedCombinationsPermutations(...)`**: A hard-coded example of generating combinations of permutations

## Output

The program prints the generated combinations and permutations as well as their sizes to the console. The output demonstrates the combinations of selected values and permutations for each category.

## Contributing

Contributions are welcome! Feel free to submit issues or pull requests for improvements or enhancements.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
