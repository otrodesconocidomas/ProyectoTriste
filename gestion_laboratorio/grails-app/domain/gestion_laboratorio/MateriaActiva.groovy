package gestion_laboratorio

class MateriaActiva {
    int idLaboratorio
    static belongsTo = [localReserva: Local, materia: Materia, horario: Horario]
    static constraints = {
        idLaboratorio unique: true
    }
    String toString(){
        materia
        horario
    }
}
