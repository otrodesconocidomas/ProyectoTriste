package gestion_laboratorio

class Escuela {
    int idEscuela
    String nombreEscuela
    
    static constraints = {
        idEscuela unique: true
        nombreEscuela size: 5..30
    }
}