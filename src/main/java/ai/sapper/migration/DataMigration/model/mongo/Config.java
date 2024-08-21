package ai.sapper.migration.DataMigration.model.mongo;

import ai.sapper.migration.DataMigration.Repository.ReadService;
import ai.sapper.migration.DataMigration.common.BaseEntity;
import ai.sapper.migration.DataMigration.constants.ConfigLevel;
import ai.sapper.migration.DataMigration.constants.ConfigType;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Document("config")
@Data
@Component
@ToString(callSuper = true)
public class Config extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private ConfigType type;
    private ConfigLevel level;
    private boolean status;
    private String userId;
    private Map<String, ?> meta;

    @Autowired
    ReadService readService;

    public List<Config> read(String lastProcessedId) {
        return  readService.findDocumentsSorted(Config.class,
                "config",
                "id",
                true,
                lastProcessedId
        );
    }
}