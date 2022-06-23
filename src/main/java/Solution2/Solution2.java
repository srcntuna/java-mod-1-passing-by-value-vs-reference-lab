package Solution2;

import Containers.NumberContainer;

public class Solution2 {

  public static void main(String[] args){
    NumberContainer myNumber = new NumberContainer();
    multiplyNumbers(myNumber,10,5);
    System.out.println("Result = "+ myNumber.number);
  }

 public static void multiplyNumbers(NumberContainer result, int firstNum , int secondNum){
  result = new NumberContainer();
  result.number = firstNum * secondNum;
 }


}