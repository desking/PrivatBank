package com.company;

import com.company.point.Point;
import com.company.triangle.Triangle;
import com.company.triangle.TriangleHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TriangleRunner {

    public static void main(String[] args) {
        new TriangleRunner().run();
    }

    private void run() {
        List<Triangle> triangles = createRandomTriangle();

        List<Triangle> isosceles = TriangleHandler.findIsosceles(triangles);
        List<Triangle> equilater = TriangleHandler.findEquilater(triangles);
        List<Triangle> rightangled = TriangleHandler.findRightangled(triangles);
        List<Triangle> arbitrary = TriangleHandler.findArbitrary(triangles);


        System.out.println("Количесвто равноберенных: " + isosceles.size());
        System.out.println("Наибольший равнобедренный: " + TriangleHandler.findMaxArea(isosceles));
        System.out.println("Наименьший равнобедренный: " + TriangleHandler.findMinArea(isosceles));
        System.out.println();
        System.out.println("Количесвто равносторонних: " + equilater.size());
        System.out.println("Наибольший равнобедренный: " + TriangleHandler.findMaxArea(equilater));
        System.out.println("Наименьший равнобедренный: " + TriangleHandler.findMinArea(equilater));
        System.out.println();
        System.out.println("Количесвто прямоугольных: " + rightangled.size());
        System.out.println("Наибольший равнобедренный: " + TriangleHandler.findMaxArea(rightangled));
        System.out.println("Наименьший равнобедренный: " + TriangleHandler.findMinArea(rightangled));
        System.out.println();
        System.out.println("Количесвто произвольных: " + arbitrary.size());
        System.out.println("Наибольший равнобедренный: " + TriangleHandler.findMaxArea(arbitrary));
        System.out.println("Наименьший равнобедренный: " + TriangleHandler.findMinArea(arbitrary));


    }

    private List<Triangle> createRandomTriangle() {
        List<Triangle> triangles = new ArrayList<>();
        Triangle triangle;
        Random random = new Random();
        int bound =5;
        for (int i = 0; i < random.nextInt(1000); i++) {
            triangle = new Triangle(new Point(random.nextInt(bound), random.nextInt(bound)),
                    new Point(random.nextInt(bound), random.nextInt(bound)),
                    new Point(random.nextInt(bound), random.nextInt(bound)));
            if (!triangle.isNotTriangle()) {
                triangles.add(triangle);
            } else {
                continue;
            }
        }

        return triangles;
    }
}
