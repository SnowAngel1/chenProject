package cn.project;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
//@ImportResource({"classpath*:META-INF/spring/spi-adapter-service.xml","classpath:spring-engine-service.xml","classpath:applicationContext-mq.xml","classpath*:spring-standalone-redis.xml"})
@MapperScan(basePackages = "cn.project.dao.**")
@SpringBootApplication(scanBasePackages = "cn.project")
@EnableTransactionManagement
public class ProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }

}
