package layering

class AthleteDAO extends DataAccessObject {
  List getFields() {
    return [
        'firstname',   'VARCHAR(64)',
        'lastname',    'VARCHAR(64)',
        'dateOfBirth', 'DATE'
    ]
  }
}
