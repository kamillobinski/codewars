# Sortable shapes

Although shapes can be very different by nature, they can be sorted by the size of their area.

**Task:**

- Create different shapes that can be part of a sortable list. The sort order is based on the size of their respective areas:
  - The area of a ***Square*** is the square of its ***side***
  - The area of a ***Rectangle*** is ***width*** multiplied by ***height***
  - The area of a ***Triangle*** is ***base*** multiplied by ***height*** divided by 2
  - The area of a ***Circle*** is the square of its ***radius*** multiplied by π
  - The ***area*** of a ***CustomShape*** is given
- The default sort order of a list of shapes is ascending on area size:
- ```java
  double side = 1.1234;
  double radius = 1.1234;
  double base = 5;
  double height = 2;
  
  ArrayList<Shape> shapes = new ArrayList<Shape>();
  shapes.add(new Square(side));
  shapes.add(new Circle(radius));
  shapes.add(new Triangle(base, height));
  
  Collections.sort(shapes);
  ```

- Use the correct π constant for your circle area calculations:
- ```java
  Math.PI
  ```