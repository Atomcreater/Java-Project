public class Main {
    public static void main(String[] args) {
        ComplexNum a = new ComplexNum(1, 2);
        a.setValid(5);
        a.setImaginary(4);
        Matrix matrixb = new Matrix(3, 3);
        Matrix matrixa = new Matrix(3, 3);



        System.out.print(matrixa+"\n");
        System.out.print(matrixb+"\n");
        System.out.print(matrixa.sumMatrix(matrixb)+"\n");
        System.out.print(matrixa.multiMatrix(matrixb)+ "\n");
        System.out.print(matrixa.det()+"\n");
        System.out.print(matrixa.subMatrix(matrixb)+"\n");
        System.out.print(matrixa.transposeMatrix());
    }


}
