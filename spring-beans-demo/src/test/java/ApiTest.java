import com.hx.demo.springframework.beans.factory.config.BeanDefinition;
import com.hx.demo.springframework.beans.factory.support.DefaultListableBeanFactory;

public class ApiTest {
	
	public static void main(String[] args) {
		
		BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		beanFactory.registerBeanDefinition("userService", beanDefinition);
		UserService userService = (UserService) beanFactory.getBean("userService");
		userService.query();
		
		UserService userService1 = (UserService) beanFactory.getBean("userService");
		userService1.query();
	}
}
