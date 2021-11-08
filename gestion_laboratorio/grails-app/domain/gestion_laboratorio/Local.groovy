package gestion_laboratorio

class Local {
    int idLocal
    String nombreLocal
    String latitud 
    String longitud
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