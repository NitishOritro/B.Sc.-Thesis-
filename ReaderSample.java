package extraction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;

class frequecncy 
{
   String word;
   int frquency; 

    public frequecncy(String w, int f) 
    {
        word = w;
        frquency = f;
    }

    public String getValue()
    {
       return word+" "+frquency;
        
    }
    
    public String getWord()
    {
       return word;
        
    }
    
    public int getFre()
    {
       return frquency;
        
    }
}

public class ReaderSample 
{

    public static void main(String[] args) 
    {
        //String cityList[] = {"USA", "Berlin", "Canada", "Newjursey", "Spain","NewYork"};
        String termList[][] = new String[1000][90000];
        String term[] = new String[90000000];
        String city[] = new String[10000];
        BufferedReader in = null;
        BufferedReader in1 = null;
        BufferedReader in2 = null;
        BufferedReader in3 = null;
        
        try 
        {
            in = new BufferedReader(new FileReader("E:\\read.txt"));
            in1 = new BufferedReader(new FileReader("E:\\status.txt"));
            in2 = new BufferedReader(new FileReader("E:\\reply.txt"));
            in3 = new BufferedReader(new FileReader("E:\\follower.txt"));
            
            StreamTokenizer st = new StreamTokenizer(in);
            StreamTokenizer st1 = new StreamTokenizer(in1);
            StreamTokenizer st2 = new StreamTokenizer(in2);
            StreamTokenizer st3 = new StreamTokenizer(in3);
            
            
            
            int i=0,j=0,k=0,m=0,n=0,count=0,line=0,p=0,q=0,fre=0;
            String value,termValue;
            while(st.nextToken() != StreamTokenizer.TT_EOF ) 
            {
                //if(st.nextToken() == '.')
                {
                    if(st.ttype == StreamTokenizer.TT_NUMBER) 
                    {
                        // the default is to treat numbers differently than words
                        // also the numbers are doubles
                        System.out.println((int)st.nval);
                    }
                    else if(st.ttype != '_' && st.ttype != '!' && st.ttype != '#' && st.ttype != '.' && st.ttype != ':' && st.ttype != ')') 
                    {
                        
                        if(st.ttype == ',')
                        {
                            
                            st.nextToken();
                            city[i++] = st.sval;
                            //termList[line][0] = st.sval;
                            line++;
                        }
                        
                        else
                        {
                            term[j++] = st.sval;
                            termList[line][k++] = st.sval;
                            count++;
                        }
                    
                        //System.out.println(st.sval);
                    }
                    
                
                }
                
                
            }
            
            HashMap<Integer, String> cityTerm = new HashMap<>();
            
            frequecncy frequent[][] = new frequecncy[line][30000];
            
            for(i=0;i<line;i++)
            {
                //System.out.println(city[i]);
                cityTerm.put(i, city[i]);
                
                for(j=0;j<k;j++)
                {
                    if(termList[i][j] != null)
                    {
                        //cityTerm.put(city[i], termList[i][j]);
                        //frequent[i][j] = new frequecncy(termList[i][j], 3);
                        value = termList[i][j];
                        //System.out.println(value+" "+i+" "+j);
                        for(m=i;m<=i;m++)
                        {
                            for(n=0;n<k;n++)
                            {
                                termValue = termList[i][n];
                                if(value.equalsIgnoreCase(termValue)) 
                                {
                                    //System.out.println("if "+i+" "+n+" "+termList[i][n]);
                                    frequent[i][j] = new frequecncy(value, ++fre);
                                }
                                else
                                {
                                    //System.out.println("else "+i+" "+n+" "+termList[i][n]);
                                    //frequent[i][j] = new frequecncy(termList[i][j], 0);
                                }
                            }
                            //System.out.println();
                            fre=0;
                        }
                        //System.out.print(termList[i][j]+" ");
                    }
                    
                }
                //m++;
                //System.out.println();
            }
            
            /*for(i=0;i<frequent.length;i++)
            {
                frequent[i] = new frequecncy(null, k);
            }*/
            
            /***********************************/
            /******** index city cityTerm ******/
            /************Print*******************/
            
            // Get keys.
            Set<Integer> keys = cityTerm.keySet();
            
            for (Integer key : keys) 
            {
                System.out.println(key+" "+cityTerm.get(key));
            }
            
            
            
            for(p=0;p<frequent.length;p++)
            {
                //System.out.println("City Name: "+cityTerm.get(p));
                //System.out.println();
                for(q=0;q<frequent[0].length;q++)
                {
                    if(frequent[p][q] != null )
                    {
                        //System.out.print(frequent[p][q].getValue()+"\n");
                    }
                }
                //System.out.println();
            }
              
            System.out.println();
            
            
            /***********************************/
            /***** Normalize Tweet Word ********/
            /***********************************/
            
            String valueCheck, termValueCheck;
            String userList[] = new String[100];
            String normTweetWord[] = new String[100];
            
            i=0;
            j=0;
            int countTerm=0, Tterm=0, totalTermFrequency=0;
            int T=0;
            Boolean flag = false;
            
            while(st1.nextToken() != StreamTokenizer.TT_EOF) 
            {
                if(st1.ttype == '@')
                { 
                    st1.nextToken();
                    userList[i++] = st1.sval;
                    //termList[line][0] = st.sval;
                    //line++;
                }
                        
                else
                {
                    normTweetWord[j++] = st1.sval;
                    //termList[line][k++] = st.sval;
                    countTerm++;
                } 
                
            }
            System.out.println();
            System.out.println();
           
            System.out.println("Name is @"+userList[0]+"\n");
            
            for(i=0;i<countTerm;i++)
            {
                //System.out.println(normTweetWord[i]);
            }
            
            HashMap<String, Float> statusWord = new HashMap<>();
            String wordTerm;
            int countWordTerm=0;
            
            
            for(i=0;i<countTerm;i++)
            {
                wordTerm = normTweetWord[i];
                for(j=0;j<countTerm;j++)
                {
                    if(wordTerm.equalsIgnoreCase(normTweetWord[j]))
                    {
                        statusWord.put(wordTerm, (float)++countWordTerm);
                    }
                }
                countWordTerm = 0;
            }
            
            Set<String> status = statusWord.keySet();

            // Loop over String keys.
            
            for(String key : status) 
            {
                statusWord.put(key, (float) ( statusWord.get(key) / countTerm ) );
                System.out.println(key+" "+statusWord.get(key));
            }
            
            
            
           
            System.out.println();
            System.out.println();
            HashMap<String, String> Distribution = new HashMap<>();
            HashMap<String, Integer> storeTermFrequency = new HashMap<>();
            HashMap<String, Integer> termUserFrequency = new HashMap<>();
            
            
            
            for(i=0;i<countTerm;i++)
            {
                valueCheck = normTweetWord[i];
                for(p=0;p<frequent.length;p++)
                {
                    //System.out.println("City Name: "+cityTerm.get(p));
                    //System.out.println();
                    for(q=0;q<frequent[0].length;q++)
                    {
                        
                        if(frequent[p][q] != null && valueCheck.equalsIgnoreCase(frequent[p][q].getWord()))
                        {
                            Tterm++;
                            //System.out.println(p+" "+q+" Matched");
                            //System.out.print(valueCheck+" ");
                            flag = true;
                        }
                    }
                    totalTermFrequency = totalTermFrequency + Tterm;
                    Tterm = 0;
                    if(flag == true)
                    {
                        //System.out.println(valueCheck+" "+totalTermFrequency);
                        storeTermFrequency.put(valueCheck, totalTermFrequency);
                    }
                    flag = false;
                }
                totalTermFrequency = 0;
                
            }
            
            System.out.println();
            
            System.out.println("Store Tewrm Frequency");
            System.out.println();
            System.out.println();
            
            
            Set<String> str = storeTermFrequency.keySet();

            // Loop over String keys.
            
            for(String key : str) 
            {
                System.out.println(key+" "+storeTermFrequency.get(key));
            }
            
            flag = false;
            
            System.out.println();
            
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
            DecimalFormat df = new DecimalFormat("#.###");
            
            
            /*********termUserProbability hashmap *********/
            /**********************************************/
            /***Each City Store the term with frequency****/
            /**********************************************/
            
            
            HashMap<Integer, String> cityWordTerm = new HashMap<>();
            HashMap<String, Float> termUserProbability = new HashMap<>();
            int iCITY = 0;
            
            for(String key : str) 
            {
                //System.out.println(key);
                for(p=0;p<frequent.length;p++)
                {
                    //System.out.println("City Name: "+cityTerm.get(p));
                    //System.out.println();
                    for(q=0;q<frequent[0].length;q++)
                    {
                        if(frequent[p][q] != null && key.equalsIgnoreCase(frequent[p][q].getWord()))
                        {
                            flag = true;
                            break;
                        }
                    }
                    if(flag == true)
                    {
                        //System.out.print("City Name: "+cityTerm.get(p)+" "+frequent[p][q].getValue()+" ");
                        //System.out.printf(" Probability "+currencyFormatter.format(((float) frequent[p][q].getFre() / (float)storeTermFrequency.get(key)))+"\n\n");
                        //System.out.printf(" Probability "+df.format(((float) frequent[p][q].getFre() / (float)storeTermFrequency.get(key)))+"\n\n");
                        
                        termUserProbability.put(cityTerm.get(p)+"-"+frequent[p][q].getWord(), (((float) frequent[p][q].getFre() / (float)storeTermFrequency.get(key))) * (float) statusWord.get(key) );
                        cityWordTerm.put(iCITY, cityTerm.get(p)+"-"+frequent[p][q].getWord());
                        iCITY++;
                    }
                    flag = false;
                    //System.out.println();
                }
            }
            
            System.out.println();
            System.out.println("term user probability");
            System.out.println();
            Set<String> prob = termUserProbability.keySet();

            // Loop over String prob.
            for (String key : prob) 
            {
                System.out.println(key+" "+termUserProbability.get(key));
            }
            
            System.out.println();
            
            String replyUserListcity[][] = new String[15][3];
            String replyTermList[][] = new String[1000][4000];
            int lineReply = 0;
            int replyTermCount = 0;
            i=0;j=0;k=0;
            
            while(st2.nextToken() != StreamTokenizer.TT_EOF ) 
            {
                //if(st.nextToken() == '.')
                {
                    if(st2.ttype == StreamTokenizer.TT_NUMBER) 
                    {
                        System.out.println((int)st2.nval);
                    }
                    
                    if(st2.ttype == '@')
                    {
                            
                        st2.nextToken();
                        replyUserListcity[i][0] = st2.sval;
                        //termList[line][0] = st.sval;
                        
                    }
                    else if(st2.ttype == ',') /*** city is stored ****/
                    {
                        
                        st2.nextToken();
                        replyUserListcity[i++][1] = st2.sval;
                        lineReply++;
                    }
                        
                    else
                    {
                        //term[j++] = st2.sval;
                        replyTermList[lineReply][k++] = st2.sval;
                        replyTermCount++;
                        //System.out.println(st2.sval);
                    }
                    
                    //System.out.println(st.sval);
                }
            }
           
            System.out.println("Reply List\n");
            
            HashMap<Integer, String> indexUserName = new HashMap<>();
            HashMap<String, String> userNameCity = new HashMap<>();
            frequecncy replyFrequent[][] = new frequecncy[lineReply][30000];
            
            for(i=0;i<lineReply;i++)
            {
                //System.out.println(replyUserListcity[i][0]+" "+replyUserListcity[i][1]);
            }
            System.out.println();
          
            String replyValue, replyTermValue;
            fre=0;
            
            for(i=0;i<lineReply;i++)
            {
                //System.out.println(city[i]);
                indexUserName.put(i, replyUserListcity[i][0]);
                userNameCity.put(replyUserListcity[i][0], replyUserListcity[i][1]);
                for(j=0;j<k;j++)
                {
                    if(replyTermList[i][j] != null)
                    {
                        //cityTerm.put(city[i], termList[i][j]);
                        //frequent[i][j] = new frequecncy(termList[i][j], 3);
                        replyValue = replyTermList[i][j];
                        //System.out.println(value+" "+i+" "+j);
                        for(m=i;m<=i;m++)
                        {
                            for(n=0;n<k;n++)
                            {
                                replyTermValue = replyTermList[i][n];
                                if(replyValue.equalsIgnoreCase(replyTermValue)) 
                                {
                                    //System.out.println("if "+i+" "+n+" "+termList[i][n]);
                                    replyFrequent[i][j] = new frequecncy(replyValue, ++fre);
                                }
                                else
                                {
                                    //System.out.println("else "+i+" "+n+" "+termList[i][n]);
                                    //frequent[i][j] = new frequecncy(termList[i][j], 0);
                                }
                            }
                            //System.out.println();
                            fre=0;
                        }
                        //System.out.print(termList[i][j]+" ");
                    }
                    
                }
                //m++;
                //System.out.println();
            }
            System.out.println();
            Set<Integer> kName = indexUserName.keySet();
            Set<String> kCity = userNameCity.keySet();
              
            for(Integer key : kName) 
            {
                System.out.println(key+" "+indexUserName.get(key));
            } 
            System.out.println();
            for(String key : kCity) 
            {
                System.out.println(key+" "+userNameCity.get(key));
            }
            System.out.println();
            
            for(p=0;p<replyFrequent.length;p++)
            {
                //System.out.println("User Name: "+indexUserName.get(p));
                //System.out.println();
                for(q=0;q<replyFrequent[0].length;q++)
                {
                    if(replyFrequent[p][q] != null )
                    {
                        //System.out.print(replyFrequent[p][q].getValue()+"\n");
                    }
                }
                //System.out.println();
            }
            
            
            flag = false;
            
            System.out.println();
            totalTermFrequency = 0;
            
            HashMap<String, Float> replyTermUserProbability = new HashMap<>();
            HashMap<Integer, String> replyCityWordTerm = new HashMap<>();
            
            iCITY = 0;
                    
            for(i=0;i<countTerm;i++)
            {
                valueCheck = normTweetWord[i];
                if(valueCheck != null)
                {
                    for(p=0;p<replyFrequent.length;p++)
                    {
                        //System.out.println("City Name: "+cityTerm.get(p));
                        //System.out.println();
                        for(q=0;q<replyFrequent[0].length;q++)
                        {
                            if(replyFrequent[p][q] != null && valueCheck.equalsIgnoreCase(replyFrequent[p][q].getWord()))
                            {
                            
                                replyTermUserProbability.put(userNameCity.get(replyUserListcity[p][0])+"-"+replyFrequent[p][q].getWord(), (((float) replyFrequent[p][q].getFre() / (float)storeTermFrequency.get(valueCheck))));
                                replyCityWordTerm.put(iCITY, userNameCity.get(replyUserListcity[p][0])+"-"+replyFrequent[p][q].getWord());
                                iCITY++;
                                //System.out.println(userNameCity.get(valueCheck)+" "+replyFrequent[p][q].getWord()+" "+(((float) replyFrequent[p][q].getFre() / (float)storeTermFrequency.get(valueCheck))));
                                break;
                            }
                        }
                    }
                }
            }
           
            Set<String> prob1 = replyTermUserProbability.keySet();

            // Loop over String prob.
            for(String key : prob1) 
            {
                System.out.println(key+" "+replyTermUserProbability.get(key));
            }
            
            
            /******************************************/
            /*****************************************/
            // city location from Word Term  
            // probabilty find out
            /******************************************/
            /*****************************************/
            
            HashMap<String, Float> userEstimatedCityLocation1 = new HashMap<>();
            HashMap<String, Float> userEstimatedCityLocation2 = new HashMap<>();
            HashMap<Float, String> userEstimatedCityLocation = new HashMap<>();
            HashMap<Float, String> estimatedCityLocation = new HashMap<>();
            String keySearch, areaSearch, replyTermKeySearch;
            Float probabilityCount = 0.0f;
            
            
            for(i=0;i<cityTerm.size();i++)
            {
                for(j=0;j<normTweetWord.length;j++)
                {
                    keySearch = cityTerm.get(i)+"-"+normTweetWord[j];
                    for(k=0;k<termUserProbability.size();k++)
                    {
                        areaSearch = cityWordTerm.get(k);
                        
                        if(keySearch.equalsIgnoreCase(areaSearch))
                        {
                            probabilityCount = probabilityCount + termUserProbability.get(areaSearch);
                            userEstimatedCityLocation1.put(cityTerm.get(i), probabilityCount);
                        }
                    }
                }
            }
            
            System.out.println();
            System.out.println();
            
            Set<String> loc1 = userEstimatedCityLocation1.keySet();

            // Loop over String prob.
            for(String key : loc1) 
            {
                System.out.println(key+" "+userEstimatedCityLocation1.get(key));
            }
            
            
            /******************************************/
            /*****************************************/
            // city location  Reply Word Term 
            // probabilty find out
            /******************************************/
            /*****************************************/
            
            
            probabilityCount = 0.0f;
            
            for(i=0;i<cityTerm.size();i++)
            {
                for(j=0;j<normTweetWord.length;j++)
                {
                    keySearch = cityTerm.get(i)+"-"+normTweetWord[j];
                    for(k=0;k<replyTermUserProbability.size();k++)
                    {
                        areaSearch = replyCityWordTerm.get(k);
                        
                        if(keySearch.equalsIgnoreCase(areaSearch))
                        {
                            probabilityCount = probabilityCount + replyTermUserProbability.get(areaSearch);
                            userEstimatedCityLocation2.put(cityTerm.get(i), probabilityCount);
                        }
                    }
                }
            }
            
            
            System.out.println();
            System.out.println();
            
            Set<String> loc2 = userEstimatedCityLocation2.keySet();

            // Loop over String prob.
            for(String key : loc2) 
            {
                System.out.println(key+" "+userEstimatedCityLocation2.get(key));
            }
            
            float f1,f2;
            
            System.out.println();
            System.out.println();
            flag = false;
            for(String key1 : loc1)
            {
                keySearch = key1;
                f1 = userEstimatedCityLocation1.get(key1);
                for(String key2 : loc2)
                {
                    areaSearch = key2;
                    f2 = userEstimatedCityLocation2.get(key2);
                    if(key1.equalsIgnoreCase(key2))
                    {
                        userEstimatedCityLocation1.put(key1, f1+f2);
                        flag = true;
                        break;
                    }
                }
                
            }
            
            for(String key2 : loc2)
            {
                keySearch = key2;
                f1 = userEstimatedCityLocation2.get(key2);
                for(String key1 : loc1)
                {
                    areaSearch = key1;
                    f2 = userEstimatedCityLocation1.get(key1);
                    if(key1.equalsIgnoreCase(key2))
                    {
                        //userEstimatedCityLocation1.put(key1, f1+f2);
                        flag = true;
                        break;
                    }
                    else
                    {
                        flag = false;
                    }
                }
                if(flag == false)
                {
                    userEstimatedCityLocation1.put(keySearch, f1);
                }
                
            }
            
            
            
            for(String key : loc1) 
            {
                System.out.println(key+" "+userEstimatedCityLocation1.get(key));
                userEstimatedCityLocation.put(userEstimatedCityLocation1.get(key), key);
            }
            
            System.out.println();
            System.out.println();
            
            Map<Float, String> map = new TreeMap<Float, String>(userEstimatedCityLocation); 
            System.out.println("After Sorting:");
            Set set2 = map.entrySet();
            Iterator iterator2 = set2.iterator();
            while(iterator2.hasNext()) 
            {
                Map.Entry me2 = (Map.Entry)iterator2.next();
                
                //estimatedCityLocation.put((float) me2.getKey(), (String) me2.getValue());
                
                System.out.print(me2.getKey() + ": ");
                System.out.println(me2.getValue());
            }
            
            System.out.println();
            System.out.println();
            
            Set<Float> loc3 = estimatedCityLocation.keySet();

            // Loop over String prob.
            for(Float key : loc3) 
            {
                System.out.println(key+" "+estimatedCityLocation.get(key));
            }
            
            
            
            
            
          
        }
        catch(IOException ex) 
        {
            System.err.println(ex.getMessage());
        }
        finally 
        {
            if (in != null) 
            {
                try 
                {
                    in.close();
                }
                catch (IOException ex) 
                {
                    
                }
            }
        }
    }
}