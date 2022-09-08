package com.test.legacy;

import java.net.MalformedURLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;


@Entity
@DiscriminatorValue("H")
@RestControllerAdvice
@Embeddable
@Slf4j
@EnableTransactionManagement
public class HomeController implements WebMvcConfigurer ,
							Converter<Integer, String> ,
							Formatter<Number> ,
							HandlerMethodArgumentResolver,
							HandlerInterceptor
							{
	@ManyToOne(fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    @Enumerated(EnumType.STRING)
	@Id 
	@GeneratedValue
    @Column(name = "order_id")
	@NotBlank
    @NotNull
    @Range(min = 1000, max = 1000000)
    @Max(value = 9999)
	@Value("${file.dir}")
    private Long id;
	@org.springframework.format.annotation.NumberFormat(pattern = "###,###")
    private Integer number;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime localDateTime;
    
    @ResponseStatus(HttpStatus.OK)
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {}
	public void configureAsyncSupport(AsyncSupportConfigurer configurer) {}
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {}
	// 컨버터, 포매터 등록
	public void addFormatters(FormatterRegistry registry) {}
	// 인터셉터 등록 registry.addInterceptor(new LogInterceptor())
	public void addInterceptors(InterceptorRegistry registry) {}
	// 리소스 핸들러 등록
	public void addResourceHandlers(ResourceHandlerRegistry registry) {}
	public void addCorsMappings(CorsRegistry registry) {}
	public void configureViewResolvers(ViewResolverRegistry registry) {}
	// 알규먼츠 리졸버 등록 resolvers.add(new LoginMemberArgumentResolver());
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {}
	// 리턴 핸들러 등록
	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {}
	// ExceptionHandler resolvers.add(new UserHandlerExceptionResolver());
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {}
	public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {}
	// Validator 글로벌 적용
	public Validator getValidator() {return WebMvcConfigurer.super.getValidator();}
	public MessageCodesResolver getMessageCodesResolver() {return WebMvcConfigurer.super.getMessageCodesResolver();	}

	@ExceptionHandler
	public void test1(@Validated String abc) throws MalformedURLException {
		BindingResult br;
		MultipartFile file;
	    String uuid = UUID.randomUUID().toString();
	    Resource resource = new UrlResource("file:" + uuid);
	    new FieldError("error", "error", "error");
	    new ObjectError("error", "error");
	    StringUtils.hasText("error");
	    new ResponseStatusException(HttpStatus.NOT_FOUND, "error.bad", new IllegalArgumentException());
	}
	
    @Override
    public String convert(Integer source) {
        log.info("convert source={}", source);
        return String.valueOf(source);
    }
    
    @Override
    public Number parse(String text, Locale locale) throws ParseException {
        log.info("test={}, locale={}", text, locale);
        NumberFormat format = java.text.NumberFormat.getInstance(locale);
        return format.parse(text);
    }

    @Override
    public String print(Number object, Locale locale) {
        log.info("object={}, locale={}", object, locale);
        return NumberFormat.getInstance(locale).format(object);
    }
    
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        log.info("supportsParameter 실행");
        boolean hasLoginAnnotation = parameter.hasParameterAnnotation(Login.class);
        boolean hasMemberType = Member.class.isAssignableFrom(parameter.getParameterType());
        return hasLoginAnnotation && hasMemberType;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer, 
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        log.info("resolveArgument 실행");
        HttpServletRequest request = (HttpServletRequest)
                webRequest.getNativeRequest();
        HttpSession session = request.getSession(false);
        if (session == null) {
            return null;
        }
        return session.getAttribute(SessionConst.LOGIN_MEMBER);
    }
    
    @RequestMapping("/headers")
    public String headers(HttpServletRequest request,
                          HttpServletResponse response,
                          HttpMethod httpMethod,
                          Locale locale,
                          @RequestHeader MultiValueMap<String, String>
                                  headerMap,
                          @RequestHeader("host") String host,
                          
                          @CookieValue(value = "myCookie", required = false)
                          String cookie) {
        log.info("request={}", request);
        log.info("response={}", response);
        log.info("httpMethod={}", httpMethod);
        log.info("locale={}", locale);
        log.info("headerMap={}", headerMap);
        log.info("header host={}", host);
        log.info("myCookie={}", cookie);
        return "ok";
    }
    
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	public void test() {
		Map<Integer, List<String>> map = new HashMap<>();
		String genre = null;
		map.put(100, Arrays.asList("인문학", "철학"));
		map.put(200, Arrays.asList("천문학", "물리학"));

		int num = map.keySet().stream()
				.filter(key -> map.values().contains(genre))
				.findAny()
				.get();
	}
	
	
}
