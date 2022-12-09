# AsCustomTextView

<p>이 Library는 AS_Remote 혹은 AS_Dashboard 개발을 위한 Library입니다.</p>

<h2>1.settings.gladle에 추가</h2>

```
pluginManagement {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

<h2>2.build.gradle에 추가</h2>

```
dependencies {
	        implementation 'com.github.tekken5953:AsCustomText:[최신버전태그]'
	}
```

<h2>3.코드적용 - xml</h2>

 <p>기본값이 에러이므로 sort옵션은 반드시 설정해주어야 한다.</p>
 <p>아래 4번 과정에서 동적선언 시 이 해당 과정은 생략 가능하다.</p>

```
 <com.astextview.AsTextView
        android:id="@+id/asTextView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
	<!-- sort : ["grade","pm","co","co2","tvoc","virus","cqi"] -->
        app:sort="grade"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
 ```

<h2>4.코드적용 - Java or Kotlin</h2>


  ```
  asTextView.setSort(String);			  텍스트뷰의 sort를 설정하는 메서드
  						  ["grade","pm","co","co2","tvoc","virus","cqi"]
  ```

  ```
  asTextView.setGradeText(String);		 sort가 grade일 때 공기질 등급을 설정하는 메서드
  						 [0~3][좋음~매우나쁨]
  ```

  ```
  asTextView.setIndexTextAsInt(Float);		 sort가 grade가 아닐 때 공기질의 수치를 Integer형으로 설정하고 메서드
  ```

  ```
  asTextView.setIndexTextAsFloat(Float);		 sort가 grade가 아닐 때 공기질의 수치를 Float형으로 설정하고 메서드
  ```

  ```
  asTextView.setIndexTextAsDouble(Float);		 sort가 grade가 아닐 때 공기질의 수치를 Double형으로 설정하고 메서드
  ```

  ```
  asTextView.getSort();				 텍스트뷰의 현재 sort를 불러오는 메서드(String)
  ```


<h2>5.적용결과</h2>

![capture](https://user-images.githubusercontent.com/52855326/206075812-ff719f66-9018-46fc-aefa-40c0da5a900b.png)

 
