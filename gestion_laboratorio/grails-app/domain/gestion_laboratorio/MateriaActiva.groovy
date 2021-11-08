package gestion_laboratorio

class MateriaActiva {
    int idLaboratorio
    String horario =["6:20 am - 8:05 am","8:05 am - 9:55 am", "9:50 am - 11:30 am", "11:35 am - 1:15 pm", "1:20 pm - 3:00 pm", "3:05 pm - 4:45 pm", "4:50 pm - 6:30 pm", "6:35 pm - 8:15 pm"]
    static belongsTo = [localReserva: Local, materia: Materia]
    static constraints = {
        idLaboratorio unique: true
    }
    String toString(){
        materia
        horario
    }
}
