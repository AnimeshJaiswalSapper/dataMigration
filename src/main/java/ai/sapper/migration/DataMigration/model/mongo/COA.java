package ai.sapper.migration.DataMigration.model.mongo;

import ai.sapper.migration.DataMigration.Repository.ReadService;
import ai.sapper.migration.DataMigration.common.BaseEntity;
import ai.sapper.migration.DataMigration.constants.Status;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Document("coa")
@ToString(callSuper = true)
@Component
public class COA extends BaseEntity {

    private String name;
    private Status status;

    @Autowired
    ReadService readService;

    public List<COA> read(String lastProcessedId) {
        return  readService.findDocumentsSorted(COA.class,
                "coa",
                "createdDate",
                true,
                lastProcessedId
        );
    }
}
