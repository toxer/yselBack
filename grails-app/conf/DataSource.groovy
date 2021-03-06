dataSource {
	pooled = true
	jmxExport = true
	driverClassName = "org.h2.Driver"
	username = "sa"
	password = ""
}

dataSource_micc {
	dbCreate = "validate"
	url = "jdbc:oracle:thin:@addressPerMicc"
	username="user"
	password="password"
	dialect = org.hibernate.dialect.Oracle10gDialect
	driverClassName = 'oracle.jdbc.driver.OracleDriver'

}
dataSource_mias {
	dbCreate = "validate"
	url = "jdbc:oracle:thin:@addressPerMias"
	username="user"
	password="password"
	dialect = org.hibernate.dialect.Oracle10gDialect
	driverClassName = 'oracle.jdbc.driver.OracleDriver'

}




hibernate {
	cache.use_second_level_cache = true
	cache.use_query_cache = false
	//    cache.region.factory_class = 'org.hibernate.cache.SingletonEhCacheRegionFactory' // Hibernate 3
	cache.region.factory_class = 'org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory' // Hibernate 4
	singleSession = true // configure OSIV singleSession mode
	flush.mode = 'manual' // OSIV session flush mode outside of transactional context
}


//environments {
//	development {
//		dataSourceMias {
//			dbCreate = "validate", // one of 'create', 'create-drop', 'update', 'validate', ''
//			url = "jdbc:oracle:thin:@vlxipena11.intra.infocamere.it:1521:ORA",
//			user= "mias",
//			password="mias",
//			dialect="org.hibernate.dialect.Oracle10gDialect",
//			driverClassName="oracle.jdbc.driver.OracleDriver",
//		}
//	}
//}


// environment specific settings
environments {
	development {
		dbCreate = "update"
		url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"

	}
	test {
		dataSource {
			dbCreate = "update"
			url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
		}
	}
	production {
		dataSource {
			dbCreate = "update"
			url = "jdbc:h2:prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
			properties {
				// See http://grails.org/doc/latest/guide/conf.html#dataSource for documentation
				jmxEnabled = true
				initialSize = 5
				maxActive = 50
				minIdle = 5
				maxIdle = 25
				maxWait = 10000
				maxAge = 10 * 60000
				timeBetweenEvictionRunsMillis = 5000
				minEvictableIdleTimeMillis = 60000
				validationQuery = "SELECT 1"
				validationQueryTimeout = 3
				validationInterval = 15000
				testOnBorrow = true
				testWhileIdle = true
				testOnReturn = false
				jdbcInterceptors = "ConnectionState"
				defaultTransactionIsolation = java.sql.Connection.TRANSACTION_READ_COMMITTED
			}
		}
	}
}
