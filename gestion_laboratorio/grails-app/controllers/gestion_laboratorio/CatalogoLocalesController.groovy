package gestion_laboratorio

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CatalogoLocalesController {

    CatalogoLocalesService catalogoLocalesService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond catalogoLocalesService.list(params), model:[catalogoLocalesCount: catalogoLocalesService.count()]
    }

    def show(Long id) {
        respond catalogoLocalesService.get(id)
    }

    def create() {
        respond new CatalogoLocales(params)
    }

    def save(CatalogoLocales catalogoLocales) {
        if (catalogoLocales == null) {
            notFound()
            return
        }

        try {
            catalogoLocalesService.save(catalogoLocales)
        } catch (ValidationException e) {
            respond catalogoLocales.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'catalogoLocales.label', default: 'CatalogoLocales'), catalogoLocales.id])
                redirect catalogoLocales
            }
            '*' { respond catalogoLocales, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond catalogoLocalesService.get(id)
    }

    def update(CatalogoLocales catalogoLocales) {
        if (catalogoLocales == null) {
            notFound()
            return
        }

        try {
            catalogoLocalesService.save(catalogoLocales)
        } catch (ValidationException e) {
            respond catalogoLocales.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'catalogoLocales.label', default: 'CatalogoLocales'), catalogoLocales.id])
                redirect catalogoLocales
            }
            '*'{ respond catalogoLocales, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        catalogoLocalesService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'catalogoLocales.label', default: 'CatalogoLocales'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'catalogoLocales.label', default: 'CatalogoLocales'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
