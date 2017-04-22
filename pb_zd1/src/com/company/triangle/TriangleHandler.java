package com.company.triangle;


import java.util.ArrayList;
import java.util.List;

public class TriangleHandler {

    public static List<Triangle> findIsosceles(List<Triangle> triangles) {
        List<Triangle> result = new ArrayList<>();
        for (Triangle triangle : triangles) {
            if (triangle.isIsosceles()) {
                result.add(triangle);
            }
        }
        return result;
    }

    public static List<Triangle> findEquilater(List<Triangle> triangles) {
        List<Triangle> result = new ArrayList<>();
        for (Triangle triangle : triangles) {
            if (triangle.isEquilater()) {
                result.add(triangle);
            }
        }
        return result;
    }

    public static List<Triangle> findRightangled(List<Triangle> triangles) {
        List<Triangle> result = new ArrayList<>();
        for (Triangle triangle : triangles) {
            if (triangle.isRightangled()) {
                result.add(triangle);
            }
        }
        return result;
    }

    public static List<Triangle> findArbitrary(List<Triangle> triangles) {
        List<Triangle> result = new ArrayList<>();
        for (Triangle triangle : triangles) {
            if (triangle.isArbitrary()) {
                result.add(triangle);
            }
        }
        return result;
    }

    public static  Triangle findMaxArea(List<Triangle> triangles) {
        if (!triangles.isEmpty()) {
            Triangle max = triangles.get(0);
            for (Triangle triangle : triangles) {
                max = max.countArea() < triangle.countArea() ? triangle : max;
            }
            return max;
        }
        return null;
    }
    public static Triangle findMinArea(List<Triangle> triangles) {
        if (!triangles.isEmpty()) {
            Triangle min = triangles.get(0);
            for (Triangle triangle : triangles) {
                min = min.countArea() > triangle.countArea() ? triangle : min;
            }
            return min;
        }
        return null;
    }
}
