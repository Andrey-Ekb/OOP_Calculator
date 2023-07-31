package data;

public class CompleMulti implements Operations{

    @Override
    public Complex getExecute(Complex a, Complex b) {
  
        double real = a.re() * b.re() - a.im() * b.im();
        double img = a.re() * b.im() - a.im() * b.im();
        return new Complex(real, img);
    }
}
