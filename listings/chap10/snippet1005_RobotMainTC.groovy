import groovy.transform.TypeChecked

class Robot {
  void move(long distance) { println "Moving $distance meters" }
}

@TypeChecked(extensions = 'Listing_10_46_RobotExtension.groovy')
main() {
  robot.move 100.meters
}

binding.robot = new Robot()
Integer.metaClass.getMeters = { delegate }
main()
