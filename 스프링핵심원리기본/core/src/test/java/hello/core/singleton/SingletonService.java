package hello.core.singleton;

public class SingletonService {

    // 외부에서의 생성은 막고 static 영역에 인스턴스 1개만 생성
    private static final SingletonService instance = new SingletonService();

    // 조회
    public static SingletonService getInstance() {
        return instance;
    }

    // 생성자를 private 로 해서 외부에서 new 키워드 생성을 막음
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 호출");
    }

}
