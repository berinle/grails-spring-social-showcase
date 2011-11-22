grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
//For development
//grails.plugin.location.'spring-social-core'="../grails-spring-social-core"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsPlugins()
        grailsHome()
        grailsCentral()
    }
    dependencies {}
	plugins {
    //compile(":twitter-bootstrap:1.3.0.7")
    
		compile(":spring-security-core:1.2.4")
		compile(":spring-social-core:0.1.30")
		compile(":spring-social-twitter:0.1.30")
		compile(":spring-social-facebook:0.1.31")
	}
}
