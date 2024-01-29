package mg.valian.tsiaro.springbootdemo.data.entity;

import jakarta.persistence.*;
import java.sql.Date;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.sql.Timestamp;


@Document(collection = "messagerie")
public class Messagerie {

    @Id
    @Field("_id")
    private String idMessagerie;

    @Field("id_envoyeur")
    private int envoyeur;

    @Field("id_recepteur")
    private int recepteur;
    
    @Field("date_Message")
    private Timestamp dateMessage;

    @Field("message")
    private String message;


}
