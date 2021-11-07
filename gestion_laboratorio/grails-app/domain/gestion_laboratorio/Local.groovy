package gestion_laboratorio

class Local {
    int idLocal
    String nombreLocal
    float latitud 
    float longuitud
    static hasMany =[materiaActivaLaB:MateriaActiva]   
    

    static constraints = {
         idLocal unique: true
         nombreLocal size: 5..30
    }
}