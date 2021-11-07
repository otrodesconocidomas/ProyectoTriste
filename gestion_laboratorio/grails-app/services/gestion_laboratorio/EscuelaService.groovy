package gestion_laboratorio

import grails.gorm.services.Service

@Service(Escuela)
interface EscuelaService {

    Escuela get(Serializable id)

    List<Escuela> list(Map args)

    Long count()

    void delete(Serializable id)

    Escuela save(Escuela escuela)

}