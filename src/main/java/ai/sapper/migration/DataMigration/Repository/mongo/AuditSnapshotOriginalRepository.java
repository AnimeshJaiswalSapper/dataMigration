package ai.sapper.migration.DataMigration.Repository.mongo;

import ai.sapper.migration.DataMigration.model.mongo.AuditSnapshotOriginal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuditSnapshotOriginalRepository extends MongoRepository<AuditSnapshotOriginal,Long> {
}
