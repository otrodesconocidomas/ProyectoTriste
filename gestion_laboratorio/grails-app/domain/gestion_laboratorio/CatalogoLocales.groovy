package gestion_laboratorio

class CatalogoLocales {
    int idCatalogo
    static hasMany = [listaLocales: Local]
    static belongsTo = [escuela: Escuela]
    
    static constraints = {
        idCatalogo unique: true
    }
    String toString(){
        escuela
    }
}