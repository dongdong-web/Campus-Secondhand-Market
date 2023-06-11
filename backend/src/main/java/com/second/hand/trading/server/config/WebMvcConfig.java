package com.second.hand.trading.server.config;

//import com.second.hand.trading.server.controller.interceptor.AdminLoginInterceptor;
import com.second.hand.trading.server.controller.interceptor.CookieInterceptor;
import com.second.hand.trading.server.controller.interceptor.LogCostInterceptor;
import com.second.hand.trading.server.controller.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     *  允许跨域访问
     *  当一个请求url的协议、域名、端口三者之间任意一个与当前页面url不同即为跨域。
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // 可限制哪个请求可以通过跨域
                .allowedHeaders("*")  // 可限制固定请求头可以通过跨域
                .allowedMethods("*") // 可限制固定methods可以通过跨域
                .allowedOrigins("http://localhost:8081")  // 可限制访问ip可以通过跨域
                .allowCredentials(true) // 是否允许发送cookie
                .exposedHeaders(HttpHeaders.SET_COOKIE);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截器顺序依次向下执行，退出则逆向执行after（1、2->2、1->2、1）
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new LogCostInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new CookieInterceptor()).addPathPatterns("/**");
//        registry.addInterceptor(new AdminLoginInterceptor()).addPathPatterns("/admin/*");
    }
}
