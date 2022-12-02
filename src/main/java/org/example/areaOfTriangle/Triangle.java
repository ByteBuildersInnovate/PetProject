package org.example.areaOfTriangle;

public class Triangle {

    public int areaOfTriangle(int a, int b, int c) throws ExceptionsForTriangle{

        if(a <= 0 || b <= 0 || c <= 0) throw new ExceptionsForTriangle("The sides of the triangle cannot be smaller or equal to 0.") {
        };
        else if (a + b <= c || b + c <= a || a + c <= b) throw new ExceptionsForTriangle("One of the sides of the triangle cannot be more than the sums of two sides of the same triangle."){
        };

        int halfPerimeter = (a + b + c)/2; //нахождение полупериметра треугольника
        int area = (int) Math.sqrt(halfPerimeter*(halfPerimeter - a)*(halfPerimeter - b)*(halfPerimeter - c)); //подстановка значений в формулу Герона

        return area;
    }

}
