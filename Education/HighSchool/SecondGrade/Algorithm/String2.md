### 중복 횟수가 많은 것 부터 내림차순

* 해결해야 하는 점

  * 입력된 값을 중복 제거 한다.
  * 중복 제거된 값을 중복 횟수 순으로 내림차순한다.
  
* 수도 코드
~~~java

  for(int j=0; j<6;  j++) {
			System.out.println(a[j]+" ");
		}
		System.out.println();		
		


~~~


* 코드화
~~~java
  int a[] = new int [6];
		Scanner sc = new Scanner(System.in);
		
		//값 입력
		System.out.println("텍스트를 입력하시오. ");
		for(int i=0; i<a.length; i++) {
			a[i] = sc.nextInt();
		}
		//값 출력
		System.out.println("입력된 값은:");
		for(int j=0; j<6;  j++) {
			System.out.println(a[j]+" ");
		}
		System.out.println();		
		

		//입력받은 수를 큰 순서대로 넣기
	    
		for(int i=0; i<a.length; i++) {
			for(int j=i+1; j<a.length; j++) {
				if(a[i]<a[j]) {
					int temp =a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		
		//결과값 출력
		Arrays.sort(a,Collections.reverseOrder());
		System.out.print("큰 수부터 출력:");
		for(int i=0; i<6; i++) {
			System.out.println(a[i]+ " ");
		}
		System.out.println();
	}

~~~

* 요약
  * Collections.reverseOrder()으로 입력된 값의 중복을 자동을 제거해줌. 
  * for문을 활용하여 값을 입력한 큰 순서대로 넣어준다.



