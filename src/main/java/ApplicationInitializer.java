import business.SpringBusinessConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import web.SpringWebConfig;

/**
 * Created by Zhao Qing on 2017/11/14.
 * 初始化
 */
public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{SpringBusinessConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{SpringWebConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
