package com.boot.pattern.config;

import java.util.List;
import java.util.Locale;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {
	 @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJackson2HttpMessageConverter());
        converters.add(new MappingJackson2XmlHttpMessageConverter());
    }

    @Bean(value = "localeResolver")
    public LocaleResolver localeResolver() {
        AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();
        acceptHeaderLocaleResolver.setDefaultLocale(Locale.KOREAN);
        return acceptHeaderLocaleResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("locale");
        registry.addInterceptor(localeChangeInterceptor)
                .excludePathPatterns("/favicon.ico")
                .addPathPatterns("/**");
    }
    
    @Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}
    
    @Override
    public void addFormatters(FormatterRegistry registry) {
        //registry.addConverter(new HotelRoomNumberConverter());
    }
    
    @Bean("viewResolver")
	public ViewResolver viewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setOrder(1);
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
    
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        //resolvers.add(new ClientInfoArgumentResolver());
    }

    @Bean
    public FilterRegistrationBean<CharacterEncodingFilter> defaultCharacterEncodingFilter() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("utf-8");
        encodingFilter.setForceEncoding(true);

        FilterRegistrationBean<CharacterEncodingFilter> filterBean = new FilterRegistrationBean<>();
        filterBean.setFilter(encodingFilter);
        filterBean.addInitParameter("paramName", "paramValue");
        filterBean.addUrlPatterns("*");
        filterBean.setOrder(1);
        return filterBean;
    }
	    
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/templates/", "classpath:/static/");
    }
}