import java.util.Random;
public class Matrix {
    private int line;
    private int column ;
    ComplexNum matrix [][];
    Matrix(){
        line = 0;
        column = 0;
    }
    Matrix(int line , int column ){
        matrix = new ComplexNum[line][column];
        this.line = line;
        this.column = column;

        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                matrix [i][j] = new ComplexNum();
            }
        }
    }

    public Matrix(ComplexNum[][] matrix) {
        this.line= matrix.length;
        this.column= matrix[0].length;
        this.matrix= new ComplexNum[line][column];
        for (int i = 0; i< line ; ++i ){
            for (int j=0;j < column ; ++j ){
                this.matrix[i][j] = new ComplexNum(matrix[i][j].getValid(),matrix[i][j].getImaginary());
            }
        }
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public ComplexNum getElement(int i, int j) {
        return matrix[i][j];
    }

    public Matrix sumMatrix(Matrix b) {
        if (line!= b.getLine() || column!=b.getColumn()) {
            System.out.println("Matrix sizes do not combine with each other");
            return null;
        }
        ComplexNum[][] matrixSum = new ComplexNum[line][column];

        for(int i = 0; i < line; ++i) {
            for(int j =0; j < column; ++j) {
                matrixSum[i][j] = (this.getElement(i,j)).sumComplex(b.getElement(i,j));
            }
        }
        return new Matrix(matrixSum);
    }
    public Matrix subMatrix(Matrix b) {
        if (line!= b.getLine() || column!=b.getColumn()) {
            System.out.println("Matrix sizes do not combine with each other");
            return null;
        }
        ComplexNum[][] matrixSub = new ComplexNum[line][column];

        for(int i = 0; i < line; ++i) {
            for(int j =0; j < column; ++j) {
                matrixSub[i][j] = (this.getElement(i,j)).subComplex(b.getElement(i,j));
            }
        }
        return new Matrix(matrixSub);
    }
    public Matrix multiMatrix(Matrix b) {
        if(this.line != b.getLine()) {
            System.out.println("Matrix sizes do not combine with each other");
            return null;
        }
        ComplexNum[][] matrixMulti = new ComplexNum[line][b.getLine()];
        for (int i = 0; i < line; ++i)
            for (int j = 0; j < b.getLine(); ++j) {
                matrixMulti[i][j] = new ComplexNum();
                for (int k = 0; k < line; ++k)
                    matrixMulti[i][j] = matrixMulti[i][j].sumComplex(matrix[i][k].multiComplex(b.getElement(k, j)));
            }
        return new Matrix(matrixMulti);
    }
    public ComplexNum det() {
        if (this.line != this.column) {
            throw new IllegalArgumentException("Could not calculate determinant of non-squared matrix");
        }
        int n = line;
        if (n == 1) {
            return matrix[0][0];
        }
        ComplexNum res = new ComplexNum(0, 0);
        ComplexNum pow1 = new ComplexNum(1, 0);
        for (int i = 0; i < n; ++i) {
            res = res.sumComplex(matrix[i][0].multiComplex(pow1).multiComplex(minor(i,0).det()));
            if (pow1.getValid() == 1) pow1.setValid(-1);
            else pow1.setValid(1);
        }
        return res;
    }
    public Matrix minor(int lin, int col) {
        ComplexNum[][] temp = new ComplexNum[line - 1][column - 1];
        int di = 0;
        int dj = 0;
        for (int i = 0; i < line - 1; ++i) {
            if (i == lin) {
                di = 1;
            }
            dj = 0;
            for (int j = 0; j < line - 1; ++j) {
                if (j == col) {
                    dj = 1;
                }
                temp[i][j] = this.matrix[i + di][j + dj];
            }
        }
        return new Matrix(temp);
    }
    public Matrix transposeMatrix(){
        ComplexNum[][] matrixTranspose = new ComplexNum[column][line];
        for(int i = 0; i < line; ++i){
            for(int j = 0; j < column; ++j){
                matrixTranspose[j][i] = matrix[i][j];
            }
        }
        return new Matrix(matrixTranspose);
    }

    public String toString() {
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < line ;i++) {
            for (int j = 0; j < column; j++) {
                stringbuilder.append(matrix[i][j].toString()).append(" ");
            }
            stringbuilder.append("\n");
        }
        return stringbuilder.toString();
    }
}
