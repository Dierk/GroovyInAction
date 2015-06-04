@Grab('org.gcontracts:gcontracts-core:1.2.12')
import org.gcontracts.annotations.*

@Invariant({ waterVolume >= 0; waterVolume <= maxVolume })
class Kettle {
    int waterVolume = 0
    int maxVolume = 1000

    // listing 20.13:
    @Requires({ amount > 0 })
    @Ensures({ waterVolume == maxVolume || waterVolume > old.waterVolume })
    void addWater(int amount) {
        waterVolume = Math.min(maxVolume, amount + waterVolume)
    }

    // listing 20.14
    @Requires({ desiredAmount > 0 })
    @Ensures({
        result >= 0;
        result == 0 ? waterVolume == old.waterVolume : waterVolume < old.waterVolume
    })
    int pour(int desiredAmount) {
        int amountPoured = (desiredAmount <= waterVolume
                ? desiredAmount
                : waterVolume)
        waterVolume = waterVolume - amountPoured
        amountPoured
    }

}

def kettle = new Kettle()
kettle.addWater(600)
kettle.addWater(600)
assert kettle.waterVolume == kettle.maxVolume