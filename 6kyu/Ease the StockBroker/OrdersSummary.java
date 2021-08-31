public class OrdersSummary {

    public static boolean isCorrect(String[] fields) {
        if(fields.length == 4) {
            if(fields[3].equals("B") || fields[3].equals("S")) {
                if(fields[2].contains(".")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String balanceStatements(String lst) {
        // G00G 300 543.0 B
        if(lst.isEmpty()) {
            return "Buy: 0 Sell: 0";
        }

        double buy = 0, sell = 0;
        String[] input = lst.split(", ");
        String bad = "";

        for(String text: input) {
            String[] fields = text.split(" ");

            if(!isCorrect(fields)) {
                bad += text + " ;";
            } else {
                double p = Double.parseDouble(fields[1]) * Double.parseDouble(fields[2]);
                if(text.endsWith("B")){
                    buy += p;
                } else {
                    sell += p;
                }
            }
        }

        String buyFormatted = String.format("%.0f", buy);
        String sellFormatted = String.format("%.0f", sell);

        String result = "Buy: " + buyFormatted + " Sell: " + sellFormatted;
        String[] badlyFormed = bad.split(";");

        if(bad.equals("")) {
            return result;
        } else {
            return result + "; Badly formed " + badlyFormed.length + ": " + bad;
        }
    }
}