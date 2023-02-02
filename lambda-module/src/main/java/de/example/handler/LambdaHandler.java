package de.example.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import de.example.repository.Repository;
import de.example.repository.Repository.MyDocument;

import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Named;

@Named("MyLambdaHandler")
public class LambdaHandler implements RequestHandler<Object, MyDocument> {
  @Inject Repository offerVariantRepository;

  @Override
  public MyDocument handleRequest(Object input, Context context) {
    return offerVariantRepository.find(UUID.fromString("01010101-0101-0101-0101-010101010101"));
  }
}
