package com.company.triangle;


import com.company.point.Point;

public class Triangle {
    private Point a;
    private Point b;
    private Point c;
    private double edgeAB;
    private double edgeAC;
    private double edgeBC;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        edgeAB = findEbge(a, b);
        edgeAC = findEbge(a, c);
        edgeBC = findEbge(b, c);
    }

    public boolean isNotTriangle() {
        return (edgeAB > edgeBC + edgeAC ||
                edgeBC > edgeAB + edgeAC ||
                edgeAC > edgeAB + edgeBC ||
                (edgeAB == 0 && edgeBC == 0 && edgeAC == 0));
    }


    public void setA(Point a) {
        this.a = a;
        edgeAB = findEbge(a, b);
        edgeAC = findEbge(a, c);
    }

    public void setB(Point b) {
        this.b = b;
        edgeAB = findEbge(a, b);
        edgeBC = findEbge(b, c);
    }

    public void setC(Point c) {
        this.c = c;
        edgeBC = findEbge(b, c);
        edgeAC = findEbge(a, c);
    }

    private double findEbge(Point a, Point b) {
        return Math.sqrt(Math.pow(a.getX(), 2) + Math.pow(a.getY(), 2) + Math.pow(b.getX(), 2) + Math.pow(b.getY(), 2));
    }


    public double countPerimeter() {
        return edgeAB + edgeAC + edgeBC;
    }


    public double countArea() {

        double halfPerimeter = countPerimeter() / 2;

        return Math.sqrt(halfPerimeter * (halfPerimeter - edgeAB) * (halfPerimeter - edgeAC) * (halfPerimeter - edgeBC));
    }


    public boolean isEquilater() {
        return edgeAB == edgeAC && edgeAC == edgeBC;
    }

    public boolean isIsosceles() {
        return (edgeAB == edgeAC && edgeAC != edgeBC)
                || (edgeAB == edgeBC && edgeBC != edgeAC)
                || (edgeBC == edgeAC && edgeAC != edgeAB)
                && (!isEquilater());
    }

    public boolean isRightangled() {

        if (Math.pow(edgeAB, 2) == Math.pow(edgeAC, 2) + Math.pow(edgeBC, 2) && !isEquilater() && !isIsosceles()) {
            return true;
        } else if (Math.pow(edgeAC, 2) == Math.pow(edgeAB, 2) + Math.pow(edgeBC, 2) && !isEquilater() && !isIsosceles()) {
            return true;
        } else if (Math.pow(edgeBC, 2) == Math.pow(edgeAB, 2) + Math.pow(edgeAC, 2) && !isEquilater() && !isIsosceles()) {
            return true;
        } else return false;
    }

    public boolean isArbitrary() {
        return (!isEquilater() && !isIsosceles() && !isRightangled());
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "edgeAB=" + edgeAB +
                ", edgeAC=" + edgeAC +
                ", edgeBC=" + edgeBC +
                '}';
    }
}
