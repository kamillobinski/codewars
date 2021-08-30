public class StockList { 
  
  // 1st parameter is the stocklist (L in example), 
  // 2nd parameter is list of categories (M in example)
  public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
    String result = "";
    
    if(lstOfArt.length != 0 && lstOf1stLetter.length != 0) {
      for(int i = 0; i < lstOf1stLetter.length; i++) {
        int quantity = 0;
        String currLetter = lstOf1stLetter[i];
        
        for(int j = 0; j < lstOfArt.length; j++) {
          String currCategory = lstOfArt[j];
          if(currCategory.substring(0, 1).equals(currLetter)) {
            String[] value = currCategory.split(" ");
            quantity += Integer.parseInt(value[1]);
          }
        }
        
        System.out.println(quantity);  
        
        result += "(" + currLetter + " : " + quantity + ")";
        if(i != lstOf1stLetter.length - 1) {
          result += " - ";
        } 
      }
    }
    return result;
  }
}