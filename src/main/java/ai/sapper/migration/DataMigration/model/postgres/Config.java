package ai.sapper.migration.DataMigration.model.postgres;

import ai.sapper.migration.DataMigration.constants.ConfigLevel;
import ai.sapper.migration.DataMigration.constants.ConfigType;
import ai.sapper.migration.DataMigration.convertor.JsonbConverter;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.ColumnTransformer;
import org.springframework.stereotype.Component;

import java.util.Map;

@Getter
@Setter
@Builder
@Slf4j
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Component("config_postgres")
@Table(name = "config")
public class Config {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ConfigType type;
    @Enumerated(EnumType.STRING)
    @Column(name = "level")
    private ConfigLevel level;
    @Column(name = "status")
    private boolean status;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "meta", columnDefinition = "jsonb")
    @Convert(converter = JsonbConverter.class)
    @ColumnTransformer(write = "?::jsonb")
    private Map<String, Object> meta;

    public Config convert(Object mongoDocument) {
        try {
            if (mongoDocument instanceof ai.sapper.migration.DataMigration.model.mongo.Config mongoConfig) {

                Config config = Config.builder()
                        .id(mongoConfig.getId())
                        .type(mongoConfig.getType())
                        .level(mongoConfig.getLevel())
                        .status(mongoConfig.isStatus())
                        .userId(mongoConfig.getUserId())
                        .meta(mongoConfig.getMeta())
                        .build();
                return config;
            }
        } catch (Exception e) {
            log.error("Error converting Config document: {}", e.getMessage(), e);
            throw e;
        }
        return null;
    }
}
