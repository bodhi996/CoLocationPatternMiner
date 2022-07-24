import java.io.*;
import java.lang.Math;
import java.util.Random;   
public class generate {
    public static void main(String[] args)
    {
        try
        {
            FileWriter geek_file;
            geek_file = new FileWriter("C:\\Users\\Bodhisatwa\\Desktop\\test.txt");
            BufferedWriter geekwrite = new BufferedWriter(geek_file);
            for(char a='a';a<='o';a++)
            {
                Random r = new Random();
                int low = 0;
                int high = 50;
                int result = r.nextInt(high-low) + low;
                for(int j=0;j<result;j++)
                {
                    int l = 0;
                    int h = 100;
                    int x=r.nextInt(h-l) + l;
                    int y=r.nextInt(h-l) + l;
                    String str=" "+ a+ " "+j+ " "+x+ " "+y;
                    //System.out.println(str);
                    // Initializing BufferedWriter
                    geekwrite.write(str);
                    geekwrite.newLine();

                }
                        
            }
            geekwrite.close();
        }
        catch (IOException except)
        {
            except.printStackTrace();
        }
    }
    
}
