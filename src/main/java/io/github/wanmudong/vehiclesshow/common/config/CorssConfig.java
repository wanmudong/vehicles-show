package io.github.wanmudong.vehiclesshow.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：wanmudong
 * @date ：Created in 2019/5/27 21:03
 * @description：跨域设置
 */
@Configuration
public class CorssConfig {

    @Bean
    public CorsFilter corsFilter(HttpServletRequest request){
        CorsConfiguration config = new CorsConfiguration();
        //放行哪些的原始域
        config.addAllowedOrigin("*");
//        是否发送cookie信息
        config.setAllowCredentials(true);
        ///放行哪些原始请求头部信息
        config.addAllowedHeader("*");
        //放行哪些请求方式
        config.addAllowedMethod("*");
        //添加映射路径
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",config);
        return new CorsFilter(source);
    }

}
