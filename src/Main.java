import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        ArrayList<RownanieKwadratowe> obiekty = new ArrayList<>();
        Scanner dane = new Scanner(System.in);
        double a;
        double b;
        double c;
        int odp;
        while(true){
            System.out.println("Wprowadz dane:");
            System.out.println("a");
            a = dane.nextDouble();
            System.out.println("b");
            b = dane.nextDouble();
            System.out.println("c");
            c = dane.nextDouble();
            obiekty.add(new RownanieKwadratowe(a,b,c));
            System.out.println("kontynuowac? 1-tak , 2-nie");
            odp = dane.nextInt();
            if(odp==2){
                break;
            }

        }
        int size = obiekty.size();
        for(int i=0;i<size;i++){
            System.out.println(obiekty.get(i).obliczpierwiastki());
        }
        System.out.println(obiekty.get(size-1).toString());
        Predicate<RownanieKwadratowe> czyparzyste =  (obj) -> {
            if((obj.getA()+ obj.getB()+ obj.getC())%2==0){
                return true;
            }
            else {
                return false;
            }
        };
        System.out.println(czyparzyste.test(obiekty.get(0)));
        Comparator<RownanieKwadratowe> comparator = new Comparator<RownanieKwadratowe>() {
            @Override
            public int compare(RownanieKwadratowe o1, RownanieKwadratowe o2) {
                if(o1.getA()-o2.getA()==0){
                    if(o1.getB()-o2.getB()==0){
                        if(o1.getC()-o2.getC()==0){
                            return 0;
                        }
                        return (int) (o1.getC()-o2.getC());
                    }
                    return (int) (o1.getB()-o2.getB());
                }
                return (int) (o1.getA()-o2.getA());
            }
        };
        obiekty.sort(comparator);

    }
}