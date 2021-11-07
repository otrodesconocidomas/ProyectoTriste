package gestion_laboratorio

class CatalogoLocales {

    static hasMany = [listaLocales: Local]
    static belongsTo = [escuela: Escuela]
    
    static constraints = {
    }
}