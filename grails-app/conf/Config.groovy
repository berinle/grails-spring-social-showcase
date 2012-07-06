// locations to search for config files that get merged into the main config
// config files can either be Java properties files or ConfigSlurper scripts

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if(System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination
grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false
grails.mime.types = [html: ['text/html', 'application/xhtml+xml'],
    xml: ['text/xml', 'application/xml'],
    text: 'text/plain',
    js: 'text/javascript',
    rss: 'application/rss+xml',
    atom: 'application/atom+xml',
    css: 'text/css',
    csv: 'text/csv',
    all: '*/*',
    json: ['application/json', 'text/json'],
    form: 'application/x-www-form-urlencoded',
    multipartForm: 'multipart/form-data'
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// The default codec used to encode data with ${}
grails.views.default.codec = "none" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"
// enable Sitemesh preprocessing of GSP pages
grails.views.gsp.sitemesh.preprocess = true
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// whether to install the java.util.logging bridge for sl4j. Disable for AppEngine!
grails.logging.jul.usebridge = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// set per-environment serverURL stem for creating absolute links
environments {
  production {
    //grails.serverURL = "http://www.changeme.com"
    grails.serverURL = "http://localhost:8080/springsocial"
  }
  development {
    grails.serverURL = "http://localhost:8080/spring-social-showcase"
  }
  test {
    grails.serverURL = "http://localhost:8080/${appName}"
  }

}

// log4j configuration
log4j = {
  // Example of changing the log pattern for the default console
  // appender:
  //
  //appenders {
  //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
  //}

  error 'org.codehaus.groovy.grails.web.servlet',  //  controllers
      'org.codehaus.groovy.grails.web.pages', //  GSP
      'org.codehaus.groovy.grails.web.sitemesh', //  layouts
      'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
      'org.codehaus.groovy.grails.web.mapping', // URL mapping
      'org.codehaus.groovy.grails.commons', // core / classloading
      'org.codehaus.groovy.grails.plugins', // plugins
      'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
      'org.codehaus.groovy.grails.scaffolding',
      'org.codehaus.groovy.grails.web.context',
      'org.apache',
      'org.springframework',
      'org.hibernate',
      'net.sf',
      'grails'

  warn 'org.mortbay.log'

  info 'grails.app.controllers.grails.plugins.springsocial', 'grails.plugins.springsocial', 'grails.plugins.controllers.grails.plugins.springsocial'

  appenders {
    //      console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    console name: 'stdout', layout: pattern(conversionPattern: '%d{ISO8601}\t%p\t%c:%L\t%m%n'), threshold: org.apache.log4j.Level.DEBUG
    //appender new DailyRollingFileAppender(name: 'file', file: logDirectory + 'ss_showcase.log', datePattern: '\'_\'yyyy-MM-dd', layout: pattern(conversionPattern: '%d{ISO8601}\t%p\t%c:%L\t%m%n'))
  }
  root {
    info 'file'
    additivity = true
  }
}

//Configuration for twitter
grails.plugins.springsocial.twitter.consumerKey = "mcBxpCFGwS9gW5NbF4AZZg"
grails.plugins.springsocial.twitter.consumerSecret = "q91y7MQwcQVbugnrMXlc83YupMjZzuEvM5o0XIiSupI"

//Configuration for facebook
grails.plugins.springsocial.facebook.clientId = "101918953236251"
grails.plugins.springsocial.facebook.clientSecret = "73b06ad466e900d07f5555062068b572"

// Added by the Spring Security Core plugin:
grails.plugins.springsecurity.userLookup.userDomainClassName = 'com.synergyj.grails.plugins.springsocial.showcase.User'
grails.plugins.springsecurity.userLookup.authorityJoinClassName = 'com.synergyj.grails.plugins.springsocial.showcase.UserRole'
grails.plugins.springsecurity.authority.className = 'com.synergyj.grails.plugins.springsocial.showcase.Role'
