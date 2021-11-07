package gestion_laboratorio

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class EscuelaController {

    EscuelaService escuelaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond escuelaService.list(params), model:[escuelaCount: escuelaService.count()]
    }

    def show(Long id) {
        respond escuelaService.get(id)
    }

    def create() {
        respond new Escuela(params)
    }

    def save(Escuela escuela) {
        if (escuela == null) {
            notFound()
            return
        }

        try {
            escuelaService.save(escuela)
        } catch (ValidationException e) {
            respond escuela.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'escuela.label', default: 'Escuela'), escuela.id])
                redirect escuela
            }
            '*' { respond escuela, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond escuelaService.get(id)
    }

    def update(Escuela escuela) {
        if (escuela == null) {
            notFound()
            return
        }

        try {
            escuelaService.save(escuela)
        } catch (ValidationException e) {
            respond escuela.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'escuela.label', default: 'Escuela'), escuela.id])
                redirect escuela
            }
            '*'{ respond escuela, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        escuelaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'escuela.label', default: 'Escuela'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'escuela.label', default: 'Escuela'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
