package gestion_laboratorio

import grails.gorm.services.Service

@Service(CatalogoLocales)
interface CatalogoLocalesService {

    CatalogoLocales get(Serializable id)

    List<CatalogoLocales> list(Map args)

    Long count()

    void delete(Serializable id)

    CatalogoLocales save(CatalogoLocales catalogoLocales)

}