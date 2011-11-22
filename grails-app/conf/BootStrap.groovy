import com.synergyj.grails.plugins.springsocial.showcase.User

class BootStrap {

  def init = { servletContext ->
    if (User.count() == 0) {
      new User(username: 'test', password: 'secret').save()
    }
  }
  def destroy = {
  }
}
