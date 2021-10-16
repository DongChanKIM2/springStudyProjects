package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// AppConfig 수동 등록만 제외하고 자동등록
@ComponentScan(
        // basePackage는 AutoAppConfig 의 같은 레벨의 위치에서 스캔하므로 현재는 hello.core 위치
        basePackages = "hello.core.member",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
