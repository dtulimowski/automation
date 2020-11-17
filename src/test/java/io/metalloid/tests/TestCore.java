package tests;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import io.metalloid.selenium.ReportListener;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(ReportListener.class)
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = TestConfig.class)
@SpringBootTest
@TestCore
public @interface TestCore {
}
