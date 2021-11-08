package gestion_laboratorio

class Local {
    int idLocal
    String nombreLocal
    float latitud 
    float longuitud
    static hasMany =[laboratorio:MateriaActiva]
    static belongsTo =[catalogo: CatalogoLocales]
    

    static constraints = {
         idLocal unique: true
         nombreLocal size: 5..30
    }
    String toString(){
        nombreLocal
    }
}