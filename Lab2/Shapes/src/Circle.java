public class Circle extends Shape {
    public void draw(int x) {
        for (int i = -x; i <= x; i++) {
            for (int j = -x; j <= x; j++) {
                if (i * i + j * j <= x * x) System.out.print("x ");
                else System.out.print("  ");
            }
            System.out.print(System.lineSeparator());
        }
    }
        public static void main(String []args){
            Circle nowy = new Circle();
            nowy.draw(5);
        }
}
