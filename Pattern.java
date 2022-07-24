import java.util.*;
import java.sql.*;
import java.time.Duration;
import java.time.Instant;
import java.io.*;
public class Pattern implements Serializable
{
    int counter=1;
    String feature;
    int dist=20;
    static HashMap<Pattern, HashMap<String, ArrayList<Integer>>> instance=new HashMap<Pattern, HashMap<String, ArrayList<Integer>>>();
    HashMap<String, ArrayList<Integer>> key=new HashMap<>();
    public Pattern(String feature)
    {
        this.feature=feature;        
    }
    public void input(Pattern Feature, String index, int x, int y)
    {
        Connection conn = null;
        try 
        { 
            String dbURL2 = "jdbc:postgresql://localhost:5432/Pattern";
            String user = "postgres";
            String pass = "ABcd1234#";
            conn = DriverManager.getConnection(dbURL2, user, pass);
            if (conn != null) {
                //
                Statement stmt = conn.createStatement();
                DatabaseMetaData dbm = conn.getMetaData();
                ResultSet tables = dbm.getTables(null, null, Feature.feature, null);
                if (tables.next()) {
                    // Table exists
                    String sql="INSERT INTO "+Feature.feature+"(row, x, y) VALUES ('"+Feature.feature+index+"', "+x+", "+y+")";
                    //System.out.println(sql);
                    stmt.executeUpdate(sql);
                }
                else {
                    // Table does not exist
                    String sql = "CREATE TABLE "+Feature.feature+" (row VARCHAR(1023) not NULL, x INTEGER not NULL, y INTEGER not NULL,"+ 
                   "PRIMARY KEY (row))"; 
                   stmt.executeUpdate(sql);
                   sql="INSERT INTO "+Feature.feature+"(row, x, y) VALUES ('"+Feature.feature+index+"', "+x+", "+y+")";
                   stmt.executeUpdate(sql);
                }
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        ArrayList<Integer> a1 = new ArrayList<Integer>();
        a1.add(x);
        a1.add(y);
        key.put(index, a1);
        instance.put(Feature, key);
    }
    public void userinput() throws Exception
    {
        int counter=0;
        Pattern fea[]=new Pattern[10000];
        HashMap<String, Integer> map=new HashMap<String, Integer>();
        FileReader fr=new FileReader("C:\\Users\\Bodhisatwa\\Desktop\\test.txt");    
        BufferedReader br=new BufferedReader(fr);    
        int i;    
        while((i=br.read())!=-1){  
            String line =br.readLine(); 
            String lin[]=line.split(" ");
            //for(int j=0;j<lin.length;j++)
            //{
                //System.out.print(lin[j]+j+" ");
            //}
            //System.out.println();
            if(map.containsKey(lin[0]))
            {
                fea[map.get(lin[0])].input(fea[map.get(lin[0])], lin[1], Integer.parseInt(lin[2]), Integer.parseInt(lin[3]));
            }
            else
            {
                map.put(lin[0], counter);
                fea[counter]=new Pattern(lin[0]);
                fea[counter].input(fea[counter], lin[1], Integer.parseInt(lin[2]), Integer.parseInt(lin[3]));
                counter++;
            }
        }  
        br.close();    
        fr.close(); 
        /*fea[0]=new Pattern("a");
        fea[0].input(fea[0], "1", 17, 19);
        fea[0].input(fea[0], "2", 1345, 193);
        fea[0].input(fea[0], "3", 12, 319);
        fea[1]=new Pattern("c");
        fea[1].input(fea[1], "11", 14, 9);
        fea[1].input(fea[1], "12", 1342, 1);
        fea[1].input(fea[1], "14", 3, 19);
        fea[2]=new Pattern("b");
        fea[2].input(fea[2], "4", 15, 19);
        fea[2].input(fea[2], "5", 12, 11);
        fea[2].input(fea[2], "6", 30, 29);
        fea[4]=new Pattern("d");
        fea[4].input(fea[4], "4", 1534, 149);
        fea[4].input(fea[4], "5", 112, 1);
        fea[4].input(fea[4], "6", 11, 20);
        fea[5]=new Pattern("e");
        fea[5].input(fea[5], "2", 15, 14);
        fea[5].input(fea[5], "7", 11, 31);
        fea[5].input(fea[5], "8", 41, 60);*/
        String str="";
        for(Map.Entry<Pattern, HashMap<String, ArrayList<Integer>>> mp1 :instance.entrySet()) 
        {
            Pattern keys1 = mp1.getKey();
            str+=keys1.feature;
        }
        String feat=participation(new Pattern(str));
        int size=2;
        int k=100;
        ArrayList<String> ans=new ArrayList<String>();
        for(i=size;i<=feat.length();i++)
        {
            generate(feat, i, "", ans, 0);
        }
        for(i=0;i<ans.size();i++)
        {
            
            fea[i+k]=new Pattern(ans.get(i));
            fea[i+k].greaterjoin(fea[i+k]);
        }
        //fea[1].join(fea[1], fea[0]);
        //fea[1].join(fea[0], fea[2]);
        //fea[1].join(fea[1], fea[2]);
        //fea[1].join(fea[4], fea[0]);
        // fea[4]=new Pattern("ac");
    }
    public static  void  main(String[] args) throws Exception
    {
        Pattern obj=new Pattern("abc");
        long start1 = System.nanoTime();
        Connection conn = null;
        try 
        { 
            String dbURL2 = "jdbc:postgresql://localhost:5432/Pattern";
            String user = "postgres";
            String pass = "ABcd1234#";
            conn = DriverManager.getConnection(dbURL2, user, pass);
            if (conn != null) {
                //
                Statement stmt = conn.createStatement();
                DatabaseMetaData metaData = conn.getMetaData();
                String[] types = {"TABLE"};
                //ResultSet tables = dbm.getTables(null, null, Feature.feature, null);
                ResultSet tables = metaData.getTables(null, null, "%", types);
                while (tables.next()) {
                    String sql="Drop table "+tables.getString("TABLE_NAME");
                    stmt.executeUpdate(sql);
                }
                
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        //Pattern obj=new Pattern("abc");
        obj.userinput();
        //obj.writer();
        //obj.display();
        obj.result();
        long end1 = System.nanoTime();      
        System.out.println("Elapsed Time in nano seconds: "+ (end1-start1));  
    }
    public void result()
    {
        ArrayList<String> list=new ArrayList<String>();
        int ma=0; 
        Connection conn = null;
        try 
        { 
            String dbURL2 = "jdbc:postgresql://localhost:5432/Pattern";
            String user = "postgres";
            String pass = "ABcd1234#";
            conn = DriverManager.getConnection(dbURL2, user, pass);
            if (conn != null) {
                //
                Statement stmt = conn.createStatement();
                DatabaseMetaData metaData = conn.getMetaData();
                String[] types = {"TABLE"};
                //ResultSet tables = dbm.getTables(null, null, Feature.feature, null);
                ResultSet tables = metaData.getTables(null, null, "%", types);
                while (tables.next()) {
                    if(tables.getString("TABLE_NAME").length()>ma)
                    {
                        ma=tables.getString("TABLE_NAME").length();
                        list.clear();
                        list.add(tables.getString("TABLE_NAME"));
                    }
                    else if(tables.getString("TABLE_NAME").length()==ma)
                    {
                        list.add(tables.getString("TABLE_NAME"));                
                    }
                    //String sql="Drop table "+tables.getString("TABLE_NAME");
                    //stmt.executeUpdate(sql);
                }
                
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i));
        }  
    } 
    
    void generate(String feat, int size, String str, ArrayList<String> ans, int x)
    {
        if(size==0)
        {
            ans.add(str);
            return ;
        }
        for(int i=x;i<feat.length();i++)
        {
            char ch=feat.charAt(i);
            x++;
            generate(feat, size-1, str+ch, ans, x);
        }
        x++;
        int len=str.length();
        //str=str.substring(0,len-1);
        return ;
    }
    public void greaterjoin(Pattern A)
    {
        String feature2=A.feature;
        String[] f = feature2.split("");
        Pattern ob[]=new Pattern[100];
        for(int i=0;i<f.length;i++)
        {
            ob[i]=new Pattern(f[i]);
        }
        ArrayList<String> ans = new ArrayList<String>();
        int size=A.feature.length();
        backtrack(ans, ob, size, "", 0, size);
        Connection conn = null;
        //HashMap<String, ArrayList<Integer>> hash=new HashMap<>();
        try 
        { 
            String dbURL2 = "jdbc:postgresql://localhost:5432/Pattern";
            String user = "postgres";
            String pass = "ABcd1234#";
            conn = DriverManager.getConnection(dbURL2, user, pass);
            if (conn != null) {
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY, 
                ResultSet.HOLD_CURSORS_OVER_COMMIT);
                //String sql = "CREATE TABLE "+a+" (row VARCHAR(1023) not NULL, "+" dist INTEGER not NULL,"+" PRIMARY KEY (row))"; 
                //stmt.executeUpdate(sql);
                for(int h=0; h<ans.size();h++)
                {
                    String[] arr = ans.get(h).split("-");
                    ArrayList<Integer> coordinates=new ArrayList<>();
                    for(int i=0;i<f.length;i++)
                    {
                        String strSelect = "select * from "+f[i];
                        ResultSet rset = stmt.executeQuery(strSelect);
                        while(rset.next())
                        {
                            int x1=Integer.parseInt(rset.getString("x"));
                            int y1=Integer.parseInt(rset.getString("y"));
                            String row=rset.getString("row");
                            if(row.equals(f[i]+arr[i]))
                            {
                                coordinates.add(x1);
                                coordinates.add(y1);
                            }
                        }
                    
                    }
                    String str=f[0]+arr[0];
                    if(validList(coordinates))
                    {
                        for(int l=1;l<arr.length;l++)
                        {
                            str+="-"+f[l]+arr[l];
                        }
                        System.out.println(str);
                        Statement stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY, 
                        ResultSet.HOLD_CURSORS_OVER_COMMIT);
                        DatabaseMetaData dbm = conn.getMetaData();
                        ResultSet tables = dbm.getTables(null, null, feature2, null);
                        if (tables.next()) {
                            // Table exists
                            //
                            String sql="INSERT INTO "+ feature2 +"(row) VALUES ('"+str+"')";
                         
                            stmt.executeUpdate(sql);
                        }
                        else {
                            // Table does not exist
                            String sql = "CREATE TABLE "+feature2+" (row VARCHAR(1023) not NULL PRIMARY KEY)";
              
                            stmt.executeUpdate(sql);
                            sql="INSERT INTO "+feature2+"(row) VALUES ('"+str+"' )";
                            stmt2.executeUpdate(sql);
                        }
                    /*for(int i=0;i<coordinates.size();i+=1)
                    {
                        //for(int j=0;j<coordinates.size();j+=2)
                        {
                            //double x1=coordinates.get(i), x2=coordinates.get(j), y1=coordinates.get(i), y2=coordinates.get(j);
                            //double distance= Math.sqrt( Math.pow((x1-x2),2) +  Math.pow((y1-y2),2));
                            //if(distance > dist)
                            {
                            }
                        }
                    }  */
                    }
                }
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }
    public void backtrack(ArrayList<String> ans, Pattern ob[], int size, String str, int xi, int n)
    {
        if(size==0)
        {
            ans.add(str);
            return ;
        }
        for(int i=xi;i<n;i++)
        {
            HashMap<String, ArrayList<Integer>> hash=null;
            for(Map.Entry<Pattern, HashMap<String, ArrayList<Integer>>> mp1 :instance.entrySet()) 
            {
                Pattern keys1 = mp1.getKey();
                if(keys1.feature.equals(ob[i].feature))
                {
                    hash=instance.get(keys1);
                }
            }
            ArrayList<String> list=new ArrayList<>();
            for(Map.Entry<String, ArrayList<Integer>> mp2 :hash.entrySet())  
            {
                String keymp2=mp2.getKey();
                ArrayList<Integer> x=mp2.getValue();
                list.add(keymp2);
            }
            for (int j=0; j<list.size();j++)
            {
                int klen=list.get(j).length();
                str+=list.get(j)+"-";
                backtrack(ans, ob, size-1, str, xi+1, n);
                int len=str.length();
                //xi--;
                str=str.substring(0, len-1-klen);
            }
            return ;
        }
    }
    public void joinGenerate(Pattern A, Pattern B)
    {
        for (Map.Entry<Pattern, HashMap<String, ArrayList<Integer>>> mp1 :instance.entrySet()) 
        {
            Pattern keys1 = mp1.getKey();
            for (Map.Entry<Pattern, HashMap<String, ArrayList<Integer>>> mp2 :instance.entrySet())  
            {
                Pattern keys2 = mp2.getKey();
                String a=keys1.feature.trim(),b = keys2.feature.trim(), c=A.feature.trim(), d = B.feature.trim();
                if(c.equals(a) && d.equals(b))
                {
                    join(keys1, keys2);
                    return ;
                }
            }
        }
    }
    public void join(Pattern A, Pattern B)
    {
        Connection conn = null;
        try 
        { 
            String dbURL2 = "jdbc:postgresql://localhost:5432/Pattern";
            String user = "postgres";
            String pass = "ABcd1234#";
            conn = DriverManager.getConnection(dbURL2, user, pass);
            if (conn != null) {
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY, 
                ResultSet.HOLD_CURSORS_OVER_COMMIT);
                String s="", a, b;
                if(A.feature.compareTo(B.feature)<0)
                {
                    a=A.feature;
                    b=B.feature;
                }
                else
                {
                    a=B.feature;
                    b=A.feature;
                }
                s=a+b;
                String sql = "CREATE TABLE "+s+" (row VARCHAR(1023) not NULL, "+" dist INTEGER not NULL,"+" PRIMARY KEY (row))"; 
                stmt.executeUpdate(sql);
                String strSelect = "select * from "+a;
                ResultSet rset = stmt.executeQuery(strSelect);
                while(rset.next())
                {
                    int x1=Integer.parseInt(rset.getString("x"));
                    int y1=Integer.parseInt(rset.getString("y"));
                    Statement stmt2 = conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
                    String strSelect2 = "select * from "+b;
                    ResultSet rset3 = stmt2.executeQuery(strSelect2);
                    ResultSet rset2=rset3;
                    while(rset2.next())
                    {
                        int x2=Integer.parseInt(rset2.getString("x"));
                        int y2=Integer.parseInt(rset2.getString("y"));
                        double distance= Math.sqrt( Math.pow((x1-x2),2) +  Math.pow((y1-y2),2));
                        String r=rset.getString("row")+"-"+rset2.getString("row");
                        if(distance < dist)
                        {
                            Statement stmt3 = conn.createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);
                            stmt3.executeUpdate("INSERT INTO "+s+" VALUES ( '"+r +"',"+distance+")");

                        }

                    }
                }
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
    }
    public String participation(Pattern A)
    {
        Set<Character> hs = new HashSet<Character>();
        for(int i=0;i<A.feature.length();i++)
        {
            char c1=A.feature.charAt(i);//, c2=B.feature.charAt(i);
            hs.add(c1);
            //hs.add(c2);
        }
        String str="";
        for(Character val: hs)
        str+=val;
        return str;
    }
    public boolean validList(ArrayList<Integer> co)
    {
        for(int i=0;i<co.size();i+=2)
        {
            for(int j=0;j<co.size();j+=2)
            {
                double x1=co.get(i), x2=co.get(j), y1=co.get(i+1), y2=co.get(j+1);
                double distance= Math.sqrt( Math.pow((x1-x2),2) +  Math.pow((y1-y2),2));
                if(distance > dist)
                {
                    return false;
                }
            }
        }  
        return true;      
        /*String featureinstance=f.feature;
        String[] rowinst = rowinstance.split("-");
        String[] featureList = featureinstance.split("");
        int n=featureList.length;
        ArrayList<ArrayList<Integer>> coordinates= new ArrayList<>();
        ArrayList<Integer> x=new ArrayList<>();
        for(Map.Entry<Pattern, HashMap<String, ArrayList<Integer>>> mp1 :instance.entrySet()) 
        {
            
             Pattern keys1 = mp1.getKey();
             HashMap<String, ArrayList<Integer>> hash=mp1.getValue();
             for(Map.Entry<String, ArrayList<Integer>> mp2 :hash.entrySet())  
             {
                 String keymp2=mp2.getKey();
                 String a=f.feature.trim(),b = keys1.feature.trim(), c=rowinstance.trim(), d=keymp2.trim();
                 if(c.equals(d) && a.equals(b))
                 {
                     x = mp2.getValue();
                 }
             }
             
        }
        for(int i=0;i<x.size();i++)
        {
        }
        return x;*/
    }
    void display()
    {
        try
        {
            FileWriter geek_file;
            geek_file = new FileWriter("C:\\Users\\Bodhisatwa\\Desktop\\test.txt");
            BufferedWriter geekwrite = new BufferedWriter(geek_file);
            for(Map.Entry<Pattern, HashMap<String, ArrayList<Integer>>> mp1 :instance.entrySet()) 
            {
                Pattern keys1 = mp1.getKey();
                HashMap<String, ArrayList<Integer>> hash=mp1.getValue();
                for(Map.Entry<String, ArrayList<Integer>> mp2 :hash.entrySet())  
                {
                    String keymp2=mp2.getKey();
                    ArrayList<Integer> x = mp2.getValue();
                    //for(int i = 0; i < x.size(); i++)
                    {
                        String str=" "+ keys1.feature+ " "+keymp2+ " "+x.get(0)+ " "+x.get(1);
                        //System.out.println(str);
                        // Initializing BufferedWriter
                        geekwrite.write(str);
                        geekwrite.newLine();
                        
                    }
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
