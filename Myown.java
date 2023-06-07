import java.security.*;
import java.util.*;

public class Myown
{
    static String [] alphabet=new String[27];
    private static String key;
    public static void main(String args[]) throws Exception
    {
        alphabet[0]=" ";
        alphabet[1]="a";
        alphabet[2]="b";
        alphabet[3]="c";
        alphabet[4]="d";
        alphabet[5]="e";
        alphabet[6]="f";
        alphabet[7]="g";
        alphabet[8]="h";
        alphabet[9]="i";
        alphabet[10]="j";
        alphabet[11]="k";
        alphabet[12]="l";
        alphabet[13]="m";
        alphabet[14]="n";
        alphabet[15]="o";
        alphabet[16]="p";
        alphabet[17]="q";
        alphabet[18]="r";
        alphabet[19]="s";
        alphabet[20]="t";
        alphabet[21]="u";
        alphabet[22]="v";
        alphabet[23]="w";
        alphabet[24]="x";
        alphabet[25]="y";
        alphabet[26]="z";        
        Scanner sc=new Scanner(System.in);
        System.out.println("Do you want to encrypt or decrypt");
        String type=sc.nextLine();
        if(type.equals("encrypt")){
            System.out.println("Give a phrase");
            String phrase=sc.nextLine();
            // phrase.toLowerCase();
            setKey();
            System.out.println(encrypt(phrase.toLowerCase(Locale.ENGLISH)));
            System.out.println("This is you key keep it safe because it is important "+getKey());
        }
        else if(type.equals("decrypt")){
            System.out.println("What is your key");
            String k=sc.nextLine();
            setExistingKey(k);
            System.out.println("What is the phrase you would like to decrypted");
            String num=sc.nextLine();
            System.out.println(decrypt(num));
        }
        else{
            System.out.println("Looks like you printed something invalid please run teh code again to try it out");
        }
    }
    public static String encrypt(String word)
    {
        String encrypted="";
        String q=(getKey().substring(0,getKey().indexOf("-")));
        String y=(getKey().substring(getKey().indexOf("-")+1));
        int mult=Integer.parseInt(q);
        int add=Integer.parseInt(y);
        for(int i=0;i<word.length();i++)
        {
            // System.out.println("1st for loop");
            for(int x=0;x<alphabet.length;x++)
            {
                // System.out.println("2nd for loop");
                if(word.substring(i,i+1).equals(alphabet[x]))
                {
                    // System.out.println("letter convert working");
                    encrypted=encrypted+(x*mult+add)+" ";
                }
            }
        }
        return encrypted;
    }
    public static String decrypt(String word)
    {
        String decrypted="";

        String[] splitstr=word.trim().split("\\s+");
        String q=(getKey().substring(0,getKey().indexOf("-")));
        String y=(getKey().substring(getKey().indexOf("-")));
        int mult=Integer.parseInt(q);
        int add=Integer.parseInt(y);
        for(int i=0;i<splitstr.length;i++)
        {
            String bob=splitstr[i];
            int small=Integer.parseInt(bob);
            small=small-add;
            small=small/mult;
            decrypted=decrypted+alphabet[small];
        }
        
        // for(int i=0;i<space;i++)
        // {
        //     // focus
        // }
        return decrypted;
    }
    public static void setKey()
    {
        int x=(int)(Math.random()*999+1);
        int y=(int)(Math.random()*200+1);
        key=x+"-"+y;
    }
    public static void setExistingKey(String x)
    {
        key=x;
    }
    public static String getKey()
    {
        return key;
    }
    
}