import java.util.Calendar;

import java.util.GregorianCalendar;

public class MyDate
{
  private int month;
  private int day;
  private int year;

  public MyDate(int month, int day, int year)
  {
    set(day,month,year);
  }

  public MyDate()
  {
    Calendar now = GregorianCalendar.getInstance();
    day = now.get(Calendar.DAY_OF_MONTH);
    month = now.get(Calendar.MONTH) + 1;
    year = now.get(Calendar.YEAR);
  }

  public int getDay()
  {
    return day;
  }

  public int getMonth()
  {
    return month;
  }

  public int getYear()
  {
    return year;
  }

  public void set(int day,int month,int year)
  {

    this.day = day;
    this.month = month;
    this.year = year;

    if(this.year < 0)
    {
      this.year = year * -1;
    }
    if (this.month < 1)
    {
      this.month = 1;
    }
    if (this.month > 12)
    {
      this.month = 12;
    }
    if (this.day < 1)
    {
      this.day = 1;
    }

    if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30)
      this.day = 30;
    else if ((month == 2 && isLeapYear()) && day > 29)
      this.day = 29;
    else if ((month == 2 && !isLeapYear()) && day > 28)
      this.day = 28;
    else if (this.day > 31)
      this.day = 31;


  }

  public String toString()
  {
    if ((day < 10 && month < 10) && (day > 0 && month > 0))
    return "" + "0"+day + "/" + "0"+month + "/" + year;
    else if ((day < 10) && (day < 0))
      return "" + "0"+day + "/" + month + "/" + year;
    else if ((month < 10) && (month < 0))
      return "" + day + "/" + "0"+month + "/" + year;
    else
     return "" + day + "/" + month + "/" + year;
  }


  public String getMonthName()
  {

    switch (month)
    {
      default:
        return "invalid month";
      case 1:
        return "January";
      case 2:
        return "February";
      case 3:
        return "March";
      case 4:
        return "April";
      case 5:
        return "May";
      case 6:
        return "July";
      case 7:
        return "June";
      case 8:
        return "August";
      case 9:
        return "September";
      case 10:
        return "November";
      case 11:
        return "October";
      case 12:
        return "December";

    }
  }

  public static int convertToMonthNumber(String monthName)
  {
    switch (monthName)
    {
      default:
        return -1;
      case "January":
        return 1;
      case "February":
        return 2;
      case "March":
        return 3;
      case "April":
        return 4;
      case "May":
        return 5;
      case "June":
        return 6;
      case "July":
        return 7;
      case "August":
        return 8;
      case "September":
        return 9;
      case "November":
        return 10;
      case "October":
        return 11;
      case "December":
        return 12;

    }
  }


  public boolean isLeapYear()
  {
    if ((year % 4 == 0) && (!(year % 100 == 0) || (year % 400 == 0)))
      return true;
    else
      return false;
  }

  public int numberOfDaysInMonth(int monthNumber)
  {
    if (month == 4 || month == 6 || month == 9 || month == 11)
      return 30;
    else if (month == 2 && isLeapYear())
      return 29;
    else if (month == 2 && !isLeapYear())
      return 28;
    else if (month < 0 || month > 12)
      return -1;
    else
      return 31;
  }

  public void stepForwardOneDay()
  {
    if ((month == 4 || month == 6 || month == 9 || month == 11) && day < 30)
      day++;
    else if ((month == 4 || month == 6 || month == 9 || month == 11) && day == 30) {
      day = 1; month++; }
    else if ((month == 2 && isLeapYear()) && day < 29)
      day++;
    else if ((month == 2 && isLeapYear()) && day == 29) {
      month++; day = 1;}
    else if ((month == 2 && !isLeapYear()) && day < 28)
      day++;
    else if ((month == 2 && !isLeapYear()) && day == 29) {
      day = 1; month++; }
    else if (day > 31)
      day++;
    else {
      month++; day = 1;
    }
  }

  public boolean equals (Object obj)
  {
    if (!(obj instanceof MyDate))
      return false;
    MyDate other = (MyDate) obj;
    return day == other.getDay() && month == other.getMonth() && year == other.getYear();
  }


  public void stepForward(int days)
  {
    if ((month == 4 || month == 6 || month == 9 || month == 11) && day + days <= 29)
      day += days;
    else if ((month == 4 || month == 6 || month == 9 || month == 11)
        && day + days > 30)
    {
      day = day + days - 30;
      month++;
    }
    else if ((month == 2 && isLeapYear()) && day + days <= 29)
      day += days;
    else if ((month == 2 && isLeapYear()) && day + days > 29)
    {
      month++;
      day = day + days - 30;
    }
    else if ((month == 2 && !isLeapYear()) && day + days <= 28)
      day += days;
    else if ((month == 2 && !isLeapYear()) && day + days > 28)
    {
      day = day + days - 30;
      month++;
    }
    else if (day + days <= 31)
      day += days;
    else
    {
      month++;
      day = day + days - 30;
    }

  }
}


