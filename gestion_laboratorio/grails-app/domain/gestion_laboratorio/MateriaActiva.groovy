package gestion_laboratorio

class MateriaActiva {
    int cicloMA
    Date anioMA
    Date horaLab

    static belongsTo = [localReserva: Local]

    static constraints = {
        cicloMA min:1, max:2
    }
}
