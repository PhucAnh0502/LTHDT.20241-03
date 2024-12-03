package application;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateDataFile {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("data.txt")) {
            Random random = new Random();
            for (int i = 0; i < 10000; i++) {
                writer.write(random.nextInt(1000000) + " ");
                if (i % 10 == 0) { // For better readability, add a new line every 10 numbers
                    writer.write("\n");
                }
            }
            System.out.println("Successfully generated data.txt with 10,000 random numbers.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
