package gestion_laboratorio

class Pensum {
    int idPensum
    String nombrePensum

    static belongsTo = [carrera: Escuela]
    static hasMany = [listaMaterias:Materia]

    static constraints = {
        idPensum unique: true
    }
    String toString(){
        nombrePensum
    }
}
