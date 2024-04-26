import com.Main;
import com.configurations.JpaConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(
                JpaConfig.class);
        configApplicationContext.getBeanFactory().createBean(Main.class).run();
        configApplicationContext.close();
    }
}
