public class Main {
    public static void main(String[] args) {
        ComplexNum a = new ComplexNum(1, 2);
        a.setValid(5);
        a.setImaginary(4);
        Matrix matrixb = new Matrix(3, 3);
        Matrix matrixa = new Matrix(3, 3);


        System.out.println("Две входные матрицы : ");
        System.out.println("Матрица A");
        System.out.print(matrixa+"\n");
        System.out.println("Матрица B");
        System.out.print(matrixb+"\n");
        System.out.print("Сумма двух матриц"+"\n");
        System.out.print(matrixa.sumMatrix(matrixb)+"\n");
        System.out.print("Разность двух матриц"+"\n");
        System.out.print(matrixa.subMatrix(matrixb)+"\n");
        System.out.print("Умножение двух матриц"+"\n");
        System.out.print(matrixa.multiMatrix(matrixb)+ "\n");
        System.out.print("Детерминант матрицы А :");
        System.out.print(matrixa.det()+"\n");
        System.out.print("Детерминант матрицы B :");
        System.out.print(matrixb.det()+"\n");
        System.out.print("Транспонирование матрицы A"+"\n");
        System.out.print(matrixa.transposeMatrix());
        System.out.print("Транспонирование матрицы B"+"\n");
        System.out.print(matrixb.transposeMatrix());
    }


}
