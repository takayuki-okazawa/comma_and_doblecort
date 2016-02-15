import java.io.FileReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Test {

    public static void main(String args[]) {

        try {
            FileReader fr = new FileReader("test.csv");
            BufferedReader br = new BufferedReader(fr);

            String line;
            StringTokenizer token;
            while ((line = br.readLine()) != null) {

                /* TEST */
                line = convertComma(line);

                token = new StringTokenizer(line, ",");

                while (token.hasMoreTokens()) {

                    /* TEST */
                    String hoge = backConvertComma(String.valueOf(token.nextToken()));
                    hoge = removeDobleC(hoge);
                    System.out.println(hoge);

                }
            }
            br.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /* 両側のダブルコートだけ削除 */
    public static String removeDobleC(String hoge){
      if(hoge.substring(0,1).equals("\"") && hoge.substring(hoge.length()-1).equals("\"")){
        hoge = hoge.substring(1,hoge.length()-1);
      }
      return hoge;
    }

    /* ダブルコートで囲まれたカンマ以外を置き換え */
    public static String convertComma(String hoge){
      char[] charArray = hoge.toCharArray();
      String result = "";
      for(int i = 0; i < charArray.length; i++){

          if(i==0){
              if(charArray[i]==','){
                  result += "ハシモト";
              }
              else{
                  result += charArray[i];
              }
          }
          else if(charArray[i]==',' && (charArray[i-1]!='\"' || charArray[i+1]!='\"')){
              result += "ハシモト";
          }
          else{
              result += charArray[i];
          }
      }
      return result;
    }

    /* ダブルコートで囲まれたカンマ以外を置き換え */
    public static String backConvertComma(String hoge){
      return hoge.replace("ハシモト", ",");
    }

}
