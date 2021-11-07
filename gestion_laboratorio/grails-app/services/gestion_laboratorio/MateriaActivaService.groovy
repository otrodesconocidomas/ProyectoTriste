package gestion_laboratorio

import grails.gorm.services.Service

@Service(MateriaActiva)
interface MateriaActivaService {

    MateriaActiva get(Serializable id)

    List<MateriaActiva> list(Map args)

    Long count()

    void delete(Serializable id)

    MateriaActiva save(MateriaActiva materiaActiva)

}