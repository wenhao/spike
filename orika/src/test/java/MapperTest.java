import domain.Person;
import domain.Request;
import domain.Teacher;
import ma.glasnost.orika.*;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.ClassMap;
import ma.glasnost.orika.metadata.Type;
import ma.glasnost.orika.metadata.TypeBuilder;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MapperTest
{
    @Test
    public void should_mapper_two_object_with_same_field_name() {
        // given
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        MapperFacade mapper = mapperFactory.getMapperFacade();

        Person person = new Person();
        person.setName("person");
        person.setAge(10);

        // when
        Teacher teacher = mapper.map(person, Teacher.class);

        // then
        assertThat(teacher.getName(), is(person.getName()));
    }

    @Test
    public void should_mapper_two_object_with_different_field_name() {
        // given
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        mapperFactory.classMap(Person.class, Teacher.class)
                .field("diff1", "diff2")
                .register();

        ClassMap<Person, Teacher> classMap = mapperFactory.classMap(Person.class, Teacher.class)
                .field("diff1", "diff2")
                .byDefault()
                .toClassMap();
        mapperFactory.registerClassMap(classMap);


        MapperFacade mapper = mapperFactory.getMapperFacade();


        Person person = new Person();
        person.setName("person");
        person.setAge(10);
        person.setDiff1("diff1");

        // when
        Teacher teacher = mapper.map(person, Teacher.class);

        // then
        assertThat(teacher.getDiff2(), is(person.getDiff1()));

    }

    @Test
    public void should_mapper_generic_type() {
        // given
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        Type<Person<Request>> personType = new TypeBuilder<Person<Request>>() { }.build();
        Type<Teacher> teacherType = new TypeBuilder<Teacher>() { }.build();

        mapperFactory.registerClassMap(mapperFactory.classMap(personType, teacherType)
                .field("diff1", "diff2")
                .field("content.name", "desc")
                .toClassMap());
        MapperFacade mapper = mapperFactory.getMapperFacade();

        Person<Request> person = new Person<>();
        person.setName("person");
        person.setAge(10);
        person.setDiff1("diff1");
        Request request = new Request();
        request.setName("request");
        person.setContent(request);

        // when
        Teacher teacher = mapper.map(person, personType, teacherType);

        // then
        assertThat(teacher.getDiff2(), is(person.getDiff1()));
        assertThat(teacher.getDesc(), is(person.getContent().getName()));
    }
}
