package gestion_laboratorio

class Horario {
    int horaLab
    int minutoLab
    static constraints = {
        horaLab min: 6, max: 20, unique: true
        minutoLab min:0, max: 50
    }
    String toString(){
        def horarioLab
        horarioLab=horaLab+":"+minutoLab

    }
}
