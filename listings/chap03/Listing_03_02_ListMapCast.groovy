import java.awt.*

Point topLeft  = new Point(0, 0) // classic
Point botRight = [100, 100]      // List cast
Point center   = [x:50, y:50]    // Map cast

assert botRight instanceof Point
assert center   instanceof Point

def rect = new Rectangle()
rect.location = [0, 0]              // Point
rect.size = [width:100, height:100] // Dimension