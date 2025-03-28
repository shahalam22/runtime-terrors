package org.pluralsight.config;

import com.pluralsight.repository.SpeakerRepository;
import com.pluralsight.repository.StubSpeakerRepositoryImpl;
import com.pluralsight.util.CalendarFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;

@Configuration
@ComponentScan({"com.pluralsight"})
public class AppConfig {
    //@Bean(name="speakerService")
//    @Scope(value="singleton")
//    @Scope(value= BeanDefinition.SCOPE_SINGLETON)
//    public SpeakerService getSpeakerService() {
//       // SpeakerServiceImpl speakerService = new SpeakerServiceImpl(getSpeakerRepository());
//      //  speakerService.setSpeakerRepository(getSpeakerRepository());
//        SpeakerServiceImpl speakerService = new SpeakerServiceImpl();
//        return speakerService;
//    }
    @Bean (name="calendar")
    public CalendarFactory calendarFactory() {
        CalendarFactory calendarFactory = new CalendarFactory();
        calendarFactory.addDays(2);
        return calendarFactory;
    }
    @Bean
    public Calendar cal() throws Exception {
        return calendarFactory().getObject();
    }
    @Bean(name="speakerRepository")
    public SpeakerRepository getSpeakerRepository() {
        return new StubSpeakerRepositoryImpl();
    }
}
