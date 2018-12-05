### 문자열 반대로 찍기

* 해결해야 하는 점
  *  입력된 문자열을 반대로 출력해야한다.

* 수도 코드

~~~java
     StringBuffer sb = new StringBuffer();
     sb.append(str);
~~~

* 코드화
~~~java

import java.util.Scanner;
 
public class ReverseString {
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        
        System.out.println(sb.reverse());
 
    }
}





~~~


* 요약
  * 사용자의 입력을 받을 Scanner 객체 생성
  * StringBuffer를 이용하여 중복 제거



### 중복된 문자열 제거 후 출력

* 해결해야 하는 점 
  * 반복문 또는 StringBuffer를 이용하여 문자열의 중복을 없애야 한다.
 


* 수도코드
~~~java
for(int i = 0; i < inputStr.length(); i++) { 
   if(!result.contains(String.valueOf(inputStr.charAt(i)))) { 
    result += String.valueOf(inputStr.charAt(i));  
~~~

* 코드 화
~~~java
import java.util.Scanner;

public class test {

 public static void main(String[] args) {
  // TODO Auto-generated method stub
  Scanner sc = new Scanner(System.in); 
  String inputStr = sc.nextLine(); 
  String result = ""; 
  
  for(int i = 0; i < inputStr.length(); i++) { 
   if(!result.contains(String.valueOf(inputStr.charAt(i)))) { 
    result += String.valueOf(inputStr.charAt(i));  
   }
  }
  System.out.println(result);
 }
}


~~~
* 요약
  * 사용자의 입력을 받을 Scanner 객체 생성

  * for문을 이용하여 사용자가 입력한 문자열의 길이만큼 반복한다.

  * 입력받은 문자열의 i번째 문자를 String으로 바꾸고 result에 이 문자가 없을 경우 result에 계속 추가
(=중복되지 않으면 추가)




