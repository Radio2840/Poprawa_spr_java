/**

 RownanieKwadratowe to klasa, która oblicza deltę, kopiuje obiekt
 i porównuje go z innymi obiektami tej samej klasy.

 a : double, przechowuje statycznie dane podane przez użytkownika pod nazwą a.
 b : double, przechowuje statycznie dane podane przez użytkownika pod nazą b.
 c : double, przechowuje statycznie dane podane przez użytkownika pod nazą c.
 tablica : ArrayList, ArrayList przechowująca obiekty Double, które są wynikami równań.

 @author: Kinga Smolarek

 **/

import java.util.ArrayList;
import java.util.Objects;

public class RownanieKwadratowe {
    private final double a;
    private final double b;
    private final double c;

    private ArrayList<Double> tablica = new ArrayList<>();

    public RownanieKwadratowe(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public RownanieKwadratowe kopiuj(){
        RownanieKwadratowe obj = new RownanieKwadratowe(a,b,c);
        return obj;
    }
    public ArrayList obliczpierwiastki(){
        double delta = (b*b)-4*a*c;
        double pierwiastek1;
        double pierwiastek2;
        if(delta < 0){
            return tablica;
        }
        if(delta == 0){
            pierwiastek1 = -b/(2*a);
            tablica.add(pierwiastek1);
        }
        if(delta >0){
            pierwiastek1 = (-b+Math.pow(delta,1/2))/(2*a);
            pierwiastek2 = (-b-Math.pow(delta,1/2))/(2*a);
            tablica.add(pierwiastek1);
            tablica.add(pierwiastek2);
        }
        return tablica;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public ArrayList<Double> getTablica() {
        return tablica;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RownanieKwadratowe that)) return false;
        return Double.compare(that.getA(), getA()) == 0 && Double.compare(that.getB(), getB()) == 0 && Double.compare(that.getC(), getC()) == 0 && Objects.equals(getTablica(), that.getTablica());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getA(), getB(), getC());
    }

    @Override
    public String toString() {
        return a+"x"+"^"+2+"+"+b+"x"+"+"+c;
    }
}

