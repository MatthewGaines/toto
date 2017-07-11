package toto

/**
 * @file
 * Task domain class sets definition of declarative validation constraints
 * on the elements within a Task such as Name, Description, etc.
 *
 * By: Matt Gaines
 * Date: 06/01/2017
 */
class Task {
  String name
  String description
  String owner

  //Handled automatically by Grails, hidden from editing.
  Date dateCreated
  Date lastUpdated

  //Each task has one parent list.
  List list

  static constraints = {
    name blank: false, size: 5..32
    description blank: true, nullable:true, maxSize: 256
    dateCreated nullable:true
    lastUpdated nullable:true
    list nullablle:false //must belong to a list
    owner blank:true, nullable:true, display:false

  }

  String toString() {
    return this.name
  }
}
