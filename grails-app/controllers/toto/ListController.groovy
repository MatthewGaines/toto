package toto

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ListController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond List.list(params), model:[listCount: List.count()]
    }

    def show(List list) {
        respond list
    }

    def create() {
        respond new List(params)
    }

    @Transactional
    def save(List list) {
        if (list == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (list.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond list.errors, view:'create'
            return
        }

        list.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'list.label', default: 'List'), list.id])
                redirect list
            }
            '*' { respond list, [status: CREATED] }
        }
    }

    def edit(List list) {
        respond list
    }

    @Transactional
    def update(List list) {
        if (list == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (list.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond list.errors, view:'edit'
            return
        }

        list.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'list.label', default: 'List'), list.id])
                redirect list
            }
            '*'{ respond list, [status: OK] }
        }
    }

    @Transactional
    def delete(List list) {

        if (list == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        list.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'list.label', default: 'List'), list.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'list.label', default: 'List'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
