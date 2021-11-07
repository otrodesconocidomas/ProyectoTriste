package gestion_laboratorio

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EscuelaServiceSpec extends Specification {

    EscuelaService escuelaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Escuela(...).save(flush: true, failOnError: true)
        //new Escuela(...).save(flush: true, failOnError: true)
        //Escuela escuela = new Escuela(...).save(flush: true, failOnError: true)
        //new Escuela(...).save(flush: true, failOnError: true)
        //new Escuela(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //escuela.id
    }

    void "test get"() {
        setupData()

        expect:
        escuelaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Escuela> escuelaList = escuelaService.list(max: 2, offset: 2)

        then:
        escuelaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        escuelaService.count() == 5
    }

    void "test delete"() {
        Long escuelaId = setupData()

        expect:
        escuelaService.count() == 5

        when:
        escuelaService.delete(escuelaId)
        sessionFactory.currentSession.flush()

        then:
        escuelaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Escuela escuela = new Escuela()
        escuelaService.save(escuela)

        then:
        escuela.id != null
    }
}
