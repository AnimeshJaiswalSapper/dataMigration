package ai.sapper.migration.DataMigration.model.mongo;

import ai.sapper.migration.DataMigration.Repository.ReadService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@Document("data_mine_report")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Component
public class DataMineReport implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @Indexed(unique = true)
    private String id;

    private String database;
    private String collateralId;
    private String loanNumber;

    private String propSeq;
    private String propType;
    private String propDesc1;

    private String formType;
    private String stmtFreq;
    private String stmtPurpose;
    private String stmtDate;
    private String periodBegin;
    private String periodEnd;
    private String annualized;
    private String dataType;

    @Autowired
    ReadService readService;
    public List<DataMineReport> read(String lastProcessedId) {
        return  readService.findDocumentsSorted(DataMineReport.class,
                "data_mine_report",
                "_id",
                true,
                lastProcessedId
        );
    }

}