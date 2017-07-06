package auth.toto

class BootStrap {

    def springSecurityService

    def init = {
        // Roles Defined
        def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush:true)
        def userRole = new Role(authority: 'ROLE_USER').save(flush:true)

        // Admin User
        def admin = new User(username:"admin", password:"admin", email:"admin@mattgaines.net", enabled:true).save(flush:true, failOnError:true)
        UserRole.create(admin, adminRole).save()
        UserRole.create(admin, userRole).save()

        // Regular User
        def user = new User(username:"user", password:"user", email: "user@mattgaines.net", enabled:true).save(flush:true, failOnError:true)
        UserRole.create(user, userRole).save()
    }
    def destroy = {
    }
}
