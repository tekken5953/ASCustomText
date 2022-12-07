# AsCustomTextView

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
	        implementation 'com.github.tekken5953:AsCustomTextView:[최신버전]'
	}
```

<h2>3.코드적용 - xml</h2>

```
 <com.astextview.AsTextView
        android:id="@+id/asTextView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:sort="grade"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
 ```
 
 <h2>4.코드적용 - Java</h2>
 
 ```
 AsTextView asTextView = findViewById(R.id.asTextView);
 asTextView.setSort("grade");
 asTextView.setGradeText("0");
 ```
 
 <h2>5.적용결과</h2>
 
 ![capture](https://user-images.githubusercontent.com/52855326/206075812-ff719f66-9018-46fc-aefa-40c0da5a900b.png)

 
