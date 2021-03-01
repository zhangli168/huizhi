package com.maoji.huizhi.demo.commmon.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExtractUtil {

    //匹配电话号码
    private static final String regEx_phone = "(^|\\D)(\\d{11}|电话.{0,6}(\\d{7,8}|(\\d{4}|\\d{3})[- ]\\d{7,8}))($^|\\D)";
    //匹配QQ
    private static final String regEx_QQ ="(^|\\D)((账号|QQ|qq).{0,8}\\d{6,13})($^|\\D)";
    //匹配微信
    private static final  String regEx_wx ="((微信).{0,8}[0-9A-Za-z_]{5,50})";
    //匹配支付宝
    private static final  String regEx_zfb ="((支付宝))\\D{0,10}(\\d{11})";
    //匹配银行卡号
    private static final String regEx_bank = "((银行|账号|账户|卡号))\\D{0,10}(\\d{20}|\\d{19}|\\d{16})";
    //匹配网址
    private static final  String regEx_http ="((网址))\\D{0,10}[0-9A-Za-z_./?=]{5,100}";

    //清洗获取数字
    private static final  String regEx_get_number = "([0-9]+)";
    //清洗获取字母或数字或符号 _-
    private static final  String regEx_get_number_letter = "([0-9A-Za-z_-]+)";
    //清洗获取网址
    private static final  String regEx_get_wz = "([0-9A-Za-z:./?=]+)";

    public static void main(String[] args) throws InterruptedException {
    String blnr =
        "测试测试电话：13012345678,测试测试电话：18154323667测试测试qq号：12345678,微信号：qwert12345,测试测试银行卡号：1234567898765412,网址：www.baidu.com,支付宝：13012345678,测试测试测试";
        //提取电话号码
        String lxdh = qxInfo(regEx_get_number,extractMessage(regEx_phone,blnr));
        //提取QQ号
        String qqh = qxInfo(regEx_get_number,extractMessage(regEx_QQ,blnr));
        //提取微信号
        String wxh = qxInfo(regEx_get_number_letter,extractMessage(regEx_wx,blnr));
        //提取支付宝
        String zfbh = qxInfo(regEx_get_number_letter,extractMessage(regEx_zfb,blnr));
        //提取银行卡号
        String yhkh = qxInfo(regEx_get_number,extractMessage(regEx_bank,blnr.replace(" ", "")));
        //提取网址
        String wz = qxInfo(regEx_get_wz,extractMessage(regEx_http,blnr));
        System.out.println("电话号码："+lxdh);
        System.out.println("QQ号："+qqh);
        System.out.println("微信号："+wxh);
        System.out.println("支付宝："+zfbh);
        System.out.println("银行卡号："+yhkh);
        System.out.println("网址："+wz);

    }

    //获取结果
    public static String qxInfo(String reg,List<String> list){
        String result = "";
        Pattern clear=Pattern.compile(reg,Pattern.CASE_INSENSITIVE);
        for (int i = 0; i <list.size() ; i++) {
            Matcher m1=clear.matcher(list.get(i));
            while (m1.find() && !result.contains(m1.group())){
                result += m1.group() + ",";
            }
        }
        if(!result.equals("")){
            result = result.substring(0,result.length()-1);
        }
        return result;
    }

    //通过正则表达式提取信息
    public static List<String> extractMessage(String regex, String context){
        Pattern p= Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher m=p.matcher(context);
        ArrayList<String> list = new ArrayList<String>();
        while(m.find()) {
            list.add(m.group());
        }
        return list;
    }

}
