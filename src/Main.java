import java.util.LinkedList;
import java.util.Scanner;

class cube {
    float x;
    float y;
    float z;

    cube(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    float findVol() {
        return this.x * this.y * this.z;
    }
}

class color extends cube {
    String color;

    color(float x, float y, float z, String color) {
        super(x, y, z);
        this.color = color;
    }

}

public class Main {

    static void print(String in) {
        System.out.println(in);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amount = -5;

        while (amount < 0) {
            print("Enter the number of colored cubes: ");
            amount = sc.nextInt();
        }
        color[] cubes = new color[amount];
        for (int i = 0; i < amount; i++) {
            float[] buff = new float[3];
            String[] buffS = {"x", "y", "z"};
            for (int j = 0; j < 3; j++) {
                while (buff[j] <= 0) {
                    print("Enter data for: " + buffS[j]);
                    buff[j] = sc.nextFloat();
                }
            }
            print("Enter color for cube: " + (i + 1));
            sc.nextLine();
            cubes[i] = new color(buff[0], buff[1], buff[2], sc.nextLine());
        }
        while (true) {
            print("1.Number of boxes with same color.\n2.Number of boxes with same volume.");
            switch (sc.nextInt()) {
                case 1 -> {
                    LinkedList<String> colorsSoFar = new LinkedList<>();
                    LinkedList<Integer> foundSoFar = new LinkedList<>();

                    for (int i = 0; i < amount; i++) {
                        if (!colorsSoFar.contains(cubes[i].color)) {
                            colorsSoFar.add(cubes[i].color);
                            foundSoFar.add(1);
                        } else {
                            int workingIndex = colorsSoFar.indexOf(cubes[i].color);
                            foundSoFar.set(workingIndex, foundSoFar.get(workingIndex) + 1);
                        }

                    }
                    System.out.println(colorsSoFar);
                    System.out.println(foundSoFar);
                }
                case 2 -> {
                    LinkedList<Float> volumesSoFar = new LinkedList<>();
                    LinkedList<Integer> foundSoFar = new LinkedList<>();

                    for (int i = 0; i < amount; i++) {
                        if (!volumesSoFar.contains(cubes[i].findVol())) {
                            volumesSoFar.add(cubes[i].findVol());
                            foundSoFar.add(1);
                        } else {
                            int workingIndex = volumesSoFar.indexOf(cubes[i].findVol());
                            foundSoFar.set(workingIndex, foundSoFar.get(workingIndex) + 1);
                        }
                    }
                    System.out.println(volumesSoFar);
                    System.out.println(foundSoFar);
                }
            }
        }
    }
}