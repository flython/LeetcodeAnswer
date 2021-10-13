package fly.leetcode.cn.q273;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class Solution {
    public static final String[] level = {"Hundred","Thousand","Million","Billion"};
    public static final String[] nums = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine",
            "Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen",
            "Twenty","Twenty One","Twenty Two","Twenty Three","Twenty Four","Twenty Five","Twenty Six","Twenty Seven","Twenty Eight","Twenty Nine",
            "Thirty","Thirty One","Thirty Two","Thirty Three","Thirty Four","Thirty Five","Thirty Six","Thirty Seven","Thirty Eight","Thirty Nine",
            "Forty","Forty One","Forty Two","Forty Three","Forty Four","Forty Five","Forty Six","Forty Seven","Forty Eight","Forty Nine",
            "Fifty","Fifty One","Fifty Two","Fifty Three","Fifty Four","Fifty Five","Fifty Six","Fifty Seven","Fifty Eight","Fifty Nine",
            "Sixty","Sixty One","Sixty Two","Sixty Three","Sixty Four","Sixty Five","Sixty Six","Sixty Seven","Sixty Eight","Sixty Nine",
            "Seventy","Seventy One","Seventy Two","Seventy Three","Seventy Four","Seventy Five","Seventy Six","Seventy Seven","Seventy Eight","Seventy Nine",
            "Eighty","Eighty One","Eighty Two","Eighty Three","Eighty Four","Eighty Five","Eighty Six","Eighty Seven","Eighty Eight","Eighty Nine",
            "Ninety","Ninety One","Ninety Two","Ninety Three","Ninety Four","Ninety Five","Ninety Six","Ninety Seven","Ninety Eight","Ninety Nine"};
    public String numberToWords(int num) {
        if (num == 0){return "Zero";}
        //逗号位
        int step = 0;
        LinkedList<String> list = new LinkedList<>();
        while (num != 0){
            int hun = num%100;
            int tho = (num / 100) % 10;
            //处理逗号位
            if (step!=0 && (hun > 0 || tho > 0)){
                list.addFirst(level[step]);
            }
            //十位
            if (hun > 0){
                list.addFirst(nums[hun-1]);
            }
            //百位
            if (tho > 0){
                list.addFirst(level[0]);
                list.addFirst(nums[tho-1]);
            }
            step++;
            num = num / 1000;
        }
        return list.stream().collect(Collectors.joining(" "));
    }
}


