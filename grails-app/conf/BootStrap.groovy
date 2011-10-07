import com.synergyj.grails.plugins.springsocial.showcase.*

class BootStrap {

    def init = { servletContext ->
	  if(User.count() == 0) {
		new User(username:'test', password:'secret').save()
	  }
    }
    def destroy = {
    }
}
