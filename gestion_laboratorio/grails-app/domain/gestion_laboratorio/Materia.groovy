package gestion_laboratorio

class Materia {
    int codMateria
    String nombreMateria
    int uV
    boolean obligatoria
    
    static belongsTo = [prerequisito: Materia]

    static constraints = {
        codMateria unique: true
        nombreMateria size: 5..30
        uV min: 1, max:20
        prerequisito nullable:true
    }
    String toString(){
        nombreMateria
    }
}
