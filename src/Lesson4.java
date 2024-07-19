public class Lesson4 {
    public static void main(String[] args) {
        printThreeWords ();
        checkSumSign();
        printColor();
        compareNumbers();
        betweenTenAndTwenty();
        positiveOrNegative ();
        positiveOrNegative2 ();
        printText ();
        leapYear ();
        change ();
        array ();
        multiplyByTwo ();
     }

          // Task1
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
        }

           //Task2
        public static void checkSumSign() {
int a = 5;
int b = -6;
if (a+b>= 0) {
                System.out.println("Сумма положительная");
            } else {
                System.out.println("Сумма отрицательная");
            }
        }

            //Task3
    public static void printColor () {
        int value = 50;
        if (value < 0) {
            System.out.println("Красный");
    } if (value > 0 && value <=100)  {
            System.out.println("Желтый");
        } if (value > 100) {
            System.out.println("Зеленый");
        }
    }

            //Task4
    public static void compareNumbers() {
      int a = 7;
      int b = 7;
      if (a >= b) {
          System.out.println("a >= b");
      } else {
          System.out.println("a < b");
      }
    }
            //Task5
    static boolean betweenTenAndTwenty(){
        int a = 10;
        int b = 0;
        int summ =  a + b;
        if (summ >= 10 && summ <= 20) {
            return true;
        }
       else  {
           return false;
        }
           }

           //Task6
           public static void positiveOrNegative () {
        int a = -1;
        if (a>=0) {
            System.out.println("положительное");
        } else {
            System.out.println("отрицательное");
        }
           }

           //Task7
    static boolean positiveOrNegative2 () {
        int a = -110;
    if (a>=0) {
        return false;
    } else {
        return true;
    }
    }

            //Task8
    public static void printText () {
        String text = "Hello";
        int quantity = 3;
        for (int i = 0; i<quantity; i++) {
            System.out.println(text);
        }
    }

        //Task9
static boolean leapYear () {
        int year = 2025;
    if (year % 4 != 0) {
        return false;
    } else if (year % 400 == 0) {
        return true;
    } else if (year % 100 == 0) {
        return false;
    } else {
        return true;
    }
}
        //Task10
    public static void change () {
     int[] number = {0, 0, 1, 0, 1, 0, 1, 1, 1};
    for (int i = 0; i < number.length; i++) {
            if (number [i] == 0 ) {
            number [i] = 1;
                    } else {
                number [i] = 0;
            }
    }
        }

        //Task11
    public static void array () {
    int [] array = new int [100];
    for (int i = 0; i<100; i++) {
        array[i] = i+1;
            }
    }

        //Task12
    public static void multiplyByTwo () {
        int[] lessThenSix = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < lessThenSix.length; i++) {
           if (lessThenSix[i] < 6) {
               lessThenSix [i] = lessThenSix [i] * 2;
            }
              }
    }

        //Task13
    int [][] table = new int [10][10];
    for (int i = 0; i < 10; i++ {
        table [i][i] = 1;
    }
    }


