package org.devnull.matchmaking.player;

//import static org.devnull.matchmaking.CommonMacros.*;

import org.devnull.matchmaking.Player;

public class PlayerWithEquipmentLevel extends BasicPlayer implements java.io.Serializable {

    /** Generated by the serialver utility */
    //TODO: private static final long serialVersionUID = 6767373972869040494L;

    //public static final PlayerProperties<PlayerWithEquipmentLevel> PLAYER_PROPERTIES = pps(
    //    BasicPlayer.PLAYER_PROPERTIES,
    //    pp("equipmentLevel", PlayerWithEquipmentLevel::getEquipmentLevel)
    //);



    private final int equipmentLevel;

    public PlayerWithEquipmentLevel(final String name, final int wins, final int losses, final int equipmentLevel) {
        super(name, wins, losses);
        this.equipmentLevel = equipmentLevel;
    }

    //@Override
    //public PlayerProperties<PlayerInterface> getPlayerProperty() {
    //    return null;
    //}

    public int getEquipmentLevel() {
        return this.equipmentLevel;
    }

    @Override
    public int hashCode() {
        // The same as java.util.Objects#hash(Object...)
        return super.hashCode() * 31 + this.equipmentLevel;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        // Note: Do NOT use "instanceof" here
        // Java equality sucks, let's use Scala!
        // See: http://stackoverflow.com/q/12239344/142239
        if (obj.getClass() != PlayerWithEquipmentLevel.class) return false;
        final PlayerWithEquipmentLevel p = (PlayerWithEquipmentLevel) obj;
        return this.getName().equals(p.getName())
            && this.getWins() == p.getWins()
            && this.getLosses() == p.getLosses()
            && this.equipmentLevel == p.equipmentLevel;
    }

    @Override
    public String toString() {
        // TODO: Should use Apache Commons StringEscapeUtils to escape this.name here,
        //       but let's assume there are no special characters for simplicity.
        return new StringBuilder("[PlayerWithEquipmentLevel: \"name\": \"")
            .append(this.getName())
            .append("\", \"wins\": ")
            .append(this.getWins())
            .append(", \"losses\": ")
            .append(this.getLosses())
            .append(", \"equipmentLevel\": ")
            .append(this.equipmentLevel)
            .append("]")
            .toString();
    }

}