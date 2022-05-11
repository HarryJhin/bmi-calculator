# BMI 계산기 앱

### 개요

키와 몸무게를 입력하고 결과를 누르면 다른 화면에서 비만 결과를 문자와 그림으로 보여줍니다.

### 핵심 구성요소

- 마지막으로 입력했던 키와 몸무게는 자동으로 저장됩니다.
- `Intent`: 화면을 전환에 사용하고, 간단한 데이터를 전달할 수 있습니다.
- `SharedPreference`: 간단한 데이터를 저장할 수 있습니다.

### 구현 순서

1. 준비하기
2. 키와 몸무게를 입력하면 화면 작성
3. 결과 화면 작성
4. `Intent`로 화면 전환
5. `SharedPreference`로 데이터를 저장

### 프로젝트 생성

- 프로젝트명: BmiCalculator
- minSdkVersion: API 21
- Activity: Empty Activity

### 뷰 바인딩

바인딩 객체를 통해 간단하게 UI에 접근할 수 있게 함

`findViewById()` 생략

`build.gradle (module)`에서 다음 코드 추가:

```groovy
android {
    // ...
    buildFeatures {
        viewBinding true
    }
}
```

`Sync Now` 버튼 클릭
