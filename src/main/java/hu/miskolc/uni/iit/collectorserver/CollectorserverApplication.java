package hu.miskolc.uni.iit.collectorserver;

import hu.miskolc.uni.iit.collectorserver.DAO.MeasurementDAO;
import hu.miskolc.uni.iit.collectorserver.DAO.MeasurementMySQLDAO;
import hu.miskolc.uni.iit.collectorserver.service.CollectorService;
import hu.miskolc.uni.iit.collectorserver.service.Impl.CollectorServiceImplementation;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@ComponentScan("hu.miskolc.uni.iit.collectorserver")
public class CollectorserverApplication {

    public static void main(final String[] args) {
        SpringApplication.run(CollectorserverApplication.class, args);
    }

    @Bean(autowire = Autowire.BY_NAME)
    public MeasurementDAO measurementDAO() {
        return new MeasurementMySQLDAO();
    }

    @Bean(autowire = Autowire.BY_NAME)
    public CollectorService collectorService() {
        return new CollectorServiceImplementation();
    }

}
