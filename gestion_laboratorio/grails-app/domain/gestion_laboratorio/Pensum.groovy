package gestion_laboratorio

class Pensum {
    int idPensum

    static belongsTo = [carrera: Escuela]
    static hasMany = [listaMaterias:Materia]

    static constraints = {
        idPensum unique: true
    }
}
