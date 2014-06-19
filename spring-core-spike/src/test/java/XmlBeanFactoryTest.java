import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;


public class XmlBeanFactoryTest {
    @Test
    public void should_be_able_to_get_bean() throws Exception {
        ClassPathResource classPathResource = new ClassPathResource("beans.xml");

        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(classPathResource);
        Object person = xmlBeanFactory.getBean("person");

        assertThat(person, notNullValue());
    }
}
