import java.util.*;
public class Pattern 
{
    int k;
    int counter=1;
    String feature;
    static HashMap<Pattern, HashMap<String, ArrayList<Integer>>> instance=new HashMap<Pattern, HashMap<String, ArrayList<Integer>>>();
    HashMap<String, ArrayList<Integer>> key=new HashMap<>();
    public Pattern(String feature)
    {
        this.feature=feature;        
    }
    public void input(Pattern Feature, String index, int x, int y)
    {
        ArrayList<Integer> a1 = new ArrayList<Integer>();
        a1.add(x);
        a1.add(y);
        key.put(index, a1);
        instance.put(Feature, key);
    }
    public void userinput()
    {
        Pattern fea[]=new Pattern[100];
        fea[0]=new Pattern("A");
        fea[0].input(fea[0], "1", 17, 139);
        fea[0].input(fea[0], "2", 1345, 193);
        fea[0].input(fea[0], "3", 12, 319);
        fea[1]=new Pattern("C");
        fea[1].input(fea[1], "11", 145, 9);
        fea[1].input(fea[1], "12", 1, 1);
        fea[1].input(fea[1], "14", 3, 19);
        fea[2]=new Pattern("B");
        fea[2].input(fea[2], "4", 15, 19);
        fea[2].input(fea[2], "5", 12, 11);
        fea[2].input(fea[2], "6", 30, 29);
        fea[1].join(fea[1], fea[0]);
        fea[1].join(fea[0], fea[2]);
    }
    public void join(Pattern A, Pattern B)
    {
        HashMap<String, ArrayList<Integer>> map1= instance.get(A);
        HashMap<String, ArrayList<Integer>> map2= instance.get(B);
        ArrayList<String> xyz = new ArrayList<String>();
        ArrayList<Pattern> abc = new ArrayList<Pattern>();
        Pattern ob;
        for (Map.Entry<String, ArrayList<Integer>> mp1 :map1.entrySet()) 
        {
             for (Map.Entry<String, ArrayList<Integer>> mp2 :map2.entrySet())  
             {
                 String keys1 = mp1.getKey();
                 ArrayList<Integer> val1 = mp1.getValue();
                 String keys2 = mp2.getKey();
                 ArrayList<Integer> val2 = mp2.getValue();
                 //System.out.println(keys1+" "+val1.get(0)+" "+keys2+" "+val2.get(0));
                 String keys=keys1+"-"+keys2,fe=A.feature+B.feature;
                 String[] k = keys.split("-");
                 int n=k.length;
                 String[] f = fe.split("");
                 //System.out.print(fe+" ");
                 for(int i=0;i<f.length;i++)
                 {
                     //System.out.print(k[i]+" ");
                     int min=i;
                     for(int j=i+1;j<f.length;j++)
                     {
                         if(f[min].compareTo(f[j])>0)
                         {
                             min=j;
                         }
                     }
                     String temp=f[min];
                     f[min]=f[i];
                     f[i]=temp;
                     temp=k[min];
                     k[min]=k[i];
                     k[i]=temp;
                 }
                 keys=k[0];
                 fe=f[0];
                 for(int i=1;i<f.length;i++)
                 {
                     fe+=f[i];
                     keys+="-"+k[i];
                 }
                 ob=new Pattern(fe);
                 abc.add(ob);
                 xyz.add(keys);
             }
        }
        Pattern p=null;
        ArrayList<Integer> x = new ArrayList<Integer>();
        HashMap<String, ArrayList<Integer>> keylocal=new HashMap<>();
        for (int i = 0; i < xyz.size(); i++)
        {
             //System.out.println(abc.get(i).feature +" "+ xyz.get(i));
             keylocal.put(xyz.get(i), x);
             p=abc.get(i);
        }
        instance.put(p, keylocal);
    }
    public boolean participation(double dist, String rowinstance, Pattern f)
    {
        String featureinstance=f.feature;
        String[] rowinst = rowinstance.split("-");
        String[] featureList = featureinstance.split("");
        int n=featureList.length;
        ArrayList<ArrayList<Integer>> coordinates= new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            Pattern obj=new Pattern(featureList[i]);
            ArrayList<Integer> x=validList(rowinst[i], obj);
            //System.out.println(obj.feature+" "+rowinst[i]);//+" "+x.get(0)
            coordinates.add(x);
        }
        for(int i=0;i<coordinates.size();i++)
        {
            for(int j=0;j<coordinates.size();j++)
            {
                System.out.println(coordinates.get(i).get(0)+","+coordinates.get(j).get(0));
                if(i!=j)
                {
                    double distance= Math.sqrt( (coordinates.get(i).get(0)-coordinates.get(j).get(0))^2 + (coordinates.get(i).get(1)-coordinates.get(j).get(1))^2);
                    if(distance > dist)
                    return false;
                }
            }
        }
        //System.out.println(coordinates.get(0).get(0));keymp2
        return true;
    }
    public ArrayList<Integer> validList(String rowinstance, Pattern f)
    {
        String featureinstance=f.feature;
        String[] rowinst = rowinstance.split("-");
        String[] featureList = featureinstance.split("");
        int n=featureList.length;
        ArrayList<ArrayList<Integer>> coordinates= new ArrayList<>();
        ArrayList<Integer> x=new ArrayList<>();
        for(Map.Entry<Pattern, HashMap<String, ArrayList<Integer>>> mp1 :instance.entrySet()) 
        {
             Pattern keys1 = mp1.getKey();
             //System.out.println("1."+ keys1.feature + "    "+f.feature);
             HashMap<String, ArrayList<Integer>> hash=mp1.getValue();
             for(Map.Entry<String, ArrayList<Integer>> mp2 :hash.entrySet())  
             {
                 String keymp2=mp2.getKey();
                 //System.out.println("2."+ keymp2+ "    "+rowinstance);
                 String a=f.feature.trim(),b = keys1.feature.trim(), c=rowinstance.trim(), d=keymp2.trim();
                 if(c.equals(d) && a.equals(b))
                 {
                     //System.out.println("New Loop");
                     x = mp2.getValue();
                     //System.out.println("2. "+x.get(0));
                 }
             }
        }
        for(int i=0;i<x.size();i++)
        {
            //System.out.println("2. "+x.get(i));
        }
        return x;
        /*for(int i=0;i<coordinates.size();i++)
        {
            ArrayList<Integer> x=coordinates.get(i);
            //System.out.println("Lat and long are "+x.get(0)+","+x.get(1));
            for(int j=0;j<x.size();j++)
            {
                System.out.println(j+","+x.get(j));
            }
        }*/
    }
    void display()
    {
        for(Map.Entry<Pattern, HashMap<String, ArrayList<Integer>>> mp1 :instance.entrySet()) 
        {
             Pattern keys1 = mp1.getKey();
             System.out.println("1."+ keys1.feature);
             HashMap<String, ArrayList<Integer>> hash=mp1.getValue();
             for(Map.Entry<String, ArrayList<Integer>> mp2 :hash.entrySet())  
             {
                 String keymp2=mp2.getKey();
                 ArrayList<Integer> x = mp2.getValue();
                 System.out.println("2. "+keymp2);
                 for(int i = 0; i < x.size(); i++)
                 {
                     System.out.println("3. "+x.get(i));
                 }
             }
        }
    }
    public static  void main()
    {
        Pattern obj=new Pattern("ABC");
        obj.userinput();
        boolean result=obj.participation(1000, "2-4-11", obj);
        System.out.print(result);
        //obj.display();
    }
}
/*
 * Pattern fea[]=new Pattern[100];
        fea[0]=new Pattern("A");
        fea[0].input(fea[0], "1", 17, 139);
        fea[0].input(fea[0], "2", 1345, 193);
        fea[0].input(fea[0], "3", 12, 319);
        fea[1]=new Pattern("C");
        fea[1].input(fea[1], "11", 145, 9);
        fea[1].input(fea[1], "12", 1, 1);
        fea[1].input(fea[1], "14", 3, 19);
        fea[2]=new Pattern("B");
        fea[2].input(fea[2], "4", 15, 19);
        fea[2].input(fea[2], "5", 12, 11);
        fea[2].input(fea[2], "6", 30, 29);
        fea[1].join(fea[1], fea[0]);
        fea[1].join(fea[0], fea[2]);
        */

