package gestion_laboratorio

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MateriaActivaController {

    MateriaActivaService materiaActivaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond materiaActivaService.list(params), model:[materiaActivaCount: materiaActivaService.count()]
    }

    def show(Long id) {
        respond materiaActivaService.get(id)
    }

    def create() {
        respond new MateriaActiva(params)
    }

    def save(MateriaActiva materiaActiva) {
        if (materiaActiva == null) {
            notFound()
            return
        }

        try {
            materiaActivaService.save(materiaActiva)
        } catch (ValidationException e) {
            respond materiaActiva.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'materiaActiva.label', default: 'MateriaActiva'), materiaActiva.id])
                redirect materiaActiva
            }
            '*' { respond materiaActiva, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond materiaActivaService.get(id)
    }

    def update(MateriaActiva materiaActiva) {
        if (materiaActiva == null) {
            notFound()
            return
        }

        try {
            materiaActivaService.save(materiaActiva)
        } catch (ValidationException e) {
            respond materiaActiva.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'materiaActiva.label', default: 'MateriaActiva'), materiaActiva.id])
                redirect materiaActiva
            }
            '*'{ respond materiaActiva, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        materiaActivaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'materiaActiva.label', default: 'MateriaActiva'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'materiaActiva.label', default: 'MateriaActiva'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
