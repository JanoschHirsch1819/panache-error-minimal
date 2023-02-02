package de.example.repository;

import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import io.quarkus.mongodb.panache.common.MongoEntity;
import java.util.UUID;
import javax.enterprise.context.ApplicationScoped;
import org.bson.codecs.pojo.annotations.BsonId;

@ApplicationScoped
public class Repository {

  public MyDocument find(UUID uuid) {
    return MyDocument.findById(uuid);
  }

  @MongoEntity(collection = "OfferVariant", database = "sms")
  public static class MyDocument extends PanacheMongoEntityBase {
    @BsonId UUID uuid;

    public MyDocument() {}

    public UUID getUuid() {
      return uuid;
    }

    public void setUuid(UUID uuid) {
      this.uuid = uuid;
    }
  }
}
