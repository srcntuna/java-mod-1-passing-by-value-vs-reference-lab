


public class Solution1 {

  public static void main(String[] args){
    NumberContainer myNumber = new NumberContainer();
    multiplyNumbers(myNumber,10,5);
    System.out.println("Result = "+ myNumber.number);
  }

 public static void multiplyNumbers(NumberContainer result, int firstNum , int secondNum){
  result.number = firstNum * secondNum;
 }


}
