package gestion_laboratorio

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MateriaActivaServiceSpec extends Specification {

    MateriaActivaService materiaActivaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new MateriaActiva(...).save(flush: true, failOnError: true)
        //new MateriaActiva(...).save(flush: true, failOnError: true)
        //MateriaActiva materiaActiva = new MateriaActiva(...).save(flush: true, failOnError: true)
        //new MateriaActiva(...).save(flush: true, failOnError: true)
        //new MateriaActiva(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //materiaActiva.id
    }

    void "test get"() {
        setupData()

        expect:
        materiaActivaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<MateriaActiva> materiaActivaList = materiaActivaService.list(max: 2, offset: 2)

        then:
        materiaActivaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        materiaActivaService.count() == 5
    }

    void "test delete"() {
        Long materiaActivaId = setupData()

        expect:
        materiaActivaService.count() == 5

        when:
        materiaActivaService.delete(materiaActivaId)
        sessionFactory.currentSession.flush()

        then:
        materiaActivaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        MateriaActiva materiaActiva = new MateriaActiva()
        materiaActivaService.save(materiaActiva)

        then:
        materiaActiva.id != null
    }
}
