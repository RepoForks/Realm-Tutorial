package shivam.developer.realmtutorial;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * This is a singleton class to access Realm Database.
 */
public enum RealmService {
    INSTANCE;

    private RealmConfiguration realmConfiguration;

    public static RealmService getInstance() {
        return INSTANCE;
    }

    public Realm getRealmService(Application application) {
        Realm.init(application);
        if (realmConfiguration == null) {
            realmConfiguration = new RealmConfiguration.Builder()
                    .name(Realm.DEFAULT_REALM_NAME)
                    .schemaVersion(0)
                    .deleteRealmIfMigrationNeeded()
                    .build();
        }
        Realm.setDefaultConfiguration(realmConfiguration);
        return Realm.getInstance(realmConfiguration);
    }
}
