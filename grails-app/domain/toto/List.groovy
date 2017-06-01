package toto

/**
 * @file
 * List domain class sets definition of declarative validation constraints
 * on the elements within a List such as Name, Description, etc.
 *
 * By: Matt Gaines
 * Date: 06/01/2017
 */

class List {
    String name
    String description
    String owner

    Date dateCreated
    Date lastUpdated

    //List can have many tasks
    static hasMany = [tasks: Task]

    static constraints = {
      name blank: false, size: 4..32, unique:true
      description blank: true, nullable:true, maxSize: 256
      dateCreated nullable:true
      lastUpdated nullable:true
      tasks nullable:true
      owner blank:true, nullable:true, display:false
    }

    String toString(_) {
      return this.name
    }
}
