package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.model.Usuario;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DozerMapperTests {

/*
	static DozerBeanMapper mapper;

	@BeforeAll
	public static void before3() throws Exception {
		mapper = new DozerBeanMapper();
	}
*/



	@Test
	void contextLoads() {
	}

	@Test
	public void givenSourceObjectAndDestObject_whenMapsSameNameFieldsCorrectly_thenCorrect() {
		Mapper mapper = new DozerBeanMapper();

		User englishUser = new User(4,"Jean-Claude Van Damme", "JCVD", 14.3);
		Usuario usuario = new Usuario();

		mapper.map(englishUser, usuario);

		assertEquals(usuario.getNombre(), "Jean-Claude Van Damme");
		assertEquals(usuario.getApellido(), "JCVD");
	}






	@Test
	public void givenAnnotatedSrcFields_whenMapsToRightDestField_thenCorrect() {
		Mapper mapper = new DozerBeanMapper();

		User englishUser = new User(4,"Jean-Claude Van Damme", "JCVD", 43.6);
		Usuario spanishUser = mapper.map(englishUser, Usuario.class);
		assertEquals(englishUser.getId(), spanishUser.getId());
		assertEquals(englishUser.getFirstName(), spanishUser.getNombre());
		assertEquals(englishUser.getLastName(), spanishUser.getApellido());


	}


	@Test
	public void givenAnnotatedSrcFields_whenMapsToRightDestFieldBidirectionally_thenCorrect() {
		Mapper mapper = new DozerBeanMapper();

		Usuario spanishUser = new Usuario(4,"Juan Claudio", "JC", 45.4F);
		User englishUser = mapper.map(spanishUser, User.class);



		assertEquals(spanishUser.getId(),englishUser.getId() );
		assertEquals(spanishUser.getNombre(),englishUser.getFirstName() );
		assertEquals(spanishUser.getApellido(),englishUser.getLastName());


	}

	@Test
	public void givenSrcAndDestWithDifferentFieldNamesWithCustomMapper_whenMaps_thenCorrect() {
		DozerBeanMapper mapper = new DozerBeanMapper();

		configureMapper(mapper, "dozer_mapping.xml");
		User englishUser = new User(4,"Jean-Claude Van Damme", "JCVD", 14.5);
		Usuario spanishUser = mapper.map(englishUser, Usuario.class);
		assertEquals(englishUser.getId(), spanishUser.getId());
		assertEquals(englishUser.getFirstName(), spanishUser.getNombre());
		assertEquals(englishUser.getLastName(), spanishUser.getApellido());

	}

	@Test
	public void givenApiMapper_whenMaps_thenCorrect() {

		DozerBeanMapper mapper = new DozerBeanMapper();

		mapper.addMapping(builder);

		Usuario spanishUser = new Usuario(4,"Juan Claudio", "JC", 43.5f);
		User englishUser = mapper.map(spanishUser, User.class);



		assertEquals(spanishUser.getId(),englishUser.getId() );
		assertEquals(spanishUser.getNombre(),englishUser.getFirstName() );
		assertEquals(spanishUser.getApellido(),englishUser.getLastName());
	}

	public void configureMapper(DozerBeanMapper mapper, String... mappingFileUrls) {
		mapper.setMappingFiles(Arrays.asList(mappingFileUrls));
	}

	BeanMappingBuilder builder = new BeanMappingBuilder() {
		@Override
		protected void configure() {
			mapping(User.class, Usuario.class)
					.fields("firstName", "nombre")
					.fields("lastName", "apellido");
		}
	};
}
