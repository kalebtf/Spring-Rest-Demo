package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.model.Usuario;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class JodaTests {

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
	public void testJoda() {
		LocalDate currentDate = LocalDate.now();


		LocalTime currentTime = LocalTime.now();

		LocalDateTime currentDateAndTime = LocalDateTime.now();

		DateTime dateTime = currentDateAndTime.toDateTime();
		LocalDate localDate = currentDateAndTime.toLocalDate();
		LocalTime localTime = currentDateAndTime.toLocalTime();

		LocalDateTime currentDateTimeFromJavaDate = new LocalDateTime(new Date());
		Date currentJavaDate = currentDateTimeFromJavaDate.toDate();

		Date oneMinuteAgoDate = new Date(System.currentTimeMillis() - (60 * 1000));
		Instant oneMinutesAgoInstant = new Instant(oneMinuteAgoDate);

		DateTime customDateTimeFromInstant = new DateTime(oneMinutesAgoInstant);
		DateTime customDateTimeFromJavaDate = new DateTime(oneMinuteAgoDate);
		DateTime customDateTimeFromString = new DateTime("2018-05-05T10:11:12.123");
		DateTime customDateTimeFromParts = new DateTime(2018, 5, 5, 10, 11, 12, 123);

		DateTime parsedDateTime = DateTime.parse("2018-05-05T10:11:12.123");

		DateTimeFormatter dateTimeFormatter
				= DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss");
		DateTime parsedDateTimeUsingFormatter
				= DateTime.parse("05/05/2018 10:11:12", dateTimeFormatter);
		Instant instant = new Instant();
		Instant.now();


/*
		Instant instantFromEpochMilli
				= Instant.ofEpochMilli(milliesFromEpochTime);
		Instant instantFromEpocSeconds
				= Instant.ofEpochSecond(secondsFromEpochTime);

*/

		Instant instantFromString
				= new Instant("2018-05-05T10:11:12");
		Instant instantFromDate
				= new Instant(oneMinuteAgoDate);
		Instant instantFromTimestamp
				= new Instant(System.currentTimeMillis() - (60 * 1000));



		Instant parsedInstant
				= Instant.parse("05/05/2018 10:11:12", dateTimeFormatter);


	/*	assertTrue(instantNow.compareTo(oneMinuteAgoInstant) > 0);
		assertTrue(instantNow.isAfter(oneMinuteAgoInstant));
		assertTrue(oneMinuteAgoInstant.isBefore(instantNow));
		assertTrue(oneMinuteAgoInstant.isBeforeNow());
		assertFalse(oneMinuteAgoInstant.isEqual(instantNow));*/

		System.out.println("rest");

	}

}
