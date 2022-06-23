package Solution4;

public class Solution4 {

  public static void main(String[] args){

   String myString ="firstText";
   addText(myString,"newAddedText");
   System.out.println("modified result: " + myString);
  }

  public static void addText(String result,String addition){
    result = result + addition;
  }


}