import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.junit.Before;
import org.junit.Test;

public class PropertiesConfigurationTest
{

    private Configuration configuration;

    @Before
    public void setUp() throws Exception
    {
        configuration = new PropertiesConfiguration("application.properties");
    }

    @Test
    public void should_be_able_to_load_configuration_from_properties_file() throws ConfigurationException
    {
        // given

        // when
        String value = configuration.getString("application.title");

        // then
        assertThat(value).isEqualTo("apache configuration-1.0.0");
    }

    @Test
    public void should_be_able_to_get_configuration_from_include_properties()
    {
        // given

        // when
        String value = configuration.getString("application.environment");

        // then
        assertThat(value).isEqualTo("dev");
    }

    @Test
    public void should_be_able_to_get_array_of_values()
    {
        // given

        // when
        List<String> values = newArrayList(configuration.getStringArray("application.developer"));

        // then
        assertThat(values).containsExactly("James", "Sicong");
    }

    @Test
    public void should_be_able_to_save_new_property() throws ConfigurationException
    {
        // given

        // when
        configuration.addProperty("application.framework", "common-configuration");
        PropertiesConfiguration propertiesConfiguration = (PropertiesConfiguration) this.configuration;
        propertiesConfiguration.save("application.backup.properties");

        String value = this.configuration.getString("application.framework");

        // then
        assertThat(value).isEqualTo("common-configuration");
    }
}
