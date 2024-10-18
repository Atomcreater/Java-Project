import java.util.Random;

public class ComplexNum {
    private int imaginary;
    private int valid;
    ComplexNum(){
        var random = new Random();
        imaginary = random.nextInt(20);
        valid = random.nextInt(20);
    }
    ComplexNum(int valid , int imaginary){
        this.valid = valid;
        this.imaginary = imaginary;

    }
    public int getImaginary() {
        return imaginary;
    }

    public void setImaginary(int imaginary) {
        this.imaginary = imaginary;
    }

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }
    public ComplexNum sumComplex(ComplexNum a){
        int valid1 = a.getValid();
        int imaginary1 = a.getImaginary();
        int newValid = valid1 + this.valid;
        int newImaginary = imaginary1 + this.imaginary;
        return new ComplexNum(newValid , newImaginary);
    }
    public ComplexNum subComplex(ComplexNum a){
        int valid1 = a.getValid();
        int imaginary1 = a.getImaginary();
        int newValid = valid1 - this.valid;
        int newImaginary = imaginary1 - this.imaginary;
        return new ComplexNum(newValid , newImaginary);
    }
    public ComplexNum multiComplex(ComplexNum a){
        int valid1 = a.getValid();
        int imaginary1 = a.getImaginary();
        int newValid = valid1 * this.valid - imaginary1 * this.valid;
        int newImaginary = imaginary1 * this.valid + valid1 * this.imaginary;
        return new ComplexNum(newValid , newImaginary);
    }

    public String toString(){
        if(imaginary > 0){ return valid + "+" + imaginary + "i";}
        else if(imaginary < 0){ return valid + "-" + imaginary + "i";}
        else{return valid + "+" + "0i";}
    }
}
