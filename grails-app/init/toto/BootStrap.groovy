package auth.toto

class BootStrap {

    def init = {
        def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush:true)
        def userRole = new Role(authority: 'ROLE_USER').save(flush:true)

        def admin = new User(username:"admin", password:"admin", enabled:true).save(flush:true)
        //Give admin both admin and user role
        UserRole.create(admin, adminRole).save()
        UserRole.create(admin, userRole).save()

        def user = new User(username:"user", password:"user", enabled:true).save(flush:true)
        UserRole.create(user, userRole).save()
    }
    def destroy = {
    }
}
