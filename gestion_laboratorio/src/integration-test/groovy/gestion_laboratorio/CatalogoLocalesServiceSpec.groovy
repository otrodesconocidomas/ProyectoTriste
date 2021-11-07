package gestion_laboratorio

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CatalogoLocalesServiceSpec extends Specification {

    CatalogoLocalesService catalogoLocalesService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new CatalogoLocales(...).save(flush: true, failOnError: true)
        //new CatalogoLocales(...).save(flush: true, failOnError: true)
        //CatalogoLocales catalogoLocales = new CatalogoLocales(...).save(flush: true, failOnError: true)
        //new CatalogoLocales(...).save(flush: true, failOnError: true)
        //new CatalogoLocales(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //catalogoLocales.id
    }

    void "test get"() {
        setupData()

        expect:
        catalogoLocalesService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<CatalogoLocales> catalogoLocalesList = catalogoLocalesService.list(max: 2, offset: 2)

        then:
        catalogoLocalesList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        catalogoLocalesService.count() == 5
    }

    void "test delete"() {
        Long catalogoLocalesId = setupData()

        expect:
        catalogoLocalesService.count() == 5

        when:
        catalogoLocalesService.delete(catalogoLocalesId)
        sessionFactory.currentSession.flush()

        then:
        catalogoLocalesService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        CatalogoLocales catalogoLocales = new CatalogoLocales()
        catalogoLocalesService.save(catalogoLocales)

        then:
        catalogoLocales.id != null
    }
}
