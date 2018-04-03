package com.zjitc.mall.conf;

import com.zjitc.mall.common.GsonOfDate;
import java.util.List;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Create by IntelliJ IDEA
 *
 * @author: jsonor
 * @date-Time: 2018/4/3 16:04
 * @description:
 */

@Configuration
@ComponentScan(basePackageClasses = WebMvcConfiguration.class)
public class WebMvcConfiguration  extends WebMvcConfigurationSupport{

  @Override
  protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    for (HttpMessageConverter converter : converters) {
      if (converter instanceof GsonHttpMessageConverter) {
        GsonHttpMessageConverter gsonHttpMessageConverter = (GsonHttpMessageConverter) converter;
        gsonHttpMessageConverter.setGson(GsonOfDate.getInstance());
      }
    }
  }
}
