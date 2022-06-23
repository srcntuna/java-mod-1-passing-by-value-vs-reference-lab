public class Solution3 {

  public static void main(String[] args){

   StringContainer myString = new StringContainer();
   addText(myString,"newAddedText");
   System.out.println("modified result: " + myString.text);
  }

  public static void addText(StringContainer result,String addition){
    result.text = result.text + addition;
  }


}
