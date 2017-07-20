/* <<<<<<<<<<<<<<<---------------- TASKS ---------------->>>>>>>>>>>>>>>
A Fibonacci series (starting from 1) written in order without any spaces in between, thus
producing a sequence of digits like 1123581321345589144233377610 and so on..
Write a Scala application to find the Nth digit in the sequence.
TASK 1: Write the function using standard for loop
TASK 2: Write the function using recursion

NOTE: User is expected to enter a valid integer number greater than 0 at command line

*/

// <<<<<<<<<<<<<<<---------------- SOLUTIONS ---------------->>>>>>>>>>>>>>>


import scala.util.Try          //As Try block is used, so its import is required

object fibonacciSeries extends App {   //fibonacciSeries object (Singleton Class) is created which will
                                       //inherit main method from App trait
   if(Try{
     args(0).toInt     //converts command line argument received as string to integer

  }.isSuccess){                    //One of the try methods (other is "isFailure") -> here it's used
                                   //to check whether body of Try returns success or not, if success is returned then
                                   //body of if executes otherwise else part executes

    val num = args(0).toInt        //Since argument received/created inside Try block has local scope so I've created
                                   // variable here in order to use it throughout the program


    //<<<<<<<<<<<<<<<---------------- SOLUTION1 STARTS---------------->>>>>>>>>>>>>>>
    //find nth digit of fibonacci sequence using standard for loop

     var a = 1                      /* a and b are used for intermediate calculations and f stores final result*/
     var b = 1
     var f = 0

     if (num == 1) println("Nth digit is 1 [Result is printed using standard for loop]")       //if num entered by user is 1, then 1 is printed
     else if (num == 2) println("Nth digit is 1 [Result is printed using standard for loop]")  //if num entered by user is 2, again  1 is printed
     else if (num > 2){                //if num entered by user is > than 2, then for loop inside else block executes
      for (i <- 3 to num) {
        f = a + b
        a = b
        b = f
        i + num
      }
      println("Nth digit is "+f+" [Result is printed using standard for loop]")     //final result is printed
    }
    else{       //if num entered by user is < 1 then this block executes
      println("!!!!!...... WRONG INPUT .....!!!!!")
    }

    //******************************** SOLUTION1 ENDS ********************************


    //<<<<<<<<<<<<<<<---------------- SOLUTION2 STARTS ---------------->>>>>>>>>>>>>>>
    //find nth digit of fibonacci sequence using my_fibonacci_method(num) using recursion

    var fib = 0        //final result is stored in this variable at the last, here this variable is initialized to zero

    if(num > 0){
      def my_fibonacci_method(n: Int): Int = { //recursive method which finds nth digit recursively
        if (n == 1) 1
        else if (n == 2) 1
        else {
          fib = my_fibonacci_method(n - 1) + my_fibonacci_method(n - 2)
          fib
        }
      }
      var fibDigit = my_fibonacci_method(num)    //call to recursive method is made
      println("Nth digit is "+fibDigit+" [Result is printed using recursion]") // final result is printed
    }
    else{         //if num entered by user is < 1 then this block executes
      println("!!!!!..... Please enter valid integer greater than 0.....!!!!!")
    }

     //******************************** SOLUTION2 ENDS ********************************
  }
 else {                        //if user enters input other than number then this block executes
    println("!!!!!........Please enter valid integer greater than 0 not a string........!!!!!")
  }
}



