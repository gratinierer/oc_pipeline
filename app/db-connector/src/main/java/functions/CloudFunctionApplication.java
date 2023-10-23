package functions;

import com.opencsv.bean.CsvToBeanBuilder;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;

import java.io.FileReader;
import java.io.StringReader;
import java.util.List;
import java.util.function.Function;

@SpringBootApplication
public class CloudFunctionApplication {

  public CloudFunctionApplication(OrgRepository orgRepository) {
    this.orgRepository = orgRepository;
  }

  public static void main(String[] args) {
    SpringApplication.run(CloudFunctionApplication.class, args);
  }

  private final OrgRepository orgRepository;
  
  @Bean
  @Transactional
  public Function<Message<String>, String> echo() {
    return (inputMessage) -> {

      var stringBuilder = new StringBuilder();

      var payload = inputMessage.getPayload();

      if (!payload.isBlank()) {
        List<Org> importedOrgs = new CsvToBeanBuilder<Org>(new StringReader(payload))
          .withType(Org.class)
          .build()
          .parse();
        importedOrgs.stream().forEach(org -> org.setJob("aJob"));
        orgRepository.saveAll(importedOrgs);
        stringBuilder.append("orgs written to db");
      } else {
        stringBuilder.append("no orgs for persist");
      }

      return stringBuilder.toString();
    };
  }
}
