package gestion_laboratorio

class Materia {
    int codMateria
    String nombreMateria
    int uV
    boolean obligatoria
    int cicloM
    Date anioM
    static belongsTo = [prerequisito: Materia, pensum: Pensum]
    static hasMany = [laBorat: MateriaActiva]

    static constraints = {
        codMateria unique: true, min: 1
        nombreMateria size: 5..30
        uV min: 1, max:20
        prerequisito nullable:true
        cicloM min:1, max:2
    }
    String toString(){
        nombreMateria
    }
}
