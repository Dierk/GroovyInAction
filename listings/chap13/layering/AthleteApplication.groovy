package layering

class AthleteApplication {
  def helper = new DbHelper()                          //#1
  def athleteDAO = new AthleteDAO(db: helper.db)       //#1
  def sortBy = 'athleteId'                             //#1
  def done = false

  def init() { helper.executeDdl(athleteDAO) }         //#1

  def exit() { done = true }

  def sort(field) {
    sortBy = field
    list()
  }

  def create(first, last = null, dob = null) {
    athleteDAO.create([first, last, dob])
    list()
  }

  def list() {
    def athletes = athleteDAO.all(sortBy)
    println athletes.size() + ' Athlete(s) in DB: '
    println 'id firstname  lastname     dateOfBirth'
    athletes.each { athlete ->
      println athlete.athleteId + ': ' +
          athlete.firstname.padRight(10) + ' ' +
          athlete.lastname.padRight(12) + ' ' +
          athlete.dateOfBirth
    }
  }

  def update(id, field, newValue) {
    def count = athleteDAO.update(field, newValue, id)
    println count + ' row(s) updated'
    list()
  }

  def delete(id) {
    def count = athleteDAO.delete(id)
    println count + ' row(s) deleted'
    list()
  }

  def mainLoop() {                                     //#2
    def reader = System.in.newReader()
    while (!done) {
      println '\ncommands: create list update delete sort exit'
      def input = reader.readLine().tokenize()         //#A
      def method = input.remove(0)                     //#A
      this."$method"(*input)                           //#A
    }
  }
}
//#1 Initialization
//#2 Entry point
//#A Commands are provided as methods, then arguments
