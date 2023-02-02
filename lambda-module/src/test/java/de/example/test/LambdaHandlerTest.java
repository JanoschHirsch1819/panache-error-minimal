package de.example.test;

import de.example.handler.LambdaHandler;
import de.example.repository.Repository.MyDocument;
import io.quarkus.test.junit.QuarkusTest;
import java.util.Objects;
import java.util.UUID;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class LambdaHandlerTest {
  @Inject LambdaHandler lambdaHandler;

  @Test
  void shouldFindOfferVariant() {
    MyDocument document = new MyDocument();
    document.setUuid(UUID.fromString("01010101-0101-0101-0101-010101010101"));
    document.persist();

    MyDocument doc = lambdaHandler.handleRequest(null, null);

    assert Objects.equals(document.getUuid(), doc.getUuid());
  }
}
