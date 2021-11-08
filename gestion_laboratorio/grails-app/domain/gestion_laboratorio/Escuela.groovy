package gestion_laboratorio

class Escuela {
    int idEscuela
    String nombreEscuela
    static belongsTo =[catalogo: CatalogoLocales]
    
    static constraints = {
        idEscuela unique: true
        nombreEscuela size: 5..30
        catalogo unique: true, nullable: true
    }
    String toString(){
        nombreEscuela
    }
}