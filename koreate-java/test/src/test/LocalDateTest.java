package test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class LocalDateTest {

	public static void main(String[] args) {

		LocalDate today = LocalDate.now();
		System.out.println(today);
		LocalDate xmas = LocalDate.of(today.getYear(), 12, 25);
		System.out.println(xmas);
		LocalDate eve = xmas.minusDays(1);
		System.out.println(eve);
		System.out.println(xmas);
		Period left = Period.between(today, eve);
		System.out.println(left);
		System.out.println(left.getDays() + " " + left.getMonths() + " " + left.getYears());

		LocalTime now = LocalTime.now();
		System.out.println(now);
		LocalTime mt = now.plusHours(2);
		mt = mt.plusMinutes(10);
		System.out.println(mt);

		ZonedDateTime present = ZonedDateTime.now();
		ZonedDateTime seoul = ZonedDateTime.now();
		ZonedDateTime paris = ZonedDateTime.of(seoul.toLocalDateTime(), ZoneId.of("Europe/Paris"));

		System.out.println(present);
		System.out.println(seoul);
		System.out.println(paris);
		System.out.println(paris.toLocalDateTime());
		System.out.println(Duration.between(seoul, paris));

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-dd, HH:MM:SS VV");
		DateTimeFormatter dtfNotV = DateTimeFormatter.ofPattern("YYYY-MM-dd, HH:MM:SS");
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(dtf.format(seoul));
		System.out.println(dtfNotV.format(ldt));

		DateTimeFormatter itf = DateTimeFormatter
					.ofLocalizedDateTime(FormatStyle.SHORT)
					.withLocale(Locale.UK)
					.withZone(ZoneId.systemDefault());
		Instant instant = Instant.now();
		System.out.println(itf.format(instant));

//		ZoneId.getAvailableZoneIds()
//			.stream()
//			.filter(s -> s.startsWith("Asia"))
//			.sorted()
//			.forEach(System.out::println);

	}

}
