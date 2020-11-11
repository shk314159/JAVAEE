import java.io.*;
import java.math.*;
import java.util.*;
import java.text.DecimalFormat;
public class MAIN {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        DecimalFormat df=new DecimalFormat("0.00");//小数保留2位

        while(cin.hasNext()){
            BigDecimal a= cin.nextBigDecimal();
            System.out.println(df.format(a));
        }//多组输入
    }
}