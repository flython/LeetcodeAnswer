package temp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TempTry{
    static String sDirPath = "E:\\Desktop\\logDir";
    static LinkedHashSet<String> tenDayStrSet = new LinkedHashSet<>();
    static Pattern dayDatehRegexPattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
    static SimpleDateFormat fullTimeDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static SimpleDateFormat dayDateFormat = new SimpleDateFormat("yyyy-MM-dd");


    public static void main(String[] args) throws Exception {
        File dir = new File(sDirPath);
        String[] fileNameArr = dir.list();
        init10DaysStrSet();
        assert fileNameArr != null;
        printLog(fileNameArr);

    }

    public static void init10DaysStrSet(){
        Calendar calendar = Calendar.getInstance();
        for (int i = 0; i > -10; --i) {
            //这里可能要考虑一个问题，年月变更会怎样
            calendar.add(Calendar.DAY_OF_YEAR,-1);
            tenDayStrSet.add(dayDateFormat.format(calendar.getTime()));
        }
    }

    public static String getFileDate(String fileName){
        Matcher matcher = dayDatehRegexPattern.matcher(fileName);
        matcher.find();
        return matcher.group();
    }

    public static void printLog(String[] fileNameArr) throws IOException {
        LinkedList<GroupHaCtrlLog> resList = new LinkedList<>();

        for (String fileName : fileNameArr) {
            String logDateDay = getFileDate(fileName);
            if(!tenDayStrSet.contains(logDateDay)){
                continue;
            }

            File file = new File(sDirPath+ File.separator+ fileName);
            BufferedReader bf = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bf.readLine()) != null){
                if(line.contains("The current state of the node changes")){
                    line = line.replaceAll("\u001B\\[34m","").replaceAll("\u001B\\[0;39m","");
                    resList.add(buildLogBean(MessageFormat.format("{0} {1}",logDateDay,line)));
                }
            }

        }

        System.out.println(resList);
    }

    public static GroupHaCtrlLog buildLogBean(String logStr){
        String[] tempArr = logStr.split("\\s*\\|\\s*");
        GroupHaCtrlLog log = null;
        try {
            log = new GroupHaCtrlLog(fullTimeDateFormat.parse(tempArr[0]),tempArr[1],tempArr[2],tempArr[3],tempArr[4]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return log;
    }

}
