## Re_frontcontroller 

#### 오류 메시지 원인
- HTTP 상태 405  허용되지 않는 메소드
타입 상태 보고
메시지 HTTP 메소드 GET은 이 URL에 의해 지원되지 않습니다.
설명 요청 행에 포함된 해당 메소드는, origin 서버에 의해 인지되었으나, 대상 리소스에 의해 지원되지 않습니다.
원인 : -> POST 요청을 보내야 하는 URL을 GET 방식으로 요청했을 때. 즉 요청 실행의 문제
- HTTP 상태 500 – 내부 서버 오류
타입 예외 보고
설명 서버가, 해당 요청을 충족시키지 못하게 하는 예기치 않은 조건을 맞닥뜨렸습니다.
예외
java.lang.NullPointerException

