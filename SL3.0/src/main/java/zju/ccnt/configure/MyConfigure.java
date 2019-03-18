package zju.ccnt.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyConfigure extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //  /uploads/  映射到D盘的uploads文件夹下
        registry.addResourceHandler("/pic/**").addResourceLocations("file:/Users/weixiao2333/Desktop/pic/concept/");
        //  js css 所在文件static映射，方便页面引用js css文件
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);

    }
}
