import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.junit.Test;

public class CompositeConfigurationTest
{

    @Test
    public void should_be_able_to_get_value_from_composite_configuration() throws ConfigurationException
    {
        // given

        // when
        CompositeConfiguration compositeConfiguration = new CompositeConfiguration();
        compositeConfiguration.addConfiguration(new PropertiesConfiguration("application.properties"));
        compositeConfiguration.addConfiguration(new XMLConfiguration("employee.xml"));

        // then
        assertThat(compositeConfiguration.getString("Employee.Name")).isEqualTo("John Doe");
        assertThat(compositeConfiguration.getString("application.environment")).isEqualTo("dev");
    }

    @Test
    public void should_be_able_to_override_the_value() throws ConfigurationException
    {
        // given

        // when
        CompositeConfiguration compositeConfiguration = new CompositeConfiguration();
        compositeConfiguration.addConfiguration(new PropertiesConfiguration("database.properties"));
        compositeConfiguration.addConfiguration(new PropertiesConfiguration("application.properties"));

        // then
        assertThat(compositeConfiguration.getString("application.database.username")).isEqualTo("root");
    }
}
