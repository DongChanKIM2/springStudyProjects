package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // url mapping 주소
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!");
        return "hello";
    }

    // MVC와 템플릿 엔진
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "nameee") String namex, Model model){
        model.addAttribute("nameee", namex);
        return "hello-template";
    }

    // 단순 문자열
    @GetMapping("hello-spring")
    @ResponseBody // body 부분에 data 을 직접 넣어주는 것
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name;
    }

    // 객체를 통해 기본으로 설정된 json 반환 (API 방법)
    @GetMapping("hello-api")
    @ResponseBody
    // 밑의 static class의 hello
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        // 문자가 아닌 Hello 객체를 넘김
        hello.setName(name);
        return hello;
    }
    // static class 는 pubilc class 내부에 만들 수 있음(HelloController.Hello)
    static class Hello {
        // key 값 name으로 설정
        private String name;

        // getter (alt + insert)
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
