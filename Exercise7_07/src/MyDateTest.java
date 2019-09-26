import java.util.Calendar;
import java.util.GregorianCalendar;
public class MyDateTest

{
  public static void main(String[] args)
  {
    MyDate date1 = new MyDate(11,29,1992);
    MyDate date2 = new MyDate(2,28,2001);
    MyDate dateIdag = new MyDate();
    MyDate dateimorgen = new MyDate();


    date1.stepForward(10);
    System.out.println(date1);


  }
}
