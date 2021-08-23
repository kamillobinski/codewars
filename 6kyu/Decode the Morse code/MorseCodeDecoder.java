public class MorseCodeDecoder {
  public static String removeBlankSpaces(String morseCode) {
      return morseCode.strip();
  }
  
  public static String refactorMorseCode(String morseCode) {
      return morseCode.replaceAll("  ", " #");
  }
    
  public static String getLetter(String morseLetter) {
      return MorseCode.get(morseLetter);
  }
  
  public static String[] getMorseCodeLetters(String morseCode) {
      return morseCode.split("\\s+");
  } 
  
  public static String decode(String morseCode) {
        morseCode = removeBlankSpaces(morseCode);
        morseCode = refactorMorseCode(morseCode);
        String[] morseCodeLetters = getMorseCodeLetters(morseCode);
        String decodedResult = "";
        for(String morseCodeStr: morseCodeLetters) {
            if(morseCodeStr.equals("#")) {
                decodedResult += " ";
            } else {
                decodedResult += getLetter(morseCodeStr);
            }
        }
        return decodedResult;
    }
}